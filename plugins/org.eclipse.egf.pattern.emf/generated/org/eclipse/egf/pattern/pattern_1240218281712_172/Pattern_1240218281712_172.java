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
package org.eclipse.egf.pattern.pattern_1240218281712_172;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Pattern 1240218281712 172</b></em>'. <!-- end-user-doc -->
 * 
 * 
 * @see org.eclipse.egf.pattern.pattern_1240218281712_172.Pattern_1240218281712_172Package#getPattern_1240218281712_172()
 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern/production Path='model/SwitchClass.javajet' Compilation='true' BufferModification='false'"
 * @generated
 */
public interface Pattern_1240218281712_172 extends Pattern {
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
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1240218281712.172/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1240218281712.172/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1240218281712.172/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1240218281712.172/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240218289133.173'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240218281712.172/PatternMethod.1240218289133.173.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240218281712.172/PatternMethod.1240218289133.173.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240218289133.174'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240218281712.172/PatternMethod.1240218289133.174.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240218281712.172/PatternMethod.1240218289133.174.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240218311521.176'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240218281712.172/PatternMethod.1240218311521.176.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240218281712.172/PatternMethod.1240218311521.176.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String include();

} // Pattern_1240218281712_172
