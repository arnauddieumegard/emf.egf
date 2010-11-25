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

import org.eclipse.egf.core.ui.contributor.EditorListenerContributor;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.types.TypeURI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author Thomas Guiu
 * 
 */
public class OpenURIListenerContributor extends EditorListenerContributor {

    @Override
    public void addListener(final IWorkbenchPage page, StructuredViewer viewer) {
        if (page == null || viewer == null) {
            return;
        }
        IDoubleClickListener listener = new IDoubleClickListener() {

            public void doubleClick(DoubleClickEvent event) {
                if (event.getSelection().isEmpty()) {
                    return;
                }
                final Object object = ((IStructuredSelection) event.getSelection()).getFirstElement();
                if (object instanceof EMFDomain || object instanceof TypeDomain || object instanceof TypeURI) {
                    OpenURIMenuContributor menu = new OpenURIMenuContributor();
                    Action openAction = menu.new URIOpenAction() {

                        @Override
                        protected EObject getEObject() {
                            return (EObject) object;
                        }

                    };
                    openAction.run();
                }
            }
        };
        viewer.addDoubleClickListener(listener);
        _listeners.put(viewer, listener);
    }

}
