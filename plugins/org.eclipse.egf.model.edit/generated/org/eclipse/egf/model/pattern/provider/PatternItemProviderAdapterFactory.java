/**
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
 */
package org.eclipse.egf.model.pattern.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.fcore.util.FcoreSwitch;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.TypePatternCallBackHandler;
import org.eclipse.egf.model.pattern.TypePatternDomainVisitor;
import org.eclipse.egf.model.pattern.TypePatternExecutionReporter;
import org.eclipse.egf.model.pattern.TypePatternList;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.model.pattern.util.PatternAdapterFactory;
import org.eclipse.egf.model.types.Type;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemFontProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class PatternItemProviderAdapterFactory extends PatternAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public PatternItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
        supportedTypes.add(ITableItemLabelProvider.class);
        supportedTypes.add(ITableItemColorProvider.class);
        supportedTypes.add(ITableItemFontProvider.class);
        supportedTypes.add(IItemColorProvider.class);
        supportedTypes.add(IItemFontProvider.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.Pattern} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PatternItemProvider patternItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.Pattern}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createPatternAdapter() {
        if (patternItemProvider == null) {
            patternItemProvider = new PatternItemProvider(this);
        }

        return patternItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternMethod} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PatternMethodItemProvider patternMethodItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternMethod}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createPatternMethodAdapter() {
        if (patternMethodItemProvider == null) {
            patternMethodItemProvider = new PatternMethodItemProvider(this);
        }

        return patternMethodItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternParameter} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PatternParameterItemProvider patternParameterItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternParameter}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createPatternParameterAdapter() {
        if (patternParameterItemProvider == null) {
            patternParameterItemProvider = new PatternParameterItemProvider(this);
        }

        return patternParameterItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternLibrary} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PatternLibraryItemProvider patternLibraryItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternLibrary}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createPatternLibraryAdapter() {
        if (patternLibraryItemProvider == null) {
            patternLibraryItemProvider = new PatternLibraryItemProvider(this);
        }

        return patternLibraryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternViewpoint} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PatternViewpointItemProvider patternViewpointItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternViewpoint}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createPatternViewpointAdapter() {
        if (patternViewpointItemProvider == null) {
            patternViewpointItemProvider = new PatternViewpointItemProvider(this);
        }

        return patternViewpointItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternCall} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PatternCallItemProvider patternCallItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternCall}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createPatternCallAdapter() {
        if (patternCallItemProvider == null) {
            patternCallItemProvider = new PatternCallItemProvider(this);
        }

        return patternCallItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.SuperCall} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SuperCallItemProvider superCallItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.SuperCall}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createSuperCallAdapter() {
        if (superCallItemProvider == null) {
            superCallItemProvider = new SuperCallItemProvider(this);
        }

        return superCallItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Paramerter2ParameterMapItemProvider paramerter2ParameterMapItemProvider;

    /**
     * This creates an adapter for a {@link java.util.Map.Entry}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createParamerter2ParameterMapAdapter() {
        if (paramerter2ParameterMapItemProvider == null) {
            paramerter2ParameterMapItemProvider = new Paramerter2ParameterMapItemProvider(this);
        }

        return paramerter2ParameterMapItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.MethodCall} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected MethodCallItemProvider methodCallItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.MethodCall}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createMethodCallAdapter() {
        if (methodCallItemProvider == null) {
            methodCallItemProvider = new MethodCallItemProvider(this);
        }

        return methodCallItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternVariable} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PatternVariableItemProvider patternVariableItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternVariable}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createPatternVariableAdapter() {
        if (patternVariableItemProvider == null) {
            patternVariableItemProvider = new PatternVariableItemProvider(this);
        }

        return patternVariableItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.PatternInjectedCall} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PatternInjectedCallItemProvider patternInjectedCallItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.PatternInjectedCall}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createPatternInjectedCallAdapter() {
        if (patternInjectedCallItemProvider == null) {
            patternInjectedCallItemProvider = new PatternInjectedCallItemProvider(this);
        }

        return patternInjectedCallItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.BasicQuery} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BasicQueryItemProvider basicQueryItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.BasicQuery}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createBasicQueryAdapter() {
        if (basicQueryItemProvider == null) {
            basicQueryItemProvider = new BasicQueryItemProvider(this);
        }

        return basicQueryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.StringQuery} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected StringQueryItemProvider stringQueryItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.StringQuery}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createStringQueryAdapter() {
        if (stringQueryItemProvider == null) {
            stringQueryItemProvider = new StringQueryItemProvider(this);
        }

        return stringQueryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.CustomQuery} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CustomQueryItemProvider customQueryItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.CustomQuery}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createCustomQueryAdapter() {
        if (customQueryItemProvider == null) {
            customQueryItemProvider = new CustomQueryItemProvider(this);
        }

        return customQueryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String2PatternListItemProvider string2PatternListItemProvider;

    /**
     * This creates an adapter for a {@link java.util.Map.Entry}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createString2PatternListAdapter() {
        if (string2PatternListItemProvider == null) {
            string2PatternListItemProvider = new String2PatternListItemProvider(this);
        }

        return string2PatternListItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link java.util.Map.Entry} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected String2StringItemProvider string2StringItemProvider;

    /**
     * This creates an adapter for a {@link java.util.Map.Entry}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createString2StringAdapter() {
        if (string2StringItemProvider == null) {
            string2StringItemProvider = new String2StringItemProvider(this);
        }

        return string2StringItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.TypePatternExecutionReporter} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TypePatternExecutionReporterItemProvider typePatternExecutionReporterItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.TypePatternExecutionReporter}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createTypePatternExecutionReporterAdapter() {
        if (typePatternExecutionReporterItemProvider == null) {
            typePatternExecutionReporterItemProvider = new TypePatternExecutionReporterItemProvider(this);
        }

        return typePatternExecutionReporterItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.BackCall} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BackCallItemProvider backCallItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.BackCall}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createBackCallAdapter() {
        if (backCallItemProvider == null) {
            backCallItemProvider = new BackCallItemProvider(this);
        }

        return backCallItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.TypePatternCallBackHandler} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TypePatternCallBackHandlerItemProvider typePatternCallBackHandlerItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.TypePatternCallBackHandler}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createTypePatternCallBackHandlerAdapter() {
        if (typePatternCallBackHandlerItemProvider == null) {
            typePatternCallBackHandlerItemProvider = new TypePatternCallBackHandlerItemProvider(this);
        }

        return typePatternCallBackHandlerItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.TypePatternDomainVisitor} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TypePatternDomainVisitorItemProvider typePatternDomainVisitorItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.TypePatternDomainVisitor}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createTypePatternDomainVisitorAdapter() {
        if (typePatternDomainVisitorItemProvider == null) {
            typePatternDomainVisitorItemProvider = new TypePatternDomainVisitorItemProvider(this);
        }

        return typePatternDomainVisitorItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.TypePatternList} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TypePatternListItemProvider typePatternListItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.TypePatternList}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createTypePatternListAdapter() {
        if (typePatternListItemProvider == null) {
            typePatternListItemProvider = new TypePatternListItemProvider(this);
        }

        return typePatternListItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.TypePatternSubstitution} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TypePatternSubstitutionItemProvider typePatternSubstitutionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.TypePatternSubstitution}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createTypePatternSubstitutionAdapter() {
        if (typePatternSubstitutionItemProvider == null) {
            typePatternSubstitutionItemProvider = new TypePatternSubstitutionItemProvider(this);
        }

        return typePatternSubstitutionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.pattern.Substitution} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SubstitutionItemProvider substitutionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.pattern.Substitution}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createSubstitutionAdapter() {
        if (substitutionItemProvider == null) {
            substitutionItemProvider = new SubstitutionItemProvider(this);
        }

        return substitutionItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void dispose() {
        if (patternItemProvider != null)
            patternItemProvider.dispose();
        if (patternMethodItemProvider != null)
            patternMethodItemProvider.dispose();
        if (patternParameterItemProvider != null)
            patternParameterItemProvider.dispose();
        if (patternLibraryItemProvider != null)
            patternLibraryItemProvider.dispose();
        if (patternViewpointItemProvider != null)
            patternViewpointItemProvider.dispose();
        if (patternCallItemProvider != null)
            patternCallItemProvider.dispose();
        if (superCallItemProvider != null)
            superCallItemProvider.dispose();
        if (paramerter2ParameterMapItemProvider != null)
            paramerter2ParameterMapItemProvider.dispose();
        if (methodCallItemProvider != null)
            methodCallItemProvider.dispose();
        if (patternVariableItemProvider != null)
            patternVariableItemProvider.dispose();
        if (patternInjectedCallItemProvider != null)
            patternInjectedCallItemProvider.dispose();
        if (basicQueryItemProvider != null)
            basicQueryItemProvider.dispose();
        if (stringQueryItemProvider != null)
            stringQueryItemProvider.dispose();
        if (customQueryItemProvider != null)
            customQueryItemProvider.dispose();
        if (string2PatternListItemProvider != null)
            string2PatternListItemProvider.dispose();
        if (string2StringItemProvider != null)
            string2StringItemProvider.dispose();
        if (typePatternExecutionReporterItemProvider != null)
            typePatternExecutionReporterItemProvider.dispose();
        if (backCallItemProvider != null)
            backCallItemProvider.dispose();
        if (typePatternCallBackHandlerItemProvider != null)
            typePatternCallBackHandlerItemProvider.dispose();
        if (typePatternDomainVisitorItemProvider != null)
            typePatternDomainVisitorItemProvider.dispose();
        if (typePatternListItemProvider != null)
            typePatternListItemProvider.dispose();
        if (typePatternSubstitutionItemProvider != null)
            typePatternSubstitutionItemProvider.dispose();
        if (substitutionItemProvider != null)
            substitutionItemProvider.dispose();
    }

    /**
     * A child creation extender for the {@link FcorePackage}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static class FcoreChildCreationExtender implements IChildCreationExtender {

        /**
         * The switch for creating child descriptors specific to each extended class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected static class CreationSwitch extends FcoreSwitch<Object> {

            /**
             * The child descriptors being populated.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * 
             * @generated
             */
            protected List<Object> newChildDescriptors;

            /**
             * The domain in which to create the children.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * 
             * @generated
             */
            protected EditingDomain editingDomain;

            /**
             * Creates the a switch for populating child descriptors in the given domain.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * 
             * @generated
             */
            CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
                this.newChildDescriptors = newChildDescriptors;
                this.editingDomain = editingDomain;
            }

            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * 
             * @generated
             */
            @Override
            public Object caseContract(Contract object) {
                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.CONTRACT__TYPE, PatternFactory.eINSTANCE.createTypePatternExecutionReporter()));

                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.CONTRACT__TYPE, PatternFactory.eINSTANCE.createTypePatternCallBackHandler()));

                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.CONTRACT__TYPE, PatternFactory.eINSTANCE.createTypePatternDomainVisitor()));

                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.CONTRACT__TYPE, PatternFactory.eINSTANCE.createTypePatternList()));

                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.CONTRACT__TYPE, PatternFactory.eINSTANCE.createTypePatternSubstitution()));

                return null;
            }

            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * 
             * @generated
             */
            @Override
            public Object caseViewpointContainer(ViewpointContainer object) {
                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.VIEWPOINT_CONTAINER__VIEWPOINTS, PatternFactory.eINSTANCE.createPatternViewpoint()));

                return null;
            }

            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * 
             * @generated
             */
            @Override
            public Object caseOrchestrationParameter(OrchestrationParameter object) {
                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ORCHESTRATION_PARAMETER__TYPE, PatternFactory.eINSTANCE.createTypePatternExecutionReporter()));

                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ORCHESTRATION_PARAMETER__TYPE, PatternFactory.eINSTANCE.createTypePatternCallBackHandler()));

                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ORCHESTRATION_PARAMETER__TYPE, PatternFactory.eINSTANCE.createTypePatternDomainVisitor()));

                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ORCHESTRATION_PARAMETER__TYPE, PatternFactory.eINSTANCE.createTypePatternList()));

                newChildDescriptors.add(createChildParameter(FcorePackage.Literals.ORCHESTRATION_PARAMETER__TYPE, PatternFactory.eINSTANCE.createTypePatternSubstitution()));

                return null;
            }

            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * 
             * @generated NOT
             */
            @Override
            public Object caseInvocationContract(InvocationContract object) {

                if (object.getInvokedContract() == null || object.getInvokedContract().getType() == null) {
                    return null;
                }

                Type invokedContractType = object.getInvokedContract().getType();

                {
                    TypePatternExecutionReporter type = PatternFactory.eINSTANCE.createTypePatternExecutionReporter();
                    if (invokedContractType.isCompatible(type)) {
                        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
                    }
                }
                {
                    TypePatternList type = PatternFactory.eINSTANCE.createTypePatternList();
                    if (invokedContractType.isCompatible(type)) {
                        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
                    }
                }
                {
                    TypePatternSubstitution type = PatternFactory.eINSTANCE.createTypePatternSubstitution();
                    if (invokedContractType.isCompatible(type)) {
                        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
                    }
                }
                {
                    TypePatternCallBackHandler type = PatternFactory.eINSTANCE.createTypePatternCallBackHandler();
                    if (invokedContractType.isCompatible(type)) {
                        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
                    }
                }
                {
                    TypePatternDomainVisitor type = PatternFactory.eINSTANCE.createTypePatternDomainVisitor();
                    if (invokedContractType.isCompatible(type)) {
                        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
                    }
                }

                return null;
            }

            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * 
             * @generated
             */
            protected CommandParameter createChildParameter(Object feature, Object child) {
                return new CommandParameter(null, feature, child);
            }

        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
            ArrayList<Object> result = new ArrayList<Object>();
            new CreationSwitch(result, editingDomain).doSwitch((EObject) object);
            return result;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public ResourceLocator getResourceLocator() {
            return EGFModelEditPlugin.INSTANCE;
        }
    }

}
