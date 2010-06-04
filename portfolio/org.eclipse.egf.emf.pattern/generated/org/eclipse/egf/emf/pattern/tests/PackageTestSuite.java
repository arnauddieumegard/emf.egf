package org.eclipse.egf.emf.pattern.tests;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class PackageTestSuite extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
  protected static String nl;
  public static synchronized PackageTestSuite create(String lineSeparator)
  {
    nl = lineSeparator;
    PackageTestSuite result = new PackageTestSuite();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * A test suite for the '<em><b>";
  protected final String TEXT_5 = "</b></em>' package." + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = NL + "{";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_9 = " copyright = ";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void main(String[] args)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_12 = ".run(suite());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_13 = " suite()" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_14 = " suite = new ";
  protected final String TEXT_15 = "(\"";
  protected final String TEXT_16 = " Tests\");";
  protected final String TEXT_17 = NL + "\t\tsuite.addTestSuite(";
  protected final String TEXT_18 = ".class);";
  protected final String TEXT_19 = NL + "\t\treturn suite;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_20 = "(String name)" + NL + "\t{" + NL + "\t\tsuper(name);" + NL + "\t}" + NL + "" + NL + "} //";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL;

	public PackageTestSuite()
	{
	//Here is the constructor
StringBuffer stringBuffer = new StringBuffer();

    // add initialisation of the pattern variables (declaration has been already done).
    
	}
  	
  	public String generate(Object argument) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    InternalPatternContext ctx = (InternalPatternContext)argument;
Map<String, String> queryCtx = null;
IQuery.ParameterDescription paramDesc = null;

    
List<Object> parameterList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object parameterParameter : parameterList ) {

this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage)parameterParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

    super.orchestration(new SuperOrchestrationContext(ictx));

    
method_preGenerate(ictx.getBuffer(), ictx);
    
method_doGenerate(ictx.getBuffer(), ictx);
    {
ictx.setExecutionCurrentIndex(ictx.getBuffer().length());
ictx.getExecutionBuffer().append(ictx.getBuffer());
final Map<String, Object> parameters = getParameters();
CallbackContext ctx_callback = new CallbackContext(ictx);
CallHelper.callBack(ctx_callback, parameters);
}

    
method_postGenerate(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("parameter", this.parameter);
return parameters; }

    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
GenPackage genPackage = parameter;
targetPath = genPackage.getGenModel().getTestsDirectory();
packageName = genPackage.getTestsPackageName();
className = genPackage.getTestSuiteClassName();
arguments = null;
canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.TestsProject");
canGenerate = canGenerate && (genPackage.hasClassifiers());

    }
    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
if (!canGenerate)
    return;
new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getTestsDirectory(), genModel, GenBaseGeneratorAdapter.TESTS_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());
Object argument = parameter;
if (arguments != null)
    argument = ((Object[]) arguments)[0];

    
/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 */

    GenPackage genPackage = (GenPackage)argument; GenModel genModel = genPackage.getGenModel(); /* Trick to import java.util.* without warnings */Iterator.class.getName();
    stringBuffer.append(TEXT_1);
    final Map<String, Object> parameters__z6sacGJ_EdFqczH3ESmRw = new HashMap<String, Object>();
parameters__z6sacGJ_EdFqczH3ESmRw.put("argument", parameter);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), parameters__z6sacGJ_EdFqczH3ESmRw);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(genPackage.getTestsPackageName());
    stringBuffer.append(TEXT_3);
    genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genPackage.getPackageName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genPackage.getTestSuiteClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genModel.getImportedName("junit.framework.TestSuite"));
    stringBuffer.append(TEXT_7);
    if (genModel.hasCopyrightField()) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getCopyrightFieldLiteral());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genModel.getNonNLS());
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genModel.getImportedName("junit.textui.TestRunner"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genModel.getImportedName("junit.framework.Test"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genModel.getImportedName("junit.framework.TestSuite"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genPackage.getTestSuiteClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genPackage.getPackageName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genModel.getNonNLS());
    for (GenClass genClass : genPackage.getGenClasses()) {
    if (!genClass.isExternalInterface() && !genClass.isAbstract() && genClass.hasTests()) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genClass.getImportedTestCaseClassName());
    stringBuffer.append(TEXT_18);
    }
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genPackage.getTestSuiteClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genPackage.getTestSuiteClassName());
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_21);
    }
    }