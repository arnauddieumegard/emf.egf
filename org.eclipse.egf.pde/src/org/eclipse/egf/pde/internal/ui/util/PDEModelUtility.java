/**
 * Copyright (c) 2005-2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 */

package org.eclipse.egf.pde.internal.ui.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.filebuffers.ITextFileBufferManager;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.pde.internal.core.text.plugin.XMLTextChangeListener;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.ISharedExtensionsModel;
import org.eclipse.pde.internal.core.bundle.BundleFragmentModel;
import org.eclipse.pde.internal.core.bundle.BundlePluginModel;
import org.eclipse.pde.internal.core.ibundle.IBundleModel;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.core.text.AbstractEditingModel;
import org.eclipse.pde.internal.core.text.IEditingModel;
import org.eclipse.pde.internal.core.text.IModelTextChangeListener;
import org.eclipse.pde.internal.core.text.build.BuildModel;
import org.eclipse.pde.internal.core.text.build.PropertiesTextChangeListener;
import org.eclipse.pde.internal.core.text.bundle.BundleModel;
import org.eclipse.pde.internal.core.text.bundle.BundleTextChangeListener;
import org.eclipse.pde.internal.core.text.plugin.FragmentModel;
import org.eclipse.pde.internal.core.text.plugin.PluginModel;
import org.eclipse.pde.internal.ui.IPDEUIConstants;
import org.eclipse.pde.internal.ui.PDEPlugin;
import org.eclipse.pde.internal.ui.editor.PDEFormEditor;
import org.eclipse.pde.internal.ui.editor.build.BuildEditor;
import org.eclipse.pde.internal.ui.editor.build.BuildInputContext;
import org.eclipse.pde.internal.ui.editor.build.BuildSourcePage;
import org.eclipse.pde.internal.ui.editor.context.InputContext;
import org.eclipse.pde.internal.ui.editor.plugin.ManifestEditor;
import org.eclipse.pde.internal.ui.editor.schema.SchemaEditor;
import org.eclipse.pde.internal.ui.editor.schema.SchemaInputContext;
import org.eclipse.pde.internal.ui.editor.site.SiteEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.forms.editor.IFormPage;
import org.osgi.framework.Constants;


/**
 * Your one stop shop for performing changes to your plug-in models.
 */
public class PDEModelUtility {

  public static final String F_MANIFEST = "MANIFEST.MF"; //$NON-NLS-1$

  public static final String F_MANIFEST_FP = "META-INF/" + F_MANIFEST; //$NON-NLS-1$

  public static final String F_PLUGIN = "plugin.xml"; //$NON-NLS-1$

  public static final String F_FRAGMENT = "fragment.xml"; //$NON-NLS-1$

  public static final String F_PROPERTIES = ".properties"; //$NON-NLS-1$

  public static final String F_BUILD = "build" + F_PROPERTIES; //$NON-NLS-1$

  // bundle / xml various Object[] indices
  private static final int F_Bi = 0; // the manifest.mf-related object will always be 1st

  private static final int F_Xi = 1; // the xml-related object will always be 2nd

  @SuppressWarnings("unchecked")
  private static Hashtable fOpenPDEEditors = new Hashtable();

  /**
   * PDE editors should call this during their creation. Currently the pde editor superclass (PDEFormEditor) connects during its createPages method and so this
   * method does not need to be invoked anywhere else.
   * @param editor the editor to connect to
   */
  @SuppressWarnings("unchecked")
  public static void connect(PDEFormEditor editor) {
    IProject project = editor.getCommonProject();
    if (project == null) {
      return;
    }
    if (fOpenPDEEditors.containsKey(project)) {
      ArrayList list = (ArrayList) fOpenPDEEditors.get(project);
      if (list.contains(editor) == false) {
        list.add(editor);
      }
    } else {
      ArrayList list = new ArrayList();
      list.add(editor);
      fOpenPDEEditors.put(project, list);
    }
  }

