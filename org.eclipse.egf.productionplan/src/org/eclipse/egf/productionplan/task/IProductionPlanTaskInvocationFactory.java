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
package org.eclipse.egf.productionplan.task;

import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.invocation.IProductionInvocation;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.core.task.IPlatformTask;
import org.eclipse.egf.model.productionplan.Task;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProductionPlanTaskInvocationFactory {

  public IProductionInvocation createInvocation(ProjectBundleSession projectBundleSession, IProductionContext<Task> context, IPlatformTask platformTask);

  public IProductionInvocation createInvocation(ProjectBundleSession projectBundleSession, IProductionContext<Task> context, String taskId);

}
