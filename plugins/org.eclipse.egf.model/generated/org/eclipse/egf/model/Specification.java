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
package org.eclipse.egf.model;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Specification</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.model.Specification#getViewpoints <em>Viewpoints</em>}</li>
 *   <li>{@link org.eclipse.egf.model.Specification#getViewpointIds <em>Viewpoint Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.model.ModelPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends NamedModelElementWithId {
  /**
   * Returns the value of the '<em><b>Viewpoints</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.egf.model.AbstractViewpoint}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Viewpoints</em>' containment reference list isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Viewpoints</em>' containment reference list.
   * @see org.eclipse.egf.model.ModelPackage#getSpecification_Viewpoints()
   * @model containment="true"
   * @generated
   */
  EList<AbstractViewpoint> getViewpoints();

  /**
   * Returns the value of the '<em><b>Viewpoint Ids</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Contains a map
   * of couple <viewpoint type, List of viewpoint ids for type uased as key>. <!-- end-model-doc -->
   * @return the value of the '<em>Viewpoint Ids</em>' attribute.
   * @see #setViewpointIds(Map)
   * @see org.eclipse.egf.model.ModelPackage#getSpecification_ViewpointIds()
   * @model transient="true"
   * @generated
   */
  Map<ViewpointType, EList<String>> getViewpointIds();

  /**
   * Sets the value of the '{@link org.eclipse.egf.model.Specification#getViewpointIds <em>Viewpoint Ids</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the new value of the '<em>Viewpoint Ids</em>' attribute.
   * @see #getViewpointIds()
   * @generated
   */
  void setViewpointIds(Map<ViewpointType, EList<String>> value);

} // Specification
