/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.fcore.provider;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractMode;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.types.TypeBigDecimal;
import org.eclipse.egf.model.types.TypeBigInteger;
import org.eclipse.egf.model.types.TypeBoolean;
import org.eclipse.egf.model.types.TypeByte;
import org.eclipse.egf.model.types.TypeCharacter;
import org.eclipse.egf.model.types.TypeCollection;
import org.eclipse.egf.model.types.TypeDate;
import org.eclipse.egf.model.types.TypeDouble;
import org.eclipse.egf.model.types.TypeFloat;
import org.eclipse.egf.model.types.TypeGeneratorAdapterFactory;
import org.eclipse.egf.model.types.TypeInteger;
import org.eclipse.egf.model.types.TypeList;
import org.eclipse.egf.model.types.TypeLong;
import org.eclipse.egf.model.types.TypeMap;
import org.eclipse.egf.model.types.TypeSet;
import org.eclipse.egf.model.types.TypeShort;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemColorProvider;
import org.eclipse.emf.edit.provider.ITableItemFontProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.egf.model.fcore.InvocationContract} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InvocationContractItemProvider extends ModelElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, ITableItemColorProvider, ITableItemFontProvider, IItemColorProvider, IItemFontProvider {
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationContractItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
    if (itemPropertyDescriptors == null) {
      super.getPropertyDescriptors(object);

      addFactoryComponentContractPropertyDescriptor(object);
      addOrchestrationParameterPropertyDescriptor(object);
      addSourceInvocationContractPropertyDescriptor(object);
      addTargetInvocationContractPropertyDescriptor(object);
      addInvokedContractPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Factory Component Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addFactoryComponentContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_factoryComponentContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_factoryComponentContract_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__FACTORY_COMPONENT_CONTRACT, true, false, true, null, getString("_UI_FactoryComponentPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContract invocationContract = (InvocationContract) current;
        Collection<Contract> result = new UniqueEList<Contract>();
        if (result.contains(null) == false) {
          result.add(null);
        }
        // Nothing to retrieve
        if (invocationContract.getFactoryComponent() == null || invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null) {
          return result;
        }
        // If an orchestration parameter is already assigned, InvocationParameter in In mode are not
        // assignable
        if (invocationContract.getOrchestrationParameter() != null && invocationContract.getInvokedMode() == ContractMode.IN) {
          return result;
        }
        // Retrieve all the typed contracts if available
        if (invocationContract.getInvokedMode() == ContractMode.IN) {
          result.addAll(invocationContract.getFactoryComponent().getContracts(invocationContract.getInvokedContract().getType(), ContractMode.IN));
        } else {
          // In or In_Out Contract should have only one assigned InvocationContract.
          for (Contract contract : invocationContract.getFactoryComponent().getContracts(invocationContract.getInvokedContract().getType(), invocationContract.getInvokedMode())) {
            if (((FactoryComponentContract) contract).getInvocationContracts().size() == 0) {
              result.add(contract);
            }
          }
        }
        // If an orchestration parameter is already assigned, InvocationContract in In_Out mode are
        // only assignable to Out Mode Contract
        if (invocationContract.getOrchestrationParameter() != null && invocationContract.getInvokedMode() == ContractMode.IN_OUT) {
          for (Iterator<Contract> it = result.iterator(); it.hasNext();) {
            Contract contract = it.next();
            if (contract.getMode() != ContractMode.OUT) {
              it.remove();
            }
          }
          return result;
        }
        return result;
      }
    });
  }

  /**
   * This adds a property descriptor for the Orchestration Parameter feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addOrchestrationParameterPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_orchestrationParameter_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_orchestrationParameter_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__ORCHESTRATION_PARAMETER, true, false, true, null, getString("_UI_OrchestrationPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContract invocationContract = (InvocationContract) current;
        Collection<OrchestrationParameter> result = new UniqueEList<OrchestrationParameter>();
        if (result.contains(null) == false) {
          result.add(null);
        }
        // Nothing to retrieve
        if (invocationContract.getFactoryComponent() == null || invocationContract.getFactoryComponent().getOrchestration() == null || invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null) {
          return result;
        }
        // InvocationContract in Out mode are not assignable
        if (invocationContract.getInvokedMode() == ContractMode.OUT) {
          return result;
        }
        // InvocationContract already assigned to an exposed contract should in be In_Out mode
        if (invocationContract.getFactoryComponentContract() != null && invocationContract.getInvokedMode() != ContractMode.IN_OUT) {
          return result;
        }
        // Retrieve all compatible typed OrchestrationParameter
        result.addAll(invocationContract.getFactoryComponent().getOrchestration().getOrchestrationParameters(invocationContract.getInvokedContract().getType()));
        return result;
      }
    });
  }

  /**
   * This adds a property descriptor for the Source Invocation Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSourceInvocationContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_sourceInvocationContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_sourceInvocationContract_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__SOURCE_INVOCATION_CONTRACT, true, false, true, null, getString("_UI_ConnectorPropertyCategory"), //$NON-NLS-1$
        null));
  }

  /**
   * This adds a property descriptor for the Target Invocation Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTargetInvocationContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_targetInvocationContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_targetInvocationContract_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__TARGET_INVOCATION_CONTRACT, true, false, true, null, getString("_UI_ConnectorPropertyCategory"), //$NON-NLS-1$
        null));
  }

  /**
   * This adds a property descriptor for the Invoked Contract feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  protected void addInvokedContractPropertyDescriptor(Object object) {
    itemPropertyDescriptors.add(new ItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(), getString("_UI_InvocationContract_invokedContract_feature"), //$NON-NLS-1$
        getString("_UI_PropertyDescriptor_description", "_UI_InvocationContract_invokedContract_feature", "_UI_InvocationContract_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        FcorePackage.Literals.INVOCATION_CONTRACT__INVOKED_CONTRACT, true, false, true, null, getString("_UI_BehaviourPropertyCategory"), //$NON-NLS-1$
        null) {
      @Override
      public Collection<?> getChoiceOfValues(Object current) {
        InvocationContract invocationContract = (InvocationContract) current;
        Collection<Contract> result = new UniqueEList<Contract>();
        // Retrieve all the typed contracts if available
        if (invocationContract.getInvocation() != null && invocationContract.getInvocation().getInvokedActivity() != null) {
          // Type filtering
          if (invocationContract.getType() != null) {
            if (invocationContract.getFactoryComponentContract() != null) {
              result.addAll(invocationContract.getInvocation().getInvokedActivity().getContracts(invocationContract.getType(), invocationContract.getFactoryComponentContract().getMode()));
            } else {
              result.addAll(invocationContract.getInvocation().getInvokedActivity().getContracts(invocationContract.getType()));
            }
            // Filter all assigned contracts if necessary
            if (result.size() > 0) {
              for (Contract innerContract : invocationContract.getInvocation().getInvokedContracts(invocationContract.getType())) {
                result.remove(innerContract);
              }
            }
          } else {
            if (invocationContract.getFactoryComponentContract() != null) {
              result.addAll(invocationContract.getInvocation().getInvokedActivity().getContracts(invocationContract.getFactoryComponentContract().getMode()));
            } else {
              result.addAll(invocationContract.getInvocation().getInvokedActivity().getContracts());
            }
            // Filter all assigned contracts if necessary
            if (result.size() > 0) {
              for (Contract innerContract : invocationContract.getInvocation().getInvokedContracts()) {
                result.remove(innerContract);
              }
            }
          }
        }
        if (result.contains(null) == false) {
          result.add(null);
        }
        return result;
      }
    });
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
    if (childrenFeatures == null) {
      super.getChildrenFeatures(object);
      childrenFeatures.add(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child) {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns InvocationContract.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object) {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/InvocationContract")); //$NON-NLS-1$
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  public String getText(Object object) {
    InvocationContract invocationContract = (InvocationContract) object;
    String invoked = null;
    if (invocationContract.getInvokedContract() != null) {
      invoked = EMFHelper.getText(invocationContract.getInvokedContract());
    }
    String label = "[" + getString("_UI_InvocationContract_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    if (invoked != null) {
      label = label + " -> " + invoked; //$NON-NLS-1$
    }
    return label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification) {
    updateChildren(notification);

    switch (notification.getFeatureID(InvocationContract.class)) {
    case FcorePackage.INVOCATION_CONTRACT__INVOKED_CONTRACT:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    case FcorePackage.INVOCATION_CONTRACT__TYPE:
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
      return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {

    super.collectNewChildDescriptors(newChildDescriptors, object);

    if (object instanceof InvocationContract == false) {
      return;
    }
    InvocationContract invocationContract = (InvocationContract) object;

    if (invocationContract.getInvokedContract() == null || invocationContract.getInvokedContract().getType() == null) {
      return;
    }

    {
      TypeCollection type = TypesFactory.eINSTANCE.createTypeCollection();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeList type = TypesFactory.eINSTANCE.createTypeList();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeSet type = TypesFactory.eINSTANCE.createTypeSet();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeMap type = TypesFactory.eINSTANCE.createTypeMap();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeBigDecimal type = TypesFactory.eINSTANCE.createTypeBigDecimal();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeBigInteger type = TypesFactory.eINSTANCE.createTypeBigInteger();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeBoolean type = TypesFactory.eINSTANCE.createTypeBoolean();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeByte type = TypesFactory.eINSTANCE.createTypeByte();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeCharacter type = TypesFactory.eINSTANCE.createTypeCharacter();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeDate type = TypesFactory.eINSTANCE.createTypeDate();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeDouble type = TypesFactory.eINSTANCE.createTypeDouble();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeFloat type = TypesFactory.eINSTANCE.createTypeFloat();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeInteger type = TypesFactory.eINSTANCE.createTypeInteger();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeLong type = TypesFactory.eINSTANCE.createTypeLong();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeShort type = TypesFactory.eINSTANCE.createTypeShort();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeString type = TypesFactory.eINSTANCE.createTypeString();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

    {
      TypeGeneratorAdapterFactory type = TypesFactory.eINSTANCE.createTypeGeneratorAdapterFactory();
      if (ClassHelper.asSubClass(type.getType(), invocationContract.getInvokedContract().getType().getType())) {
        newChildDescriptors.add(createChildParameter(FcorePackage.Literals.INVOCATION_CONTRACT__TYPE, type));
      }
    }

  }

}
