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

package org.eclipse.egf.portfolio.eclipse.build.buildfile;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Move Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.MoveStep#getDestinationFolderPath <em>Destination Folder Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getMoveStep()
 * @model
 * @generated
 */
public interface MoveStep extends FileStep, FilesetProvider {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";






    /**
     * Returns the value of the '<em><b>Destination Folder Path</b></em>' attribute.

     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Destination Folder Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Destination Folder Path</em>' attribute.
     * @see #setDestinationFolderPath(String)
     * @see org.eclipse.egf.portfolio.eclipse.build.buildfile.BuildfilePackage#getMoveStep_DestinationFolderPath()
     * @model required="true"
     * @generated
     */

    String getDestinationFolderPath();




    /**
     * Sets the value of the '{@link org.eclipse.egf.portfolio.eclipse.build.buildfile.MoveStep#getDestinationFolderPath <em>Destination Folder Path</em>}' attribute.

     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Destination Folder Path</em>' attribute.
     * @see #getDestinationFolderPath()
     * @generated
     */

    void setDestinationFolderPath(String value);





} // MoveStep