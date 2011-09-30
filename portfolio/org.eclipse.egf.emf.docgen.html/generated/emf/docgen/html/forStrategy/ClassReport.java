package emf.docgen.html.forStrategy;

import java.util.*;
import java.util.Map.Entry;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.emf.docgen.html.util.*;

public class ClassReport extends emf.docgen.html.EClassDocGen {
	protected static String nl;

	public static synchronized ClassReport create(String lineSeparator) {
		nl = lineSeparator;
		ClassReport result = new ClassReport();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<p>Description of ";
	protected final String TEXT_2 = "</p>";
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public ClassReport() {
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

		List<Object> elementList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object elementParameter : elementList) {

			this.element = (org.eclipse.emf.ecore.EClass) elementParameter;

			{
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setVariable(new StringBuffer(), ictx);

		method_setSpecificVariables(new StringBuffer(), ictx);

		method_fileHeader(new StringBuffer(), ictx);

		method_writeEAnnotations(new StringBuffer(), ictx);

		method_writeSuperTypes(new StringBuffer(), ictx);

		method_writeEAttributes(new StringBuffer(), ictx);

		method_writeEReferences(new StringBuffer(), ictx);

		method_writeEOperations(new StringBuffer(), ictx);

		method_writeEPackageReference(new StringBuffer(), ictx);

		method_fileFooter(new StringBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("element", this.element);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.emf.ecore.EClass element = null;

	public void set_element(org.eclipse.emf.ecore.EClass object) {
		this.element = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("element", this.element);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(element.getName());
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@eefca4 (description: null) (name: body) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.docgen.html/templates/pattern._ouOkgAbWEd-6kIajn4nnRQ/method._ouOkgwbWEd-6kIajn4nnRQ.pt)", stringBuffer.toString());
	}

	protected void method_setVariable(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// Set Object variables
		_Title = element.getName() + " Class";

		// Set EObject variables
		_element = element;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@11e7dd8 (description: null) (name: setVariable) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.docgen.html/templates/pattern._ouOkgAbWEd-6kIajn4nnRQ/method._FWeXUAbXEd-6kIajn4nnRQ.pt)", stringBuffer.toString());
	}
}