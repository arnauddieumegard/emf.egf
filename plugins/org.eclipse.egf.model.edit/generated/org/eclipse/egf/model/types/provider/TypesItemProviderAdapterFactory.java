/**
 * 
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
 * 
 */
package org.eclipse.egf.model.types.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.egf.model.types.util.TypesAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
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
 * @generated
 */
public class TypesItemProviderAdapterFactory extends TypesAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This helps manage the child creation extenders.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(EGFModelEditPlugin.INSTANCE, TypesPackage.eNS_URI);

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypesItemProviderAdapterFactory() {
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
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeCollection} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeCollectionItemProvider typeCollectionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeCollection}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeCollectionAdapter() {
        if (typeCollectionItemProvider == null) {
            typeCollectionItemProvider = new TypeCollectionItemProvider(this);
        }

        return typeCollectionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeList} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeListItemProvider typeListItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeList}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeListAdapter() {
        if (typeListItemProvider == null) {
            typeListItemProvider = new TypeListItemProvider(this);
        }

        return typeListItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeSet} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeSetItemProvider typeSetItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeSet}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeSetAdapter() {
        if (typeSetItemProvider == null) {
            typeSetItemProvider = new TypeSetItemProvider(this);
        }

        return typeSetItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeClass} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeClassItemProvider typeClassItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeClass}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeClassAdapter() {
        if (typeClassItemProvider == null) {
            typeClassItemProvider = new TypeClassItemProvider(this);
        }

        return typeClassItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeMap} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeMapItemProvider typeMapItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeMap}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeMapAdapter() {
        if (typeMapItemProvider == null) {
            typeMapItemProvider = new TypeMapItemProvider(this);
        }

        return typeMapItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeBigDecimal} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeBigDecimalItemProvider typeBigDecimalItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeBigDecimal}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeBigDecimalAdapter() {
        if (typeBigDecimalItemProvider == null) {
            typeBigDecimalItemProvider = new TypeBigDecimalItemProvider(this);
        }

        return typeBigDecimalItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeBigInteger} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeBigIntegerItemProvider typeBigIntegerItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeBigInteger}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeBigIntegerAdapter() {
        if (typeBigIntegerItemProvider == null) {
            typeBigIntegerItemProvider = new TypeBigIntegerItemProvider(this);
        }

        return typeBigIntegerItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeBoolean} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeBooleanItemProvider typeBooleanItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeBoolean}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeBooleanAdapter() {
        if (typeBooleanItemProvider == null) {
            typeBooleanItemProvider = new TypeBooleanItemProvider(this);
        }

        return typeBooleanItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeByte} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeByteItemProvider typeByteItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeByte}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeByteAdapter() {
        if (typeByteItemProvider == null) {
            typeByteItemProvider = new TypeByteItemProvider(this);
        }

        return typeByteItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeCharacter} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeCharacterItemProvider typeCharacterItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeCharacter}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeCharacterAdapter() {
        if (typeCharacterItemProvider == null) {
            typeCharacterItemProvider = new TypeCharacterItemProvider(this);
        }

        return typeCharacterItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeDate} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeDateItemProvider typeDateItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeDate}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeDateAdapter() {
        if (typeDateItemProvider == null) {
            typeDateItemProvider = new TypeDateItemProvider(this);
        }

        return typeDateItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeDouble} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeDoubleItemProvider typeDoubleItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeDouble}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeDoubleAdapter() {
        if (typeDoubleItemProvider == null) {
            typeDoubleItemProvider = new TypeDoubleItemProvider(this);
        }

        return typeDoubleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeFloat} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeFloatItemProvider typeFloatItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeFloat}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeFloatAdapter() {
        if (typeFloatItemProvider == null) {
            typeFloatItemProvider = new TypeFloatItemProvider(this);
        }

        return typeFloatItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeInteger} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeIntegerItemProvider typeIntegerItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeInteger}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeIntegerAdapter() {
        if (typeIntegerItemProvider == null) {
            typeIntegerItemProvider = new TypeIntegerItemProvider(this);
        }

        return typeIntegerItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeLong} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeLongItemProvider typeLongItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeLong}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeLongAdapter() {
        if (typeLongItemProvider == null) {
            typeLongItemProvider = new TypeLongItemProvider(this);
        }

        return typeLongItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeShort} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeShortItemProvider typeShortItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeShort}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeShortAdapter() {
        if (typeShortItemProvider == null) {
            typeShortItemProvider = new TypeShortItemProvider(this);
        }

        return typeShortItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeString} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeStringItemProvider typeStringItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeString}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeStringAdapter() {
        if (typeStringItemProvider == null) {
            typeStringItemProvider = new TypeStringItemProvider(this);
        }

        return typeStringItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.egf.model.types.TypeURI} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypeURIItemProvider typeURIItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.egf.model.types.TypeURI}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTypeURIAdapter() {
        if (typeURIItemProvider == null) {
            typeURIItemProvider = new TypeURIItemProvider(this);
        }

        return typeURIItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public List<IChildCreationExtender> getChildCreationExtenders() {
        return childCreationExtenderManager.getChildCreationExtenders();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
        return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ResourceLocator getResourceLocator() {
        return childCreationExtenderManager;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * @generated
     */
    public void dispose() {
        if (typeClassItemProvider != null)
            typeClassItemProvider.dispose();
        if (typeCollectionItemProvider != null)
            typeCollectionItemProvider.dispose();
        if (typeListItemProvider != null)
            typeListItemProvider.dispose();
        if (typeSetItemProvider != null)
            typeSetItemProvider.dispose();
        if (typeMapItemProvider != null)
            typeMapItemProvider.dispose();
        if (typeBigDecimalItemProvider != null)
            typeBigDecimalItemProvider.dispose();
        if (typeBigIntegerItemProvider != null)
            typeBigIntegerItemProvider.dispose();
        if (typeBooleanItemProvider != null)
            typeBooleanItemProvider.dispose();
        if (typeByteItemProvider != null)
            typeByteItemProvider.dispose();
        if (typeCharacterItemProvider != null)
            typeCharacterItemProvider.dispose();
        if (typeDateItemProvider != null)
            typeDateItemProvider.dispose();
        if (typeDoubleItemProvider != null)
            typeDoubleItemProvider.dispose();
        if (typeFloatItemProvider != null)
            typeFloatItemProvider.dispose();
        if (typeIntegerItemProvider != null)
            typeIntegerItemProvider.dispose();
        if (typeLongItemProvider != null)
            typeLongItemProvider.dispose();
        if (typeShortItemProvider != null)
            typeShortItemProvider.dispose();
        if (typeStringItemProvider != null)
            typeStringItemProvider.dispose();
        if (typeURIItemProvider != null)
            typeURIItemProvider.dispose();
    }

}
