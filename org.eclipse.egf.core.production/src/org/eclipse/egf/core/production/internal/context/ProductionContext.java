/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.core.production.internal.context;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.l10n.CoreProductionMessages;
import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author Xavier Maysonnave
 * 
 */
public abstract class ProductionContext<Q extends Object> implements IProductionContext<Q> {

  private class Data {

    private String _name;

    private Class<?> _clazz;

    private Object _value;

    public Data(String name, Class<?> clazz, Object value) throws InvocationException {
      if (name == null) {
        throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_null_name, getName()));
      }
      if (name.trim().length() == 0) {
        throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_emtpy_name, getName()));
      }
      _name = name.trim();
      if (clazz == null) {
        throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_null_class, getName()));
      }
      _clazz = clazz;
      // null value is a valid value
      if (value != null && _clazz.isInstance(value) == false) {
        throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_wrong_value_type, new Object[] { _clazz.getName(), _name, value.getClass().getName(), getName() }));
      }
      _value = value;
    }

    public Class<?> getType() {
      return _clazz;
    }

    public Object getValue() {
      return _value;
    }

    public void setValue(Object value) throws InvocationException {
      // null value is a valid value
      if (value != null && _clazz.isInstance(value) == false) {
        throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_wrong_value_type, new Object[] { _clazz.getName(), _name, value.getClass().getName(), getName() }));
      }
      _value = value;
    }

  }

  private Q _element;

  private final Map<String, Data> _inputDatas = new HashMap<String, Data>();

  private final Map<String, Data> _outputDatas = new HashMap<String, Data>();

  public ProductionContext(Q element) {
    Assert.isNotNull(element);
    _element = element;
  }

  public Q getElement() {
    return _element;
  }

  public void reset() {
    _inputDatas.clear();
    _outputDatas.clear();
  }

  public abstract String getName();

  protected void addInputData(String name, Class<?> clazz, Object object) throws InvocationException {
    _inputDatas.put(name, new Data(name, clazz, object));
  }

  protected void addOutputData(String name, Class<?> clazz, Object object) throws InvocationException {
    _outputDatas.put(name, new Data(name, clazz, object));
  }

  public void setOutputValue(String name, Object value) throws InvocationException {
    Data data = getData(name, _outputDatas);
    // null value is a valid value
    if (value != null && (checkClass(value.getClass(), data.getType()) == false || data.getType().isInstance(value) == false)) {
      throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_wrong_value_type, new Object[] { data.getType().getName(), name.trim(), value.getClass().getName(), getName() }));
    }
    data.setValue(value);
  }

  public Class<?> getInputValueType(String name) throws InvocationException {
    return getData(name, _inputDatas).getType();
  }

  public <T extends Object> T getInputValue(String name, Class<T> clazz) throws InvocationException {
    return getValue(name, clazz, _inputDatas);
  }

  public Class<?> getOutputValueType(String name) throws InvocationException {
    return getData(name, _outputDatas).getType();
  }

  public <T extends Object> T getOutputValue(String name, Class<T> clazz) throws InvocationException {
    return getValue(name, clazz, _outputDatas);
  }

  private Data getData(String name, Map<String, Data> datas) throws InvocationException {
    if (name == null) {
      throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_null_name, getName()));
    }
    if (name.trim().length() == 0) {
      throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_emtpy_name, getName()));
    }
    String innerName = name.trim();
    Data data = datas.get(innerName);
    if (data == null) {
      throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_unknown_value, innerName, getName()));
    }
    return data;
  }

  private <T extends Object> T getValue(String name, Class<T> clazz, Map<String, Data> datas) throws InvocationException {
    Data data = getData(name, datas);
    if (checkClass(clazz, data.getType()) == false) {
      throw new InvocationException(NLS.bind(CoreProductionMessages.ProductionContext_wrong_value_type, new Object[] { data.getType().getName(), name.trim(), clazz.getName(), getName() }));
    }
    try {
      return clazz.cast(data.getValue());
    } catch (ClassCastException cce) {
      throw new InvocationException(cce);
    }
  }

  private boolean checkClass(Class<?> clazz, Class<?> type) {
    // Type Checking
    try {
      clazz.asSubclass(type);
    } catch (ClassCastException cce) {
      return false;
    }
    return true;
  }

}