  /**
   * PDE editors should call this when they are closing down.
   * @param editor the pde editor to disconnect from
   */
  @SuppressWarnings("unchecked")
  public static void disconnect(PDEFormEditor editor) {
    IProject project = editor.getCommonProject();
    if (project == null) {
      return;
    }
    if (fOpenPDEEditors.containsKey(project) == false) {
      return;
    }
    ArrayList list = (ArrayList) fOpenPDEEditors.get(project);
    list.remove(editor);
    if (list.size() == 0) {
      fOpenPDEEditors.remove(project);
    }
  }

  /**
   * Returns an open ManifestEditor that is associated with this project.
   * @param project
   * @return null if no ManifestEditor is open for this project
   */
  public static ManifestEditor getOpenManifestEditor(IProject project) {
    return (ManifestEditor) getOpenEditor(project, IPDEUIConstants.MANIFEST_EDITOR_ID);
  }

  /**
   * Returns an open BuildEditor that is associated with this project.
   * @param project
   * @return null if no BuildEditor is open for this project
   */
  public static BuildEditor getOpenBuildPropertiesEditor(IProject project) {
    return (BuildEditor) getOpenEditor(project, IPDEUIConstants.BUILD_EDITOR_ID);
  }

  /**
   * Returns an open SiteEditor that is associated with this project.
   * @param project
   * @return null if no SiteEditor is open for this project
   */
  public static SiteEditor getOpenUpdateSiteEditor(IProject project) {
    return (SiteEditor) getOpenEditor(project, IPDEUIConstants.SITE_EDITOR_ID);
  }

  @SuppressWarnings("unchecked")
  private static PDEFormEditor getOpenEditor(IProject project, String editorId) {
    ArrayList list = (ArrayList) fOpenPDEEditors.get(project);
    if (list == null) {
      return null;
    }
    for (int i = 0; i < list.size(); i++) {
      PDEFormEditor editor = (PDEFormEditor) list.get(i);
      if (editor.getEditorSite().getId().equals(editorId))
        return editor;
    }
    return null;
  }

  /**
   * Get the open schema editor rooted at the specified underlying file
   * @param file
   * @return editor if found or null
   */
  public static SchemaEditor getOpenSchemaEditor(IFile file) {
    return (SchemaEditor) getOpenEditor(IPDEUIConstants.SCHEMA_EDITOR_ID, SchemaInputContext.CONTEXT_ID, file);
  }

  /**
   * @param editorID
   * @param inputContextID
   * @param file
   * @return
   */
  @SuppressWarnings("unchecked")
  private static PDEFormEditor getOpenEditor(String editorID, String inputContextID, IFile file) {
    // Get the file's project
    IProject project = file.getProject();
    // Check for open editors housed in the specified project
    ArrayList list = (ArrayList) fOpenPDEEditors.get(project);
    // No open editors found
    if (list == null) {
      return null;
    }
    // Get the open editor whose
    // (1) Editor ID matches the specified editor ID
    // (2) Underlying file matches the specified file
    // Check all open editors
    for (int i = 0; i < list.size(); i++) {
      // Get the editor
      PDEFormEditor editor = (PDEFormEditor) list.get(i);
      // Check for the specified type
      // Get the editor ID
      String currentEditorID = editor.getEditorSite().getId();
      if (currentEditorID.equals(editorID) == false) {
        continue;
      }
      // Check for the specified file
      // Find the editor's input context
      InputContext context = editor.getContextManager().findContext(inputContextID);
      // Ensure we have an input context
      if (context == null) {
        continue;
      }
      // Get the editor input
      IEditorInput input = context.getInput();
      // Ensure we have a file editor input
      if ((input instanceof IFileEditorInput) == false) {
        continue;
      }
      // Get the editor's underlying file
      IFile currentFile = ((IFileEditorInput) input).getFile();
      // If the file matches the specified file, we have found the
      // specified editor
      if (currentFile.equals(file)) {
        return editor;
      }
    }
    return null;
  }

