/**
 * Copyright (c) 2005-2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 */
package org.eclipse.egf.common.ui.toolkit.fields;

import org.apache.log4j.Logger;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * The custom string field editor. 
 * The custom string field editor supports the text style.
 */
public class CStringFieldEditor extends AbstractFieldEditor {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(CStringFieldEditor.class.getPackage().getName());
  
  // Cached valid state.
  private boolean _isValid = false;

  // Old text value.
  private String _oldValue = null;

  // Width of text field in characters; initially unlimited.
  private int _widthInChars = UNLIMITED;

  // Text limit of text field in characters; initially unlimited.
  private int _textLimit = UNLIMITED;

  // Indicates whether the empty string is legal.
  private boolean _emptyStringAllowed = true;

  // The validation strategy.
  private int _validateStrategy = VALIDATE_ON_KEY_STROKE;

  /**
   * The text field, or <code>null</code> if none.
   */
  protected Text _textField;

  /**
   * Validation strategy constant (value <code>0</code>) indicating that the editor should perform validation after every key stroke (when key is released).
   * @see #setValidateStrategy
   */
  public static final int VALIDATE_ON_KEY_STROKE = 0;
  
  /**
   * Validation strategy constant (value <code>1</code>) indicating that the editor should perform validation only when the text widget loses focus.
   * @see #setValidateStrategy
   */
  public static final int VALIDATE_ON_FOCUS_LOST = 1;
  
  /**
   * Validation strategy constant (value <code>2</code>) indicating that the editor should perform validation after every change.
   * @see #setValidateStrategy
   */
  public static final int VALIDATE_ON_MODIFICATION = 2;

  /**
   * Text limit constant (value <code>-1</code>) indicating unlimited text limit and width.
   */
  public static int UNLIMITED = -1;

  /**
   * Creates a string field editor of unlimited width which supports style. Use the method <code>setTextLimit</code> to limit the text. By default the style
   * is {@value SWT#SINGLE}|{@value SWT#BORDER}.
   * @param name_p The name of field this field editor works on.
   * @param label_p The label text of the field editor
   * @param parent_p The parent of the field editor's control.
   */
  public CStringFieldEditor(String name_p, String label_p, Composite parent_p) {
    this(name_p, label_p, UNLIMITED, parent_p, SWT.SINGLE | SWT.BORDER);
  }

  /**
   * Creates a string field editor of unlimited width which supports style. Use the method <code>setTextLimit</code> to limit the text.
   * @param name_p The name of field this field editor works on.
   * @param label_p The label text of the field editor
   * @param parent_p The parent of the field editor's control
   * @param valueStyle_p The text style.
   * @see Text#Text(Composite, int)
   */
  public CStringFieldEditor(String name_p, String label_p, Composite parent_p, int valueStyle_p) {
    this(name_p, label_p, UNLIMITED, parent_p, valueStyle_p);
  }

  /**
   * Creates a string field editor which supports style. Use the method <code>setTextLimit</code> to limit the text.
   * @param name_p The name of field this field editor works on.
   * @param label_p The label text of the field editor
   * @param width_p The width of the text input field in characters, or <code>UNLIMITED</code> for no limit
   * @param parent_p The parent of the field editor's control
   * @param valueStyle_p The text style.
   * @see Text#Text(Composite, int)
   */
  public CStringFieldEditor(String name_p, String label_p, int width_p, Composite parent_p, int valueStyle_p) {
    this(name_p, label_p, width_p, VALIDATE_ON_KEY_STROKE, parent_p, valueStyle_p);
  }

