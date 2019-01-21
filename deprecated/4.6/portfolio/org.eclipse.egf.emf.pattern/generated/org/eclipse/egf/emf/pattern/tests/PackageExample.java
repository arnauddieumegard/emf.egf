//Generated with EGF 1.3.0.qualifier
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

public class PackageExample extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
	protected static String nl;

	public static synchronized PackageExample create(String lineSeparator) {
		nl = lineSeparator;
		PackageExample result = new PackageExample();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL;
	protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL
			+ " * A sample utility for the '<em><b>";
	protected final String TEXT_5 = "</b></em>' package." + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL
			+ " */" + NL + "public class ";
	protected final String TEXT_6 = NL + "{";
	protected final String TEXT_7 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_8 = " copyright = ";
	protected final String TEXT_9 = ";";
	protected final String TEXT_10 = NL + "\t";
	protected final String TEXT_11 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * Load all the argument file paths or URIs as instances of the model." + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @param args the file paths or URIs." + NL + "\t * @generated"
			+ NL + "\t */" + NL + "\tpublic static void main(String[] args)" + NL + "\t{" + NL
			+ "\t\t// Create a resource set to hold the resources." + NL + "\t\t//" + NL + "\t\t";
	protected final String TEXT_12 = " resourceSet = new ";
	protected final String TEXT_13 = "();" + NL + "\t\t";
	protected final String TEXT_14 = NL + "\t\t// Register the appropriate resource factory to handle the content type."
			+ NL + "\t\t//" + NL + "\t\tresourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put" + NL
			+ "\t\t\t(";
	protected final String TEXT_15 = ".eCONTENT_TYPE," + NL + "\t\t\t new ";
	protected final String TEXT_16 = "());" + NL + "\t\t" + NL
			+ "\t\t// Register the appropriate content handler for all file extensions and any element from the package's namespace."
			+ NL + "\t\t//" + NL + "\t\tresourceSet.getURIConverter().getContentHandlers().add" + NL + "\t\t\t(new ";
	protected final String TEXT_17 = "(";
	protected final String TEXT_18 = ".eCONTENT_TYPE, null, null, ";
	protected final String TEXT_19 = ".eNS_URI";
	protected final String TEXT_20 = "(";
	protected final String TEXT_21 = ")null";
	protected final String TEXT_22 = ", null));";
	protected final String TEXT_23 = NL
			+ "\t\t// Register the appropriate resource factory to handle all file extensions." + NL + "\t\t//" + NL
			+ "\t\tresourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put" + NL
			+ "\t\t\t(Resource.Factory.Registry.DEFAULT_EXTENSION, " + NL + "\t\t\t new ";
	protected final String TEXT_24 = "());";
	protected final String TEXT_25 = NL + NL + "\t\t// Register the package to ensure it is available during loading."
			+ NL + "\t\t//" + NL + "\t\tresourceSet.getPackageRegistry().put" + NL + "\t\t\t(";
	protected final String TEXT_26 = ".eNS_URI, " + NL + "\t\t\t ";
	protected final String TEXT_27 = ".eINSTANCE);" + NL + "        " + NL
			+ "\t\t// If there are no arguments, emit an appropriate usage message." + NL + "\t\t//" + NL
			+ "\t\tif (args.length == 0)" + NL + "\t\t{";
	protected final String TEXT_28 = NL
			+ "\t\t\tSystem.out.println(\"Enter a list of file paths or URIs that have content like this:\");";
	protected final String TEXT_29 = NL + "\t\t\ttry" + NL + "\t\t\t{";
	protected final String TEXT_30 = NL + "\t\t\t\t";
	protected final String TEXT_31 = " resource = resourceSet.createResource(";
	protected final String TEXT_32 = ".createURI(\"http:///My.";
	protected final String TEXT_33 = "\"), ";
	protected final String TEXT_34 = ".eCONTENT_TYPE);";
	protected final String TEXT_35 = NL + "\t\t\t\t";
	protected final String TEXT_36 = " resource = resourceSet.createResource(";
	protected final String TEXT_37 = ".createURI(\"http:///My.";
	protected final String TEXT_38 = "\"));";
	protected final String TEXT_39 = NL + "\t\t\t\t";
	protected final String TEXT_40 = " documentRoot = ";
	protected final String TEXT_41 = ".create";
	protected final String TEXT_42 = "();" + NL + "\t\t\t\t";
	protected final String TEXT_43 = " root = ";
	protected final String TEXT_44 = ".create";
	protected final String TEXT_45 = "();";
	protected final String TEXT_46 = NL + "\t\t\t\tdocumentRoot.eSet(";
	protected final String TEXT_47 = ", root);";
	protected final String TEXT_48 = NL + "\t\t\t\tdocumentRoot.set";
	protected final String TEXT_49 = "(root);";
	protected final String TEXT_50 = NL + "\t\t\t\tresource.getContents().add(";
	protected final String TEXT_51 = "(";
	protected final String TEXT_52 = ")";
	protected final String TEXT_53 = "documentRoot);";
	protected final String TEXT_54 = NL + "\t\t\t\t";
	protected final String TEXT_55 = " root = ";
	protected final String TEXT_56 = ".create";
	protected final String TEXT_57 = "();" + NL + "\t\t\t\tresource.getContents().add(";
	protected final String TEXT_58 = "(";
	protected final String TEXT_59 = ")";
	protected final String TEXT_60 = "root);";
	protected final String TEXT_61 = NL + "\t\t\t\tresource.save(";
	protected final String TEXT_62 = ".out, null);" + NL + "\t\t\t}" + NL + "\t\t\tcatch (";
	protected final String TEXT_63 = " exception) " + NL + "\t\t\t{" + NL + "\t\t\t\texception.printStackTrace();" + NL
			+ "\t\t\t}";
	protected final String TEXT_64 = NL + "\t\t\tSystem.out.println(\"Enter a list of file paths or URIs\");";
	protected final String TEXT_65 = NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL
			+ "\t\t\t// Iterate over all the arguments." + NL + "\t\t\t//" + NL
			+ "\t\t\tfor (int i = 0; i < args.length; ++i)" + NL + "\t\t\t{" + NL
			+ "\t\t\t\t// Construct the URI for the instance file." + NL
			+ "\t\t\t\t// The argument is treated as a file path only if it denotes an existing file." + NL
			+ "\t\t\t\t// Otherwise, it's directly treated as a URL." + NL + "\t\t\t\t//" + NL + "\t\t\t\t";
	protected final String TEXT_66 = " file = new ";
	protected final String TEXT_67 = "(args[i]);" + NL + "\t\t\t\t";
	protected final String TEXT_68 = " uri = file.isFile() ? ";
	protected final String TEXT_69 = ".createFileURI(file.getAbsolutePath()): URI.createURI(args[i]);" + NL + "" + NL
			+ "\t\t\t\ttry" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\t// Demand load resource for this file." + NL
			+ "\t\t\t\t\t//" + NL + "\t\t\t\t\t";
	protected final String TEXT_70 = " resource = resourceSet.getResource(uri, true);" + NL
			+ "\t\t\t\t\tSystem.out.println(\"Loaded \" + uri);";
	protected final String TEXT_71 = NL + NL + "\t\t\t\t\t// Validate the contents of the loaded resource." + NL
			+ "\t\t\t\t\t//";
	protected final String TEXT_72 = NL + "\t\t\t\t\tfor (";
	protected final String TEXT_73 = " eObject : resource.getContents())";
	protected final String TEXT_74 = NL + "\t\t\t\t\tfor (";
	protected final String TEXT_75 = " j = resource.getContents().iterator(); j.hasNext(); )";
	protected final String TEXT_76 = NL + "\t\t\t\t\t{";
	protected final String TEXT_77 = NL + "\t\t\t\t\t\t";
	protected final String TEXT_78 = " eObject = (";
	protected final String TEXT_79 = ")j.next();";
	protected final String TEXT_80 = NL + "\t\t\t\t\t\t";
	protected final String TEXT_81 = " diagnostic = ";
	protected final String TEXT_82 = ".INSTANCE.validate(eObject);" + NL
			+ "\t\t\t\t\t\tif (diagnostic.getSeverity() != Diagnostic.OK)" + NL + "\t\t\t\t\t\t{" + NL
			+ "\t\t\t\t\t\t\tprintDiagnostic(diagnostic, \"\");";
	protected final String TEXT_83 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL
			+ "\t\t\t\tcatch (";
	protected final String TEXT_84 = " exception) " + NL + "\t\t\t\t{" + NL
			+ "\t\t\t\t\tSystem.out.println(\"Problem loading \" + uri);";
	protected final String TEXT_85 = NL + "\t\t\t\t\texception.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}"
			+ NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * Prints diagnostics with indentation." + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @param diagnostic the diagnostic to print." + NL
			+ "\t * @param indent the indentation for printing." + NL + "\t * @generated" + NL + "\t */" + NL
			+ "\tprotected static void printDiagnostic(Diagnostic diagnostic, String indent)" + NL + "\t{" + NL
			+ "\t\tSystem.out.print(indent);" + NL + "\t\tSystem.out.println(diagnostic.getMessage());";
	protected final String TEXT_86 = NL + "\t\tfor (Diagnostic child : diagnostic.getChildren())" + NL + "\t\t{" + NL
			+ "\t\t\tprintDiagnostic(child, indent + \"  \");";
	protected final String TEXT_87 = NL + "\t\t}";
	protected final String TEXT_88 = NL + "\t\tfor (Iterator i = diagnostic.getChildren().iterator(); i.hasNext(); )"
			+ NL + "\t\t{" + NL + "\t\t\tprintDiagnostic((Diagnostic)i.next(), indent + \"  \");";
	protected final String TEXT_89 = NL + "\t\t}";
	protected final String TEXT_90 = NL + "\t}" + NL + "" + NL + "} //";
	protected final String TEXT_91 = NL;
	protected final String TEXT_92 = NL;
	protected final String TEXT_93 = NL;

	public PackageExample() {
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

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_92);
		stringBuffer.append(TEXT_93);
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

		GenPackage genPackage = parameter;
		targetPath = genPackage.getGenModel().getTestsDirectory();
		packageName = genPackage.getTestsPackageName();
		className = genPackage.getExampleClassName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenPackage genPackage = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getTestsDirectory(), genModel,
				GenBaseGeneratorAdapter.TESTS_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * Copyright (c) 2005-2007 IBM Corporation and others.
		 * This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v2.0
		 * which accompanies this distribution, and is available at
		 * https://www.eclipse.org/legal/epl-v2.0
		 *
		 * SPDX-License-Identifier: EPL-2.0
		 * 
		 * Contributors: 
		 *   IBM - Initial API and implementation
		 */

		GenPackage genPackage = (GenPackage) argument;
		GenModel genModel = genPackage.getGenModel();

		String _System = genModel.getImportedName("java.lang.System");
		String _String = genModel.getImportedName("java.lang.String");
		String _RuntimeException = genModel.getImportedName("java.lang.RuntimeException");
		String _File = genModel.getImportedName("java.io.File");
		String _Iterator = null;
		if (!genModel.useGenerics()) {
			_Iterator = genModel.getImportedName("java.util.Iterator");
		}
		String _Diagnostic = genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic");
		String _URI = genModel.getImportedName("org.eclipse.emf.common.util.URI");
		String _EObject = genModel.getImportedName("org.eclipse.emf.ecore.EObject");
		String _Diagnostician = genModel.getImportedName("org.eclipse.emf.ecore.util.Diagnostician");
		String _Resource = genModel.getImportedName("org.eclipse.emf.ecore.resource.Resource");
		String _ResourceSet = genModel.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet");
		String _ResourceSetImpl = genModel.getImportedName("org.eclipse.emf.ecore.resource.impl.ResourceSetImpl");

		stringBuffer.append(TEXT_1);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genPackage.getTestsPackageName());
		stringBuffer.append(TEXT_3);
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genPackage.getPackageName());
		stringBuffer.append(TEXT_5);
		stringBuffer.append(genPackage.getExampleClassName());
		stringBuffer.append(TEXT_6);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_7);
			stringBuffer.append(_String);
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_9);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_10);
		}
		stringBuffer.append(TEXT_11);
		stringBuffer.append(_ResourceSet);
		stringBuffer.append(TEXT_12);
		stringBuffer.append(_ResourceSetImpl);
		stringBuffer.append(TEXT_13);
		if (genPackage.isContentType()) {
			stringBuffer.append(TEXT_14);
			stringBuffer.append(genPackage.getImportedPackageInterfaceName());
			stringBuffer.append(TEXT_15);
			stringBuffer.append(genModel.getImportedName(genPackage.getQualifiedEffectiveResourceFactoryClassName()));
			stringBuffer.append(TEXT_16);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl"));
			stringBuffer.append(TEXT_17);
			stringBuffer.append(genPackage.getImportedPackageInterfaceName());
			stringBuffer.append(TEXT_18);
			if (genPackage.hasTargetNamespace()) {
				stringBuffer.append(genPackage.getImportedPackageInterfaceName());
				stringBuffer.append(TEXT_19);
			} else {
				stringBuffer.append(TEXT_20);
				stringBuffer.append(_String);
				stringBuffer.append(TEXT_21);
			}
			stringBuffer.append(TEXT_22);
		} else {
			stringBuffer.append(TEXT_23);
			stringBuffer.append(genModel.getImportedName(genPackage.getQualifiedEffectiveResourceFactoryClassName()));
			stringBuffer.append(TEXT_24);
		}
		stringBuffer.append(TEXT_25);
		stringBuffer.append(genPackage.getImportedPackageInterfaceName());
		stringBuffer.append(TEXT_26);
		stringBuffer.append(genPackage.getImportedPackageInterfaceName());
		stringBuffer.append(TEXT_27);
		if (genPackage.getRootClass() != null) {
			GenClass rootClass = genPackage.getRootClass();
			stringBuffer.append(TEXT_28);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_29);
			if (genPackage.isContentType()) {
				stringBuffer.append(TEXT_30);
				stringBuffer.append(_Resource);
				stringBuffer.append(TEXT_31);
				stringBuffer.append(_URI);
				stringBuffer.append(TEXT_32);
				stringBuffer.append(genPackage.getFileExtension());
				stringBuffer.append(TEXT_33);
				stringBuffer.append(genPackage.getImportedPackageInterfaceName());
				stringBuffer.append(TEXT_34);
				stringBuffer.append(genModel.getNonNLS());
			} else {
				stringBuffer.append(TEXT_35);
				stringBuffer.append(_Resource);
				stringBuffer.append(TEXT_36);
				stringBuffer.append(_URI);
				stringBuffer.append(TEXT_37);
				stringBuffer.append(genPackage.getFileExtension());
				stringBuffer.append(TEXT_38);
				stringBuffer.append(genModel.getNonNLS());
			}
			if (genPackage.getRootFeature() != null) {
				GenFeature rootFeature = genPackage.getRootFeature();
				GenClass documentRoot = rootFeature.getGenClass();
				stringBuffer.append(TEXT_39);
				stringBuffer.append(documentRoot.getImportedInterfaceName());
				stringBuffer.append(TEXT_40);
				stringBuffer.append(genPackage.getQualifiedEFactoryInternalInstanceAccessor());
				stringBuffer.append(TEXT_41);
				stringBuffer.append(documentRoot.getName());
				stringBuffer.append(TEXT_42);
				stringBuffer.append(rootClass.getImportedInterfaceName());
				stringBuffer.append(TEXT_43);
				stringBuffer.append(rootClass.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
				stringBuffer.append(TEXT_44);
				stringBuffer.append(rootClass.getName());
				stringBuffer.append(TEXT_45);
				if (documentRoot.isDynamic()) {
					stringBuffer.append(TEXT_46);
					stringBuffer.append(rootFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_47);
				} else {
					stringBuffer.append(TEXT_48);
					stringBuffer.append(rootFeature.getCapName());
					stringBuffer.append(TEXT_49);
				}
				stringBuffer.append(TEXT_50);
				if (!documentRoot.isEObjectExtension()) {
					stringBuffer.append(TEXT_51);
					stringBuffer.append(_EObject);
					stringBuffer.append(TEXT_52);
				}
				stringBuffer.append(TEXT_53);
			} else {
				stringBuffer.append(TEXT_54);
				stringBuffer.append(rootClass.getImportedInterfaceName());
				stringBuffer.append(rootClass.getInterfaceWildTypeArguments());
				stringBuffer.append(TEXT_55);
				stringBuffer.append(rootClass.getGenPackage().getQualifiedEFactoryInternalInstanceAccessor());
				stringBuffer.append(TEXT_56);
				stringBuffer.append(rootClass.getName());
				stringBuffer.append(TEXT_57);
				if (!rootClass.isEObjectExtension()) {
					stringBuffer.append(TEXT_58);
					stringBuffer.append(_EObject);
					stringBuffer.append(TEXT_59);
				}
				stringBuffer.append(TEXT_60);
			}
			stringBuffer.append(TEXT_61);
			stringBuffer.append(_System);
			stringBuffer.append(TEXT_62);
			stringBuffer.append(genModel.getImportedName("java.io.IOException"));
			stringBuffer.append(TEXT_63);
		} else {
			stringBuffer.append(TEXT_64);
		}
		stringBuffer.append(TEXT_65);
		stringBuffer.append(_File);
		stringBuffer.append(TEXT_66);
		stringBuffer.append(_File);
		stringBuffer.append(TEXT_67);
		stringBuffer.append(_URI);
		stringBuffer.append(TEXT_68);
		stringBuffer.append(_URI);
		stringBuffer.append(TEXT_69);
		stringBuffer.append(_Resource);
		stringBuffer.append(TEXT_70);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_71);
		if (genModel.useGenerics()) {
			stringBuffer.append(TEXT_72);
			stringBuffer.append(_EObject);
			stringBuffer.append(TEXT_73);
		} else {
			stringBuffer.append(TEXT_74);
			stringBuffer.append(_Iterator);
			stringBuffer.append(TEXT_75);
		}
		stringBuffer.append(TEXT_76);
		if (!genModel.useGenerics()) {
			stringBuffer.append(TEXT_77);
			stringBuffer.append(_EObject);
			stringBuffer.append(TEXT_78);
			stringBuffer.append(_EObject);
			stringBuffer.append(TEXT_79);
		}
		stringBuffer.append(TEXT_80);
		stringBuffer.append(_Diagnostic);
		stringBuffer.append(TEXT_81);
		stringBuffer.append(_Diagnostician);
		stringBuffer.append(TEXT_82);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_83);
		stringBuffer.append(_RuntimeException);
		stringBuffer.append(TEXT_84);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_85);
		if (genModel.useGenerics()) {
			stringBuffer.append(TEXT_86);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_87);
		} else {
			stringBuffer.append(TEXT_88);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_89);
		}
		stringBuffer.append(TEXT_90);
		stringBuffer.append(genPackage.getExampleClassName());
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_91);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenPackage genPackage = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.TestsProject");
		canGenerate = canGenerate && (genPackage.hasClassifiers() && genPackage.isGenerateExampleClass());
		return canGenerate;
	}
}