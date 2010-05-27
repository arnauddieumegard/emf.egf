/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.egf.pattern.ftask.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.pattern.utils.SubstitutionHelper;

/**
 * @author Thomas Guiu
 * 
 */
public class MergePatternSubstitutionTask implements ITaskProduction {

    private static final String SUBSTITUTION_A = "substitution A";
    private static final String SUBSTITUTION_B = "substitution B";
    private static final String SUBSTITUTION_OUT = "merged substitution";

    public void doExecute(ITaskProductionContext ctx, IProgressMonitor monitor) throws InvocationException {
        TypePatternSubstitution inputA = ctx.getInputValue(SUBSTITUTION_A, TypePatternSubstitution.class);
        TypePatternSubstitution inputB = ctx.getInputValue(SUBSTITUTION_B, TypePatternSubstitution.class);

        TypePatternSubstitution result = SubstitutionHelper.merge(inputA, inputB);
        ctx.setOutputValue(SUBSTITUTION_OUT, result);
    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

}
