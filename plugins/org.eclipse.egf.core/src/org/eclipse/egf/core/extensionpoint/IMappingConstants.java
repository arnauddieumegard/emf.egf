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
package org.eclipse.egf.core.extensionpoint;

import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.CoreActivator;


/**
 * Defines all constants related to a mapping into extension-point declaration.
 * @author Guillaume Brocard
 */
public interface IMappingConstants {
  /**
   * Define a constant for the mapping extension-point id.
   */
  static final String MAPPING_EXTENSION_POINT_ID = "mapping"; //$NON-NLS-1$
  /**
   * Define a constant for the mapping extension-point id as a fully qualified id.
   */
  static final String FULLY_QUALIFIED_EXTENSION_POINT_ID =
                                                           ExtensionPointHelper.getExtensionPointId(CoreActivator.getDefault().getPluginID(),
                                                                                                    MAPPING_EXTENSION_POINT_ID);
  /**
   * Define a constant for the mapping extension-point child.
   */
  static final String MAPPING_EXTENSION_CHILD = MAPPING_EXTENSION_POINT_ID;
  /**
   * Define a constant for the 'path' attribute.
   */
  static final String MAPPING_ATT_PATH = "path"; //$NON-NLS-1$ 
  /**
   * Define a constant for the 'source' attribute.
   */
  static final String MAPPING_ATT_SOURCE = "assetIdAsSource"; //$NON-NLS-1$ 
  /**
   * Define a constant for the 'target' attribute.
   */
  static final String MAPPING_ATT_TARGET = "assetIdAsTarget"; //$NON-NLS-1$ 
}