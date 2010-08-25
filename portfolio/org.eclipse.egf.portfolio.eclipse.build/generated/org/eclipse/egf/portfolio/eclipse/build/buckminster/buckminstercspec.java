package org.eclipse.egf.portfolio.eclipse.build.buckminster;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buckminstercspec extends org.eclipse.egf.portfolio.eclipse.build.BuildStepFilePattern {
    protected static String nl;

    public static synchronized buckminstercspec create(String lineSeparator) {
        nl = lineSeparator;
        buckminstercspec result = new buckminstercspec();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "<cs:cspec xmlns:cs=\"http://www.eclipse.org/buckminster/CSpec-1.0\" name=\"";
    protected final String TEXT_2 = "\" componentType=\"buckminster\" version=\"1.0.0\">" + NL + "    <cs:dependencies>" + NL;
    protected final String TEXT_3 = "    </cs:dependencies>" + NL + "    " + NL + "\t<cs:actions>" + NL + "\t\t<cs:public name=\"convertSiteToRuntime\" actor=\"ant\">" + NL + "\t\t\t<cs:actorProperties>" + NL + "\t\t\t\t<cs:property key=\"buildFile\" value=\"buckminster.ant\"/>" + NL + "\t\t\t\t<cs:property key=\"targets\" value=\"convertSiteToRuntime\"/>" + NL + "\t\t\t</cs:actorProperties>" + NL + "\t\t</cs:public>" + NL + "\t</cs:actions>" + NL + "</cs:cspec>" + NL;
    protected final String TEXT_4 = NL;
    protected final String TEXT_5 = NL;

    public buckminstercspec() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> buildStepList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object buildStepParameter : buildStepList) {

            this.buildStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep) buildStepParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_4);
        stringBuffer.append(TEXT_5);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        method_begin(ictx.getBuffer(), ictx);
        {
            ExecutionContext ctx_local = new ExecutionContext(ictx);
            ctx_local.setValue(PatternContext.INJECTED_CONTEXT, buildStep);
            CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_yCPiUJMXEd-pjLQZUcJ3fw", ctx_local);
        }

        method_end(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("buildStep", this.buildStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("buildStep", this.buildStep);
        return parameters;
    }

    protected void method_setFileName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        fileName = "buckminster.cspec";
    }

    protected void method_begin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        {
            //<%@ egf:patternCall
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.XmlHeader"
            //%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_LhlsYJ5OEd-3wvN5SnesGA", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_1);
        stringBuffer.append(buildStepName);
        stringBuffer.append(TEXT_2);
    }

    protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_3);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}