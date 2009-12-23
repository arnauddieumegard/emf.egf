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
package org.eclipse.egf.model.productionplan;

import org.eclipse.egf.model.factorycomponent.FactoryComponentPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.productionplan.ProductionplanFactory
 * @model kind="package"
 * @generated
 */
public interface ProductionplanPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "productionplan"; //$NON-NLS-1$

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/egf/1.0.0/productionplan"; //$NON-NLS-1$

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "productionplan"; //$NON-NLS-1$

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ProductionplanPackage eINSTANCE = org.eclipse.egf.model.productionplan.impl.ProductionplanPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanImpl <em>Production Plan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanImpl
   * @see org.eclipse.egf.model.productionplan.impl.ProductionplanPackageImpl#getProductionPlan()
   * @generated
   */
  int PRODUCTION_PLAN = 0;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__ID = FactoryComponentPackage.ORCHESTRATION__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__NAME = FactoryComponentPackage.ORCHESTRATION__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__DESCRIPTION = FactoryComponentPackage.ORCHESTRATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Production Plan Invocations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS = FactoryComponentPackage.ORCHESTRATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Production Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_FEATURE_COUNT = FactoryComponentPackage.ORCHESTRATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl <em>Production Plan Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl
   * @see org.eclipse.egf.model.productionplan.impl.ProductionplanPackageImpl#getProductionPlanInvocation()
   * @generated
   */
  int PRODUCTION_PLAN_INVOCATION = 1;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__ID = FactoryComponentPackage.INVOCATION__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__NAME = FactoryComponentPackage.INVOCATION__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__DESCRIPTION = FactoryComponentPackage.INVOCATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION__CONTEXT = FactoryComponentPackage.INVOCATION__CONTEXT;

  /**
   * The number of structural features of the '<em>Production Plan Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT = FactoryComponentPackage.INVOCATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.productionplan.impl.FactoryComponentInvocationImpl <em>Factory Component Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.productionplan.impl.FactoryComponentInvocationImpl
   * @see org.eclipse.egf.model.productionplan.impl.ProductionplanPackageImpl#getFactoryComponentInvocation()
   * @generated
   */
  int FACTORY_COMPONENT_INVOCATION = 2;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__ID = PRODUCTION_PLAN_INVOCATION__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__NAME = PRODUCTION_PLAN_INVOCATION__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__DESCRIPTION = PRODUCTION_PLAN_INVOCATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__CONTEXT = PRODUCTION_PLAN_INVOCATION__CONTEXT;

  /**
   * The feature id for the '<em><b>Factory Component</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Factory Component Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_COMPONENT_INVOCATION_FEATURE_COUNT = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl <em>Task Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl
   * @see org.eclipse.egf.model.productionplan.impl.ProductionplanPackageImpl#getTaskInvocation()
   * @generated
   */
  int TASK_INVOCATION = 3;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__ID = PRODUCTION_PLAN_INVOCATION__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__NAME = PRODUCTION_PLAN_INVOCATION__NAME;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__DESCRIPTION = PRODUCTION_PLAN_INVOCATION__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__CONTEXT = PRODUCTION_PLAN_INVOCATION__CONTEXT;

  /**
   * The feature id for the '<em><b>Task</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION__TASK = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Task Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TASK_INVOCATION_FEATURE_COUNT = PRODUCTION_PLAN_INVOCATION_FEATURE_COUNT + 1;

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.ProductionPlan <em>Production Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Plan</em>'.
   * @see org.eclipse.egf.model.productionplan.ProductionPlan
   * @generated
   */
  EClass getProductionPlan();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.egf.model.productionplan.ProductionPlan#getProductionPlanInvocations <em>Production Plan Invocations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Production Plan Invocations</em>'.
   * @see org.eclipse.egf.model.productionplan.ProductionPlan#getProductionPlanInvocations()
   * @see #getProductionPlan()
   * @generated
   */
  EReference getProductionPlan_ProductionPlanInvocations();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.ProductionPlanInvocation <em>Production Plan Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Plan Invocation</em>'.
   * @see org.eclipse.egf.model.productionplan.ProductionPlanInvocation
   * @generated
   */
  EClass getProductionPlanInvocation();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.FactoryComponentInvocation <em>Factory Component Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Factory Component Invocation</em>'.
   * @see org.eclipse.egf.model.productionplan.FactoryComponentInvocation
   * @generated
   */
  EClass getFactoryComponentInvocation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.productionplan.FactoryComponentInvocation#getFactoryComponent <em>Factory Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Factory Component</em>'.
   * @see org.eclipse.egf.model.productionplan.FactoryComponentInvocation#getFactoryComponent()
   * @see #getFactoryComponentInvocation()
   * @generated
   */
  EReference getFactoryComponentInvocation_FactoryComponent();

  /**
   * Returns the meta object for class '{@link org.eclipse.egf.model.productionplan.TaskInvocation <em>Task Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Task Invocation</em>'.
   * @see org.eclipse.egf.model.productionplan.TaskInvocation
   * @generated
   */
  EClass getTaskInvocation();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.egf.model.productionplan.TaskInvocation#getTask <em>Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Task</em>'.
   * @see org.eclipse.egf.model.productionplan.TaskInvocation#getTask()
   * @see #getTaskInvocation()
   * @generated
   */
  EReference getTaskInvocation_Task();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ProductionplanFactory getProductionplanFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanImpl <em>Production Plan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionplanPackageImpl#getProductionPlan()
     * @generated
     */
    EClass PRODUCTION_PLAN = eINSTANCE.getProductionPlan();

    /**
     * The meta object literal for the '<em><b>Production Plan Invocations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRODUCTION_PLAN__PRODUCTION_PLAN_INVOCATIONS = eINSTANCE.getProductionPlan_ProductionPlanInvocations();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl <em>Production Plan Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.ProductionPlanInvocationImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionplanPackageImpl#getProductionPlanInvocation()
     * @generated
     */
    EClass PRODUCTION_PLAN_INVOCATION = eINSTANCE.getProductionPlanInvocation();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.FactoryComponentInvocationImpl <em>Factory Component Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.FactoryComponentInvocationImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionplanPackageImpl#getFactoryComponentInvocation()
     * @generated
     */
    EClass FACTORY_COMPONENT_INVOCATION = eINSTANCE.getFactoryComponentInvocation();

    /**
     * The meta object literal for the '<em><b>Factory Component</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FACTORY_COMPONENT_INVOCATION__FACTORY_COMPONENT = eINSTANCE.getFactoryComponentInvocation_FactoryComponent();

    /**
     * The meta object literal for the '{@link org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl <em>Task Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.egf.model.productionplan.impl.TaskInvocationImpl
     * @see org.eclipse.egf.model.productionplan.impl.ProductionplanPackageImpl#getTaskInvocation()
     * @generated
     */
    EClass TASK_INVOCATION = eINSTANCE.getTaskInvocation();

    /**
     * The meta object literal for the '<em><b>Task</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TASK_INVOCATION__TASK = eINSTANCE.getTaskInvocation_Task();

  }

} //ProductionplanPackage
