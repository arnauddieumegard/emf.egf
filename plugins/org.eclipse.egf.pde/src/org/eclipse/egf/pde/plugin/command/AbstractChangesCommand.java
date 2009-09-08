/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pde.plugin.command;

import org.apache.log4j.Logger;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * Base class to implement a command that performs plug-in changes either in the manifest file or in the plug-in file.<br>
 * @author Guillaume Brocard
 */
public abstract class AbstractChangesCommand implements IPluginChangesCommand {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AbstractChangesCommand.class.getPackage().getName());
  
  /**
   * Plug-in model that this command is performed against.
   */
  private IPluginModelBase _pluginModelBase;

  /**
   * @see org.eclipse.egf.pde.plugin.command.IPluginChangesCommand#setPluginModelBase(org.eclipse.pde.core.plugin.IPluginModelBase)
   */
  public void setPluginModelBase(IPluginModelBase pluginModel_p) {
    _pluginModelBase = pluginModel_p;
  }

  /**
   * Get the plug-in model that this command is performed against.
   * @return the pluginModelBase
   */
  protected IPluginModelBase getPluginModelBase() {
    return _pluginModelBase;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.IPluginChangesCommand#execute()
   */
  public void execute() {
    // Check Precondition.
    if (_pluginModelBase == null) {
      StringBuilder loggerMessage = new StringBuilder("AbstractChangesCommand.execute(..) _ "); //$NON-NLS-1$
      loggerMessage.append("PluginModelBase object must not be null"); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
      return;
    }
  }
  
}
