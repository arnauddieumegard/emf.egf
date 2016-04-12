//Generated with EGF 1.3.0.qualifier
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

public class PluginXML extends org.eclipse.egf.emf.pattern.base.GenModelText {
	protected static String nl;

	public static synchronized PluginXML create(String lineSeparator) {
		nl = lineSeparator;
		PluginXML result = new PluginXML();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>"
			+ NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL + "<plugin>";
	protected final String TEXT_5 = NL + "<plugin" + NL + "      name=\"%pluginName\"" + NL + "      id=\"";
	protected final String TEXT_6 = "\"" + NL + "      version=\"1.0.0\"";
	protected final String TEXT_7 = NL + "      provider-name=\"%providerName\"" + NL + "      class=\"";
	protected final String TEXT_8 = "$Implementation\">";
	protected final String TEXT_9 = NL + "      provider-name=\"%providerName\">";
	protected final String TEXT_10 = NL + NL + "   <requires>";
	protected final String TEXT_11 = NL + "      <import plugin=\"";
	protected final String TEXT_12 = "\"";
	protected final String TEXT_13 = " export=\"true\"";
	protected final String TEXT_14 = "/>";
	protected final String TEXT_15 = NL + "   </requires>" + NL + "" + NL + "   <runtime>";
	protected final String TEXT_16 = NL + "      <library name=\"";
	protected final String TEXT_17 = ".jar\">";
	protected final String TEXT_18 = NL + "      <library name=\".\">";
	protected final String TEXT_19 = NL + "         <export name=\"*\"/>" + NL + "      </library>" + NL
			+ "   </runtime>";
	protected final String TEXT_20 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.generated_package\">";
	protected final String TEXT_21 = NL + "      <!-- @generated ";
	protected final String TEXT_22 = " -->";
	protected final String TEXT_23 = NL + "      <package" + NL + "            uri=\"";
	protected final String TEXT_24 = "\"";
	protected final String TEXT_25 = NL + "            class=\"";
	protected final String TEXT_26 = "\"" + NL + "            genModel=\"";
	protected final String TEXT_27 = "\"/>";
	protected final String TEXT_28 = NL + "            class=\"";
	protected final String TEXT_29 = "\"/>";
	protected final String TEXT_30 = NL + "   </extension>";
	protected final String TEXT_31 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.content_parser\">";
	protected final String TEXT_32 = NL + "      <!-- @generated ";
	protected final String TEXT_33 = " -->";
	protected final String TEXT_34 = NL + "      <parser" + NL + "            contentTypeIdentifier=\"";
	protected final String TEXT_35 = "\"" + NL + "            class=\"";
	protected final String TEXT_36 = "\"/>" + NL + "   </extension>" + NL + "" + NL
			+ "   <extension point=\"org.eclipse.core.contenttype.contentTypes\">";
	protected final String TEXT_37 = NL + "      <!-- @generated ";
	protected final String TEXT_38 = " -->";
	protected final String TEXT_39 = NL + "      <content-type" + NL + "            base-type=\"";
	protected final String TEXT_40 = "\"" + NL + "            file-extensions=\"";
	protected final String TEXT_41 = "\"" + NL + "            id=\"";
	protected final String TEXT_42 = "\"" + NL + "            name=\"%_UI_";
	protected final String TEXT_43 = "_content_type\"" + NL + "            priority=\"normal\">" + NL
			+ "         <describer class=\"org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl$Describer\">";
	protected final String TEXT_44 = NL + "            <parameter name=\"namespace\" value=\"";
	protected final String TEXT_45 = "\"/>";
	protected final String TEXT_46 = NL + "            <parameter name=\"kind\" value=\"xmi\"/>";
	protected final String TEXT_47 = NL + "         </describer>" + NL + "      </content-type>" + NL
			+ "   </extension>";
	protected final String TEXT_48 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.extension_parser\">";
	protected final String TEXT_49 = NL + "      <!-- @generated ";
	protected final String TEXT_50 = " -->";
	protected final String TEXT_51 = NL + "      <parser" + NL + "            type=\"";
	protected final String TEXT_52 = "\"" + NL + "            class=\"";
	protected final String TEXT_53 = "\"/>";
	protected final String TEXT_54 = NL + "   </extension>";
	protected final String TEXT_55 = NL + NL + "</plugin>" + NL;
	protected final String TEXT_56 = NL;
	protected final String TEXT_57 = NL;

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
		Node.Container currentNode = ctx.getNode();

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_56);
		stringBuffer.append(TEXT_57);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_preGenerate(new StringBuffer(), ictx);

