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

package org.eclipse.egf.domain.file;

import java.util.Arrays;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.domain.Activator;
import org.eclipse.egf.domain.DomainException;
import org.eclipse.egf.domain.LoadableDomainHelper;
import org.eclipse.egf.domain.Messages;
import org.eclipse.egf.model.domain.LoadableDomain;
import org.eclipse.egf.model.domain.WorkspaceDomain;
import org.eclipse.osgi.util.NLS;

/**
 * @author Thomas Guiu
 * 
 */
public class WorkspaceDomainHelper extends LoadableDomainHelper {

	protected boolean doLoadDomain(LoadableDomain domain) throws DomainException {
		if (domain instanceof WorkspaceDomain) {
			WorkspaceDomain myDomain = (WorkspaceDomain) domain;
			final String path = myDomain.getPath();
			myDomain.setLoaded(true);

			if (path == null || "".equals(path)) { //$NON-NLS-1$
				Activator.getDefault().logWarning(Messages.bind(Messages.Load_WorkspaceDomain_error1, domain.getName()));
				return true;
			}

			if (!myDomain.getContent().isEmpty())
				throw new DomainException(Messages.bind(Messages.Load_Domain_error1, domain.eClass().getName(), domain.getName()));
			if (".".equals(path)) { //$NON-NLS-1$
				myDomain.getContent().addAll(Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects()));
				return true;
			}
			final Path path2 = new Path(path);
			final int segmentCount = path2.segmentCount();
			try {
				if (segmentCount == 1) {
					final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(path);
					myDomain.getContent().addAll(Arrays.asList(project.members()));
					return true;
				}
				IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(path2);
				myDomain.getContent().addAll(Arrays.asList(folder.members()));
			} catch (CoreException e) {
				throw new DomainException(NLS.bind(Messages.Load_WorkspaceDomain_error2, path2), e);
			}
			return true;
		}
		return false;
	}

	protected boolean doUnLoadDomain(LoadableDomain domain) throws DomainException {
		if (domain instanceof WorkspaceDomain) {
			WorkspaceDomain myDomain = (WorkspaceDomain) domain;
			myDomain.getContent().clear();
			myDomain.setLoaded(false);
			return true;
		}
		return false;
	}

}
