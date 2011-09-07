package org.eclipse.egf.emf.pattern.edit.call.ItemProvider;

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

public class ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride {
	protected static String nl;

	public static synchronized ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride result = new ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
	protected final String TEXT_2 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_3 = ".createEntry" + NL + "\t\t\t\t\t(";
	protected final String TEXT_4 = ",";
	protected final String TEXT_5 = NL + "\t\t\t\t\t ";
	protected final String TEXT_6 = ".create(";
	protected final String TEXT_7 = "))));";
	protected final String TEXT_8 = NL + "\t\t\t\t\t ";
	protected final String TEXT_9 = ".create";
	protected final String TEXT_10 = "())));";
	protected final String TEXT_11 = NL;
	protected final String TEXT_12 = NL;
	protected final String TEXT_13 = NL;
	protected final String TEXT_14 = NL;

	public ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride() {
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

		List<Object> createClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> createFeatureList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> delegatedFeatureList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> createClassifierList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> childCreationDataList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object createClassParameter : createClassList) {
			for (Object createFeatureParameter : createFeatureList) {
				for (Object delegatedFeatureParameter : delegatedFeatureList) {
					for (Object createClassifierParameter : createClassifierList) {
						for (Object childCreationDataParameter : childCreationDataList) {
							for (Object genClassParameter : genClassList) {
								for (Object genPackageParameter : genPackageList) {
									for (Object genModelParameter : genModelList) {

										this.createClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) createClassParameter;
										this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) createFeatureParameter;
										this.delegatedFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) delegatedFeatureParameter;
										this.createClassifier = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier) createClassifierParameter;
										this.childCreationData = (org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData) childCreationDataParameter;
										this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
										this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
										this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;

										if (preCondition()) {
											ctx.setNode(new Node.Container(currentNode, getClass()));
											orchestration(ctx);
										}

									}
								}
							}
						}
					}
				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_13);
		stringBuffer.append(TEXT_14);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(ictx.getBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("createClass", this.createClass);
			parameterValues.put("createFeature", this.createFeature);
			parameterValues.put("delegatedFeature", this.delegatedFeature);
			parameterValues.put("createClassifier", this.createClassifier);
			parameterValues.put("childCreationData", this.childCreationData);
			parameterValues.put("genClass", this.genClass);
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClass createClass = null;

	public void set_createClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass object) {
		this.createClass = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature createFeature = null;

	public void set_createFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
		this.createFeature = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature delegatedFeature = null;

	public void set_delegatedFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
		this.delegatedFeature = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClassifier createClassifier = null;

	public void set_createClassifier(org.eclipse.emf.codegen.ecore.genmodel.GenClassifier object) {
		this.createClassifier = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData childCreationData = null;

	public void set_childCreationData(org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData object) {
		this.childCreationData = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClass genClass = null;

	public void set_genClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass object) {
		this.genClass = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage = null;

	public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage object) {
		this.genPackage = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;

	public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
		this.genModel = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createClass", this.createClass);
		parameters.put("createFeature", this.createFeature);
		parameters.put("delegatedFeature", this.delegatedFeature);
		parameters.put("createClassifier", this.createClassifier);
		parameters.put("childCreationData", this.childCreationData);
		parameters.put("genClass", this.genClass);
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {
		final IndexValue idx = new IndexValue(stringBuffer.length());

		stringBuffer.append(TEXT_1);
		stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
		stringBuffer.append(TEXT_2);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
		stringBuffer.append(TEXT_3);
		stringBuffer.append(delegatedFeature.getQualifiedFeatureAccessor());
		stringBuffer.append(TEXT_4);
		if (createClass.isMapEntry()) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
			stringBuffer.append(TEXT_6);
			stringBuffer.append(createClass.getQualifiedClassifierAccessor());
			stringBuffer.append(TEXT_7);
		} else {
			stringBuffer.append(TEXT_8);
			stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
			stringBuffer.append(TEXT_9);
			stringBuffer.append(createClass.getName());
			stringBuffer.append(TEXT_10);
		}
		stringBuffer.append(TEXT_11);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceDelegatedFeature.insert" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.substring(idx.value));
			idx.value = stringBuffer.length();

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("createClass", createClass);
			callParameters.put("createFeature", createFeature);
			callParameters.put("delegatedFeature", delegatedFeature);
			callParameters.put("createClassifier", createClassifier);
			callParameters.put("childCreationData", childCreationData);
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04NBAGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			idx.value = stringBuffer.length();
		}

		stringBuffer.append(TEXT_12);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.substring(idx.value));
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}