  /**
   * Returns an IPluginModelBase from the active ManifestEditor or null if no manifest editor is open.
   * @return the active IPluginModelBase
   */
  public static IPluginModelBase getActivePluginModel() {
    IEditorPart editor = PDEPlugin.getActivePage().getActiveEditor();
    if (editor instanceof ManifestEditor) {
      IBaseModel model = ((ManifestEditor) editor).getAggregateModel();
      if (model instanceof IPluginModelBase)
        return (IPluginModelBase) model;
    }
    return null;
  }

  /**
   * @param doc
   * @return
   */
  @SuppressWarnings("unchecked")
  public static IEditingModel getOpenModel(IDocument doc) {
    Iterator it = fOpenPDEEditors.values().iterator();
    while (it.hasNext()) {
      ArrayList list = (ArrayList) it.next();
      for (int i = 0; i < list.size(); i++) {
        PDEFormEditor e = (PDEFormEditor) list.get(i);
        IPluginModelBase model = (IPluginModelBase) e.getAggregateModel();
        if (model instanceof IBundlePluginModelBase) {
          IBundleModel bModel = ((IBundlePluginModelBase) model).getBundleModel();
          if (bModel instanceof IEditingModel && doc == ((IEditingModel) bModel).getDocument()) {
            return (IEditingModel) bModel;
          }
          ISharedExtensionsModel eModel = ((IBundlePluginModelBase) model).getExtensionsModel();
          if (eModel instanceof IEditingModel && doc == ((IEditingModel) eModel).getDocument()) {
            return (IEditingModel) eModel;
          }
        }
        // IBuildModel bModel = model.getBuildModel();
        // if (bModel instanceof IEditingModel &&
        // doc == ((IEditingModel)bModel).getDocument())
        // return (IEditingModel)bModel;
        if (model instanceof IEditingModel && doc == ((IEditingModel) model).getDocument()) {
          return (IEditingModel) model;
        }
      }
    }
    return null;
  }

  /**
   * Modify a model based on the specifications provided by the ModelModification parameter. A model will be searched for in the open editors, if it is found
   * changes will be applied and the editor will be saved. If no model is found one will be created and text edit operations will be generated / applied. NOTE:
   * If a MANIFEST.MF file is specified in the ModelModification a BundlePluginModel will be searched for / created and passed to
   * ModelModification#modifyModel(IBaseModel). (not a BundleModel - which can be retreived from the BundlePluginModel)
   * @param modification
   * @param monitor
   * @throws CoreException
   */
  @SuppressWarnings("deprecation")
  public static void modifyModel(final ModelModification modification, final IProgressMonitor monitor) {
    // ModelModification was not supplied with the right files
    // TODO should we just fail silently?
    if (modification.getFile() == null) {
      return;
    }
    PDEFormEditor editor = getOpenEditor(modification);
    IBaseModel model = getModelFromEditor(editor, modification);
    if (model != null) {
      // open editor found, should have underlying text listeners -> apply modification
      modifyEditorModel(modification, editor, model, monitor);
    } else {
      // create own model, attach listeners and grab text edits
      ITextFileBufferManager manager = FileBuffers.getTextFileBufferManager();
      IFile[] files;
      if (modification.isFullBundleModification()) {
        files = new IFile [2];
        files[F_Bi] = modification.getManifestFile();
        files[F_Xi] = modification.getXMLFile();
      } else {
        files = new IFile []{ modification.getFile() };
      }
      // need to monitor number of successfull buffer connections for disconnection purposes
      // @see } finally { statement
      int sc = 0;
      try {
        ITextFileBuffer[] buffers = new ITextFileBuffer [files.length];
        IDocument[] documents = new IDocument [files.length];
        for (int i = 0; i < files.length; i++) {
          if (files[i] == null || files[i].exists() == false) {
            continue;
          }
          manager.connect(files[i].getFullPath(), monitor);
          sc++;
          buffers[i] = manager.getTextFileBuffer(files[i].getFullPath());
          if (buffers[i].isDirty()) {
            buffers[i].commit(monitor, true);
          }
          documents[i] = buffers[i].getDocument();
        }
        
        IBaseModel editModel;
        if (modification.isFullBundleModification()) {
          editModel = prepareBundlePluginModel(files, documents);
        } else {
          editModel = prepareAbstractEditingModel(files[0], documents[0]);
        }

        modification.modifyModel(editModel, monitor);

        IModelTextChangeListener[] listeners = gatherListeners(editModel);
        for (int i = 0; i < listeners.length; i++) {
          if (listeners[i] == null) {
            continue;
          }
          TextEdit[] edits = listeners[i].getTextOperations();
          if (edits.length > 0) {
            MultiTextEdit multi = new MultiTextEdit();
            multi.addChildren(edits);
            multi.apply(documents[i]);
            buffers[i].commit(monitor, true);
          }
        }
      } catch (CoreException e) {
        PDEPlugin.log(e);
      } catch (MalformedTreeException e) {
        PDEPlugin.log(e);
      } catch (BadLocationException e) {
        PDEPlugin.log(e);
      } finally {
        // don't want to over-disconnect in case we ran into an exception during connections
        // dc <= sc stops this from happening
        int dc = 0;
        for (int i = 0; i < files.length && dc <= sc; i++) {
          if (files[i] == null || files[i].exists() == false) {
            continue;
          }
          try {
            manager.disconnect(files[i].getFullPath(), monitor);
            dc++;
          } catch (CoreException e) {
            PDEPlugin.log(e);
          }
        }
      }
    }
  }

