/**
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.portfolio.genchain.generationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage#getPluginProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PluginProvider extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model domainsMany="true"
     * @generated
     */
    EList<String> getPluginNames(EList<EObject> domains);

} // PluginProvider
