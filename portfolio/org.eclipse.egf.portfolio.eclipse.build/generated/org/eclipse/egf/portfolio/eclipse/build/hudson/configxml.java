package org.eclipse.egf.portfolio.eclipse.build.hudson;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class configxml extends org.eclipse.egf.portfolio.eclipse.build.JobFilePattern {
    protected static String nl;

    public static synchronized configxml create(String lineSeparator) {
        nl = lineSeparator;
        configxml result = new configxml();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "<project>" + NL;
    protected final String TEXT_2 = "  <description>";
    protected final String TEXT_3 = "</description>" + NL + "  <actions>";
    protected final String TEXT_4 = NL;
    protected final String TEXT_5 = NL + "  </actions>" + NL + "  <builders>";
    protected final String TEXT_6 = NL;
    protected final String TEXT_7 = NL + "  </builders>" + NL + "  <buildWrappers>";
    protected final String TEXT_8 = NL;
    protected final String TEXT_9 = NL + "  </buildWrappers>" + NL + "  <properties>";
    protected final String TEXT_10 = NL;
    protected final String TEXT_11 = NL + "  </properties>" + NL + "  <publishers>";
    protected final String TEXT_12 = NL;
    protected final String TEXT_13 = NL + "  </publishers>" + NL + "  <triggers class=\"vector\">";
    protected final String TEXT_14 = NL;
    protected final String TEXT_15 = NL + "  </triggers>" + NL;
    protected final String TEXT_16 = "</project>";
    protected final String TEXT_17 = NL;
    protected final String TEXT_18 = NL;

    public configxml() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> jobList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object jobParameter : jobList) {

            this.job = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Job) jobParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_17);
        stringBuffer.append(TEXT_18);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        method_begin(ictx.getBuffer(), ictx);

        method_body(ictx.getBuffer(), ictx);
        {
            ictx.setExecutionCurrentIndex(ictx.getBuffer().length());
            ictx.getExecutionBuffer().append(ictx.getBuffer());
            final Map<String, Object> parameters = getParameters();
            CallbackContext ctx_callback = new CallbackContext(ictx);
            CallHelper.callBack(ctx_callback, parameters);
        }

        method_end(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("job", this.job);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("job", this.job);
        return parameters;
    }

    protected void method_setFileName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        fileName = "config.xml";
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
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(job.getDescription()));
        stringBuffer.append(TEXT_3);
        stringBuffer.append(TEXT_4);
        {
            //<%@ egf:patternInjectedCall toInject="job"
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.hudson.call.Action.add"
            //%>

            ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
            callCtx.setValue(PatternContext.INJECTED_CONTEXT, job);
            CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_6L_TEJAWEd-LOqbFhvvp0A", callCtx);
        }

        stringBuffer.append(TEXT_5);
        stringBuffer.append(TEXT_6);
        {
            //<%@ egf:patternInjectedCall toInject="job"
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.hudson.call.Builder.add"
            //%>

            ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
            callCtx.setValue(PatternContext.INJECTED_CONTEXT, job);
            CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_AQWCMJAXEd-LOqbFhvvp0A", callCtx);
        }

        stringBuffer.append(TEXT_7);
        stringBuffer.append(TEXT_8);
        {
            //<%@ egf:patternInjectedCall toInject="job"
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.hudson.call.BuildWrapper.add"
            //%>

            ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
            callCtx.setValue(PatternContext.INJECTED_CONTEXT, job);
            CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_EBBegJAXEd-LOqbFhvvp0A", callCtx);
        }

        stringBuffer.append(TEXT_9);
        stringBuffer.append(TEXT_10);
        {
            //<%@ egf:patternInjectedCall toInject="job"
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.hudson.call.Property.add"
            //%>

            ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
            callCtx.setValue(PatternContext.INJECTED_CONTEXT, job);
            CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_H6o0YJAXEd-LOqbFhvvp0A", callCtx);
        }

        stringBuffer.append(TEXT_11);
        stringBuffer.append(TEXT_12);
        {
            //<%@ egf:patternInjectedCall toInject="job"
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.hudson.call.Publisher.add"
            //%>

            ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
            callCtx.setValue(PatternContext.INJECTED_CONTEXT, job);
            CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_LaUnUJAXEd-LOqbFhvvp0A", callCtx);
        }

        stringBuffer.append(TEXT_13);
        stringBuffer.append(TEXT_14);
        {
            //<%@ egf:patternInjectedCall toInject="job"
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.hudson.call.Trigger.add"
            //%>

            ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
            callCtx.setValue(PatternContext.INJECTED_CONTEXT, job);
            CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_N0HwQJAXEd-LOqbFhvvp0A", callCtx);
        }

        stringBuffer.append(TEXT_15);
    }

    protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_16);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}