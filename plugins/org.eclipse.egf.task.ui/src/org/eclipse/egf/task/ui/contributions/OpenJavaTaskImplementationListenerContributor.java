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

package org.eclipse.egf.task.ui.contributions;

import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.task.EGFTaskPlugin;

/**
 * @author Xavier Maysonnave
 * 
 */
public class OpenJavaTaskImplementationListenerContributor extends TaskListenerContributor {

    @Override
    protected void doDoubleClick(Task task) {
        new OpenJavaTaskImplementationMenuContributor.OpenAction(task).run();
    }

    @Override
    protected String getExpectedKind() {

        return EGFTaskPlugin.KIND_JAVA;
    }

}
