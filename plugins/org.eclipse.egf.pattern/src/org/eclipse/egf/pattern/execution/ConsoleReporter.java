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

package org.eclipse.egf.pattern.execution;

import java.util.Map;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

/**
 * @author Thomas Guiu
 * 
 */
public class ConsoleReporter implements PatternExecutionReporter {

    public void executionFinished(String output, PatternContext context) {
        if (output != null && output.trim().length() != 0) {
            System.out.println(output);
            EGFCorePlugin.getDefault().logInfo(output);
        }
    }

    public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
        if (output != null && output.trim().length() != 0) {
            System.out.println(output);
            EGFCorePlugin.getDefault().logInfo(output);
        }
    }

}
