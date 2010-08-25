package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class Triggercron extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Triggeradd {
    protected static String nl;

    public static synchronized Triggercron create(String lineSeparator) {
        nl = lineSeparator;
        Triggercron result = new Triggercron();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "    <hudson.triggers.TimerTrigger>" + NL + "      <spec>";
    protected final String TEXT_2 = "</spec>" + NL + "    </hudson.triggers.TimerTrigger>" + NL;
    protected final String TEXT_3 = NL;
    protected final String TEXT_4 = NL;

    public Triggercron() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("cronTrigger", "http://www.eclipse.org/egf/1.0.0/buildtrigger#//CronTrigger");
        queryCtx = new HashMap<String, String>();
        List<Object> cronTriggerList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);

        for (Object cronTriggerParameter : cronTriggerList) {

            this.cronTrigger = (org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger) cronTriggerParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_3);
        stringBuffer.append(TEXT_4);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("cronTrigger", this.cronTrigger);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger cronTrigger = null;

    public void set_cronTrigger(org.eclipse.egf.portfolio.eclipse.build.buildtrigger.CronTrigger object) {
        this.cronTrigger = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cronTrigger", this.cronTrigger);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(cronTrigger.getPlanning());
        stringBuffer.append(TEXT_2);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}