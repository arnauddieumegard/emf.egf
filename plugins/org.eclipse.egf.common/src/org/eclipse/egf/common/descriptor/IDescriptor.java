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
package org.eclipse.egf.common.descriptor;

import java.util.List;

/**
 * Base interface to implement a model object descriptor.<br>
 * Each model object property can be get through {@link #getValue(String)} method.
 * @author Guillaume Brocard
 */
public interface IDescriptor {
  
  /**
   * Return the value set for the specified property name.
   * @param propertyName_p the property name must be unique.
   * @return the object value or null if not found.
   */
  public Object getValue(String propertyName_p);
  

  /**
   * Get parent descriptor, if it was set by the reading algorithm.
   * @return null if this information is not available, or if it has none.
   */
  public IDescriptor getParent();
  

  /**
   * Get children descriptors, if any.
   * @return
   */
  public List<IDescriptor> getChildren();
  
}
