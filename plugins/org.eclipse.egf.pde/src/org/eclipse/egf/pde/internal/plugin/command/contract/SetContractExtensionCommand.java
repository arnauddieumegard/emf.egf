/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pde.internal.plugin.command.contract;

/**
 * This command creates a new root contract extension (see Contract extension point).<br>
 * This root does not contain any contract element.
 * @author Guillaume Brocard
 */
public class SetContractExtensionCommand extends AbstractContractCommand {
  /**
   * Constructor.
   * @param contractId_p
   */
  public SetContractExtensionCommand(String contractId_p) {
    super(contractId_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    getExtensionElementWithId(getContractId());
  }
}
