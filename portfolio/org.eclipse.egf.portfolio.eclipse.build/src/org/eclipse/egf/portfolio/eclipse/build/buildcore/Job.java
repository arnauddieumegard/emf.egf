/**
 *    Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *    All rights reserved. This program and the accompanying materials
 *    are made available under the terms of the Eclipse Public License v1.0
 *    which accompanies this distribution, and is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *   
 *    Contributors:
 *        Thales Corporate Services S.A.S - initial API and implementation
 *
 * $Id$
 */

package org.eclipse.egf.portfolio.eclipse.build.buildcore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getScms <em>Scms</em>}</li>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getTriggers <em>Triggers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getJob()
 * @model
 * @generated
 */
public interface Job extends AbstractStepContainer {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Scms</b></em>' containment reference.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Scms</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Scms</em>' containment reference.
     * @see #setScms(SCM)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getJob_Scms()
     * @model containment="true"
     * @generated
     */

    SCM getScms();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Job#getScms <em>Scms</em>}' containment reference.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Scms</em>' containment reference.
     * @see #getScms()
     * @generated
     */

    void setScms(SCM value);







    /**
     * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.egf.portfolio.eclipse.build.buildcore.Trigger}.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Triggers</em>' containment reference list.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.BuildcorePackage#getJob_Triggers()
     * @model containment="true"
     * @generated
     */

    EList<Trigger> getTriggers();





} // Job