  private static void modifyEditorModel(    
    final ModelModification mod,
    final PDEFormEditor editor,
    final IBaseModel model,
    final IProgressMonitor monitor
  ) {    
    getDisplay().syncExec(
      new Runnable() {
        public void run() {
          try {
            mod.modifyModel(model, monitor);
            IFile[] files = new IFile []{ mod.getManifestFile(), mod.getXMLFile(), mod.getPropertiesFile() };
            for (int i = 0; i < files.length; i++) {
              if (files[i] == null) {
                continue;
              }
              InputContext con = editor.getContextManager().findContext(files[i]);
              if (con != null) {
                con.flushEditorInput();
              }
            }
            if (mod.saveOpenEditor()) {
              editor.doSave(monitor);
            }
          } catch (CoreException e) {
            PDEPlugin.log(e);
          }
        }
      }
    );
  }

  private static PDEFormEditor getOpenEditor(ModelModification modification) {
    IProject project = modification.getFile().getProject();
    String name = modification.getFile().getName();
    if (name.equals(F_PLUGIN) || name.equals(F_FRAGMENT) || name.equals(F_MANIFEST)) {
      return getOpenManifestEditor(project);
    } else if (name.equals(F_BUILD)) {
      PDEFormEditor openEditor = getOpenBuildPropertiesEditor(project);
      if (openEditor == null) {
        openEditor = getOpenManifestEditor(project);
      }
      return openEditor;
    }
    return null;
  }

  private static IBaseModel getModelFromEditor(PDEFormEditor openEditor, ModelModification modification) {
    if (openEditor == null) {
      return null;
    }
    String name = modification.getFile().getName();
    IBaseModel model = null;
    if (name.equals(F_PLUGIN) || name.equals(F_FRAGMENT)) {
      model = openEditor.getAggregateModel();
      if (model instanceof IBundlePluginModelBase) {
        model = ((IBundlePluginModelBase) model).getExtensionsModel();
      }
    } else if (name.equals(F_BUILD)) {
      if (openEditor instanceof BuildEditor) {
        model = openEditor.getAggregateModel();
      } else if (openEditor instanceof ManifestEditor) {
        IFormPage page = openEditor.findPage(BuildInputContext.CONTEXT_ID);
        if (page instanceof BuildSourcePage) {
          model = ((BuildSourcePage) page).getInputContext().getModel();
        }
      }
    } else if (name.equals(F_MANIFEST)) {
      model = openEditor.getAggregateModel();
      if (model instanceof IBundlePluginModelBase) {
        return model;
      }
    }
    if (model instanceof AbstractEditingModel) {
      return model;
    }
    return null;
  }

