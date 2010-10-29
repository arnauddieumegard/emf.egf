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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.core.ui.dialogs.SubTypeSelectionExtension;
import org.eclipse.egf.core.ui.dialogs.TypeSelectionDialog;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AbstractTypeEditorContributor extends DefaultPropertyEditorContributor {

    public CellEditor createPropertyEditor(final Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final String value = getValue(object);

        final String filteredType = getFilteredType(object);

        final Resource resource = ((EObject) object).eResource();

        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                // IJavaProject lookup
                IJavaProject javaProject = EMFHelper.getJavaProject(resource);
                if (javaProject == null) {
                    return value;
                }
                // IType Lookup
                IType type = null;
                try {
                    type = javaProject.findType(filteredType, new NullProgressMonitor());
                } catch (CoreException ce) {
                    ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), ce);
                    return value;
                }
                if (type == null) {
                    MessageDialog.openWarning(cellEditorWindow.getShell(), CoreUIMessages._UI_TypeSelection, NLS.bind(ModelEditorMessages.AbstractTypeEditorContributor_unable_to_locate_type, filteredType));
                    return value;
                }
                // Dialog
                try {
                    TypeSelectionDialog dialog = new TypeSelectionDialog(composite.getShell(), false, PlatformUI.getWorkbench().getProgressService(), javaProject, IJavaSearchConstants.CLASS_AND_INTERFACE, new SubTypeSelectionExtension(type));
                    dialog.setTitle(NLS.bind(CoreUIMessages._UI_SelectType, filteredType));
                    if (dialog.open() != IDialogConstants.OK_ID) {
                        return value;
                    }
                    Object innerResult = dialog.getFirstResult();
                    if (innerResult instanceof IType) {
                        return ((IType) innerResult).getFullyQualifiedName();
                    }
                } catch (Throwable t) {
                    ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), t);
                } finally {
                    try {
                        javaProject.close();
                    } catch (JavaModelException jme) {
                        // Ignore
                    }
                }
                return value;
            }
        };
    }

    protected abstract String getFilteredType(Object object);

    protected abstract String getValue(Object object);

}
