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
package org.eclipse.egf.pattern.pattern_1240231814527_248;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Pattern 1240231814527 248</b></em>'. <!-- end-user-doc -->
 * 
 * 
 * @see org.eclipse.egf.pattern.pattern_1240231814527_248.Pattern_1240231814527_248Package#getPattern_1240231814527_248()
 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern/production Path='model.tests/TestCase/getGenFeature.TODO.override.javajetinc' Compilation='false' BufferModification='false'"
 * @generated
 */
public interface Pattern_1240231814527_248 extends Pattern {
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
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1240231814527.248/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1240231814527.248/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1240231814527.248/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1240231814527.248/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240231822385.249'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240231814527.248/PatternMethod.1240231822385.249.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240231814527.248/PatternMethod.1240231822385.249.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240231822385.250'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240231814527.248/PatternMethod.1240231822385.250.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240231814527.248/PatternMethod.1240231822385.250.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

} // Pattern_1240231814527_248
