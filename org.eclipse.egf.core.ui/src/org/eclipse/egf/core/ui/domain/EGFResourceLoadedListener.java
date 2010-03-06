/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.ObjectUndoContext;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.core.workspace.EGFWorkspaceSynchronizer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author Thomas Guiu
 * 
 */
public class EGFResourceLoadedListener implements EGFWorkspaceSynchronizer.Delegate {

  public static final ResourceEventManager RESOURCE_MANAGER = new ResourceEventManager();

  public static interface ResourceUser {

    Resource getResource();

    ResourceListener getListener();

    boolean isDirty();

    boolean userHasSavedResource();

    boolean resourceHasBeenExternallyChanged();

    IOperationHistory getOperationHistory();

    ObjectUndoContext getUndoContext();

  }

  public static interface ResourceListener {

    void resourceDeleted(Resource resource);

    void resourceMoved(Resource resource, URI newURI);

    void resourceReloaded(Resource resource);

    void externalUpdate(Resource resource);

    void internalUpdate(Resource resource);

  }

  public static class ResourceEventManager {

    final List<ResourceListener> _listeners = new ArrayList<ResourceListener>();

    final Map<Resource, List<ResourceUser>> _observers = new HashMap<Resource, List<ResourceUser>>();

    // Due to PDE bug notification we need to handle
    // notification in a weird way
    // https://bugs.eclipse.org/bugs/show_bug.cgi?id=267954
    // See PlatformManager for more informations
    final Map<Resource, IPlatformFcore> _fcores = new HashMap<Resource, IPlatformFcore>();

    public void addObserver(ResourceUser resourceUser) {
      Resource resource = resourceUser.getResource();
      List<ResourceUser> list = _observers.get(resource);
      if (list == null) {
        list = new ArrayList<ResourceUser>();
        _observers.put(resource, list);
        // Start Workaround PDE Bug 267954
        IPlatformFcore fcore = EGFCorePlugin.getPlatformFcore(resource);
        if (fcore != null) {
          _fcores.put(resource, fcore);
        }
        // End Workaround PDE Bug 267954
      }
      list.add(resourceUser);
      _listeners.add(resourceUser.getListener());
    }

    public void removeObserver(ResourceUser resourceUser) {
      Resource resource = resourceUser.getResource();
      List<ResourceUser> list = _observers.get(resource);
      if (list == null) {
        return;
      }
      list.remove(resourceUser);
      if (list.isEmpty()) {
        _observers.remove(resource);
        // Start Workaround PDE Bug 267954
        _fcores.remove(resource);
        // End Workaround PDE Bug 267954
      }
      _listeners.remove(resourceUser.getListener());
      if (noMoreObserver()) {
        clearResourceSet();
      }
    }

    private void clearResourceSet() {
      // no editor is actually open, so let's unload all the resources
      final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
      try {
        editingDomain.runExclusive(new Runnable() {
          public void run() {
            for (Resource resource : editingDomain.getResourceSet().getResources()) {
              resource.unload();
            }
          }
        });
        if (EGFCoreUIPlugin.getDefault().isDebugging()) {
          EGFPlatformPlugin.getDefault().logInfo("EGFResourceLoadedListener.clearResourceSet()"); //$NON-NLS-1$           
        }
      } catch (InterruptedException e) {
        EGFCoreUIPlugin.getDefault().logError(e);
      }
    }

    private boolean noMoreObserver() {
      for (List<ResourceUser> users : _observers.values()) {
        if (users.isEmpty() == false) {
          return false;
        }
      }
      return true;
    }

    public void reloadResource(Resource resource) {
      if (resource == null) {
        throw new IllegalArgumentException();
      }
      FcoreResourceLoadedListener.getDefault().ignore(resource);
      try {
        ResourceHelper.reloadResources(Collections.singletonList(resource));
      } catch (IOException e) {
        EGFCoreUIPlugin.getDefault().logError(e);
      } finally {
        FcoreResourceLoadedListener.getDefault().watch(resource);
      }
      for (ResourceListener resourceListener : _listeners) {
        resourceListener.resourceReloaded(resource);
      }
    }

    public boolean resourceHasBeenExternallyChanged(Resource resource) {
      if (resource == null) {
        throw new IllegalArgumentException();
      }
      List<ResourceUser> users = _observers.get(resource);
      if (users == null) {
        return false;
      }
      boolean resourceHasBeenExternallyChanged = false;
      // This state is propagated, the first user is enough to check this state
      for (ResourceUser user : users) {
        resourceHasBeenExternallyChanged = user.resourceHasBeenExternallyChanged();
        break;
      }
      return resourceHasBeenExternallyChanged;
    }

    public void populateUndoContext(IOperationHistory operationHistory, ObjectUndoContext undoContext, Resource resource) {
      if (resource == null || undoContext == null) {
        throw new IllegalArgumentException();
      }
      List<ResourceUser> users = _observers.get(resource);
      if (users == null) {
        return;
      }
      // Operation History is propagated, the first user is enough to retrieve it
      ObjectUndoContext innerUndoContext = null;
      for (ResourceUser user : users) {
        if (user.getUndoContext() != undoContext) {
          innerUndoContext = user.getUndoContext();
          break;
        }
      }
      // Populate
      if (innerUndoContext != null) {
        for (IUndoableOperation operation : operationHistory.getUndoHistory(innerUndoContext)) {
          operation.addContext(undoContext);
        }
        for (IUndoableOperation operation : operationHistory.getRedoHistory(innerUndoContext)) {
          operation.addContext(undoContext);
        }
      }
    }

  }

