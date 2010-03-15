/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.helper;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ResourceHelper {

  private ResourceHelper() {
    // Prevent instantiation
  }

  public static Resource createResource(ResourceSet resourceSet, IResource resource) {
    return createResource(resourceSet, URIHelper.getPlatformURI(resource));
  }

  public static Resource createResource(ResourceSet resourceSet, URI uri) {
    if (resourceSet == null || uri == null) {
      return null;
    }
    // Clear the previous URIConverter content
    resourceSet.getURIConverter().getURIMap().clear();
    // Assign a fresh platform aware URIConverter
    resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // Create
    return resourceSet.createResource(uri);
  }

  public static Resource loadResource(ResourceSet resourceSet, IResource resource) {
    return loadResource(resourceSet, URIHelper.getPlatformURI(resource));
  }

  public static Resource loadResource(ResourceSet resourceSet, URI uri) {
    if (resourceSet == null || uri == null) {
      return null;
    }
    // Clear the previous URIConverter content
    resourceSet.getURIConverter().getURIMap().clear();
    // Assign a fresh platform aware URIConverter
    resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // Load or create
    return resourceSet.getResource(uri, true);
  }

  public static void loadResource(Resource resource) throws IOException {
    if (resource == null) {
      return;
    }
    if (resource.getResourceSet() != null) {
      // Clear the previous URIConverter content
      resource.getResourceSet().getURIConverter().getURIMap().clear();
      // Assign a fresh platform aware URIConverter
      resource.getResourceSet().getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    }
    // Load
    resource.load(Collections.EMPTY_MAP);
  }

  public static void reloadResources(Collection<Resource> resources) throws IOException {
    if (resources == null) {
      return;
    }
    // Track resourceSets as this been method could work with multiple resourceSets
    List<ResourceSet> resourceSets = new UniqueEList<ResourceSet>();
    // Unload resources
    for (Resource resource : resources) {
      resource.unload();
      if (resource.getResourceSet() != null) {
        resourceSets.add(resource.getResourceSet());
      }
    }
    // Update URI Converter
    for (ResourceSet resourceSet : resourceSets) {
      // Clear the previous URIConverter content
      resourceSet.getURIConverter().getURIMap().clear();
      // Assign a fresh platform aware URIConverter
      resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    }
    // Load Resource
    for (Resource resource : resources) {
      resource.load(Collections.EMPTY_MAP);
    }
  }

  public static boolean hasApplicableProxies(Resource resource, URI uri) {
    Assert.isNotNull(resource);
    if (uri == null) {
      return false;
    }
    Map<EObject, Collection<EStructuralFeature.Setting>> proxies = EcoreUtil.ProxyCrossReferencer.find(resource);
    for (EObject reference : proxies.keySet()) {
      if (reference instanceof InternalEObject == false) {
        continue;
      }
      InternalEObject internalReference = (InternalEObject) reference;
      if (internalReference.eProxyURI() == null) {
        continue;
      }
      if (internalReference.eProxyURI().trimFragment().equals(uri)) {
        return true;
      }
    }
    return false;
  }

  public static List<EObject> getApplicableProxies(Resource resource, URI uri) {
    List<EObject> applicable = new UniqueEList<EObject>();
    Map<EObject, Collection<EStructuralFeature.Setting>> proxies = EcoreUtil.ProxyCrossReferencer.find(resource);
    for (EObject reference : proxies.keySet()) {
      if (reference instanceof InternalEObject == false) {
        continue;
      }
      InternalEObject internalReference = (InternalEObject) reference;
      if (internalReference.eProxyURI() == null) {
        continue;
      }
      if (internalReference.eProxyURI().trimFragment().equals(uri)) {
        applicable.add(reference);
      }
    }
    return applicable;
  }

  public static List<EObject> getApplicableProxies(Resource resource) {
    List<EObject> applicable = new UniqueEList<EObject>();
    Map<EObject, Collection<EStructuralFeature.Setting>> proxies = EcoreUtil.ProxyCrossReferencer.find(resource);
    for (EObject reference : proxies.keySet()) {
      if (reference instanceof InternalEObject == false) {
        continue;
      }
      InternalEObject internalReference = (InternalEObject) reference;
      if (internalReference.eProxyURI() == null) {
        continue;
      }
      applicable.add(reference);
    }
    return applicable;
  }

  /**
   * is there any unresolved proxy against this resource ?
   * This method doesn't resolve proxies while analysed
   */
  public static boolean hasURIProxyReferences(Resource resource, URI uri) {
    Assert.isNotNull(resource);
    if (uri == null) {
      return false;
    }
    Map<EObject, Collection<EStructuralFeature.Setting>> proxies = EMFHelper.URIProxyCrossReferencer.find(resource, uri);
    return proxies != null && proxies.size() > 0;
  }

  /**
   * return unresolved proxies for this resource ?
   * This method doesn't resolve proxies while analysed
   */
  public static Map<EObject, Collection<EStructuralFeature.Setting>> getURIProxyReferences(Resource resource, URI uri) {
    Assert.isNotNull(resource);
    Map<EObject, Collection<EStructuralFeature.Setting>> references = new HashMap<EObject, Collection<EStructuralFeature.Setting>>();
    if (uri == null) {
      return references;
    }
    return EMFHelper.URIProxyCrossReferencer.find(resource, uri);
  }

  /**
   * return owners of proxies who qualify a resource URI
   * This method doesn't resolve proxies while analysed
   */
  public static List<EObject> getURIProxyReferenceOwners(Resource resource, URI uri) {
    Assert.isNotNull(resource);
    List<EObject> owners = new UniqueEList<EObject>();
    if (uri == null) {
      return owners;
    }
    // Build proxies list
    Map<EObject, Collection<EStructuralFeature.Setting>> proxies = getURIProxyReferences(resource, uri);
    for (EObject reference : proxies.keySet()) {
      // Build holders list
      for (EStructuralFeature.Setting setting : proxies.get(reference)) {
        URI holderURI = EcoreUtil.getURI(setting.getEObject());
        if (holderURI == null) {
          continue;
        }
        // Looking for an holder who match our current resource uri
        // Since the first one we found we iterate
        if (resource.getURI().equals(holderURI.trimFragment())) {
          owners.add(setting.getEObject());
          break;
        }
      }
    }
    return owners;
  }

}