  private static IModelTextChangeListener createListener(String filename, IDocument doc) {
    if (filename.equals(F_PLUGIN) || filename.equals(F_FRAGMENT)) {
      return new XMLTextChangeListener(doc);
    } else if (filename.equals(F_MANIFEST)) {
      return new BundleTextChangeListener(doc);
    } else if (filename.endsWith(F_PROPERTIES)) {
      return new PropertiesTextChangeListener(doc);
    }
    return null;
  }

  private static AbstractEditingModel prepareAbstractEditingModel(IFile file, IDocument doc) {
    AbstractEditingModel model;
    String filename = file.getName();
    if (filename.equals(F_MANIFEST)) {
      model = new BundleModel(doc, true);
    } else if (filename.equals(F_FRAGMENT)) {
      model = new FragmentModel(doc, true);
    } else if (filename.equals(F_PLUGIN)) {
      model = new PluginModel(doc, true);
    } else if (filename.endsWith(F_PROPERTIES)) {
      model = new BuildModel(doc, true);
    } else {
      return null;
    }
    model.setUnderlyingResource(file);
    try {
      model.load();
      IModelTextChangeListener listener = createListener(filename, doc);
      model.addModelChangedListener(listener);
    } catch (CoreException e) {
      PDEPlugin.log(e);
    }
    return model;
  }

  private static IBaseModel prepareBundlePluginModel(IFile[] files, IDocument[] docs) throws CoreException {
    AbstractEditingModel[] models = new AbstractEditingModel [docs.length];
    boolean isFragment = false;
    models[F_Bi] = prepareAbstractEditingModel(files[F_Bi], docs[F_Bi]);
    if (models[F_Bi] instanceof IBundleModel) {
      isFragment = ((IBundleModel) models[F_Bi]).getBundle().getHeader(Constants.FRAGMENT_HOST) != null;
    }
    IBundlePluginModelBase pluginModel;
    if (isFragment) {
      pluginModel = new BundleFragmentModel();
    } else {
      pluginModel = new BundlePluginModel();
    }
    pluginModel.setBundleModel((IBundleModel) models[F_Bi]);
    if (files.length > F_Xi && files[F_Xi] != null) {
      models[F_Xi] = prepareAbstractEditingModel(files[F_Xi], docs[F_Xi]);
      pluginModel.setExtensionsModel((ISharedExtensionsModel) models[F_Xi]);
    }
    return pluginModel;
  }

  private static IModelTextChangeListener[] gatherListeners(IBaseModel editModel) {
    IModelTextChangeListener[] listeners = new IModelTextChangeListener [0];
    if (editModel instanceof AbstractEditingModel) {
      listeners = new IModelTextChangeListener [] {         
        ((AbstractEditingModel) editModel).getLastTextChangeListener() 
      };
    }
    if (editModel instanceof IBundlePluginModelBase) {
      IBundlePluginModelBase modelBase = (IBundlePluginModelBase) editModel;
      listeners = new IModelTextChangeListener [2];
      listeners[F_Bi] = gatherListener(modelBase.getBundleModel());
      listeners[F_Xi] = gatherListener(modelBase.getExtensionsModel());
      return listeners;
    }
    return listeners;
  }

  private static IModelTextChangeListener gatherListener(IBaseModel model) {
    if (model instanceof AbstractEditingModel) {
      return ((AbstractEditingModel) model).getLastTextChangeListener();
    }
    return null;
  }

  private static Display getDisplay() {
    Display display = Display.getCurrent();
    if (display == null) {
      display = Display.getDefault();
    }
    return display;
  }
  
}
