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
package org.eclipse.egf.emf.pattern.base;

import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.Monitor;

/**
 * @author Matthieu Helleboid
 * 
 */
public class StringJETEmitter extends JETEmitter {

    protected String output;

    public StringJETEmitter(String output) {
        super(null);
        this.output = output;
    }

    @Override
    public String generate(Monitor progressMonitor, Object[] arguments, String lineDelimiter) throws JETException {
        return output;
    }

}