/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.test;

import org.eclipse.egf.common.activator.EGFAbstractPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EGFCoreTestPlugin extends EGFAbstractPlugin {

  // The shared instance
  private static EGFCoreTestPlugin __plugin;

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.Plugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    __plugin = this;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
        super.stop(context);
    __plugin = null;
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static EGFCoreTestPlugin getDefault() {
    return __plugin;
  }

}
