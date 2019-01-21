/**
 * <copyright>
 * 
 * Copyright (c) 2007 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * Thales Corporate Services S.A.S - Target Platform resolve initial implementation
 * 
 * </copyright>
 * 
 * $Id: URIHandlerImpl.java,v 1.4 2008/03/10 19:17:34 emerks Exp $
 */
package org.eclipse.egf.core.platform.uri;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

/**
 * An implementation of a {@link URIHandler URI handler}.
 * 
 */
public class TargetPlatformURIHandlerImpl implements URIHandler {

	/**
	 * Creates an instance.
	 */
	public TargetPlatformURIHandlerImpl() {
		super();
	}

	/**
	 * This implementation always returns true; clients are generally expected to override this.
	 */
	public boolean canHandle(URI uri) {
		return true;
	}

	/**
	 * Returns the value of the {@link URIConverter#OPTION_URI_CONVERTER URI converter option}.
	 * 
	 * @param options
	 *            the options in which to look for the URI converter.
	 * @return the value of the URI converter option.
	 */
	protected URIConverter getURIConverter(Map<?, ?> options) {
		return (URIConverter) options.get(URIConverter.OPTION_URI_CONVERTER);
	}

	/**
	 * Returns the value of the {@link URIConverter#OPTION_RESPONSE response option}.
	 * 
	 * @param options
	 *            the options in which to look for the response option.
	 * @return the value of the response option.
	 */
	@SuppressWarnings("unchecked")
	protected Map<Object, Object> getResponse(Map<?, ?> options) {
		return (Map<Object, Object>) options.get(URIConverter.OPTION_RESPONSE);
	}

	/**
	 * Returns the value of the {@link URIConverter#OPTION_REQUESTED_ATTRIBUTES requested attributes option}.
	 * 
	 * @param options
	 *            the options in which to look for the requested attributes option.
	 * @return the value of the requested attributes option.
	 */
	@SuppressWarnings("unchecked")
	protected Set<String> getRequestedAttributes(Map<?, ?> options) {
		return (Set<String>) options.get(URIConverter.OPTION_REQUESTED_ATTRIBUTES);
	}

