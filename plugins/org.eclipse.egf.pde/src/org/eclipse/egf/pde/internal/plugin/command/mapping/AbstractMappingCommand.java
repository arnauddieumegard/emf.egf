/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pde.internal.plugin.command.mapping;

import org.eclipse.egf.core.extensionpoint.IMappingConstants;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;


/**
 * Base class to implement command that deal with <code>mapping</code> extension-point.
 * @author Guillaume Brocard
 */
public abstract class AbstractMappingCommand extends AbstractExtensionChangesCommand {
  /**
   * Mapping id value.
   */
  private String _mappingId;

  /**
   * Constructor.
   * @param mappingId_p
   */
  protected AbstractMappingCommand(String mappingId_p) {
    _mappingId = mappingId_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  protected String getExtensionChildName() {
    return IMappingConstants.MAPPING_EXTENSION_CHILD;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IMappingConstants.FULLY_QUALIFIED_EXTENSION_POINT_ID;
  }

  /**
   * Get the mapping id.
   * @return the mappingId
   */
  protected String getMappingId() {
    return _mappingId;
  }
}