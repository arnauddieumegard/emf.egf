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
package org.eclipse.egf.common.ui.toolkit.fields;

import org.eclipse.egf.common.ui.toolkit.validators.IValidator;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;


/**
 * The field editor interface. 
 * This interface is used to make field editors services public, uniform and extends them.
 * @author D. GATIBELZA
 */
public interface IFieldEditor {
  
  /**
   * Gets the field name.
   * @return The name of this field.
   */
  public String getFieldName();

  /**
   * Gets the label control.
   * @return The label control or <code>null</code> if it doesn't exist.
   */
  public Label getLabel();

  /**
   * Gets the value control.
   * @return The value control or <code>null</code> if it doesn't exist.
   */
  public Control getValueControl();

  /**
   * Gets the helper control.
   * @return The helper control or <code>null</code> if it doesn't exist.
   */
  public Control getHelperControl();

  /**
   * Returns the error message that will be displayed when an error occurs.
   * @return The error message, or <code>null</code> if none.
   */
  public String getErrorMessage();

  /**
   * Sets the field validator.
   * @param validator_p The validator.
   */
  public void setValidator(IValidator validator_p);

  /**
   * Gets the field validator.
   * @return The validator.
   */
  public IValidator getValidator();

  /**
   * Returns whether this field contains a valid value.
   * @return <code>True</code> if the field value is valid else <code>false</code>.
   */
  public boolean isValid();

  /**
   * Sets whether or not the value control in the field is enabled.
   * @param enabled_p <code>True</code> to enable else <code>false</code>.
   */
  public void setValueEnabled(boolean enabled_p);

  /**
   * Sets whether or not the helper control in the field is enabled.
   * @param enabled_p <code>True</code> to enable else <code>false</code>.
   */
  public void setHelperEnabled(boolean enabled_p);

  /**
   * Checks if the value control is enabled.
   * @return <code>True</code> if the value control is enabled else <code>false</code>.
   */
  public boolean isValueEnabled();

  /**
   * Checks if the helper control is enabled.
   * @return <code>True</code> if the value control is enabled else <code>false</code>.
   */
  public boolean isHelperEnabled();

  /**
   * Sets the page to be the receiver.
   * @param page_p The dialog page.
   */
  public void setFieldPage(DialogPage page_p);

  /**
   * Gets the page that the field sends messages to.
   * @return The dialog page.
   */
  public DialogPage getFieldPage();

  /**
   * Sets the focus.
   */
  public void setFocus();

  /**
   * Returns if the current field editor is focused.
   * @return <code>True</code> if the fiedl editor is focused else <code>false</code>.
   */
  public boolean isFocused();

  /**
   * Layouts the current field editor with the default layout.
   */
  public void defaultLayout();

  /**
   * Layouts the current field editor into the specified number of columns.
   * @param numColumns_p The number of columns.
   */
  public void layout(int numColumns_p);
  
}
