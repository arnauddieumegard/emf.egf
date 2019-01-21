/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.java.extension;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.common.java.BaseJavaPatternInitializer;
import org.eclipse.egf.pattern.java.Activator;
import org.eclipse.egf.pattern.java.JavaPreferences;
import org.eclipse.egf.pattern.templates.SimpleEngine;
import org.eclipse.egf.pattern.templates.TemplateEngine;

/**
 * @author Thomas Guiu
 * 
 */
public class JavaPatternInitializer extends BaseJavaPatternInitializer {

    public JavaPatternInitializer(IProject project, Pattern pattern, TemplateEngine engine) {
        super(project, pattern, engine);
    }

    public JavaPatternInitializer(IProject project, Pattern pattern) {
        super(project, pattern, new SimpleEngine(Activator.getDefault().getPluginID(), project, JavaPreferences.getTemplateFileExtension()));
    }
}
