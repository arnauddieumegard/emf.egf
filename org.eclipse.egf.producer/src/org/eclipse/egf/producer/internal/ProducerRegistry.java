/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.producer.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Orchestration;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.activity.ActivityProducer;
import org.eclipse.egf.producer.orchestration.OrchestrationProducer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProducerRegistry {

  private ProducerRegistry() {
    // Prevent Instantiation
  }

  /**
   * Extension point "activity" short id.
   */
  protected static final String EXTENSION_POINT_SHORT_ID_ACTIVITY = "activity"; //$NON-NLS-1$

  /**
   * Extension point "orchestration" short id.
   */
  protected static final String EXTENSION_POINT_SHORT_ID_ORCHESTRATION = "orchestration"; //$NON-NLS-1$ 

  /**
   * EGF Registered Activity Producers.
   */
  private static Map<String, ActivityProducer<Activity>> __activityProducers;

  /**
   * EGF Registered Orchestration Producers.
   */
  private static Map<String, OrchestrationProducer<Orchestration>> __orchestrationProducers;

  public static String getName(EObject eObject) {
    return eObject.eClass().getName();
  }

  /**
   * Get Activity Producers implementations.
   * 
   * @return an empty map if none could be found.
   */
  @SuppressWarnings("unchecked")
  public static Map<String, ActivityProducer<Activity>> getActivityProducers() {
    // Lazy loading. Search for the implementation.
    if (__activityProducers == null) {
      __activityProducers = new HashMap<String, ActivityProducer<Activity>>();
      // Get ActivityProducer extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(EGFProducerPlugin.getDefault().getPluginID(), EXTENSION_POINT_SHORT_ID_ACTIVITY)) {
        Object object = ExtensionPointHelper.createInstance(configurationElement);
        if (object == null) {
          continue;
        }
        // Make sure this is the correct resulting type.
        if (object instanceof ActivityProducer<?> == false) {
          EGFProducerPlugin.getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("This Class should be a sub-type of ''{0}''.", ActivityProducer.class.getName()), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Extension-point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          continue;
        }
        __activityProducers.put(getName(((ActivityProducer<Activity>) object).getActivity()), (ActivityProducer<Activity>) object);
      }
    }
    return __activityProducers;
  }

  /**
   * Get Orchestration Producers implementations.
   * 
   * @return an empty map if none could be found.
   */
  @SuppressWarnings("unchecked")
  public static Map<String, OrchestrationProducer<Orchestration>> getOrchestrationProducers() {
    // Lazy loading. Search for the implementation.
    if (__orchestrationProducers == null) {
      __orchestrationProducers = new HashMap<String, OrchestrationProducer<Orchestration>>();
      // Get ActivityProducer extension points.
      for (IConfigurationElement configurationElement : ExtensionPointHelper.getConfigurationElements(EGFProducerPlugin.getDefault().getPluginID(), EXTENSION_POINT_SHORT_ID_ORCHESTRATION)) {
        Object object = ExtensionPointHelper.createInstance(configurationElement);
        if (object == null) {
          continue;
        }
        // Make sure this is the correct resulting type.
        if (object instanceof OrchestrationProducer<?> == false) {
          EGFProducerPlugin.getDefault().logError(NLS.bind("Wrong Class {0}", object.getClass().getName())); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("This Class should be a sub-type of ''{0}''.", OrchestrationProducer.class.getName()), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Bundle ''{0}''", ExtensionPointHelper.getNamespace(configurationElement)), 1); //$NON-NLS-1$
          EGFProducerPlugin.getDefault().logInfo(NLS.bind("Extension-point ''{0}''", configurationElement.getName()), 1); //$NON-NLS-1$
          continue;
        }
        __orchestrationProducers.put(getName(((OrchestrationProducer<Orchestration>) object).getOrchestration()), (OrchestrationProducer<Orchestration>) object);
      }
    }
    return __orchestrationProducers;
  }

}
