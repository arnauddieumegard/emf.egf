/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fprod;

import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Production Plan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.fprod.ProductionPlan#getInvocations <em>Invocations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.fprod.FprodPackage#getProductionPlan()
 * @model
 * @generated
 */
public interface ProductionPlan extends Orchestration {

  /**
   * Returns the value of the '<em><b>Invocations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.fprod.ProductionPlanInvocation}.
   * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.fprod.ProductionPlanInvocation#getProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invocations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invocations</em>' containment reference list.
   * @see org.eclipse.egf.model.fprod.FprodPackage#getProductionPlan_Invocations()
   * @see org.eclipse.egf.model.fprod.ProductionPlanInvocation#getProductionPlan
   * @model opposite="productionPlan" containment="true" required="true"
   * @generated
   */
  @SuppressWarnings("unchecked")
  EList<ProductionPlanInvocation> getInvocations();
} // ProductionPlan