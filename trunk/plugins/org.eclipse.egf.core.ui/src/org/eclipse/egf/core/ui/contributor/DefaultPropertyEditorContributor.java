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

package org.eclipse.egf.core.ui.contributor;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class DefaultPropertyEditorContributor implements PropertyEditorContributor {

    protected boolean checkFeature(Object object, IItemPropertyDescriptor descriptor, EStructuralFeature expectedFeature) {
        return descriptor.getFeature(object).equals(expectedFeature);
    }

    protected ILabelProvider getLabelProvider(Object object, IItemPropertyDescriptor descriptor) {
        final IItemLabelProvider itemLabelProvider = descriptor.getLabelProvider(object);
        return new LabelProvider() {

            @Override
            public String getText(Object innerObject) {
                return itemLabelProvider.getText(innerObject);
            }

            @Override
            public Image getImage(Object innerObject) {
                return ExtendedImageRegistry.getInstance().getImage(itemLabelProvider.getImage(innerObject));
            }
        };
    }

}
