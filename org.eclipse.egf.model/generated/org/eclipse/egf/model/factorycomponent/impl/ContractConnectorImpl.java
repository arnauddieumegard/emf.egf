/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.egf.model.factorycomponent.impl;

import org.eclipse.egf.model.factorycomponent.Context;
import org.eclipse.egf.model.factorycomponent.Contract;
import org.eclipse.egf.model.factorycomponent.ContractConnector;
import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contract Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContractConnectorImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContractConnectorImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.egf.model.factorycomponent.impl.ContractConnectorImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContractConnectorImpl extends ModelElementImpl implements ContractConnector {
  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected Contract source;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Contract target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContractConnectorImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return FactoryComponentPackage.Literals.CONTRACT_CONNECTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Context getContext() {
    if (eContainerFeatureID() != FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT)
      return null;
    return (Context) eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContext(Context newContext, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject) newContext, FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContext(Context newContext) {
    if (newContext != eInternalContainer()
        || (eContainerFeatureID() != FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT && newContext != null)) {
      if (EcoreUtil.isAncestor(this, newContext))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString()); //$NON-NLS-1$
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newContext != null)
        msgs = ((InternalEObject) newContext).eInverseAdd(this, FactoryComponentPackage.CONTEXT__CONNECTORS, Context.class, msgs);
      msgs = basicSetContext(newContext, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT, newContext, newContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract getSource() {
    if (source != null && source.eIsProxy()) {
      InternalEObject oldSource = (InternalEObject) source;
      source = (Contract) eResolveProxy(oldSource);
      if (source != oldSource) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FactoryComponentPackage.CONTRACT_CONNECTOR__SOURCE, oldSource, source));
      }
    }
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract basicGetSource() {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(Contract newSource) {
    Contract oldSource = source;
    source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.CONTRACT_CONNECTOR__SOURCE, oldSource, source));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract getTarget() {
    if (target != null && target.eIsProxy()) {
      InternalEObject oldTarget = (InternalEObject) target;
      target = (Contract) eResolveProxy(oldTarget);
      if (target != oldTarget) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, FactoryComponentPackage.CONTRACT_CONNECTOR__TARGET, oldTarget, target));
      }
    }
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contract basicGetTarget() {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(Contract newTarget) {
    Contract oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, FactoryComponentPackage.CONTRACT_CONNECTOR__TARGET, oldTarget, target));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetContext((Context) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT:
      return basicSetContext(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT:
      return eInternalContainer().eInverseRemove(this, FactoryComponentPackage.CONTEXT__CONNECTORS, Context.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT:
      return getContext();
    case FactoryComponentPackage.CONTRACT_CONNECTOR__SOURCE:
      if (resolve)
        return getSource();
      return basicGetSource();
    case FactoryComponentPackage.CONTRACT_CONNECTOR__TARGET:
      if (resolve)
        return getTarget();
      return basicGetTarget();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT:
      setContext((Context) newValue);
      return;
    case FactoryComponentPackage.CONTRACT_CONNECTOR__SOURCE:
      setSource((Contract) newValue);
      return;
    case FactoryComponentPackage.CONTRACT_CONNECTOR__TARGET:
      setTarget((Contract) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT:
      setContext((Context) null);
      return;
    case FactoryComponentPackage.CONTRACT_CONNECTOR__SOURCE:
      setSource((Contract) null);
      return;
    case FactoryComponentPackage.CONTRACT_CONNECTOR__TARGET:
      setTarget((Contract) null);
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case FactoryComponentPackage.CONTRACT_CONNECTOR__CONTEXT:
      return getContext() != null;
    case FactoryComponentPackage.CONTRACT_CONNECTOR__SOURCE:
      return source != null;
    case FactoryComponentPackage.CONTRACT_CONNECTOR__TARGET:
      return target != null;
    }
    return super.eIsSet(featureID);
  }

} //ContractConnectorImpl