  /**
   * Creates a string field editor which supports style. Use the method <code>setTextLimit</code> to limit the text.
   * @param name_p The name of field this field editor works on.
   * @param label_p The label text of the field editor
   * @param width_p The width of the text input field in characters, or <code>UNLIMITED</code> for no limit
   * @param strategy_p either <code>VALIDATE_ON_KEY_STROKE</code> to perform on the fly checking (the default), or <code>VALIDATE_ON_FOCUS_LOST</code> to
   *          perform validation only after the text has been typed in
   * @param parent_p The parent of the field editor's control
   * @param valueStyle_p The text style.
   * @see Text#Text(Composite, int)
   */
  public CStringFieldEditor(String name_p, String label_p, int width_p, int strategy_p, Composite parent_p, int valueStyle_p) {
    init(name_p, label_p, SWT.LEFT, valueStyle_p);
    _widthInChars = width_p;
    setValidateStrategy(strategy_p);
    _isValid = false;
    setErrorMessage(JFaceResources.getString("StringFieldEditor.errorMessage"));//$NON-NLS-1$
    createControl(parent_p);
  }

  /**
   * @see FieldEditor#adjustForNumColumns(int)
   */
  @Override
  protected void adjustForNumColumns(int numColumns_p) {
    GridData gd = (GridData) _textField.getLayoutData();
    gd.horizontalSpan = numColumns_p - 1;
    // We only grab excess space if we have to
    // If another field editor has more columns then
    // we assume it is setting the width.
    gd.grabExcessHorizontalSpace = gd.horizontalSpan == 1;
  }

  /**
   * Checks whether the text input field contains a valid value or not.
   * @return <code>true</code> if the field value is valid, and <code>false</code> if invalid
   */
  protected boolean checkState() {
    boolean result = false;
    // Keep the previous valid state
    boolean wasValid = _isValid;
    if (_emptyStringAllowed) {
      result = true;
    }
    if (_textField == null) {
      result = false;
    }

    String txt = _textField.getText();
    result = (txt.trim().length() > 0) || _emptyStringAllowed;

    // Call hook for subclasses
    result = result && doCheckState();
    // Clear error message only if this field editor was not valid and it gets valid now.
    if (!wasValid && result) {
      clearErrorMessage();
    }
    // If this field editor is not valid, show the related error message.
    else if (!result) {
      showErrorMessage(getErrorMessage());
    }
    return result;
  }

  /**
   * Fills this field editor's basic controls into the given parent.
   * <p>
   * The string field implementation of this <code>FieldEditor</code> framework method contributes the text field. Subclasses may override but must call
   * <code>super.doFillIntoGrid</code>.
   * </p>
   */
  @Override
  protected void doFillIntoGrid(Composite parent_p, int numColumns_p) {
    getLabelControl(parent_p);
    _textField = getTextControl(parent_p);
    GridData gd = new GridData();
    gd.horizontalSpan = numColumns_p - 1;
    if (_widthInChars != UNLIMITED) {
      GC gc = new GC(_textField);
      try {
        Point extent = gc.textExtent("X");//$NON-NLS-1$
        gd.widthHint = _widthInChars * extent.x;
      } finally {
        gc.dispose();
      }
    } else {
      gd.horizontalAlignment = SWT.FILL;
      gd.grabExcessHorizontalSpace = true;
    }

    if (0 != (_textField.getStyle() & SWT.MULTI)) {
      gd.verticalAlignment = SWT.FILL;
      gd.verticalSpan = 2;
      gd.grabExcessVerticalSpace = true;
    }
    _textField.setLayoutData(gd);
  }

  /**
   * @see FieldEditor#doLoad()
   */
  @Override
  protected void doLoad() {
    if (_textField != null) {
      String value = getPreferenceStore().getString(getPreferenceName());
      _textField.setText(null == value ? "" : value); //$NON-NLS-1$
      _oldValue = value;
    }
  }

  /**
   * @see FieldEditor#doLoadDefault()
   */
  @Override
  protected void doLoadDefault() {
    if (_textField != null) {
      String value = getPreferenceStore().getDefaultString(getPreferenceName());
      _textField.setText(value);
    }
    valueChanged();
  }

