/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.fc.generator.java.contract.type;

import org.eclipse.egf.fc.generator.java.model.AbstractGenModelGenerator;
import org.eclipse.egf.model.contract.type.ClassTypeHolder;


/**
 * Provides an implementation to host the {@link AbstractGenModelGenerator} type.
 * @author fournier
 */
public class GenModelGeneratorTypeHolder extends ClassTypeHolder {
  
  /**
   * @see org.eclipse.egf.model.contract.type.ClassTypeHolder#getExpectedType()
   */
  @Override
  public Class<?> getExpectedType() {
    return AbstractGenModelGenerator.class;
  }
  
}
