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
package org.eclipse.egf.fc.generator.java.model;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.importer.ModelImporter;
import org.eclipse.emf.importer.ecore.EcoreImporter;


/**
 * GenModel generator from an ecore source file.
 * @author fournier
 */
public class EcoreGenModelGenerator extends AbstractGenModelGenerator {
  
  /**
   * @see org.eclipse.egf.fc.generator.java.model.AbstractGenModelGenerator#createModelImporter()
   */
  @Override
  protected ModelImporter createModelImporter() {
    return new EcoreImporter();
  }

  /**
   * @see org.eclipse.egf.fc.generator.java.model.AbstractGenModelGenerator#getGenModelPath()
   */
  @Override
  protected IPath getGenModelPath() {
    // Remove the file extension.
    IPath modelFilename = getInputPath().removeFileExtension();
    // Extract file name.
    String modelFilenameSegment = modelFilename.segment(modelFilename.segmentCount() - 1);
    return new Path(modelFilenameSegment).addFileExtension(ICommonConstants.GENMODEL_FILE_EXTENSION);
  }

  /**
   * @see org.eclipse.egf.fc.generator.java.model.AbstractGenModelGenerator#adjustModelImporter(org.eclipse.emf.common.util.Monitor)
   */
  @Override
  protected void adjustModelImporter(Monitor monitor_p) {
    super.adjustModelImporter(monitor_p);
    // Set model location. Be careful, given path must start with URI scheme (here : "platform:/?/")
    getModelImporter().setModelLocation(FileHelper.getFileFullUri(getInputPath().toString()).toString());
  }
  
}
