package org.eclipse.egf.emf.pattern.model;

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

public class Plugin extends org.eclipse.egf.emf.pattern.base.GenModelJava {
  protected static String nl;
  public static synchronized Plugin create(String lineSeparator)
  {
    nl = lineSeparator;
    Plugin result = new Plugin();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * This is the central singleton for the ";
  protected final String TEXT_5 = " model plugin." + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public final class ";
  protected final String TEXT_6 = " extends EMFPlugin" + NL + "{";
  protected final String TEXT_7 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_8 = " copyright = ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * Keep track of the singleton." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_12 = " INSTANCE = new ";
  protected final String TEXT_13 = "();" + NL + "" + NL + "\t/**" + NL + "\t * Keep track of the singleton." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static Implementation plugin;" + NL + "" + NL + "\t/**" + NL + "\t * Create the instance." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_14 = "()" + NL + "\t{" + NL + "\t\tsuper(new ResourceLocator [] {});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns the singleton instance of the Eclipse plugin." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the singleton instance." + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_15 = NL + "\t@Override";
  protected final String TEXT_16 = NL + "\tpublic ResourceLocator getPluginResourceLocator()" + NL + "\t{" + NL + "\t\treturn plugin;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns the singleton instance of the Eclipse plugin." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the singleton instance." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static Implementation getPlugin()" + NL + "\t{" + NL + "\t\treturn plugin;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The actual implementation of the Eclipse <b>Plugin</b>." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Implementation extends EclipsePlugin" + NL + "\t{" + NL + "\t\t/**" + NL + "\t\t * Creates an instance." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->";
  protected final String TEXT_17 = NL + "\t\t * @param descriptor the description of the plugin.";
  protected final String TEXT_18 = NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Implementation(";
  protected final String TEXT_19 = " descriptor";
  protected final String TEXT_20 = ")" + NL + "\t\t{" + NL + "\t\t\tsuper(";
  protected final String TEXT_21 = "descriptor";
  protected final String TEXT_22 = ");" + NL + "" + NL + "\t\t\t// Remember the static instance." + NL + "\t\t\t//" + NL + "\t\t\tplugin = this;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL;

	public Plugin()
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

this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel)parameterParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
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

    
GenModel genModel = parameter;
targetPath = genModel.getModelDirectory();
packageName = genModel.getModelPluginPackageName();
className = genModel.getModelPluginClassName();
arguments = null;

    }
    protected void method_setCanGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
GenModel genModel = parameter;
canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
canGenerate = canGenerate && (genModel.hasModelPluginClass());

    }
    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
if (canGenerate)
    new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

    }
    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
if (!canGenerate)
    return;
Object argument = parameter;
if (arguments != null)
    argument = ((Object[]) arguments)[0];

    
/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
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

    GenModel genModel = (GenModel)argument;
    stringBuffer.append(TEXT_1);
    final Map<String, Object> parameters__1phA0GKMEd_wNQtGaQlw = new HashMap<String, Object>();
parameters__1phA0GKMEd_wNQtGaQlw.put("argument", parameter);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), parameters__1phA0GKMEd_wNQtGaQlw);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(genModel.getModelPluginPackageName());
    stringBuffer.append(TEXT_3);
    genModel.addImport("org.eclipse.emf.common.EMFPlugin");
    genModel.addImport("org.eclipse.emf.common.util.ResourceLocator");
    genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genModel.getModelPluginClassName());
    stringBuffer.append(TEXT_6);
    if (genModel.hasCopyrightField()) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genModel.getCopyrightFieldLiteral());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genModel.getModelPluginClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genModel.getModelPluginClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genModel.getModelPluginClassName());
    stringBuffer.append(TEXT_14);
    if (genModel.useClassOverrideAnnotation()) {
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    if (genModel.needsRuntimeCompatibility()) {
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    if (genModel.needsRuntimeCompatibility()) {
    stringBuffer.append(genModel.getImportedName("org.eclipse.core.runtime.IPluginDescriptor"));
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    if (genModel.needsRuntimeCompatibility()) {
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    genModel.emitSortedImports();
    stringBuffer.append(TEXT_23);
    }
    }