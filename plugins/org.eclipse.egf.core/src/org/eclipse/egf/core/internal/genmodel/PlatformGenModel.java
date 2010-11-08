/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 * 
 */
package org.eclipse.egf.core.internal.genmodel;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.common.loader.IClassLoader;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.epackage.IProxyEPackage;
import org.eclipse.egf.core.epackage.IProxyERoot;
import org.eclipse.egf.core.epackage.ProxyFactory;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.platform.loader.BundleClassLoaderFactory;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.PlatformExtensionPointURI;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;

public final class PlatformGenModel extends PlatformExtensionPointURI implements IPlatformGenModel {

    private String _generatedPackage;

    private String _genModel;

    private URI _genModelURI;

    private static Map<URI, URI> _targetPlatformGenModelLocationMap;

    private static Map<URI, IPlatformGenModel> _nsURIToTargetPlatformGenModel;

    private static Map<URI, URI> _runtimePlatformGenModelLocationMap;

    private static Map<URI, IPlatformGenModel> _nsURIToRuntimePlatformGenModel;

    /**
     * Returns a map from {@link EPackage#getNsURI() package namespace URI} (represented as a String)
     * to the location of the GenModel containing a GenPackage for the package (represented as a {@link URI URI}).
     * 
     * @return a map from package namespace to GenModel location.
     */
    public static Map<URI, URI> getTargetPlatformGenModelLocationMap() {
        if (_targetPlatformGenModelLocationMap == null) {
            _targetPlatformGenModelLocationMap = new HashMap<URI, URI>();
        }
        return _targetPlatformGenModelLocationMap;
    }

    public static Map<URI, IPlatformGenModel> getTargetPlatformGenModels() {
        if (_nsURIToTargetPlatformGenModel == null) {
            _nsURIToTargetPlatformGenModel = new HashMap<URI, IPlatformGenModel>();
        }
        return _nsURIToTargetPlatformGenModel;
    }

    /**
     * Returns a map from {@link EPackage#getNsURI() package namespace URI} (represented as a String)
     * to the location of the GenModel containing a GenPackage for the package (represented as a {@link URI URI}).
     * 
     * @return a map from package namespace to GenModel location.
     */
    public static Map<URI, URI> getRuntimePlatformGenModelLocationMap() {
        if (_runtimePlatformGenModelLocationMap == null) {
            _runtimePlatformGenModelLocationMap = new HashMap<URI, URI>();
        }
        return _runtimePlatformGenModelLocationMap;
    }

    public static Map<URI, IPlatformGenModel> getRuntimePlatformGenModels() {
        if (_nsURIToRuntimePlatformGenModel == null) {
            _nsURIToRuntimePlatformGenModel = new HashMap<URI, IPlatformGenModel>();
        }
        return _nsURIToRuntimePlatformGenModel;
    }

    public URI getEPackageNsURI(URI uri) {
        return getEPackageNsURI(uri, null);
    }

    public URI getEPackageNsURI(URI uri, Map<IPluginModelBase, IClassLoader> loaders) {
        if (uri == null) {
            return null;
        }
        // Load the static resource
        try {
            if (getBundle() == null) {
                IClassLoader loader = null;
                if (loaders != null) {
                    loader = loaders.get(getPluginModelBase());
                    if (loader == null) {
                        loader = BundleClassLoaderFactory.getBundleClassLoader(getPluginModelBase());
                        loaders.put(getPluginModelBase(), loader);
                    }
                } else {
                    loader = BundleClassLoaderFactory.getBundleClassLoader(getPluginModelBase());
                }
                return EMFHelper.getEPackageNsURI(loader, getGeneratedPackage(), uri);
            }
            return EMFHelper.getEPackageNsURI(getEPackage(), uri);
        } catch (Throwable t) {
            EGFCorePlugin.getDefault().logError(t);
        }
        return null;
    }

    public static String getBasePackage(IPlatformGenModel genModel) {
        String classname = genModel.getGeneratedPackage();
        int index = classname.lastIndexOf("."); //$NON-NLS-1$
        if (index == -1 || index == 0) {
            return null;
        }
        return classname.substring(0, index);
    }

