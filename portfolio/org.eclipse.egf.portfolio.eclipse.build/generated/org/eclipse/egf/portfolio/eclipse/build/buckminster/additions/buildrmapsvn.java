package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildrmapsvn extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildrmaplocationadd {
    protected static String nl;

    public static synchronized buildrmapsvn create(String lineSeparator) {
        nl = lineSeparator;
        buildrmapsvn result = new buildrmapsvn();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<locator searchPathRef=\"";
    protected final String TEXT_2 = "\" ";
    protected final String TEXT_3 = " failOnError=\"false\" />" + NL + "\t<searchPath name=\"";
    protected final String TEXT_4 = "\">" + NL + "\t    <!-- provider for windows if checkouted with Hudson -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file:/{0}/";
    protected final String TEXT_5 = "/";
    protected final String TEXT_6 = "/{1}";
    protected final String TEXT_7 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"build.root\" />" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t    <!-- provider for unix if checkouted with Hudson -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file://{0}/";
    protected final String TEXT_8 = "/";
    protected final String TEXT_9 = "/{1}";
    protected final String TEXT_10 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"build.root\" />" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t    <!-- standalone provider -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"svn\" source=\"true\">" + NL + "\t\t\t<uri format=\"";
    protected final String TEXT_11 = ":";
    protected final String TEXT_12 = "@";
    protected final String TEXT_13 = "/";
    protected final String TEXT_14 = "/{0}";
    protected final String TEXT_15 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t</searchPath>" + NL + NL;
    protected final String TEXT_16 = NL;
    protected final String TEXT_17 = NL;

    public buildrmapsvn() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("scmBuildLocation", "http://www.eclipse.org/egf/1.0.0/buildstep#//SCMBuildLocation");
        queryCtx = new HashMap<String, String>();
        List<Object> scmBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);

        for (Object scmBuildLocationParameter : scmBuildLocationList) {

            this.scmBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildstep.SCMBuildLocation) scmBuildLocationParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_16);
        stringBuffer.append(TEXT_17);
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
            parameterValues.put("scmBuildLocation", this.scmBuildLocation);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.SCMBuildLocation scmBuildLocation = null;

    public void set_scmBuildLocation(org.eclipse.egf.portfolio.eclipse.build.buildstep.SCMBuildLocation object) {
        this.scmBuildLocation = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("scmBuildLocation", this.scmBuildLocation);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        SVNLocation svnLocation = ((SVNLocation) scmBuildLocation.getScmLocation());
        String id = new GenerationHelper().getPositionString(scmBuildLocation);
        stringBuffer.append(TEXT_1);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getPatternString(scmBuildLocation));
        stringBuffer.append(TEXT_3);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_4);
        stringBuffer.append(svnLocation.getLocalPath());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(scmBuildLocation.getFolderName());
        stringBuffer.append(TEXT_6);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(scmBuildLocation.getSuffix()));
        stringBuffer.append(TEXT_7);
        stringBuffer.append(svnLocation.getLocalPath());
        stringBuffer.append(TEXT_8);
        stringBuffer.append(scmBuildLocation.getFolderName());
        stringBuffer.append(TEXT_9);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(scmBuildLocation.getSuffix()));
        stringBuffer.append(TEXT_10);
        stringBuffer.append(svnLocation.getProtocol().getLiteral());
        if (svnLocation.getUsername() != null) {
            stringBuffer.append(svnLocation.getUsername());
            stringBuffer.append(TEXT_11);
            stringBuffer.append(svnLocation.getPassword());
            stringBuffer.append(TEXT_12);
        }
        stringBuffer.append(svnLocation.getUrl());
        stringBuffer.append(TEXT_13);
        stringBuffer.append(scmBuildLocation.getFolderName());
        stringBuffer.append(TEXT_14);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(scmBuildLocation.getSuffix()));
        stringBuffer.append(TEXT_15);
    }

    public boolean preCondition() throws Exception {
        return scmBuildLocation.getScmLocation() instanceof SVNLocation;
    }
}