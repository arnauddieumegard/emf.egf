/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain;

import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class Messages extends NLS {

    private static final String BUNDLE_NAME = "org.eclipse.egf.portfolio.genchain.genchainMessages";//$NON-NLS-1$
    public static String emfDocumentation_extension_label;
    public static String emfGeneration_extension_label;

    public static String Extension_load_error1;

    static {
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

}
