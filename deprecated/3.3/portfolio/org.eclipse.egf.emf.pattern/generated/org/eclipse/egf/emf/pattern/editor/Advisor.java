package org.eclipse.egf.emf.pattern.editor;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class Advisor extends org.eclipse.egf.emf.pattern.base.GenModelJava {
	protected static String nl;

	public static synchronized Advisor create(String lineSeparator) {
		nl = lineSeparator;
		Advisor result = new Advisor();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL + "" + NL + "import java.io.File;";
	protected final String TEXT_4 = NL + "import java.util.Iterator;";
	protected final String TEXT_5 = NL + NL + "import org.eclipse.equinox.app.IApplication;" + NL + "import org.eclipse.equinox.app.IApplicationContext;" + NL + "" + NL + "import org.eclipse.jface.action.GroupMarker;" + NL + "import org.eclipse.jface.action.IAction;" + NL + "import org.eclipse.jface.action.IMenuManager;" + NL + "import org.eclipse.jface.action.MenuManager;" + NL + "import org.eclipse.jface.action.Separator;" + NL + "import org.eclipse.jface.dialogs.Dialog;" + NL + "import org.eclipse.jface.dialogs.MessageDialog;" + NL + "import org.eclipse.swt.SWT;" + NL + "import org.eclipse.swt.graphics.Point;" + NL + "import org.eclipse.swt.widgets.Display;" + NL + "import org.eclipse.swt.widgets.FileDialog;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL
			+ "import org.eclipse.ui.IEditorDescriptor;" + NL + "import org.eclipse.ui.IFolderLayout;" + NL + "import org.eclipse.ui.IPageLayout;" + NL + "import org.eclipse.ui.IPerspectiveFactory;" + NL + "import org.eclipse.ui.IWorkbench;" + NL + "import org.eclipse.ui.IWorkbenchActionConstants;" + NL + "import org.eclipse.ui.IWorkbenchPage;" + NL + "import org.eclipse.ui.IWorkbenchWindow;" + NL + "import org.eclipse.ui.PartInitException;" + NL + "import org.eclipse.ui.PlatformUI;" + NL + "import org.eclipse.ui.actions.ActionFactory;" + NL + "import org.eclipse.ui.actions.ContributionItemFactory;" + NL + "import org.eclipse.ui.application.ActionBarAdvisor;" + NL + "import org.eclipse.ui.application.IActionBarConfigurer;" + NL + "import org.eclipse.ui.application.IWorkbenchConfigurer;"
			+ NL + "import org.eclipse.ui.application.IWorkbenchWindowConfigurer;" + NL + "import org.eclipse.ui.application.WorkbenchAdvisor;" + NL + "import org.eclipse.ui.application.WorkbenchWindowAdvisor;" + NL + "" + NL + "import org.eclipse.emf.common.ui.URIEditorInput;" + NL + "import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.edit.ui.action.LoadResourceAction;" + NL + "" + NL + "import ";
	protected final String TEXT_6 = ";";
	protected final String TEXT_7 = NL + NL + NL + "/**" + NL + " * Customized {@link WorkbenchAdvisor} for the RCP application." + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public final class ";
	protected final String TEXT_8 = " extends WorkbenchAdvisor" + NL + "{";
	protected final String TEXT_9 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String copyright = ";
	protected final String TEXT_10 = ";";
	protected final String TEXT_11 = NL;
	protected final String TEXT_12 = NL + "\t/**" + NL + "\t * This looks up a string in the plugin's plugin.properties file." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static String getString(String key)" + NL + "\t{" + NL + "\t\treturn ";
	protected final String TEXT_13 = ".INSTANCE.getString(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * This looks up a string in plugin.properties, making a substitution." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static String getString(String key, Object s1)" + NL + "\t{" + NL + "\t\treturn ";
	protected final String TEXT_14 = ".INSTANCE.getString(key, new Object [] { s1 });" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * RCP's application" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Application implements IApplication" + NL + "\t{" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Object start(IApplicationContext context) throws Exception" + NL + "\t\t{" + NL + "\t\t\tWorkbenchAdvisor workbenchAdvisor = new ";
	protected final String TEXT_15 = "();" + NL + "\t\t\tDisplay display = PlatformUI.createDisplay();" + NL + "\t\t\ttry" + NL + "\t\t\t{" + NL + "\t\t\t\tint returnCode = PlatformUI.createAndRunWorkbench(display, workbenchAdvisor);" + NL + "\t\t\t\tif (returnCode == PlatformUI.RETURN_RESTART)" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\treturn IApplication.EXIT_RESTART;" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\treturn IApplication.EXIT_OK;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tfinally" + NL + "\t\t\t{" + NL + "\t\t\t\tdisplay.dispose();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.equinox.app.IApplication#stop()" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL
			+ "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void stop()" + NL + "\t\t{" + NL + "\t\t\t// Do nothing." + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * RCP's perspective" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Perspective implements IPerspectiveFactory" + NL + "\t{" + NL + "\t\t/**" + NL + "\t\t * Perspective ID" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ID_PERSPECTIVE = \"";
	protected final String TEXT_16 = "Perspective\";";
	protected final String TEXT_17 = NL + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void createInitialLayout(IPageLayout layout)" + NL + "\t\t{" + NL + "\t\t\tlayout.setEditorAreaVisible(true);" + NL + "\t\t\tlayout.addPerspectiveShortcut(ID_PERSPECTIVE);" + NL + "" + NL + "\t\t\tIFolderLayout right = layout.createFolder(\"right\", IPageLayout.RIGHT, (float)0.66, layout.getEditorArea());";
	protected final String TEXT_18 = NL + "\t\t\tright.addView(IPageLayout.ID_OUTLINE);" + NL + "" + NL + "\t\t\tIFolderLayout bottonRight = layout.createFolder(\"bottonRight\", IPageLayout.BOTTOM, (float)0.60, \"right\");";
	protected final String TEXT_19 = NL + "\t\t\tbottonRight.addView(IPageLayout.ID_PROP_SHEET);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * RCP's window advisor" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class WindowAdvisor extends WorkbenchWindowAdvisor" + NL + "\t{" + NL + "\t\t/**" + NL + "\t\t * @see WorkbenchWindowAdvisor#WorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchWindowConfigurer)" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic WindowAdvisor(IWorkbenchWindowConfigurer configurer)" + NL + "\t\t{" + NL + "\t\t\tsuper(configurer);" + NL + "\t\t}" + NL
			+ "\t\t" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#preWindowOpen()" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */";
	protected final String TEXT_20 = NL + "\t\t@Override";
	protected final String TEXT_21 = NL + "\t\tpublic void preWindowOpen()" + NL + "\t\t{" + NL + "\t\t\tIWorkbenchWindowConfigurer configurer = getWindowConfigurer();" + NL + "\t\t\tconfigurer.setInitialSize(new Point(600, 450));" + NL + "\t\t\tconfigurer.setShowCoolBar(false);" + NL + "\t\t\tconfigurer.setShowStatusLine(true);" + NL + "\t\t\tconfigurer.setTitle(getString(\"_UI_Application_title\"));";
	protected final String TEXT_22 = NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.application.WorkbenchWindowAdvisor#createActionBarAdvisor(org.eclipse.ui.application.IActionBarConfigurer)" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */";
	protected final String TEXT_23 = NL + "\t\t@Override";
	protected final String TEXT_24 = NL + "\t\tpublic ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer)" + NL + "\t\t{" + NL + "\t\t\treturn new WindowActionBarAdvisor(configurer);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * RCP's action bar advisor" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class WindowActionBarAdvisor extends ActionBarAdvisor" + NL + "\t{" + NL + "\t\t/**" + NL + "\t\t * @see ActionBarAdvisor#ActionBarAdvisor(org.eclipse.ui.application.IActionBarConfigurer)" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL
			+ "\t\tpublic WindowActionBarAdvisor(IActionBarConfigurer configurer)" + NL + "\t\t{" + NL + "\t\t\tsuper(configurer);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.application.ActionBarAdvisor#fillMenuBar(org.eclipse.jface.action.IMenuManager)" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */";
	protected final String TEXT_25 = NL + "\t\t@Override";
	protected final String TEXT_26 = NL + "\t\tprotected void fillMenuBar(IMenuManager menuBar)" + NL + "\t\t{" + NL + "\t\t\tIWorkbenchWindow window = getActionBarConfigurer().getWindowConfigurer().getWindow();" + NL + "\t\t\tmenuBar.add(createFileMenu(window));" + NL + "\t\t\tmenuBar.add(createEditMenu(window));" + NL + "\t\t\tmenuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\t\tmenuBar.add(createWindowMenu(window));" + NL + "\t\t\tmenuBar.add(createHelpMenu(window));\t\t\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * Creates the 'File' menu." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL
			+ "\t\tprotected IMenuManager createFileMenu(IWorkbenchWindow window)" + NL + "\t\t{" + NL + "\t\t\tIMenuManager menu = new MenuManager(getString(\"_UI_Menu_File_label\"),";
	protected final String TEXT_27 = NL + "\t\t\tIWorkbenchActionConstants.M_FILE);    " + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));" + NL + "\t" + NL + "\t\t\tIMenuManager newMenu = new MenuManager(getString(\"_UI_Menu_New_label\"), \"new\");";
	protected final String TEXT_28 = " ";
	protected final String TEXT_29 = NL + "\t\t\tnewMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t" + NL + "\t\t\tmenu.add(newMenu);" + NL + "\t\t\tmenu.add(new Separator());" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\t\tmenu.add(new Separator());" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.CLOSE.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.CLOSE_ALL.create(window));" + NL + "\t\t\tmenu.add(new Separator());" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.SAVE.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.SAVE_AS.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.SAVE_ALL.create(window));" + NL
			+ "\t\t\tmenu.add(new Separator());" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.QUIT.create(window));" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));" + NL + "\t\t\treturn menu;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Creates the 'Edit' menu." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected IMenuManager createEditMenu(IWorkbenchWindow window)" + NL + "\t\t{" + NL + "\t\t\tIMenuManager menu = new MenuManager(getString(\"_UI_Menu_Edit_label\"),";
	protected final String TEXT_30 = NL + "\t\t\tIWorkbenchActionConstants.M_EDIT);" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));" + NL + "\t" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.UNDO.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.REDO.create(window));" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.UNDO_EXT));" + NL + "\t\t\tmenu.add(new Separator());" + NL + "\t" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.CUT.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.COPY.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.PASTE.create(window));" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.CUT_EXT));" + NL
			+ "\t\t\tmenu.add(new Separator());" + NL + "\t" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.DELETE.create(window));" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.SELECT_ALL.create(window));" + NL + "\t\t\tmenu.add(new Separator());" + NL + "\t" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.ADD_EXT));" + NL + "\t" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));" + NL + "\t\t\tmenu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\t\treturn menu;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * Creates the 'Window' menu." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL
			+ "\t\tprotected IMenuManager createWindowMenu(IWorkbenchWindow window)" + NL + "\t\t{" + NL + "\t\t\tIMenuManager menu = new MenuManager(getString(\"_UI_Menu_Window_label\"),";
	protected final String TEXT_31 = NL + "\t\t\tIWorkbenchActionConstants.M_WINDOW);" + NL + "\t" + NL + "\t\t\taddToMenuAndRegister(menu, ActionFactory.OPEN_NEW_WINDOW.create(window));" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\t\tmenu.add(ContributionItemFactory.OPEN_WINDOWS.create(window));" + NL + "\t" + NL + "\t\t\treturn menu;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * Creates the 'Help' menu." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected IMenuManager createHelpMenu(IWorkbenchWindow window)" + NL + "\t\t{" + NL
			+ "\t\t\tIMenuManager menu = new MenuManager(getString(\"_UI_Menu_Help_label\"), IWorkbenchActionConstants.M_HELP);";
	protected final String TEXT_32 = NL + "\t\t\t// Welcome or intro page would go here" + NL + "\t\t\t// Help contents would go here" + NL + "\t\t\t// Tips and tricks page would go here" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.HELP_START));" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));" + NL + "\t\t\tmenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));" + NL + "\t\t\treturn menu;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * Adds the specified action to the given menu and also registers the action with the" + NL + "\t\t * action bar configurer, in order to activate its key binding." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */"
			+ NL + "\t\tprotected void addToMenuAndRegister(IMenuManager menuManager, IAction action)" + NL + "\t\t{" + NL + "\t\t\tmenuManager.add(action);" + NL + "\t\t\tgetActionBarConfigurer().registerGlobalAction(action);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * About action for the RCP application." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class AboutAction extends WorkbenchWindowActionDelegate" + NL + "\t{" + NL + "\t\t/**" + NL + "\t\t * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)" + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL
			+ "\t\tpublic void run(IAction action)" + NL + "\t\t{" + NL + "\t\t\tMessageDialog.openInformation(getWindow().getShell(), getString(\"_UI_About_title\"),";
	protected final String TEXT_33 = NL + "\t\t\tgetString(\"_UI_About_text\"));";
	protected final String TEXT_34 = NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Open action for the objects from the ";
	protected final String TEXT_35 = " model." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class OpenAction extends WorkbenchWindowActionDelegate" + NL + "\t{" + NL + "\t\t/**" + NL + "\t\t * Opens the editors for the files selected using the file dialog." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run(IAction action)" + NL + "\t\t{" + NL + "\t\t\tString filePath = openFilePathDialog(getWindow().getShell(), null, SWT.OPEN);" + NL + "\t\t\tif (filePath != null)" + NL + "\t\t\t{" + NL + "\t\t\t\topenEditor(getWindow().getWorkbench(), URI.createFileURI(filePath));" + NL + "\t\t\t}" + NL + "\t\t}"
			+ NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Open URI action for the objects from the ";
	protected final String TEXT_36 = " model." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class OpenURIAction extends WorkbenchWindowActionDelegate" + NL + "\t{" + NL + "\t\t/**" + NL + "\t\t * Opens the editors for the files selected using the LoadResourceDialog." + NL + "\t\t * <!-- begin-user-doc -->" + NL + "\t\t * <!-- end-user-doc -->" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run(IAction action)" + NL + "\t\t{" + NL + "\t\t\tLoadResourceAction.LoadResourceDialog loadResourceDialog = new LoadResourceAction.LoadResourceDialog(getWindow().getShell());" + NL + "\t\t\tif (Dialog.OK == loadResourceDialog.open())" + NL + "\t\t\t{";
	protected final String TEXT_37 = NL + "\t\t\t\tfor (URI uri : loadResourceDialog.getURIs())" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\topenEditor(getWindow().getWorkbench(), uri);" + NL + "\t\t\t\t}";
	protected final String TEXT_38 = NL + "\t\t\t\tfor (Iterator i = loadResourceDialog.getURIs().iterator(); i.hasNext();)" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\topenEditor(getWindow().getWorkbench(), (URI)i.next());" + NL + "\t\t\t\t}";
	protected final String TEXT_39 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String openFilePathDialog(Shell shell, String fileExtensionFilter, int style)" + NL + "\t{" + NL + "\t\tFileDialog fileDialog = new FileDialog(shell, style);";
	protected final String TEXT_40 = NL + "\t\tif (fileExtensionFilter == null)" + NL + "\t\t{" + NL + "\t\t\tfileExtensionFilter =";
	protected final String TEXT_41 = NL + "\t\t\t\t\"*.\" + getString(\"_UI_";
	protected final String TEXT_42 = "FilenameExtension\")";
	protected final String TEXT_43 = " + \";\" +";
	protected final String TEXT_44 = ";";
	protected final String TEXT_45 = NL + "\t\t}" + NL + "\t\tfileDialog.setFilterExtensions(new String[]{fileExtensionFilter});";
	protected final String TEXT_46 = NL + "\t" + NL + "\t\tfileDialog.open();" + NL + "\t\tif (fileDialog.getFileName() != null && fileDialog.getFileName().length() > 0)" + NL + "\t\t{" + NL + "\t\t\treturn fileDialog.getFilterPath() + File.separator + fileDialog.getFileName();" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static boolean openEditor(IWorkbench workbench, URI fileURI)" + NL + "\t{" + NL + "\t\tIWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();" + NL + "\t\tIWorkbenchPage page = workbenchWindow.getActivePage();" + NL + "\t" + NL
			+ "\t\tIEditorDescriptor editorDescriptor = workbench.getEditorRegistry().getDefaultEditor(fileURI.toFileString());" + NL + "\t\tif (editorDescriptor == null)" + NL + "\t\t{" + NL + "\t\t\tMessageDialog.openError(" + NL + "\t\t\tworkbenchWindow.getShell()," + NL + "\t\t\tgetString(\"_UI_Error_title\"), ";
	protected final String TEXT_47 = NL + "\t\t\tgetString(\"_WARN_No_Editor\", fileURI.toFileString())); ";
	protected final String TEXT_48 = NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\ttry" + NL + "\t\t\t{" + NL + "\t\t\t\tpage.openEditor(new URIEditorInput(fileURI), editorDescriptor.getId());" + NL + "\t\t\t}" + NL + "\t\t\tcatch (PartInitException exception)" + NL + "\t\t\t{" + NL + "\t\t\t\tMessageDialog.openError(" + NL + "\t\t\t\tworkbenchWindow.getShell()," + NL + "\t\t\t\tgetString(\"_UI_OpenEditorError_label\"), ";
	protected final String TEXT_49 = NL + "\t\t\t\texception.getMessage());" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @see org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId()" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_50 = NL + "\t\t@Override";
	protected final String TEXT_51 = NL + "\tpublic String getInitialWindowPerspectiveId()" + NL + "\t{" + NL + "\t\treturn Perspective.ID_PERSPECTIVE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @see org.eclipse.ui.application.WorkbenchAdvisor#initialize(org.eclipse.ui.application.IWorkbenchConfigurer)" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_52 = NL + "\t\t@Override";
	protected final String TEXT_53 = NL + "\tpublic void initialize(IWorkbenchConfigurer configurer)" + NL + "\t{" + NL + "\t\tsuper.initialize(configurer);" + NL + "\t\tconfigurer.setSaveAndRestore(true);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @see org.eclipse.ui.application.WorkbenchAdvisor#createWorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchConfigurer)" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_54 = NL + "\t\t@Override";
	protected final String TEXT_55 = NL + "\tpublic WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer)" + NL + "\t{" + NL + "\t\treturn new WindowAdvisor(configurer);" + NL + "\t}" + NL + "}";
	protected final String TEXT_56 = NL;
	protected final String TEXT_57 = NL;
	protected final String TEXT_58 = NL;

	public Advisor() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) parameterParameter;

			if (preCondition()) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_57);
		stringBuffer.append(TEXT_58);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_preGenerate(new StringBuffer(), ictx);

		method_doGenerate(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_postGenerate(new StringBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenModel genModel = parameter;
		targetPath = genModel.getEditorPluginDirectory();
		packageName = genModel.getEditorPluginPackageName();
		className = genModel.getEditorAdvisorClassName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenModel genModel = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditorDirectory(), genModel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * <copyright>
		 *
		 * Copyright (c) 2004 IBM Corporation and others.
		 * This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v2.0
		 * which accompanies this distribution, and is available at
		 * https://www.eclipse.org/legal/epl-v2.0
		 *
		 * SPDX-License-Identifier: EPL-2.0
		 * 
		 * Contributors: 
		 *   IBM - Initial API and implementation
		 *
		 * </copyright>
		 */

		GenModel genModel = (GenModel) argument;
		stringBuffer.append(TEXT_1);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genModel.getEditorPluginPackageName());
		stringBuffer.append(TEXT_3);
		if (!genModel.useGenerics()) {
			stringBuffer.append(TEXT_4);
		}
		stringBuffer.append(TEXT_5);
		stringBuffer.append(genModel.getQualifiedEditorPluginClassName());
		stringBuffer.append(TEXT_6);
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_7);
		stringBuffer.append(genModel.getEditorAdvisorClassName());
		stringBuffer.append(TEXT_8);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_9);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_11);
		}
		stringBuffer.append(TEXT_12);
		stringBuffer.append(genModel.getEditorPluginClassName());
		stringBuffer.append(TEXT_13);
		stringBuffer.append(genModel.getQualifiedEditorPluginClassName());
		stringBuffer.append(TEXT_14);
		stringBuffer.append(genModel.getEditorAdvisorClassName());
		stringBuffer.append(TEXT_15);
		stringBuffer.append(genModel.getQualifiedEditorAdvisorClassName());
		stringBuffer.append(TEXT_16);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_17);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_18);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(genModel.getNonNLS(2));
		stringBuffer.append(TEXT_19);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_20);
		}
		stringBuffer.append(TEXT_21);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_22);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_23);
		}
		stringBuffer.append(TEXT_24);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_25);
		}
		stringBuffer.append(TEXT_26);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_27);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_28);
		stringBuffer.append(genModel.getNonNLS(2));
		stringBuffer.append(TEXT_29);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_30);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_31);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_32);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_33);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_34);
		stringBuffer.append(genModel.getModelName());
		stringBuffer.append(TEXT_35);
		stringBuffer.append(genModel.getModelName());
		stringBuffer.append(TEXT_36);
		if (genModel.useGenerics()) {
			stringBuffer.append(TEXT_37);
		} else {
			stringBuffer.append(TEXT_38);
		}
		stringBuffer.append(TEXT_39);
		List<GenPackage> genPackages = genModel.getAllGenPackagesWithClassifiers();
		if (!genPackages.isEmpty()) {
			stringBuffer.append(TEXT_40);
			for (Iterator<GenPackage> i = genPackages.iterator(); i.hasNext();) {
				GenPackage genPackage = i.next();
				stringBuffer.append(TEXT_41);
				stringBuffer.append(genPackage.getEditorClassName());
				stringBuffer.append(TEXT_42);
				if (i.hasNext()) {
					stringBuffer.append(TEXT_43);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(genModel.getNonNLS(2));
					stringBuffer.append(genModel.getNonNLS(3));
				} else {
					stringBuffer.append(TEXT_44);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(genModel.getNonNLS(2));
				}
			}
			stringBuffer.append(TEXT_45);
		}
		stringBuffer.append(TEXT_46);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_47);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_48);
		stringBuffer.append(genModel.getNonNLS());
		stringBuffer.append(TEXT_49);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_50);
		}
		stringBuffer.append(TEXT_51);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_52);
		}
		stringBuffer.append(TEXT_53);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_54);
		}
		stringBuffer.append(TEXT_55);
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_56);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		GenModel genModel = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditorProject");
		canGenerate = canGenerate && (genModel.isRichClientPlatform());
		return canGenerate;
	}
}