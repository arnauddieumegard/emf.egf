/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.contributor;

import java.util.List;

import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IMenuEditorActionBarContributor extends IEditorActionBarContributor {

    public void removeEditorMenuContributors(List<EditorMenuContributor> menus);

    public IWorkbenchPage getPage();

}
