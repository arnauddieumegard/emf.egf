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
package org.eclipse.egf.model.pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.Pattern#getHeaderMethod <em>Header Method</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.Pattern#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.Pattern#getFooterMethod <em>Footer Method</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.Pattern#getSuperPattern <em>Super Pattern</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.Pattern#getOrchestration <em>Orchestration</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.Pattern#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.Pattern#getNature <em>Nature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends PatternElement {
  /**
   * Returns the value of the '<em><b>Header Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Header Method</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Header Method</em>' containment reference.
   * @see #setHeaderMethod(PatternMethod)
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPattern_HeaderMethod()
   * @model containment="true" required="true"
   * @generated
   */
  PatternMethod getHeaderMethod();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.pattern.Pattern#getHeaderMethod <em>Header Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Header Method</em>' containment reference.
   * @see #getHeaderMethod()
   * @generated
   */
  void setHeaderMethod(PatternMethod value);

  /**
   * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.pattern.PatternMethod}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Methods</em>' containment reference list.
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPattern_Methods()
   * @model containment="true"
   * @generated
   */
  EList<PatternMethod> getMethods();

  /**
   * Returns the value of the '<em><b>Super Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Pattern</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Pattern</em>' reference.
   * @see #setSuperPattern(Pattern)
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPattern_SuperPattern()
   * @model resolveProxies="false"
   * @generated
   */
  Pattern getSuperPattern();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.pattern.Pattern#getSuperPattern <em>Super Pattern</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Pattern</em>' reference.
   * @see #getSuperPattern()
   * @generated
   */
  void setSuperPattern(Pattern value);

  /**
   * Returns the value of the '<em><b>Footer Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Footer Method</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Footer Method</em>' containment reference.
   * @see #setFooterMethod(PatternMethod)
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPattern_FooterMethod()
   * @model containment="true" required="true"
   * @generated
   */
  PatternMethod getFooterMethod();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.pattern.Pattern#getFooterMethod <em>Footer Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Footer Method</em>' containment reference.
   * @see #getFooterMethod()
   * @generated
   */
  void setFooterMethod(PatternMethod value);

  /**
   * Returns the value of the '<em><b>Orchestration</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.egf.model.pattern.PatternUnit}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Orchestration</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Orchestration</em>' reference list.
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPattern_Orchestration()
   * @model
   * @generated
   */
  EList<PatternUnit> getOrchestration();

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.pattern.PatternParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPattern_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<PatternParameter> getParameters();

  /**
   * Returns the value of the '<em><b>Nature</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nature</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nature</em>' containment reference.
   * @see #setNature(PatternNature)
   * @see org.eclipse.egf.model.pattern.PatternPackage#getPattern_Nature()
   * @model containment="true" required="true"
   * @generated
   */
  PatternNature getNature();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.pattern.Pattern#getNature <em>Nature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nature</em>' containment reference.
   * @see #getNature()
   * @generated
   */
  void setNature(PatternNature value);

} // Pattern
