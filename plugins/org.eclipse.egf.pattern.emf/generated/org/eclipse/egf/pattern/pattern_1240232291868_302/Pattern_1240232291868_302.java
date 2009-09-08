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
package org.eclipse.egf.pattern.pattern_1240232291868_302;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Pattern 1240232291868 302</b></em>'. <!-- end-user-doc -->
 * 
 * 
 * @see org.eclipse.egf.pattern.pattern_1240232291868_302.Pattern_1240232291868_302Package#getPattern_1240232291868_302()
 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern/production Path='model.tests/TestCase/isSetGenFeature.annotations.insert.javajetinc' Compilation='false' BufferModification='false'"
 * @generated
 */
public interface Pattern_1240232291868_302 extends Pattern {
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
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1240232291868.302/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1240232291868.302/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1240232291868.302/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1240232291868.302/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240232299554.303'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240232291868.302/PatternMethod.1240232299554.303.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240232291868.302/PatternMethod.1240232299554.303.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240232299554.304'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240232291868.302/PatternMethod.1240232299554.304.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240232291868.302/PatternMethod.1240232299554.304.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

} // Pattern_1240232291868_302