	/**
	 * Creates an output stream for the URI, assuming it's a URL, and returns it.
	 * Specialized support is provided for HTTP URLs.
	 * 
	 * @return an open output stream.
	 * @exception IOException
	 *                if there is a problem obtaining an open output stream.
	 */
	public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
		try {
			URL url = resolveTarget(uri);
			final URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			if (urlConnection instanceof HttpURLConnection) {
				final HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setRequestMethod("PUT"); //$NON-NLS-1$
				return new FilterOutputStream(urlConnection.getOutputStream()) {

					@Override
					public void close() throws IOException {
						super.close();
						int responseCode = httpURLConnection.getResponseCode();
						switch (responseCode) {
						case HttpURLConnection.HTTP_OK:
						case HttpURLConnection.HTTP_CREATED:
						case HttpURLConnection.HTTP_NO_CONTENT: {
							break;
						}
						default: {
							throw new IOException("PUT failed with HTTP response code " + responseCode); //$NON-NLS-1$
						}
						}
					}
				};
			}
			OutputStream result = urlConnection.getOutputStream();
			final Map<Object, Object> response = getResponse(options);
			if (response != null) {
				result = new FilterOutputStream(result) {

					@Override
					public void close() throws IOException {
						try {
							super.close();
						} finally {
							response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, urlConnection.getLastModified());
						}
					}
				};
			}
			return result;
		} catch (RuntimeException exception) {
			throw new Resource.IOWrappedException(exception);
		}
	}

	/**
	 * Creates an input stream for the URI, assuming it's a URL, and returns it.
	 * 
	 * @return an open input stream.
	 * @exception IOException
	 *                if there is a problem obtaining an open input stream.
	 */
	public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
		try {
			URL url = resolveTarget(uri);
			final URLConnection urlConnection = url.openConnection();
			InputStream result = urlConnection.getInputStream();
			Map<Object, Object> response = getResponse(options);
			if (response != null) {
				response.put(URIConverter.RESPONSE_TIME_STAMP_PROPERTY, urlConnection.getLastModified());
			}
			return result;
		} catch (RuntimeException exception) {
			throw new Resource.IOWrappedException(exception);
		}
	}

	protected static URL resolveTarget(URI uri) throws IOException {
		if (uri.isPlatform() == false) {
			return new URL(uri.toString());
		}
		String pluginID = uri.segment(1);
		// Retrieve the target bundle (either workspace or target) if any
		IPluginModelBase model = PluginRegistry.findModel(pluginID);
		if (model == null) {
			//            throw new IOException(NLS.bind("Unable to resolve target plug-in \"{0}\".", pluginID)); //$NON-NLS-1$
			return new URL(uri.toString());
		}
		// Not sure if it's needed however we are conservative here
		if (model.isEnabled() == false) {
			throw new IOException(NLS.bind("Target plug-in is disabled \"{0}\".", pluginID)); //$NON-NLS-1$
		}
		IPath path = new Path(uri.toPlatformString(true)).removeFirstSegments(1);
		File file = new File(model.getInstallLocation());
		if (file.exists() == false) {
			throw new IOException(NLS.bind("Target install location \"{0}\" doesn't exist.", file.toString())); //$NON-NLS-1$
		}
		// regular directory
		if (file.isFile() == false) {
			file = new File(model.getInstallLocation(), path.toOSString());
			if (file.exists() == false) {
				throw new IOException(NLS.bind("Target resource \"{0}\" doesn't exist.", file.toString())); //$NON-NLS-1$
			}
			return file.toURL();
		}
		// jar or zip file see getInstallLocation() for comments
		// inner jar or zip file are not supported
		return new URL("jar:" + file.toURL().toString() + "!/" + path.toString()); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Only HTTP connections support delete.
	 */
	public void delete(URI uri, Map<?, ?> options) throws IOException {
		try {
			URL url = new URL(uri.toString());
			URLConnection urlConnection = url.openConnection();
			urlConnection.setDoOutput(true);
			if (urlConnection instanceof HttpURLConnection) {
				final HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setRequestMethod("DELETE"); //$NON-NLS-1$
				int responseCode = httpURLConnection.getResponseCode();
				switch (responseCode) {
				case HttpURLConnection.HTTP_OK:
				case HttpURLConnection.HTTP_ACCEPTED:
				case HttpURLConnection.HTTP_NO_CONTENT: {
					break;
				}
				default: {
					throw new IOException("DELETE failed with HTTP response code " + responseCode); //$NON-NLS-1$
				}
				}
			} else {
				throw new IOException("Delete is not supported for " + uri); //$NON-NLS-1$
			}
		} catch (RuntimeException exception) {
			throw new Resource.IOWrappedException(exception);
		}
	}

	/**
	 * This implementation delegates to the {@link #getURIConverter(Map) URI converter}'s {@link URIConverter#getContentHandlers() content handlers}.
	 */
	public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
		URIConverter uriConverter = (URIConverter) options.get(URIConverter.OPTION_URI_CONVERTER);
		InputStream inputStream = null;
		Map<String, ?> result = null;
		Map<Object, Object> context = new HashMap<Object, Object>();
		try {
			for (ContentHandler contentHandler : uriConverter.getContentHandlers()) {
				if (contentHandler.canHandle(uri)) {
					if (inputStream == null) {
						try {
							inputStream = createInputStream(uri, options);
						} catch (IOException exception) {
							inputStream = new ByteArrayInputStream(new byte[0]);
						}
						if (!inputStream.markSupported()) {
							inputStream = new BufferedInputStream(inputStream);
						}
						inputStream.mark(Integer.MAX_VALUE);
					} else {
						inputStream.reset();
					}
					Map<String, ?> contentDescription = contentHandler.contentDescription(uri, inputStream, options, context);
					switch ((ContentHandler.Validity) contentDescription.get(ContentHandler.VALIDITY_PROPERTY)) {
					case VALID: {
						return contentDescription;
					}
					case INDETERMINATE: {
						if (result == null) {
							result = contentDescription;
						}
						break;
					}
					case INVALID: {
						break;
					}
					}
				}
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

		return result == null ? ContentHandler.INVALID_CONTENT_DESCRIPTION : result;
	}

	/**
	 * If a stream can be created the file exists.
	 * Specialized support is provided for HTTP connections to avoid fetching the whole stream in that case.
	 */
	public boolean exists(URI uri, Map<?, ?> options) {
		try {
			URL url = new URL(uri.toString());
			URLConnection urlConnection = url.openConnection();
			if (urlConnection instanceof HttpURLConnection) {
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				httpURLConnection.setRequestMethod("HEAD"); //$NON-NLS-1$
				int responseCode = httpURLConnection.getResponseCode();
				// TODO
				// I'm concerned that folders will often return 401 or even 403.
				// So should we consider something to exist even though access if unauthorized or forbidden?
				//
				return responseCode == HttpURLConnection.HTTP_OK;
			}
			InputStream inputStream = urlConnection.getInputStream();
			inputStream.close();
			return true;
		} catch (Throwable exception) {
			return false;
		}
	}

	public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
		Map<String, Object> result = new HashMap<String, Object>();
		Set<String> requestedAttributes = getRequestedAttributes(options);
		try {
			URL url = new URL(uri.toString());
			URLConnection urlConnection = null;
			if (requestedAttributes == null || requestedAttributes.contains(URIConverter.ATTRIBUTE_READ_ONLY)) {
				urlConnection = url.openConnection();
				if (urlConnection instanceof HttpURLConnection) {
					HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
					httpURLConnection.setRequestMethod("OPTIONS"); //$NON-NLS-1$
					int responseCode = httpURLConnection.getResponseCode();
					if (responseCode == HttpURLConnection.HTTP_OK) {
						String allow = httpURLConnection.getHeaderField("Allow"); //$NON-NLS-1$
						result.put(URIConverter.ATTRIBUTE_READ_ONLY, allow == null || !allow.contains("PUT")); //$NON-NLS-1$
					}
					urlConnection = null;
				} else {
					result.put(URIConverter.ATTRIBUTE_READ_ONLY, true);
				}
			}

			if (requestedAttributes == null || requestedAttributes.contains(URIConverter.ATTRIBUTE_TIME_STAMP)) {
				if (urlConnection == null) {
					urlConnection = url.openConnection();
					if (urlConnection instanceof HttpURLConnection) {
						HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
						httpURLConnection.setRequestMethod("HEAD");//$NON-NLS-1$
						httpURLConnection.getResponseCode();
					}
				}
				if (urlConnection.getHeaderField("last-modified") != null) { //$NON-NLS-1$
					result.put(URIConverter.ATTRIBUTE_TIME_STAMP, urlConnection.getLastModified());
				}
			}

			if (requestedAttributes == null || requestedAttributes.contains(URIConverter.ATTRIBUTE_LENGTH)) {
				if (urlConnection == null) {
					urlConnection = url.openConnection();
					if (urlConnection instanceof HttpURLConnection) {
						HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
						httpURLConnection.setRequestMethod("HEAD"); //$NON-NLS-1$
						httpURLConnection.getResponseCode();
					}
				}
				if (urlConnection.getHeaderField("content-length") != null) { //$NON-NLS-1$
					result.put(URIConverter.ATTRIBUTE_LENGTH, urlConnection.getContentLength());
				}
			}
		} catch (IOException exception) {
			// Ignore exceptions.
		}
		return result;
	}

	public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
		// We can't update any properties via just a URL connection.
	}
}
