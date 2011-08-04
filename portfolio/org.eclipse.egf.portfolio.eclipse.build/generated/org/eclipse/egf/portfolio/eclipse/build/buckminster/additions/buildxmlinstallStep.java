package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

public class buildxmlinstallStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmlinstallStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmlinstallStep result = new buildxmlinstallStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" depends=\"init,get.director\" >" + NL + "        <eclipse.launch app=\"director\">" + NL + "            <args>" + NL + "                <jvmarg value=\"-Declipse.p2.mirrors=false\" />";
    protected final String TEXT_3 = NL;
    protected final String TEXT_4 = NL + NL + "            \t<arg value=\"-roaming\" />" + NL + "            \t<arg value=\"-profileProperties\" />" + NL + "                <arg value=\"org.eclipse.update.install.features=true \" />" + NL + "" + NL + "                <arg value=\"-d\" />" + NL + "                <arg value=\"${publish}/";
    protected final String TEXT_5 = "\" />" + NL + "                " + NL + "                <arg value=\"-p\" />" + NL + "                <arg value=\"";
    protected final String TEXT_6 = "\" />" + NL;
    protected final String TEXT_7 = NL + "                <arg value=\"-r\" />" + NL + "                <arg value=\"";
    protected final String TEXT_8 = "\" />";
    protected final String TEXT_9 = NL;
    protected final String TEXT_10 = NL + "                <arg value=\"-r\" />" + NL + "                <arg value=\"";
    protected final String TEXT_11 = "\" />";
    protected final String TEXT_12 = NL;
    protected final String TEXT_13 = NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"";
    protected final String TEXT_14 = ".feature.group\" />";
    protected final String TEXT_15 = "                " + NL;
    protected final String TEXT_16 = NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"";
    protected final String TEXT_17 = "\" />";
    protected final String TEXT_18 = NL;
    protected final String TEXT_19 = NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"";
    protected final String TEXT_20 = ".feature.group\" />";
    protected final String TEXT_21 = NL + NL + "            </args>" + NL + "        </eclipse.launch>" + NL + "\t</target>\t" + NL;
    protected final String TEXT_22 = NL;
    protected final String TEXT_23 = NL;

    public buildxmlinstallStep() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("installStep", "http://www.eclipse.org/egf/1.0.0/buildstep#//InstallStep");
        queryCtx = new HashMap<String, String>();
        List<Object> installStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object installStepParameter : installStepList) {

            this.installStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep) installStepParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_22);
        stringBuffer.append(TEXT_23);
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
            parameterValues.put("installStep", this.installStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep installStep = null;

    public void set_installStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStep object) {
        this.installStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("installStep", this.installStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        ArrayList<PublishStep> publishSteps = new ArrayList<PublishStep>();
        for (ResultStep resultStep : installStep.getResultSteps()) {
            if (resultStep instanceof PublishStep)
                publishSteps.add((PublishStep) resultStep);
            else if (resultStep instanceof AggregateStep)
                publishSteps.addAll(((AggregateStep) resultStep).getPublishSteps());
        }
        stringBuffer.append(TEXT_1);
        stringBuffer.append(new GenerationHelper().getPositionString(installStep));
        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
        {
            //<%@ egf:patternCall
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.buckminster.call.build.xml.Xmx"
            //%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_VCSRcJ5MEd-3wvN5SnesGA", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_4);
        stringBuffer.append(installStep.getName());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(installStep.getProfile());
        stringBuffer.append(TEXT_6);
        for (String updateSiteUrl : installStep.getUpdateSiteUrls()) {
            stringBuffer.append(TEXT_7);
            stringBuffer.append(updateSiteUrl);
            stringBuffer.append(TEXT_8);
        }
        stringBuffer.append(TEXT_9);
        for (PublishStep publishStep : publishSteps) {
            String location = "file:/${build.root}/../../" + new GenerationHelper().getJobName(ctx, publishStep.getJob()) + "/workspace/result/publish/" + publishStep.getComponent().getName() + "/site.p2";
            stringBuffer.append(TEXT_10);
            stringBuffer.append(location);
            stringBuffer.append(TEXT_11);
        }
        stringBuffer.append(TEXT_12);
        for (String featureName : installStep.getFeatureNames()) {
            stringBuffer.append(TEXT_13);
            stringBuffer.append(featureName);
            stringBuffer.append(TEXT_14);
        }
        stringBuffer.append(TEXT_15);
        for (String productName : installStep.getProductNames()) {
            stringBuffer.append(TEXT_16);
            stringBuffer.append(productName);
            stringBuffer.append(TEXT_17);
        }
        stringBuffer.append(TEXT_18);
        for (PublishStep publishStep : publishSteps) {
            stringBuffer.append(TEXT_19);
            stringBuffer.append(publishStep.getComponent().getName());
            stringBuffer.append(TEXT_20);
        }
        stringBuffer.append(TEXT_21);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}