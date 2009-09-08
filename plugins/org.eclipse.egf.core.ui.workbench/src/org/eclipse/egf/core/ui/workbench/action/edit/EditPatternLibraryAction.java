/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench.action.edit;

import org.eclipse.egf.core.ui.wizard.PatternLibraryWizard;
import org.eclipse.egf.core.ui.wizard.RootPatternLibraryWizard;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternViewpoint;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;


/**
 * Open a wizard to edit the {@link PatternLibrary} model element.
 * @author Guillaume Brocard
 */
public class EditPatternLibraryAction extends EditModelElementAction {

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  public EditPatternLibraryAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractModelElementAction#getWizardFor(org.eclipse.egf.model.NamedModelElementWithId)
   */
  @Override
  protected Wizard getWizardFor(NamedModelElementWithId modelElement_p) {
    Wizard result = null;
    // Get the right wizard depending on the model element used as parent.
    EObject parent = modelElement_p.eContainer();
    // If the parent is the pattern viewpoint, given library is a 'root' pattern library.
    // A 'root' pattern library is a library which has a pattern viewpoint as parent.
    if (parent instanceof PatternViewpoint) {
      // Open the appropriate wizard when parent is a pattern viewpoint.
      result = new RootPatternLibraryWizard(parent, modelElement_p, isReadOnly(), false);
    } else if (parent instanceof PatternLibrary) {
      // Open the appropriate wizard when parent is also a pattern library.
      result = new PatternLibraryWizard(parent, modelElement_p, isReadOnly(), false);
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.action.navigator.AbstractNavigatorAction#getModelElementClass()
   */
  @Override
  protected Class<?> getModelElementClass() {
    return PatternLibrary.class;
  }
}
