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
package org.eclipse.egf.core.log4j;

import java.util.Properties;

/**
 * Allow to add or modify log4j configuration.
 * @author Guillaume Brocard
 */
public interface ILog4jConfigurer {
  /**
   * Handle Log4J configuration.
   * @param log4jConfiguration_p
   * @return
   */
  public void handleConfiguration(Properties log4jConfiguration_p);
}
