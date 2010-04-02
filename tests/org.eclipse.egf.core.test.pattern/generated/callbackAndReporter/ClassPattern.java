package callbackAndReporter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.CallHelper;
import org.eclipse.egf.pattern.execution.CallbackContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.query.IQuery;

public class ClassPattern {
    protected static String nl;

    public static synchronized ClassPattern create(String lineSeparator) {
        nl = lineSeparator;
        ClassPattern result = new ClassPattern();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "[class ";
    protected final String TEXT_2 = "]";
    protected final String TEXT_3 = "[end Class]";
    protected final String TEXT_4 = NL;
    protected final String TEXT_5 = NL;

    public ClassPattern() {
        // Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been
        // already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> parameterList = null;
        // this pattern can only be called by another (i.e. it's not an entry
        // point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.emf.ecore.EClass) parameterParameter;

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
        int index = 0, executionIndex = ictx.getExecutionBuffer().length();

        method_start(ictx.getBuffer(), ictx);
        {
            final Map<String, Object> parameters = new HashMap<String, Object>();
            index = ictx.getBuffer().length();
            ictx.getExecutionBuffer().append(ictx.getBuffer());
            parameters.put("parameter", this.parameter);
            CallbackContext ctx_callback = new CallbackContext(ictx);
            CallHelper.callBack(ctx_callback, parameters);
        }

        method_end(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(index));
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.emf.ecore.EClass parameter = null;

    public void set_parameter(org.eclipse.emf.ecore.EClass object) {
        this.parameter = object;
    }

    protected void method_start(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(parameter.getName());
        stringBuffer.append(TEXT_2);
    }

    protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_3);
    }
}