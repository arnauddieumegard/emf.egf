/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.platform.uri.PlatformXMLURIHandler;
import org.eclipse.egf.core.processor.IFcoreProcessor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLParserPool;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.XMLSave.XMLTypeInfo;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * @implements IPlatformFcoreProvider
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.fcore.util.FcoreResourceFactoryImpl
 * @generated
 */
public class FcoreResourceImpl extends XMIResourceImpl implements IPlatformFcoreProvider {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	private ChangeRecorder _recorder;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	private IPlatformFcore _fcore;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private List<Object> lookupTable = new ArrayList<Object>();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private XMLParserPool parserPool = new XMLParserPoolImpl();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private Map<Object, Object> nameToFeatureMap = new HashMap<Object, Object>();

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public FcoreResourceImpl(URI uri) {
		super(uri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected boolean useIDAttributes() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected boolean useUUIDs() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IPlatformFcore getIPlatformFcore() {
		if (_fcore == null)
			_fcore = EGFCorePlugin.getPlatformFcore(this);
		return _fcore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	protected XMLHelper createXMLHelper() {
		return new FcoreXMIHelperImpl(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	protected XMLSave createXMLSave() {
		return new FcoreXMISaveImpl(createXMLHelper());
	}

	/**
	 * Called when the object is unloaded.
	 * This implementation
	 * {@link InternalEObject#eSetProxyURI sets} the object to be a proxy
	 * and clears the {@link #eAdapters adapters}.
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=292866
	 * Fix available in HEAD: 2.6.0.I200911020144
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated	 
	 */
	@Override
	protected void unloaded(InternalEObject internalEObject) {
		// Ensure that an unresolved containment proxy's URI isn't reset.
		//
		if (!internalEObject.eIsProxy()) {
			internalEObject.eSetProxyURI(uri.appendFragment(getURIFragment(internalEObject)));
		}
		internalEObject.eAdapters().clear();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void init() {
		super.init();
		setTrackingModification(true);
		setEncoding("UTF-8"); //$NON-NLS-1$
		setXMIVersion("2.1"); //$NON-NLS-1$
		// Save Options		
		getDefaultSaveOptions().put(XMLResource.OPTION_CONFIGURATION_CACHE, Boolean.TRUE);
		getDefaultSaveOptions().put(XMLResource.OPTION_USE_CACHED_LOOKUP_TABLE, lookupTable);
		getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		getDefaultSaveOptions().put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		getDefaultSaveOptions().put(XMLResource.OPTION_SAVE_TYPE_INFORMATION, new XMLTypeInfo() {
			public boolean shouldSaveType(EClass objectType, EClassifier featureType, EStructuralFeature feature) {
				return objectType != featureType && objectType != XMLTypePackage.Literals.ANY_TYPE;
			}

			public boolean shouldSaveType(EClass objectType, EClass featureType, EStructuralFeature feature) {
				return objectType != featureType && objectType != XMLTypePackage.Literals.ANY_TYPE;
			}
		});
		getDefaultSaveOptions().put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(80));
		getDefaultSaveOptions().put(XMLResource.OPTION_URI_HANDLER, new PlatformXMLURIHandler());
		getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		getDefaultSaveOptions().put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		// Load Options		
		getDefaultLoadOptions().put(XMLResource.OPTION_URI_HANDLER, new PlatformXMLURIHandler());
		getDefaultLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, Boolean.FALSE);
		getDefaultLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.FALSE);
		getDefaultLoadOptions().put(XMLResource.OPTION_USE_DEPRECATED_METHODS, Boolean.TRUE);
		getDefaultLoadOptions().put(XMLResource.OPTION_USE_PARSER_POOL, parserPool);
		getDefaultLoadOptions().put(XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP, nameToFeatureMap);
		getDefaultLoadOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	protected Notification setLoaded(boolean isLoaded) {
		Notification notification = super.setLoaded(isLoaded);
		if (isLoaded == true) {
			// Start a recorder once the resource is loaded
			_recorder = new ChangeRecorder(this);
		}
		return notification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	protected void doUnload() {
		try {
			// ChangeDescription snapshot
			ChangeDescription changeDescription = null;
			if (_recorder != null) {
				changeDescription = _recorder.endRecording();
			}
			if (changeDescription != null && (changeDescription.getResourceChanges().isEmpty() == false || changeDescription.getObjectsToAttach().isEmpty() == false || changeDescription.getObjectChanges().isEmpty() == false)) {
				// Post-Processing
				for (IFcoreProcessor processor : EGFCorePlugin.getFcoreProcessors()) {
					processor.processPreUnload(this, changeDescription);
				}
			}
			// Unload
			super.doUnload();
		} finally {
			// reset
			_fcore = null;
			// dispose
			if (_recorder != null) {
				_recorder.dispose();
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		try {
			// Save
			try {
				super.save(options);
			} catch (IOException ioe) {
				throw ioe;
			}
		} finally {
			// ChangeDescription snapshot
			ChangeDescription changeDescription = null;
			if (_recorder != null) {
				changeDescription = _recorder.endRecording();
			}
			if (changeDescription != null && (changeDescription.getResourceChanges().isEmpty() == false || changeDescription.getObjectsToAttach().isEmpty() == false || changeDescription.getObjectChanges().isEmpty() == false)) {
				// Post-Processing
				for (IFcoreProcessor processor : EGFCorePlugin.getFcoreProcessors()) {
					processor.processPostSave(this, changeDescription);
				}
			}
			// Start a fresh recorder
			if (_recorder != null) {
				_recorder.dispose();
				_recorder = new ChangeRecorder(this);
			}
		}
	}

} // FcoreResourceImpl
