package callbackAndReporter2;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class BasePattern 
{
  protected static String nl;
  public static synchronized BasePattern create(String lineSeparator)
  {
    nl = lineSeparator;
    BasePattern result = new BasePattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//default content";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public BasePattern()
	{
	//Here is the constructor
StringBuffer stringBuffer = new StringBuffer();

    // add initialisation of the pattern variables (declaration has been already done).
    
	}
  	
  	public String generate(Object argument) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    InternalPatternContext ctx = (InternalPatternContext)argument;
Map<String, String> queryCtx = null;
IQuery.ParameterDescription paramDesc = null;

    orchestration(ctx);
    if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();}
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0, executionIndex = ictx.getExecutionBuffer().length();

    
method_start(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
index = ictx.getBuffer().length();
ictx.getExecutionBuffer().append(ictx.getBuffer());
CallbackContext ctx_callback = new CallbackContext(ictx);
CallHelper.callBack(ctx_callback, parameters);
}

    
method_end(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
return loop;
} 


    protected void method_start(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    }
    }