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
package org.eclipse.egf.task.ui;

import org.eclipse.egf.common.ui.activator.EGFAbstractUIPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.osgi.framework.BundleContext;

/**
 * @author Thomas Guiu
 * 
 */
public class EGFTaskUIPlugin extends EGFAbstractUIPlugin {

    // The shared instance
    private static EGFTaskUIPlugin __plugin;

    /**
     * 
     * Returns the currently active window for this workbench (if any). Returns
     * <code>null</code> if there is no active workbench window. Returns
     * <code>null</code> if called from a non-UI thread.
     * 
     * @return the active workbench window, or <code>null</code> if there is
     *         no active workbench window or if called from a non-UI thread
     */
    public static IWorkbenchWindow getActiveWorkbenchWindow() {
        return getDefault().getWorkbench().getActiveWorkbenchWindow();
    }

    /**
     * Returns the currently active shell for this workbench (if any).
     * 
     * @return the active workbench shell.
     */
    public static Shell getActiveWorkbenchShell() {
        IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window == null) {
            IWorkbenchWindow[] windows = getDefault().getWorkbench().getWorkbenchWindows();
            if (windows.length > 0) {
                return windows[0].getShell();
            }
        } else {
            return window.getShell();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        __plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
    public static EGFTaskUIPlugin getDefault() {
        return __plugin;
    }

}
