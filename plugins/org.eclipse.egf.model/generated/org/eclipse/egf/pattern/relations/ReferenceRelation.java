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
package org.eclipse.egf.pattern.relations;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference Relation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.pattern.relations.ReferenceRelation#getReferencedPattern <em>Referenced Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.pattern.relations.RelationsPackage#getReferenceRelation()
 * @model
 * @generated
 */
public interface ReferenceRelation extends PatternRelation {
  /**
   * Returns the value of the '<em><b>Referenced Pattern</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced Pattern</em>' reference isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Pattern</em>' reference.
   * @see #setReferencedPattern(Pattern)
   * @see org.eclipse.egf.pattern.relations.RelationsPackage#getReferenceRelation_ReferencedPattern()
   * @model
   * @generated
   */
  Pattern getReferencedPattern();

  /**
   * Sets the value of the '{@link org.eclipse.egf.pattern.relations.ReferenceRelation#getReferencedPattern <em>Referenced Pattern</em>}' reference. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Pattern</em>' reference.
   * @see #getReferencedPattern()
   * @generated
   */
  void setReferencedPattern(Pattern value);

} // ReferenceRelation
