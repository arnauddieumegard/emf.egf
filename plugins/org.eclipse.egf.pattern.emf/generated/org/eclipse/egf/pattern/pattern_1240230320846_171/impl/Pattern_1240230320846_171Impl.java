/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.pattern_1240230320846_171.impl;

import org.eclipse.egf.pattern.impl.PatternImpl;

import org.eclipse.egf.pattern.pattern_1240230320846_171.Pattern_1240230320846_171;
import org.eclipse.egf.pattern.pattern_1240230320846_171.Pattern_1240230320846_171Package;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Pattern 1240230320846 171</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class Pattern_1240230320846_171Impl extends PatternImpl implements
		Pattern_1240230320846_171 {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Pattern_1240230320846_171Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Pattern_1240230320846_171Package.Literals.PATTERN_1240230320846_171;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String generatePreMatching() {
		StringBuilder builder = new StringBuilder();
		builder
				.append(org.eclipse.egf.pattern.production.template.TemplateHelper
						.readTemplateFile("emf.patterns/templates/generated/Pattern.1240230320846.171/generatePreMatching.pt"));
		return builder.toString();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String generatePostMatching() {
		StringBuilder builder = new StringBuilder();
		builder
				.append(org.eclipse.egf.pattern.production.template.TemplateHelper
						.readTemplateFile("emf.patterns/templates/generated/Pattern.1240230320846.171/generatePostMatching.pt"));
		return builder.toString();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String generateHeader() {
		StringBuilder builder = new StringBuilder();
		builder
				.append(org.eclipse.egf.pattern.production.template.TemplateHelper
						.readTemplateFile("emf.patterns/templates/Pattern.1240230320846.171/PatternMethod.1240230326861.172.pt"));
		return builder.toString();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String generateFooter() {
		StringBuilder builder = new StringBuilder();
		builder
				.append(org.eclipse.egf.pattern.production.template.TemplateHelper
						.readTemplateFile("emf.patterns/templates/Pattern.1240230320846.171/PatternMethod.1240230326861.173.pt"));
		return builder.toString();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String include() {
		StringBuilder builder = new StringBuilder();
		builder
				.append(org.eclipse.egf.pattern.production.template.TemplateHelper
						.readTemplateFile("emf.patterns/templates/Pattern.1240230320846.171/PatternMethod.1240230417220.182.pt"));
		return builder.toString();

	}

} // Pattern_1240230320846_171Impl
