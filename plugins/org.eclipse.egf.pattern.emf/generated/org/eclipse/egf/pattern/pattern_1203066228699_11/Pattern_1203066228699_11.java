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
package org.eclipse.egf.pattern.pattern_1203066228699_11;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Pattern 1203066228699 11</b></em>'. <!-- end-user-doc -->
 * 
 * 
 * @see org.eclipse.egf.pattern.pattern_1203066228699_11.Pattern_1203066228699_11Package#getPattern_1203066228699_11()
 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern/production Path='editor/plugin.xmljet' Compilation='true' BufferModification='false'"
 * @generated
 */
public interface Pattern_1203066228699_11 extends Pattern {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	String generateBody(Object classLoader_p);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1203066228699.11/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1203066228699.11/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1203066228699.11/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1203066228699.11/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1203066228715.12'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1203066228699.11/PatternMethod.1203066228715.12.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1203066228699.11/PatternMethod.1203066228715.12.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1203066228715.13'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1203066228699.11/PatternMethod.1203066228715.13.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1203066228699.11/PatternMethod.1203066228715.13.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1203066415400.14'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1203066228699.11/PatternMethod.1203066415400.14.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1203066228699.11/PatternMethod.1203066415400.14.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String include();

} // Pattern_1203066228699_11
