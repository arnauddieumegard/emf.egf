/**
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
 */
package org.eclipse.egf.model.pattern;

/**
 * @author Guiu
 * 
 */
public class PatternException extends Exception {

    private static final long serialVersionUID = 8116611457631229391L;

    /**
     * @param message
     * @param cause
     */
    public PatternException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public PatternException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public PatternException(Throwable cause) {
        super(cause);
    }

}
