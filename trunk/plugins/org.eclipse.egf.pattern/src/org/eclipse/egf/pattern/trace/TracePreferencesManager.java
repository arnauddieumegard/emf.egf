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

package org.eclipse.egf.pattern.trace;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.egf.core.trace.Category;
import org.eclipse.egf.core.trace.Configuration;
import org.eclipse.egf.core.trace.Filter;
import org.eclipse.egf.core.trace.TraceFactory;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author Thomas Guiu
 * 
 */
public class TracePreferencesManager implements ITracePreferences {

    public void save(TraceState state, Configuration configuration) throws BackingStoreException, IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Resource eResource = configuration.eResource();
        if (eResource == null) {
            Resource res = new XMLResourceImpl();
            res.getContents().add(configuration);
            eResource = res;
        }
        eResource.save(out, new HashMap());
        final String configurationStr = new String(out.toByteArray());

        final IEclipsePreferences node = new ConfigurationScope().getNode(EGFPatternPlugin.getDefault().getPluginID());
        node.put(FILTER__KEY, configurationStr);
        node.put(ENABLE_TRACE__KEY, state.getLabel());
        node.flush();
    }

    public Configuration getDefaultConfiguration() {
        Configuration configuration = TraceFactory.eINSTANCE.createConfiguration();
        final Category emfCategory = TraceFactory.eINSTANCE.createCategory();
        emfCategory.setName("Emf generation");
        emfCategory.setActive(true);
        configuration.getCategories().add(emfCategory);

        Filter filter = TraceFactory.eINSTANCE.createFilter();
        filter.setComment("<!--{}-->");
        filter.setPattern(".*XML");
        emfCategory.getFilters().add(filter);

        filter = TraceFactory.eINSTANCE.createFilter();
        filter.setComment("<!--{}-->");
        filter.setPattern(".*Xml");
        emfCategory.getFilters().add(filter);

        filter = TraceFactory.eINSTANCE.createFilter();
        filter.setComment("# ");
        filter.setPattern(".*Properties");
        emfCategory.getFilters().add(filter);

        filter = TraceFactory.eINSTANCE.createFilter();
        filter.setComment(": ");
        filter.setPattern(".*MF");
        emfCategory.getFilters().add(filter);

        filter = TraceFactory.eINSTANCE.createFilter();
        filter.setComment("//");
        filter.setPattern("org\\.eclipse\\.egf\\.emf\\.pattern.*");
        emfCategory.getFilters().add(filter);

        emfCategory.getFilters().add(filter);

        Resource res = new XMLResourceImpl();
        res.getContents().add(configuration);
        return configuration;
    }

    public Configuration loadConfiguration() throws IOException {
        final IEclipsePreferences node = new ConfigurationScope().getNode(EGFPatternPlugin.getDefault().getPluginID());
        final String configurationStr = node.get(ITracePreferences.FILTER__KEY, null);

        Resource res = new XMLResourceImpl();
        if (configurationStr == null || "".equals(configurationStr)) {
            Configuration configuration = getDefaultConfiguration();
            res.getContents().add(configuration);
            return configuration;
        } else {
            res.load(new ByteArrayInputStream(configurationStr.getBytes()), new HashMap());
            return (Configuration) res.getContents().get(0);
        }
    }

    public TraceState loadState() throws IOException {
        final IEclipsePreferences node = new ConfigurationScope().getNode(EGFPatternPlugin.getDefault().getPluginID());
        final String state = node.get(ITracePreferences.ENABLE_TRACE__KEY, TraceState.NEVER.getLabel());
        return TraceState.get(state);
    }
}