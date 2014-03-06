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

package org.eclipse.egf.pattern.execution;

/**
 * This class is used to holder an index value across statements in Runnable
 * structures.
 * 
 * @author Thomas Guiu
 * 
 */
public class IndexValue {
    public IndexValue(int value) {
        super();
        this.value = value;
    }

    public int value;
}
