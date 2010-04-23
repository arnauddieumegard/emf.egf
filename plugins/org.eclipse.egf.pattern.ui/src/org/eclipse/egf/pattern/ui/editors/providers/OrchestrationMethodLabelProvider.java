/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.providers;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class OrchestrationMethodLabelProvider extends MethodLabelProvider {
    public String getColumnText(Object element, int columnIndex) {
        if (element instanceof PatternMethod) {
            PatternMethod patternMethod = (PatternMethod) element;
            Pattern pattern = patternMethod.getPattern();
            String patternName = pattern == null ? "" : pattern.getName();
            return patternMethod.getName() + " [" + patternName + "]";
        }
        return "";
    }
}