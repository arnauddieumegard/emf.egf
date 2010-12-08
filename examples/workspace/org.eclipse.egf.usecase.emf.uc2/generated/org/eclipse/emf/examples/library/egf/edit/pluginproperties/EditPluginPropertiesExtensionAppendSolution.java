package org.eclipse.emf.examples.library.egf.edit.pluginproperties;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class EditPluginPropertiesExtensionAppendSolution extends
		org.eclipse.egf.emf.pattern.edit.PluginProperties {
	protected static String nl;

	public static synchronized EditPluginPropertiesExtensionAppendSolution create(
			String lineSeparator) {
		nl = lineSeparator;
		EditPluginPropertiesExtensionAppendSolution result = new EditPluginPropertiesExtensionAppendSolution();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties()
			.getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "#--  Customization - Start" + NL
			+ "providerName = www.library.org" + NL
			+ "#--  Customization - End" + NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public EditPluginPropertiesExtensionAppendSolution() {
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
			ctx.getReporter().executionFinished(
					ctx.getExecutionBuffer().toString(), ctx);
			ctx.clearBuffer();
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		int executionIndex = ictx.getExecutionBuffer().length();

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_doGenerateAppendPart(ictx.getBuffer(), ictx);

		String loop = ictx.getBuffer().toString();
		if (ictx.useReporter()) {
			ictx.getExecutionBuffer()
					.append(
							ictx.getBuffer().substring(
									ictx.getExecutionCurrentIndex()));
			ictx.setExecutionCurrentIndex(0);
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = ictx.getExecutionBuffer().substring(
					executionIndex);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx,
					parameterValues);
			ictx.clearBuffer();
		}
		return loop;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_doGenerateAppendPart(final StringBuffer stringBuffer,
			final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
	}

	public boolean preCondition() throws Exception {
		return super.preCondition();
	}
}