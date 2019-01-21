/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.pattern;

import org.eclipse.egf.model.fcore.NamedModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.pattern.PatternParameter#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.egf.model.pattern.PatternParameter#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternParameter()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='MandatoryName'"
 * @generated
 */
public interface PatternParameter extends NamedModelElement, InjectedContext {

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternParameter_Type()
     * @model required="true"
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.pattern.PatternParameter#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Query</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.egf.model.pattern.Query#getParameter <em>Parameter</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Query</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Query</em>' containment reference.
     * @see #setQuery(Query)
     * @see org.eclipse.egf.model.pattern.PatternPackage#getPatternParameter_Query()
     * @see org.eclipse.egf.model.pattern.Query#getParameter
     * @model opposite="parameter" containment="true"
     * @generated
     */
    Query getQuery();

    /**
     * Sets the value of the '{@link org.eclipse.egf.model.pattern.PatternParameter#getQuery <em>Query</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Query</em>' containment reference.
     * @see #getQuery()
     * @generated
     */
    void setQuery(Query value);

} // PatternParameter
