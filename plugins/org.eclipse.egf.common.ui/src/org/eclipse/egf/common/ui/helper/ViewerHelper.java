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
package org.eclipse.egf.common.ui.helper;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Control;

/**
 * @author Guillaume Brocard
 */
public class ViewerHelper {
  /**
   * Refresh in an efficient way the specified viewer completely with information freshly obtained from this viewer's model.
   * @param viewer_p
   */
  public static void refresh(StructuredViewer viewer_p) {
    refresh(viewer_p, true);
  }

  /**
   * Refresh in an efficient way the specified viewer completely with information freshly obtained from this viewer's model.<br>
   * If <code>updateLabels_p</code> is <code>true</code> then labels for otherwise unaffected elements are updated as well.<br>
   * Otherwise, it assumes labels for existing elements are unchanged, and labels are only obtained as needed (for example, for new elements).
   * <p>
   * Calling <code>refresh(viewer, true)</code> has the same effect as <code>refresh(viewer)</code>.
   * <p>
   * Note that the implementation may still obtain labels for existing elements even if <code>updateLabels</code> is false. The intent is simply to allow
   * optimization where possible.
   * @param updateLabels <code>true</code> to update labels for existing elements, <code>false</code> to only update labels as needed, assuming that labels
   *          for existing elements are unchanged.
   * @param viewer_p
   * @param updateLabels_p
   */
  public static void refresh(StructuredViewer viewer_p, boolean updateLabels_p) {
    // Precondition.
    if (null == viewer_p) {
      return;
    }
    // Get the related control.
    Control control = viewer_p.getControl();
    try {
      // Switch off redraw
      control.setRedraw(false);
      // Refresh it...
      viewer_p.refresh(updateLabels_p);
    } finally {
      // Finally, redraw again.
      control.setRedraw(true);
    }
  }
}