		method_doGenerate(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_postGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		GenModel genModel = parameter;
		targetPathName = genModel.getModelProjectDirectory() + "/plugin.xml";
		overwrite = true;
		encoding = "UTF-8";

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenModel genModel = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel,
				GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * Copyright (c) 2002-2005 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 * 
		 * Contributors: 
		 *   IBM - Initial API and implementation
		 */

		GenModel genModel = (GenModel) argument;
		String key = genModel.getPluginKey();
		boolean hasKey = key != null && !key.equals("");
		/* Trick to import java.util.* without warnings */Iterator.class.getName();
		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderXml" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#__h1VkCwtEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_3);
		if (genModel.isBundleManifest()) {
			stringBuffer.append(TEXT_4);
		} else {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genModel.getModelPluginID());
			stringBuffer.append(TEXT_6);
			if (genModel.hasModelPluginClass()) {
				stringBuffer.append(TEXT_7);
				stringBuffer.append(genModel.getQualifiedModelPluginClassName());
				stringBuffer.append(TEXT_8);
			} else {
				stringBuffer.append(TEXT_9);
			}
			stringBuffer.append(TEXT_10);
			for (String pluginID : genModel.getModelRequiredPlugins()) {
				stringBuffer.append(TEXT_11);
				stringBuffer.append(pluginID);
				stringBuffer.append(TEXT_12);
				if (!pluginID.startsWith("org.eclipse.core.runtime")) {
					stringBuffer.append(TEXT_13);
				}
				stringBuffer.append(TEXT_14);
			}
			stringBuffer.append(TEXT_15);
			if (genModel.isRuntimeJar()) {
				stringBuffer.append(TEXT_16);
				stringBuffer.append(genModel.getModelPluginID());
				stringBuffer.append(TEXT_17);
			} else {
				stringBuffer.append(TEXT_18);
			}
			stringBuffer.append(TEXT_19);
		}
		for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
			stringBuffer.append(TEXT_20);
			if (hasKey) {
				stringBuffer.append(TEXT_21);
				stringBuffer.append(key);
				stringBuffer.append(TEXT_22);
			}
			stringBuffer.append(TEXT_23);
			stringBuffer.append(genPackage.getNSURI());
			stringBuffer.append(TEXT_24);
			if (genModel.hasLocalGenModel()) {
				stringBuffer.append(TEXT_25);
				stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genModel.getRelativeGenModelLocation());
				stringBuffer.append(TEXT_27);
			} else {
				stringBuffer.append(TEXT_28);
				stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
				stringBuffer.append(TEXT_29);
			}
			stringBuffer.append(TEXT_30);
			if (genPackage.isContentType()) {
				stringBuffer.append(TEXT_31);
				if (hasKey) {
					stringBuffer.append(TEXT_32);
					stringBuffer.append(key);
					stringBuffer.append(TEXT_33);
				}
				stringBuffer.append(TEXT_34);
				stringBuffer.append(genPackage.getContentTypeIdentifier());
				stringBuffer.append(TEXT_35);
				stringBuffer.append(genPackage.getQualifiedEffectiveResourceFactoryClassName());
				stringBuffer.append(TEXT_36);
				if (hasKey) {
					stringBuffer.append(TEXT_37);
					stringBuffer.append(key);
					stringBuffer.append(TEXT_38);
				}
				stringBuffer.append(TEXT_39);
				stringBuffer.append(
						genPackage.isXMIResource() ? "org.eclipse.emf.ecore.xmi" : "org.eclipse.core.runtime.xml");
				stringBuffer.append(TEXT_40);
				stringBuffer.append(genPackage.getFileExtensions());
				stringBuffer.append(TEXT_41);
				stringBuffer.append(genPackage.getContentTypeIdentifier());
				stringBuffer.append(TEXT_42);
				stringBuffer.append(genPackage.getPrefix());
				stringBuffer.append(TEXT_43);
				if (genPackage.hasTargetNamespace()) {
					stringBuffer.append(TEXT_44);
					stringBuffer.append(genPackage.getNSURI());
					stringBuffer.append(TEXT_45);
				}
				if (genPackage.isXMIResource()) {
					stringBuffer.append(TEXT_46);
				}
				stringBuffer.append(TEXT_47);
			} else if (genPackage.getResource() != GenResourceKind.NONE_LITERAL) {
				stringBuffer.append(TEXT_48);
				if (hasKey) {
					stringBuffer.append(TEXT_49);
					stringBuffer.append(key);
					stringBuffer.append(TEXT_50);
				}
				for (String fileExtension : genPackage.getFileExtensionList()) {
					stringBuffer.append(TEXT_51);
					stringBuffer.append(fileExtension);
					stringBuffer.append(TEXT_52);
					stringBuffer.append(genPackage.getQualifiedResourceFactoryClassName());
					stringBuffer.append(TEXT_53);
				}
				stringBuffer.append(TEXT_54);
			}
		}
		stringBuffer.append(TEXT_55);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenModel genModel = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
		canGenerate = canGenerate && (genModel.getRuntimePlatform() != GenRuntimePlatform.GWT)
				&& (genModel.hasPluginSupport() && !genModel.sameModelEditProject()
						&& !genModel.sameModelEditorProject());
		return canGenerate;
	}
}