/*******************************************************************************
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.productionplan.ui.internal.actions;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.l10n.EGFCommonMessages;
import org.eclipse.egf.common.ui.diagnostic.DiagnosticHandler;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.ui.dialogs.FcoreSelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.productionplan.Task;
import org.eclipse.egf.productionplan.EGFProductionPlanPlugin;
import org.eclipse.egf.productionplan.manager.IProductionPlanManager;
import org.eclipse.egf.productionplan.ui.ProductionPlanUIPlugin;
import org.eclipse.egf.productionplan.ui.internal.ui.ProductionPlanUIImages;
import org.eclipse.egf.productionplan.ui.l10n.ProductionPlanUIMessages;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class GlobalRunActivityAction extends Action implements IWorkbenchWindowActionDelegate, IActionDelegate2 {

  public GlobalRunActivityAction() {
    super();
    setText(ProductionPlanUIMessages.GlobalRunActivityAction_label);
    setDescription(ProductionPlanUIMessages.GlobalRunActivityAction_description);
    setToolTipText(ProductionPlanUIMessages.GlobalRunActivityAction_tooltip);
    setImageDescriptor(ProductionPlanUIImages.EGF_RUN_ACTIVITY);
  }

  @Override
  public void run() {
    runWithEvent(null);
  }

  @Override
  public void runWithEvent(Event event) {

    FcoreSelectionDialog dialog = new FcoreSelectionDialog(ProductionPlanUIPlugin.getActiveWorkbenchShell(), false);
    dialog.setTitle(ProductionPlanUIMessages.GlobalRunActivityAction_dialogTitle);
    dialog.setMessage(ProductionPlanUIMessages.GlobalRunActivityAction_dialogMessage);

    int result = dialog.open();
    if (result != IDialogConstants.OK_ID) {
      return;
    }

    final Object[] fcores = dialog.getResult();
    if (fcores == null || fcores.length != 1) {
      return;
    }

    final InvocationException[] invocationException = new InvocationException[1];

    // Run activity
    WorkspaceJob activityJob = new WorkspaceJob(ProductionPlanUIMessages.GlobalRunActivityAction_label) {

      @Override
      public boolean belongsTo(Object family) {
        return EGFCorePlugin.FAMILY_MANUAL_BUILD.equals(family);
      }

      @Override
      public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
        Activity activity = null;
        // Load Resource
        try {
          ResourceSet resourceSet = new ResourceSetImpl();
          Resource resource = ResourceHelper.loadResource(resourceSet, ((IPlatformFcore) fcores[0]).getURI());
          EObject eObject = resource.getContents().get(0);
          if (eObject instanceof Activity == false) {
            return Status.OK_STATUS;
          }
          activity = (Activity) eObject;
        } catch (Throwable t) {
          throw new CoreException(ProductionPlanUIPlugin.getDefault().newStatus(IStatus.ERROR, "GlobalRunActivityAction.runWithEvent(..) _", t)); //$NON-NLS-1$
        }
        IProductionPlanManager<?, ?> production = null;
        int ticks = 0;
        try {
          if (activity instanceof FactoryComponent) {
            production = EGFProductionPlanPlugin.getProductionPlanManagerFactory().createProductionManager((FactoryComponent) activity);
          } else if (activity instanceof Task) {
            production = EGFProductionPlanPlugin.getProductionPlanManagerFactory().createProductionManager((Task) activity);
          } else {
            return Status.OK_STATUS;
          }
          ticks = production.getSteps();
        } catch (InvocationException ie) {
          if (ie.getCause() instanceof CoreException) {
            throw (CoreException) ie.getCause();
          }
          invocationException[0] = ie;
          return Status.OK_STATUS;
        }
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, production.getName()), (900 * ticks) + 100);
        try {
          try {
            if (ProductionPlanUIPlugin.getDefault().isDebugging()) {
              ProductionPlanUIPlugin.getDefault().logInfo(NLS.bind("Activity ''{0}'' will invoke ''{1}'' step(s).", activity.getExternalName(), ticks)); //$NON-NLS-1$
            }
            production.invoke(subMonitor.newChild(900 * ticks, SubMonitor.SUPPRESS_NONE));
            if (monitor.isCanceled()) {
              throw new OperationCanceledException();
            }
          } catch (InvocationException ie) {
            if (ie.getCause() instanceof CoreException) {
              throw (CoreException) ie.getCause();
            }
            invocationException[0] = ie;
          } catch (Throwable t) {
            throw new CoreException(ProductionPlanUIPlugin.getDefault().newStatus(IStatus.ERROR, EGFCommonMessages.Exception_unexpectedException, t));
          }
        } finally {
          subMonitor.done();
        }
        return Status.OK_STATUS;
      }
    };
    activityJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
    activityJob.setUser(true);
    activityJob.schedule();

    try {// block
      activityJob.join();
    } catch (InterruptedException ie) {
      // Do nothing
    }

    if (invocationException[0] != null) {
      DiagnosticHandler.displayAsyncDiagnostic(ProductionPlanUIPlugin.getActiveWorkbenchShell(), invocationException[0]);
    }

    return;

  }

  // ---- IWorkbenchWindowActionDelegate
  // ------------------------------------------------

  public void run(IAction action) {
    run();
  }

  public void dispose() {
    // do nothing.
  }

  public void init(IWorkbenchWindow window) {
    // do nothing.
  }

  public void selectionChanged(IAction action, ISelection selection) {
    // do nothing. Action doesn't depend on selection.
  }

  // ---- IActionDelegate2
  // ------------------------------------------------

  public void runWithEvent(IAction action, Event event) {
    runWithEvent(event);
  }

  public void init(IAction action) {
    // do nothing.
  }

}
