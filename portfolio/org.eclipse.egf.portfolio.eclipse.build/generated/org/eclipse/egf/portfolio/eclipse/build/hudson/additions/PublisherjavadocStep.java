package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class PublisherjavadocStep extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Publisheradd {
	protected static String nl;

	public static synchronized PublisherjavadocStep create(String lineSeparator) {
		nl = lineSeparator;
		PublisherjavadocStep result = new PublisherjavadocStep();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "    <hudson.tasks.JavadocArchiver>" + NL + "      <javadocDir>../javadoc</javadocDir>" + NL + "      <keepAll>false</keepAll>" + NL + "    </hudson.tasks.JavadocArchiver>" + NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public PublisherjavadocStep() {
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

		paramDesc = new IQuery.ParameterDescription("javadocStep", "http://www.eclipse.org/egf/1.0.1/buildstep#//JavadocStep");
		queryCtx = new HashMap<String, String>();
		List<Object> javadocStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object javadocStepParameter : javadocStepList) {

			this.javadocStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep) javadocStepParameter;

			if (preCondition()) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("javadocStep", this.javadocStep);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep javadocStep = null;

	public void set_javadocStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep object) {
		this.javadocStep = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("javadocStep", this.javadocStep);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@15a37ef (description: null) (name: body) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._GyPi8J7_Ed-9VeXE6iwCzg/method._GyPi9J7_Ed-9VeXE6iwCzg.pt)", stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return super.preCondition();
	}
}