  /**
   * @see FieldEditor#doStore()
   */
  @Override
  protected void doStore() {
    getPreferenceStore().setValue(getPreferenceName(), _textField.getText());
  }

  /**
   * @see FieldEditor#getNumberOfControls()
   */
  @Override
  public int getNumberOfControls() {
    return 2;
  }

  /**
   * Returns the field editor's value.
   * @return the current value
   */
  public String getStringValue() {
    if (_textField != null) {
      return _textField.getText();
    }
    return getPreferenceStore().getString(getPreferenceName());
  }

  /**
   * Returns this field editor's text control.
   * @return the text control, or <code>null</code> if no text field is created yet
   */
  public Text getTextControl() {
    return _textField;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.AbstractFieldEditor#checkValueStyle(int)
   */
  @Override
  protected int checkValueStyle(int valueStyle_p) {
    int newStyle = valueStyle_p;

    // Force BORDER style, if not specified.
    if (0 == (SWT.BORDER & valueStyle_p)) {
      newStyle |= SWT.BORDER;
    }

    // Force SINGLE style (single line), if only BORDER style is applied.
    if (SWT.BORDER == _valueStyle) {
      newStyle |= SWT.SINGLE;
    }
    return newStyle;
  }

  /**
   * Returns this field editor's text control.
   * <p>
   * The control is created if it does not yet exist
   * </p>
   * @param parent_p The parent
   * @return the text control
   */
  protected Text getTextControl(Composite parent_p) {
    if (_textField == null) {
      _textField = doTextControl(parent_p, _valueStyle);
      _textField.setFont(parent_p.getFont());
      switch (_validateStrategy) {
        case VALIDATE_ON_KEY_STROKE:
          _textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent event_p) {
              valueChanged();
            }
          });
        break;
        case VALIDATE_ON_MODIFICATION:
          _textField.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent event_p) {
              valueChanged();
            }
          });
        break;
        case VALIDATE_ON_FOCUS_LOST:
          _textField.addKeyListener(new KeyAdapter() {
            @SuppressWarnings("synthetic-access")
            @Override
            public void keyPressed(KeyEvent event_p) {
              clearErrorMessage();
            }
          });
          _textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent event_p) {
              refreshValidState();
            }

            @SuppressWarnings("synthetic-access")
            @Override
            public void focusLost(FocusEvent event_p) {
              valueChanged();
              clearErrorMessage();
            }
          });
        break;
        default:
          StringBuilder loggerMessage = new StringBuilder("CStringFieldEditor.getTextControl(..) _ "); //$NON-NLS-1$
          loggerMessage.append("Unknown validate strategy");//$NON-NLS-1$
          __logger.error(loggerMessage.toString());
      }
      _textField.addDisposeListener(new DisposeListener() {
        public void widgetDisposed(DisposeEvent event_p) {
          _textField = null;
        }
      });
      if (_textLimit > 0) {// Only set limits above 0 - see SWT spec
        _textField.setTextLimit(_textLimit);
      }
    } else {
      checkParent(_textField, parent_p);
    }
    return _textField;
  }

  /**
   * Does the text control.
   * @param parent_p The parent composite.
   * @param style_p The text style.
   * @return The text control.
   */
  protected Text doTextControl(Composite parent_p, int style_p) {
    return new Text(parent_p, style_p);
  }

  /**
   * Returns whether an empty string is a valid value.
   * @return <code>true</code> if an empty string is a valid value, and <code>false</code> if an empty string is invalid
   * @see #setEmptyStringAllowed
   */
  public boolean isEmptyStringAllowed() {
    return _emptyStringAllowed;
  }

  /**
   * @see FieldEditor#isValid()
   */
  @Override
  public boolean isValid() {
    return _isValid;
  }

  /**
   * @see FieldEditor#refreshValidState()
   */
  @Override
  protected void refreshValidState() {
    _isValid = checkState();
  }

  /**
   * Sets whether the empty string is a valid value or not.
   * @param allowed_p <code>true</code> if the empty string is allowed, and <code>false</code> if it is considered invalid
   */
  public void setEmptyStringAllowed(boolean allowed_p) {
    _emptyStringAllowed = allowed_p;
  }

  /**
   * @see FieldEditor#setFocus()
   */
  @Override
  public void setFocus() {
    if (_textField != null) {
      _textField.setFocus();
    }
  }

  /**
   * Sets this field editor's value.
   * @param value_p The new value, or <code>null</code> meaning the empty string
   */
  public void setStringValue(String value_p) {
    String value = value_p;
    if (_textField != null) {
      if (value == null) {
        value = "";//$NON-NLS-1$
      }
      _oldValue = _textField.getText();
      if (!_oldValue.equals(value)) {
        _textField.setText(value);
        valueChanged();
      }
    }
  }

  /**
   * Sets this text field's text limit.
   * @param limit_p The limit on the number of character in the text input field, or <code>UNLIMITED</code> for no limit
   */
  public void setTextLimit(int limit_p) {
    _textLimit = limit_p;
    if (_textField != null) {
      _textField.setTextLimit(limit_p);
    }
  }

  /**
   * Sets the strategy for validating the text.
   * <p>
   * Calling this method has no effect after <code>createPartControl</code> is called. Thus this method is really only useful for subclasses to call in their
   * constructor. However, it has public visibility for backward compatibility.
   * </p>
   * @param value_p either <code>VALIDATE_ON_KEY_STROKE</code> to perform on the fly checking (the default), or <code>VALIDATE_ON_FOCUS_LOST</code> to
   *          perform validation only after the text has been typed in
   */
  public void setValidateStrategy(int value_p) {
    if (value_p == VALIDATE_ON_FOCUS_LOST || value_p == VALIDATE_ON_KEY_STROKE || (value_p == VALIDATE_ON_MODIFICATION)) {
      _validateStrategy = value_p;
    } else {
      StringBuilder loggerMessage = new StringBuilder("CStringFieldEditor.setValidateStrategy(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Validation strategy unknown"); //$NON-NLS-1$
      __logger.error(loggerMessage.toString());
    }
  }

  /**
   * Shows the error message set via <code>setErrorMessage</code>.
   */
  public void showErrorMessage() {
    showErrorMessage(getErrorMessage());
  }

  /**
   * Informs this field editor's listener, if it has one, about a change to the value (<code>VALUE</code> property) provided that the old and new values are
   * different.
   * <p>
   * This hook is <em>not</em> called when the text is initialized (or reset to the default value) from the preference store.
   * </p>
   */
  protected void valueChanged() {
    setPresentsDefaultValue(false);
    boolean oldState = _isValid;
    refreshValidState();

    if (_isValid != oldState) {
      fireStateChanged(IS_VALID, oldState, _isValid);
    }

    String newValue = _textField.getText();
    if (!newValue.equals(_oldValue)) {
      fireValueChanged(VALUE, _oldValue, newValue);
      _oldValue = newValue;
    }
  }

  /**
   * @see FieldEditor#setEnabled(boolean, Composite)
   */
  @Override
  public void setEnabled(boolean enabled_p, Composite parent_p) {
    super.setEnabled(enabled_p, parent_p);
    getTextControl(parent_p).setEnabled(enabled_p);
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.AbstractFieldEditor#getHelperControl()
   */
  @Override
  public Control getHelperControl() {
    return null;
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.AbstractFieldEditor#getValue(org.eclipse.swt.widgets.Control)
   */
  @Override
  protected Object getValue(Control control_p) {
    return _textField.getText();
  }

  /**
   * @see org.eclipse.egf.common.ui.toolkit.fields.AbstractFieldEditor#getValueControl()
   */
  @Override
  public Control getValueControl() {
    return _textField;
  }
  
}
