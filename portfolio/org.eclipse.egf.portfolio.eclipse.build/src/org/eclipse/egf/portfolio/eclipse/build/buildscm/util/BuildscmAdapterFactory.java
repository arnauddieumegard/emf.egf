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

package org.eclipse.egf.portfolio.eclipse.build.buildscm.util;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.SCMLocation;

import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.BuildscmPackage
 * @generated
 */
public class BuildscmAdapterFactory extends AdapterFactoryImpl {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "   Copyright (c) 2009-2010 Thales Corporate Services S.A.S.\r\n   All rights reserved. This program and the accompanying materials\r\n   are made available under the terms of the Eclipse Public License v1.0\r\n   which accompanies this distribution, and is available at\r\n   http://www.eclipse.org/legal/epl-v10.html\r\n  \r\n   Contributors:\r\n       Thales Corporate Services S.A.S - initial API and implementation";

    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static BuildscmPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BuildscmAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = BuildscmPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BuildscmSwitch<Adapter> modelSwitch =
        new BuildscmSwitch<Adapter>() {
            @Override
            public Adapter caseSVN(SVN object) {
                return createSVNAdapter();
            }
            @Override
            public Adapter caseSVNLocation(SVNLocation object) {
                return createSVNLocationAdapter();
            }
            @Override
            public Adapter caseSCM(SCM object) {
                return createSCMAdapter();
            }
            @Override
            public Adapter caseSCMLocation(SCMLocation object) {
                return createSCMLocationAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN <em>SVN</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN
     * @generated
     */
    public Adapter createSVNAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation <em>SVN Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNLocation
     * @generated
     */
    public Adapter createSVNLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM <em>SCM</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.SCM
     * @generated
     */
    public Adapter createSCMAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.egf.portfolio.eclipse.build.buildcore.SCMLocation <em>SCM Location</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.egf.portfolio.eclipse.build.buildcore.SCMLocation
     * @generated
     */
    public Adapter createSCMLocationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //BuildscmAdapterFactory