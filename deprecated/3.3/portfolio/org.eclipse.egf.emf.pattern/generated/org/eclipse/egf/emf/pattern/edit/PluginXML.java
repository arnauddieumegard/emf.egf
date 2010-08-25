package org.eclipse.egf.emf.pattern.edit;

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

public class PluginXML extends org.eclipse.egf.emf.pattern.base.GenModelText {
    protected static String nl;

    public static synchronized PluginXML create(String lineSeparator) {
        nl = lineSeparator;
        PluginXML result = new PluginXML();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL;
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL + NL + "<plugin";
    protected final String TEXT_4 = ">";
    protected final String TEXT_5 = NL + "    name = \"%pluginName\"" + NL + "    id = \"";
    protected final String TEXT_6 = "\"" + NL + "    version = \"1.0.0\"" + NL + "    provider-name = \"%providerName\"" + NL + "    class = \"";
    protected final String TEXT_7 = "$Implementation\">" + NL + "" + NL + "  <requires>";
    protected final String TEXT_8 = NL + "    <import plugin=\"";
    protected final String TEXT_9 = "\" ";
    protected final String TEXT_10 = "export=\"true\"";
    protected final String TEXT_11 = "/>";
    protected final String TEXT_12 = NL + "  </requires>" + NL + "" + NL + "  <runtime>";
    protected final String TEXT_13 = NL + "    <library name=\"";
    protected final String TEXT_14 = ".jar\">";
    protected final String TEXT_15 = NL + "    <library name=\".\">";
    protected final String TEXT_16 = NL + "      <export name=\"*\"/>" + NL + "    </library>" + NL + "  </runtime>";
    protected final String TEXT_17 = NL + "    " + NL + "  <extension point=\"org.eclipse.emf.edit.itemProviderAdapterFactories\">" + NL + "    <factory " + NL + "       uri = \"";
    protected final String TEXT_18 = "\" " + NL + "       class = \"";
    protected final String TEXT_19 = "\" " + NL + "       supportedTypes = ";
    protected final String TEXT_20 = NL + "         ";
    protected final String TEXT_21 = " />" + NL + "  </extension>";
    protected final String TEXT_22 = NL + NL + "  <extension point=\"org.eclipse.emf.ecore.generated_package\">" + NL + "    <package" + NL + "       uri = \"";
    protected final String TEXT_23 = "\"" + NL + "       class = \"";
    protected final String TEXT_24 = "\"";
    protected final String TEXT_25 = " />";
    protected final String TEXT_26 = NL + "       genModel = \"";
    protected final String TEXT_27 = "\" /> ";
    protected final String TEXT_28 = NL + "  </extension>";
    protected final String TEXT_29 = NL + NL + "  <extension point=\"org.eclipse.emf.ecore.extension_parser\">" + NL + "    <parser" + NL + "       type=\"";
    protected final String TEXT_30 = "\"" + NL + "       class=\"";
    protected final String TEXT_31 = "\" />" + NL + "  </extension>";
    protected final String TEXT_32 = NL + NL + "</plugin>" + NL;
    protected final String TEXT_33 = NL;
    protected final String TEXT_34 = NL;

    public PluginXML() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> parameterList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) parameterParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_33);
        stringBuffer.append(TEXT_34);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
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
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("parameter", this.parameter);
        return parameters;
    }

    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenModel genModel = parameter;
        targetPathName = genModel.getEditProjectDirectory() + "/plugin.xml";
        overwrite = false;
        encoding = "UTF-8";

    }

    protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenModel genModel = parameter;
        argument = parameter;

    }

    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        /**
         * <copyright>
         *
         * Copyright (c) 2002-2005 IBM Corporation and others.
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

        GenModel genModel = (GenModel) argument;
        stringBuffer.append(TEXT_1);
        stringBuffer.append(TEXT_2);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderXml" args="parameter:argument"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("argument", parameter);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#__h1VkCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_3);
        if (genModel.isBundleManifest()) {
            stringBuffer.append(TEXT_4);
        } else {
            stringBuffer.append(TEXT_5);
            stringBuffer.append(genModel.getEditPluginID());
            stringBuffer.append(TEXT_6);
            stringBuffer.append(genModel.getQualifiedEditPluginClassName());
            stringBuffer.append(TEXT_7);
            for (String pluginID : genModel.getEditRequiredPlugins()) {
                stringBuffer.append(TEXT_8);
                stringBuffer.append(pluginID);
                stringBuffer.append(TEXT_9);
                if (!pluginID.startsWith("org.eclipse.core.runtime")) {
                    stringBuffer.append(TEXT_10);
                }
                stringBuffer.append(TEXT_11);
            }
            stringBuffer.append(TEXT_12);
            if (genModel.isRuntimeJar()) {
                stringBuffer.append(TEXT_13);
                stringBuffer.append(genModel.getEditPluginID());
                stringBuffer.append(TEXT_14);
            } else {
                stringBuffer.append(TEXT_15);
            }
            stringBuffer.append(TEXT_16);
        }
        for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
            if (!genPackage.getGenClasses().isEmpty()) {
                stringBuffer.append(TEXT_17);
                stringBuffer.append(genPackage.getNSURI());
                stringBuffer.append(TEXT_18);
                stringBuffer.append(genPackage.getQualifiedItemProviderAdapterFactoryClassName());
                stringBuffer.append(TEXT_19);
                for (ListIterator<?> j = genPackage.getProviderSupportedTypes().listIterator(); j.hasNext();) {
                    stringBuffer.append(TEXT_20);
                    stringBuffer.append((j.hasPrevious() ? " " : "\"") + j.next() + (j.hasNext() ? "" : "\""));
                }
                stringBuffer.append(TEXT_21);
            }
        }
        if (genModel.sameModelEditProject()) {
            for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
                stringBuffer.append(TEXT_22);
                stringBuffer.append(genPackage.getNSURI());
                stringBuffer.append(TEXT_23);
                stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
                stringBuffer.append(TEXT_24);
                if (!genModel.hasLocalGenModel()) {
                    stringBuffer.append(TEXT_25);
                } else {
                    stringBuffer.append(TEXT_26);
                    stringBuffer.append(genModel.getRelativeGenModelLocation());
                    stringBuffer.append(TEXT_27);
                }
                stringBuffer.append(TEXT_28);
                if (genPackage.getResource() != GenResourceKind.NONE_LITERAL) {
                    stringBuffer.append(TEXT_29);
                    stringBuffer.append(genPackage.getPrefix().toLowerCase());
                    stringBuffer.append(TEXT_30);
                    stringBuffer.append(genPackage.getQualifiedResourceFactoryClassName());
                    stringBuffer.append(TEXT_31);
                }
            }
        }
        stringBuffer.append(TEXT_32);
    }

    public boolean preCondition() throws Exception {
        GenModel genModel = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
        canGenerate = canGenerate && (!genModel.sameEditEditorProject());
        return canGenerate;
    }
}