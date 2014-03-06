/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.engine;

import org.eclipse.egf.common.constant.EGFCommonConstants;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.emf.common.util.EList;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AssemblyHelper {

    public static final String GENERATE_METHOD = "generate"; //$NON-NLS-1$

    public static final String ORCHESTRATION_METHOD = "orchestration"; //$NON-NLS-1$    

    protected final Pattern pattern;

    protected final StringBuilder content = new StringBuilder(1000);

    protected int orchestrationIndex;

    protected final AssemblyContentHelper contentHelper;

    public AssemblyHelper(Pattern pattern, AssemblyContentProvider contentProvider) {
        super();
        this.pattern = pattern;
        this.contentHelper = new AssemblyContentHelper(contentProvider);
        contentProvider.setContent(content);
    }

    public String visit() throws PatternException {
        orchestrationIndex = -1;
        addHeader();
        addVariableInitialization();
        beginOrchestration();
        if (orchestrationIndex == -1)
            throw new PatternException(EGFPatternMessages.assembly_error6);
        visitOrchestration();
        endOrchestration();
        addMethodBodies();
        addFooter();
        return content.toString();
    }

    protected void addFooter() throws PatternException {
        String read = contentHelper.getMethodContent(pattern.getFooterMethod());
        if (read != null)
            content.append(read).append(EGFCommonConstants.LINE_SEPARATOR);
    }

    protected void addHeader() throws PatternException {
        String read = contentHelper.getMethodContent(pattern.getHeaderMethod());
        if (read != null)
            content.append(read).append(EGFCommonConstants.LINE_SEPARATOR);
    }

    protected void addMethodBodies() throws PatternException {
        contentHelper.addMethodBodies();
    }

    /**
     * This method may code to handle parameter at the orchestrationIndex and at
     * the current index. The inserted code is mainly a kind of loop containing
     * the pattern body over the result of the query.
     */
    @SuppressWarnings("unused")
    protected void endOrchestration() throws PatternException {
        // Nothing to do
    }

    @SuppressWarnings("unused")
    protected void beginOrchestration() throws PatternException {
        orchestrationIndex = content.length();
    }

    protected abstract void addVariableInitialization() throws PatternException;

    protected void visitOrchestration() throws PatternException {
        EList<Call> orchestration = pattern.getOrchestration();
        if (orchestration.isEmpty())
            return;

        for (Call element : orchestration) {
            contentHelper.addContent(element);
        }
    }

}
