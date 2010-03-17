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
 */

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Xavier Maysonnave
 * 
 */
public class URIMenuContributor extends EObjectMenuContributor {

  public static final String OPEN_URI_ACTION_ID = "open-uri"; //$NON-NLS-1$  

  private final OpenAction _openAction = new OpenAction(ModelEditorMessages.URIMenuContributor_openAction_label, OPEN_URI_ACTION_ID) {
    @Override
    public boolean isEnabled() {
      return true;
    }

    @Override
    protected EObject getEObject() {
      if (selection == null) {
        return null;
      }
      IStructuredSelection sselection = (IStructuredSelection) selection;
      if (sselection.size() != 1) {
        return null;
      }
      Object object = sselection.getFirstElement();
      if (object instanceof DomainURI) {
        return (DomainURI) object;
      } else if (object instanceof TypeDomainURI) {
        return (TypeDomainURI) object;
      }
      return null;
    }

    @Override
    protected URI getURI(EObject eObject) {
      if (eObject instanceof DomainURI) {
        DomainURI domainURI = (DomainURI) eObject;
        return domainURI.getUri();
      } else if (eObject instanceof TypeDomainURI) {
        TypeDomainURI typeDomainURI = (TypeDomainURI) eObject;
        return typeDomainURI.getValue();
      }
      return null;
    }
  };

  @Override
  public void menuAboutToShow(IMenuManager menuManager) {
    IStructuredSelection selection2 = (IStructuredSelection) selection;
    if (selection2.size() == 1) {
      if (selection2.getFirstElement() instanceof DomainURI || selection2.getFirstElement() instanceof TypeDomainURI) {
        _openAction.setEnabled(_openAction.isEnabled());
        menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, _openAction);
      }
    }
  }

}
