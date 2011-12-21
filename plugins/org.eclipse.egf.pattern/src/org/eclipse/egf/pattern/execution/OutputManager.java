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

package org.eclipse.egf.pattern.execution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.Node.CallBackContainer;
import org.eclipse.egf.model.pattern.Node.Container;
import org.eclipse.egf.model.pattern.Node.Leaf;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternOutputProcessor;
import org.eclipse.egf.model.pattern.PatternRuntimeException;

/**
 * @author Thomas Guiu
 * 
 */
public class OutputManager {
    public static String getHierarchy(Node node) {
        StringBuilder builder = new StringBuilder();
        getHierarchy(builder, node, 0);
        return builder.toString();
    }

    public static void getHierarchy(StringBuilder builder, Node node, int nb) {
        for (int n = 0; n < nb; n++)
            builder.append('\t');
        builder.append("[").append(node.getPatternClass()).append("] > \n");
        nb++;
        if (node instanceof Container) {
            Container container = (Container) node;
            for (Node node1 : container.getChildren())
                getHierarchy(builder, node1, nb);
            return;
        }
        if (node instanceof Leaf) {
            Leaf leaf = (Leaf) node;
            leaf.toString(builder);
            builder.append("\n");
        }

    }

    private static void doFlatten(StringBuilder builder, Node node, boolean deep) {
        if (!deep && node instanceof CallBackContainer) {
            return;
        }
        if (node instanceof Container) {
            Container container = (Container) node;
            for (Node node1 : container.getChildren())
                doFlatten(builder, node1, deep);
            return;
        }
        if (node instanceof Leaf) {
            Leaf leaf = (Leaf) node;
            leaf.toString(builder);
            return;
        }
        throw new IllegalStateException();
    }

    public static String getOutputWithoutCallback(PatternContext ctx) {
        StringBuilder builder = new StringBuilder();
        applyProcessors(ctx);
        doFlatten(builder, ((InternalPatternContext) ctx).getNode(), false);
        return builder.toString();
    }

    public static String getOutput(PatternContext ctx) {
        StringBuilder builder = new StringBuilder();
        applyProcessors(ctx);
        doFlatten(builder, ((InternalPatternContext) ctx).getNode(), true);
        return builder.toString();
    }

    protected static void applyProcessors(PatternContext ctx) {
        try {
            final Container node = ((InternalPatternContext) ctx).getNode();
            // apply the default processor defined in extension points
            for (PatternOutputProcessor defaultProcessor : getDefaultProcessors()) {
                defaultProcessor.execute(node);
            }

            // apply processor from activity contract
            PatternOutputProcessor processor = (PatternOutputProcessor) ctx.getValue(PatternContext.PATTERN_OUTPUT_PROCESSOR);
            if (processor != null)
                processor.execute(node);

        } catch (CoreException e) {
            throw new PatternRuntimeException(e);
        }
    }

    private static List<PatternOutputProcessor> getDefaultProcessors() throws CoreException {
        List<PatternOutputProcessor> result = new ArrayList<PatternOutputProcessor>();
        IExtensionPoint point = RegistryFactory.getRegistry().getExtensionPoint(PatternOutputProcessor.EXTENSION_ID);
        if (point != null) {
            for (IExtension extension : point.getExtensions()) {
                for (IConfigurationElement element : extension.getConfigurationElements()) {
                    result.add((PatternOutputProcessor) element.createExecutableExtension("class"));
                }
            }
        }
        return result;
    }

}