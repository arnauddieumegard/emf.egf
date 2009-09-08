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
package org.eclipse.egf.common.ui.toolkit.viewers;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The message handler for the viewers package.
 * @author D. GATIBELZA
 */
public class Messages {
  // The bundle name.
  private static final String BUNDLE_NAME = "org.eclipse.egf.common.ui.toolkit.viewers.messages"; //$NON-NLS-1$
  // The resource bundle.
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

  // Constructs the message handler.
  private Messages() {
    // Do nothing.
  }

  /**
   * Gets the string corresponding from the specified key.
   * @param key_p The key.
   * @return The string corresponding to the given key..
   */
  public static String getString(String key_p) {
    try {
      return RESOURCE_BUNDLE.getString(key_p);
    } catch (MissingResourceException e) {
      return '!' + key_p + '!';
    }
  }
}