    public PlatformGenModel(IPlatformBundle bundle, String uri, String className, String genModel) {
        super(bundle, uri);
        _uri = URI.createURI(URI.decode(getId()));
        Assert.isNotNull(className);
        Assert.isLegal(className.trim().length() != 0);
        Assert.isLegal(bundle.isRuntime() == false);
        _generatedPackage = className.trim();
        if (genModel != null && genModel.trim().length() != 0) {
            _genModel = genModel.trim();
            _genModelURI = URIHelper.getPlatformPluginURI(getPlatformBundle().getBundleId(), URI.decode(_genModel), false);
            getTargetPlatformGenModelLocationMap().put(getNsURI(), _genModelURI);
        }
        getTargetPlatformGenModels().put(getNsURI(), this);
    }

    public PlatformGenModel(IPlatformBundle bundle, String uri, String uniqueIdentifier, int handleId, String className, String genModel) {
        super(bundle, uri, uniqueIdentifier, handleId);
        _uri = URI.createURI(URI.decode(getId()));
        Assert.isNotNull(className);
        Assert.isLegal(className.trim().length() != 0);
        Assert.isLegal(bundle.isRuntime());
        _generatedPackage = className.trim();
        if (genModel != null && genModel.trim().length() != 0) {
            _genModel = genModel.trim();
            _genModelURI = URIHelper.getPlatformPluginURI(getPlatformBundle().getBundleId(), URI.decode(_genModel), false);
            getRuntimePlatformGenModelLocationMap().put(getNsURI(), _genModelURI);
        }
        getRuntimePlatformGenModels().put(getNsURI(), this);
    }

    public URI getNsURI() {
        return getURI();
    }

    public String getGeneratedPackage() {
        return _generatedPackage;
    }

    public String getGenModel() {
        return _genModel;
    }

    public URI getGenModelURI() {
        return _genModelURI;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object) == false) {
            return false;
        }
        if (object instanceof IPlatformGenModel == false) {
            return false;
        }
        IPlatformGenModel platformGenModel = (IPlatformGenModel) object;
        if (platformGenModel.getGeneratedPackage().equals(getGeneratedPackage()) == false) {
            return false;
        }
        if (platformGenModel.getGenModel() == null && getGenModel() == null) {
            return true;
        }
        if (platformGenModel.getGenModel() == null || getGenModel() == null) {
            return false;
        }
        if (platformGenModel.getGenModel().equals(getGenModel()) == false) {
            return false;
        }
        return true;
    }

    public String getBasePackage() {
        return getBasePackage(this);
    }

    public IProxyEPackage getIProxyEPackage() {
        return getIProxyEPackage(null);
    }

    public IProxyEPackage getIProxyEPackage(Map<IPluginModelBase, IClassLoader> loaders) {
        IProxyERoot wrapper = getIProxyERoot(loaders);
        if (wrapper != null && wrapper.getChildren().length == 1) {
            return wrapper.getChildren()[0];
        }
        return null;
    }

    public IProxyERoot getIProxyERoot() {
        return getIProxyERoot(null);
    }

    public IProxyERoot getIProxyERoot(Map<IPluginModelBase, IClassLoader> loaders) {
        // Load the static resource
        try {
            if (getBundle() == null) {
                IClassLoader loader = null;
                if (loaders != null) {
                    loader = loaders.get(getPluginModelBase());
                    if (loader == null) {
                        loader = BundleClassLoaderFactory.getBundleClassLoader(getPluginModelBase());
                        loaders.put(getPluginModelBase(), loader);
                    }
                } else {
                    loader = BundleClassLoaderFactory.getBundleClassLoader(getPluginModelBase());
                }
                return ProxyFactory.buildIProxyERoot(loader, this);
            }
            return ProxyFactory.buildIProxyERoot(this);
        } catch (Throwable t) {
            EGFCorePlugin.getDefault().logError(t);
        }
        return null;
    }

    public EPackage getEPackage() {
        if (getBundle() != null) {
            return EPackage.Registry.INSTANCE.getEPackage(getNsURI().toString());
        }
        throw new UnsupportedOperationException(NLS.bind("EPackage couldn't be resolved ''{0}''", getNsURI())); //$NON-NLS-1$
    }

    @Override
    protected void dispose() {
        if (isTarget() || isWorkspace()) {
            getTargetPlatformGenModelLocationMap().remove(getNsURI());
            getTargetPlatformGenModels().remove(getNsURI());
        } else {
            getRuntimePlatformGenModelLocationMap().remove(getNsURI());
            getRuntimePlatformGenModels().remove(getNsURI());
        }
    }

}
