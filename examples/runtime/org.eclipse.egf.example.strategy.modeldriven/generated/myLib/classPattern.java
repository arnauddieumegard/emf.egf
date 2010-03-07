package myLib;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class classPattern 
{
  protected static String nl;
  public static synchronized classPattern create(String lineSeparator)
  {
    nl = lineSeparator;
    classPattern result = new classPattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

	public classPattern()
	{
	//Here is the constructor
StringBuffer stringBuffer = new StringBuffer();

    // add initialisation of the pattern variables (declaration has been already done).
    
	}
  	
  	public String generate(Object argument) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    InternalPatternContext ctx = (InternalPatternContext)argument;
StringBuilder collector = new StringBuilder(2000);
Map<String, String> queryCtx = null;
IQuery.ParameterDescription paramDesc = null;

    
List<Object> parameterList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object parameterParameter : parameterList ) {


    collector.append(generate(ctx, parameterParameter));
    
}
((InternalPatternContext)ctx).getReporter().executionFinished(collector.toString(), ctx);

    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object parameterParameter) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
if (!ictx.hasCallReporter()) {
    ictx = new ExecutionContext(ctx);
    ictx.setCallReporter(new PatternCallReporter(new StringBuffer()));
}

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EClass parameter = (org.eclipse.emf.ecore.EClass)parameterParameter;
parameterValues.put("parameter", parameterParameter);

    
method_body(ictx.getCallReporter().getBuffer(), ictx, parameter);

    CallHelper.callBack(ctx, parameter);

    
String loop = ictx.getCallReporter().getBuffer().toString();
((InternalPatternContext)ctx).getReporter().loopFinished(loop, ictx, parameterValues);
return loop;
} 


    protected void method_body(StringBuffer stringBuffer, PatternContext ctx, org.eclipse.emf.ecore.EClass parameter)throws Exception 
{
    stringBuffer.append(TEXT_1);
    stringBuffer.append("class "+parameter.getName());
    }
    }