  /**
   * This listens for platform changes.
   */
  protected IPlatformExtensionPointListener _platformListener = new IPlatformExtensionPointListener() {

    public void platformExtensionPointChanged(IPlatformExtensionPointDelta delta) {

      final List<Resource> deltaChangedResources = new UniqueEList<Resource>();

      final List<Resource> deltaRemovedResources = new UniqueEList<Resource>();

      // Check if a removed platform fcore is applicable
      for (IPlatformExtensionPoint extensionPoint : delta.getRemovedPlatformExtensionPoints(IPlatformFcore.class)) {
        IPlatformFcore fcore = (IPlatformFcore) extensionPoint;
        for (Resource resource : RESOURCE_MANAGER._observers.keySet()) {
          if (resource.getURI().equals(fcore.getURI())) {
            deltaRemovedResources.add(resource);
          }
        }
      }
      // Check if an added platform fcore is applicable
      // if a removed platform fcore is also detected it means a changed resource
      // eg: changed means target versus workspace fcore
      for (IPlatformExtensionPoint extensionPoint : delta.getAddedPlatformExtensionPoints(IPlatformFcore.class)) {
        IPlatformFcore fcore = (IPlatformFcore) extensionPoint;
        for (Resource resource : RESOURCE_MANAGER._observers.keySet()) {
          if (resource.getURI().equals(fcore.getURI()) && deltaRemovedResources.remove(resource) == true) {
            // Start Workaround PDE Bug 267954
            IPlatformFcore innerFcore = RESOURCE_MANAGER._fcores.get(resource);
            if (innerFcore.equals(fcore) == false) {
              deltaChangedResources.add(resource); // <- this statement is not a workaround bug
            } else {
              RESOURCE_MANAGER._fcores.put(resource, innerFcore);
            }
            // End Workaround PDE Bug 267954
          }
        }
      }

      if (deltaRemovedResources.isEmpty() == false) {
        for (Resource resource : deltaRemovedResources) {
          List<ResourceUser> users = RESOURCE_MANAGER._observers.get(resource);
          if (users == null) {
            continue;
          }
          boolean isDirty = false;
          for (ResourceUser user : users) {
            // This state is propagated, the first user is enough to check this state
            isDirty = user.isDirty();
            break;
          }
          for (ResourceListener l : RESOURCE_MANAGER._listeners) {
            l.resourceDeleted(resource);
          }
          // Non dirty editors should close themselves
          // The isDirty is processed against the resource (setTrackingModification)
          // We unload the resource once notified
          if (isDirty == false) {
            resource.unload();
            // Start Workaround PDE Bug 267954
            RESOURCE_MANAGER._fcores.remove(resource);
            // End Workaround PDE Bug 267954
          }
        }
      }

      if (deltaChangedResources.isEmpty() == false) {
        for (Resource resource : deltaChangedResources) {
          RESOURCE_MANAGER.reloadResource(resource);
        }
      }

    }

  };

  public EGFResourceLoadedListener() {
    EGFPlatformPlugin.getPlatformManager().addPlatformExtensionPointListener(_platformListener);
  }

  public boolean handleResourcePersisted(Resource resource) {
    for (ResourceListener l : RESOURCE_MANAGER._listeners) {
      l.internalUpdate(resource);
    }
    return true;
  }

  public boolean handleResourceMoved(Resource resource, URI newURI) {
    resource.unload();
    for (ResourceListener l : RESOURCE_MANAGER._listeners) {
      l.resourceMoved(resource, newURI);
    }
    return true;
  }

  public boolean handleResourceDeleted(Resource resource) {
    // ignore fcore resources, they are handled by _platformListener
    if (EGFCorePlugin.getPlatformFcore(resource) == null) {
      resource.unload();
      for (ResourceListener l : RESOURCE_MANAGER._listeners) {
        l.resourceDeleted(resource);
      }
    }
    return true;
  }

  public boolean handleResourceChanged(final Resource resource) {
    List<ResourceUser> users = RESOURCE_MANAGER._observers.get(resource);
    if (users == null) {
      RESOURCE_MANAGER.reloadResource(resource);
      return true;
    }
    boolean hasSavedResource = false;
    boolean isDirty = false;
    for (ResourceUser user : users) {
      // We need to deeply analyse users as anyone could have saved this resource if any
      hasSavedResource |= user.userHasSavedResource();
      // This state is propagated, the first user is enough to check this state
      isDirty |= user.isDirty();
    }
    if (hasSavedResource == false && isDirty == false) {
      RESOURCE_MANAGER.reloadResource(resource);
      return true;
    }
    if (hasSavedResource == false && isDirty) { // Give a chance to cancel dirty editors while reloading external changed resource
      final Boolean[] reload = new Boolean[] { Boolean.FALSE };
      Display.getDefault().syncExec(new Runnable() {
        public void run() {
          IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
          if (activeWorkbenchWindow != null) {
            reload[0] = MessageDialog.openQuestion(activeWorkbenchWindow.getShell(), CoreUIMessages.ResourceListener_reloadDialog_title, NLS.bind(CoreUIMessages.ResourceListener_reloadDialog_message, URI.decode(resource.getURI().toString())));
          }
        }
      });
      if (reload[0]) {
        RESOURCE_MANAGER.reloadResource(resource);
        return true;
      }
      for (ResourceListener l : RESOURCE_MANAGER._listeners) {
        l.externalUpdate(resource);
      }
      return true;
    }
    for (ResourceListener l : RESOURCE_MANAGER._listeners) {
      l.internalUpdate(resource);
    }
    return true;
  }

  public void dispose() {
    EGFPlatformPlugin.getPlatformManager().removePlatformExtensionPointListener(_platformListener);
  }

}
