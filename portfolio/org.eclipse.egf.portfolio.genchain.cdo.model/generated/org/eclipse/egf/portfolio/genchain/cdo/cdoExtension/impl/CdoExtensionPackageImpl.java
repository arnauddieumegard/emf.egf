/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.impl;

import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionFactory;
import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionPackage;
import org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationChainPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CdoExtensionPackageImpl extends EPackageImpl implements CdoExtensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cdoGenerationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.egf.portfolio.genchain.cdo.cdoExtension.CdoExtensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CdoExtensionPackageImpl() {
		super(eNS_URI, CdoExtensionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CdoExtensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CdoExtensionPackage init() {
		if (isInited) return (CdoExtensionPackage)EPackage.Registry.INSTANCE.getEPackage(CdoExtensionPackage.eNS_URI);

		// Obtain or create and register package
		CdoExtensionPackageImpl theCdoExtensionPackage = (CdoExtensionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CdoExtensionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CdoExtensionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GenerationChainPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCdoExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theCdoExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCdoExtensionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CdoExtensionPackage.eNS_URI, theCdoExtensionPackage);
		return theCdoExtensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCdoGeneration() {
		return cdoGenerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCdoGeneration_CdoSuffix() {
		return (EAttribute)cdoGenerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCdoGeneration_FeatureDelegation() {
		return (EAttribute)cdoGenerationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CdoExtensionFactory getCdoExtensionFactory() {
		return (CdoExtensionFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		cdoGenerationEClass = createEClass(CDO_GENERATION);
		createEAttribute(cdoGenerationEClass, CDO_GENERATION__CDO_SUFFIX);
		createEAttribute(cdoGenerationEClass, CDO_GENERATION__FEATURE_DELEGATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GenerationChainPackage theGenerationChainPackage = (GenerationChainPackage)EPackage.Registry.INSTANCE.getEPackage(GenerationChainPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cdoGenerationEClass.getESuperTypes().add(theGenerationChainPackage.getEcoreElement());
		cdoGenerationEClass.getESuperTypes().add(theGenerationChainPackage.getPluginProvider());

		// Initialize classes and features; add operations and parameters
		initEClass(cdoGenerationEClass, CdoGeneration.class, "CdoGeneration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCdoGeneration_CdoSuffix(), ecorePackage.getEString(), "cdoSuffix", "cdo", 0, 1, CdoGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCdoGeneration_FeatureDelegation(), ecorePackage.getEString(), "featureDelegation", "Dynamic", 0, 1, CdoGeneration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CdoExtensionPackageImpl
