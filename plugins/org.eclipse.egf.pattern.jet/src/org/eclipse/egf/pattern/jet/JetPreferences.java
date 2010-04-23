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

package org.eclipse.egf.pattern.jet;

/**
 * @author Guiu
 * 
 */
public class JetPreferences {

    // TODO get the encoding value from global preferences
    public static String getEncoding() {
        return "UTF8";
    }

    public static String getTemplateFileExtension() {
        return "jet_template";
    }

    private JetPreferences() {
        super();

    }

}