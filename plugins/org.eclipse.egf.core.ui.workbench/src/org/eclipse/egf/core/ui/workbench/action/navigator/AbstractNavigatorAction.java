/**
 *  Copyright (c) 2007, 2009 La Carotte Et Le Baton.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      La Carotte Et Le Baton - initial API and implementation
 */
package org.eclipse.egf.core.ui.workbench.action.navigator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;

/**
 * Base class to implement action located in the context menu of a tree viewer based on the {@link CommonNavigator}.
 * @author fournier
 */
public abstract class AbstractNavigatorAction extends Action {
  
  /**
   * Selection provider.
   */
  private ISelectionProvider _provider;
  
  /**
   * Shell.
   */
  private Shell _shell;

  /**
   * Constructor..
   * @param selectionProvider_p
   */
  protected AbstractNavigatorAction(ISelectionProvider selectionProvider_p) {
    _provider = selectionProvider_p;
  }

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   */
  protected AbstractNavigatorAction(Shell shell_p, ISelectionProvider selectionProvider_p) {
    this(selectionProvider_p);
    _shell = shell_p;
  }

  /**
   * Get the current selected object
   * @param objectType_p the object type that the selection must be an instance of
   */
  protected Object getSelection(Class<?> objectType_p) {
    Object selectedObject = null;
    // Get selected objects if any.
    IStructuredSelection selectedObjects = (IStructuredSelection) _provider.getSelection();
    // If not empty, get the first selected object.
    if (!selectedObjects.isEmpty()) {
      Object firstElement = selectedObjects.getFirstElement();
      if (selectedObjects.size() == 1 && objectType_p.isInstance(firstElement)) {
        selectedObject = firstElement;
      }
    }
    return selectedObject;
  }

  /**
   * Get the shell
   * @return the shell or null if not set with the constructor.
   */
  protected Shell getShell() {
    return _shell;
  }

  /**
   * Returns whether this action is compatible with current selection.
   * @return
   */
  public boolean isSelectionCompatible() {
    boolean isEnabled = false;
    // Check selected element has a type that matches the expected one.
    Object element = getSelection(getModelElementClass());
    if (element != null) {
      setSelectedElement(element);
      isEnabled = true;
    }
    return isEnabled;
  }

  /**
   * Get the model element class for which this action is enabled for.
   * @return
   */
  protected abstract Class<?> getModelElementClass();

  /**
   * Set given object as the selected object.
   * @param object_p
   */
  protected abstract void setSelectedElement(Object object_p);

  /**
   * Get the shared images.
   * @return
   */
  protected ISharedImages getSharedImages() {
    ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
    return sharedImages;
  }

  /**
   * Get the selection provider.
   * @return the provider
   */
  protected ISelectionProvider getSelectionProvider() {
    return _provider;
  }
  
}
