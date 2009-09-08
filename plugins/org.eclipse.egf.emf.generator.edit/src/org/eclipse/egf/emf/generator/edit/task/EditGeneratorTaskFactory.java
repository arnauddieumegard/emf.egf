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
package org.eclipse.egf.emf.generator.edit.task;

import org.eclipse.egf.core.task.AbstractTask;
import org.eclipse.egf.core.task.ITaskFactory;
import org.eclipse.egf.emf.generator.edit.internal.task.EditGeneratorTask;


/**
 * Provides the task used to generate the EMF Edit plug-in.
 * @author Guillaume Brocard
 */
public class EditGeneratorTaskFactory implements ITaskFactory {

  /**
   * @see org.eclipse.egf.core.task.ITaskFactory#createTask()
   */
  public AbstractTask createTask() {
    return new EditGeneratorTask();
  }
}
