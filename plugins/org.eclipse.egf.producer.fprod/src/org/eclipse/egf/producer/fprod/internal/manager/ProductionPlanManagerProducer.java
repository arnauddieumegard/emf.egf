/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.producer.fprod.internal.manager;

import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.egf.producer.manager.IModelElementManager;
import org.eclipse.egf.producer.manager.OrchestrationManagerProducer;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionPlanManagerProducer extends OrchestrationManagerProducer<ProductionPlan> {

  @Override
  public EClass getOrchestration() {
    return FprodPackage.Literals.PRODUCTION_PLAN;
  }

  @Override
  protected IModelElementManager<ProductionPlan, OrchestrationParameter> doCreateOrchestrationManager(IActivityManager<FactoryComponent> parent, ProductionPlan productionPlan) throws InvocationException {
    return ProductionPlanManagerFactory.createProductionManager(parent, productionPlan);
  }
}
