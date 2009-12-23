package org.eclipse.egf.model.factorycomponent.util;

import java.util.Map;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.EGFModelsPlugin;
import org.eclipse.egf.model.factorycomponent.*;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ITraversalStrategy.Recursive;
import org.eclipse.emf.validation.service.ModelValidationService;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.egf.model.factorycomponent.FactoryComponentPackage
 * @generated
 */
public class FactoryComponentValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final FactoryComponentValidator INSTANCE = new FactoryComponentValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.model.factorycomponent"; //$NON-NLS-1$

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * Model Validation Service interface for batch validation of EMF elements.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final IBatchValidator batchValidator;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FactoryComponentValidator() {
    super();
    batchValidator = (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
    batchValidator.setTraversalStrategy(new Recursive());
    batchValidator.setIncludeLiveConstraints(true);
    batchValidator.setReportSuccesses(false);
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EPackage getEPackage() {
    return FactoryComponentPackage.eINSTANCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
    IStatus status = Status.OK_STATUS;
    // do whatever the basic EcoreValidator does
    super.validate(eClass, eObject, diagnostics, context);
    // no point in validating if we can't report results
    if (diagnostics != null) {
      // if EMF Mode Validation Service already covered the sub-tree,
      //    which it does for efficient computation and error reporting,
      //    then don't repeat (the Diagnostician does the recursion
      //    externally).  If there is no context map, then we can't
      //    help it
      if (hasProcessed(eObject, context) == false) {
        status = batchValidator.validate(eObject, new NullProgressMonitor());
        processed(eObject, context, status);
        appendDiagnostics(status, diagnostics);
      }
    }
    return status.isOK();
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
    switch (classifierID) {
    case FactoryComponentPackage.MODEL_ELEMENT:
      return validateModelElement((ModelElement) value, diagnostics, context);
    case FactoryComponentPackage.ACTIVITY:
      return validateActivity((Activity) value, diagnostics, context);
    case FactoryComponentPackage.TASK:
      return validateTask((Task) value, diagnostics, context);
    case FactoryComponentPackage.FACTORY_COMPONENT:
      return validateFactoryComponent((FactoryComponent) value, diagnostics, context);
    case FactoryComponentPackage.VIEWPOINT_CONTAINER:
      return validateViewpointContainer((ViewpointContainer) value, diagnostics, context);
    case FactoryComponentPackage.VIEWPOINT:
      return validateViewpoint((Viewpoint) value, diagnostics, context);
    case FactoryComponentPackage.ORCHESTRATION:
      return validateOrchestration((Orchestration) value, diagnostics, context);
    case FactoryComponentPackage.INVOCATION:
      return validateInvocation((Invocation) value, diagnostics, context);
    case FactoryComponentPackage.CONTEXT:
      return validateContext((Context) value, diagnostics, context);
    case FactoryComponentPackage.CONTRACT_CONTAINER:
      return validateContractContainer((ContractContainer) value, diagnostics, context);
    case FactoryComponentPackage.CONTRACT:
      return validateContract((Contract) value, diagnostics, context);
    case FactoryComponentPackage.CONTEXT_VALUE:
      return validateContextValue((ContextValue) value, diagnostics, context);
    case FactoryComponentPackage.CONTRACT_VALUE:
      return validateContractValue((ContractValue) value, diagnostics, context);
    case FactoryComponentPackage.CONTRACT_CONNECTOR:
      return validateContractConnector((ContractConnector) value, diagnostics, context);
    case FactoryComponentPackage.CONTRACT_MODE:
      return validateContractMode((ContractMode) value, diagnostics, context);
    case FactoryComponentPackage.INVOCATION_EXCEPTION:
      return validateInvocationException((RuntimeException) value, diagnostics, context);
    case FactoryComponentPackage.URI:
      return validateURI((URI) value, diagnostics, context);
    default:
      return true;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateModelElement(ModelElement modelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(modelElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(modelElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(modelElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(modelElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(modelElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(modelElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(modelElement, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(modelElement, diagnostics, context);
    return result;
  }

  /**
   * Validates the overall constraint of '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateModelElement_overall(ModelElement modelElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    // TODO implement the constraint
    // -> specify the condition that violates the constraint
    // -> verify the diagnostic details, including severity, code, and message
    // Ensure that you remove @generated or mark it @generated NOT
    if (false) {
      if (diagnostics != null) {
        diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
            new Object[] { "overall", getObjectLabel(modelElement, context) }, //$NON-NLS-1$
            new Object[] { modelElement }, context));
      }
      return false;
    }
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateActivity(Activity activity, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(activity, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(activity, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(activity, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(activity, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(activity, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(activity, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(activity, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(activity, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateTask(Task task, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(task, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(task, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateFactoryComponent(FactoryComponent factoryComponent, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(factoryComponent, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(factoryComponent, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(factoryComponent, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(factoryComponent, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(factoryComponent, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(factoryComponent, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(factoryComponent, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(factoryComponent, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateViewpointContainer(ViewpointContainer viewpointContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(viewpointContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(viewpointContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(viewpointContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(viewpointContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(viewpointContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(viewpointContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(viewpointContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(viewpointContainer, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateViewpoint(Viewpoint viewpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(viewpoint, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(viewpoint, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(viewpoint, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(viewpoint, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(viewpoint, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(viewpoint, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(viewpoint, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(viewpoint, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateOrchestration(Orchestration orchestration, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(orchestration, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(orchestration, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(orchestration, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(orchestration, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(orchestration, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(orchestration, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(orchestration, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(orchestration, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateInvocation(Invocation invocation, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(invocation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(invocation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(invocation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(invocation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(invocation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(invocation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(invocation, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(invocation, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
    boolean result = validate_EveryMultiplicityConforms(context, diagnostics, theContext);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(context, diagnostics, theContext);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(context, diagnostics, theContext);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(context, diagnostics, theContext);
    if (result || diagnostics != null)
      result &= validate_UniqueID(context, diagnostics, theContext);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(context, diagnostics, theContext);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(context, diagnostics, theContext);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(context, diagnostics, theContext);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContractContainer(ContractContainer contractContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(contractContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(contractContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(contractContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(contractContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(contractContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(contractContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(contractContainer, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(contractContainer, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContract(Contract contract, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(contract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(contract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(contract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(contract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(contract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(contract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(contract, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(contract, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContextValue(ContextValue contextValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(contextValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(contextValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(contextValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(contextValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(contextValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(contextValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(contextValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(contextValue, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContractValue(ContractValue contractValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(contractValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(contractValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(contractValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(contractValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(contractValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(contractValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(contractValue, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(contractValue, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContractConnector(ContractConnector contractConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
    boolean result = validate_EveryMultiplicityConforms(contractConnector, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryDataValueConforms(contractConnector, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryReferenceIsContained(contractConnector, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryProxyResolves(contractConnector, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_UniqueID(contractConnector, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryKeyUnique(contractConnector, diagnostics, context);
    if (result || diagnostics != null)
      result &= validate_EveryMapEntryUnique(contractConnector, diagnostics, context);
    if (result || diagnostics != null)
      result &= validateModelElement_overall(contractConnector, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContractMode(ContractMode contractMode, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateInvocationException(RuntimeException invocationException, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateURI(URI uri, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return EGFModelsPlugin.INSTANCE;
  }

  /**
   * If we have a context map, record this object's <code>status</code> in it
   * so that we will know later that we have processed it and its sub-tree.
   * 
   * @param eObject an element that we have validated
   * @param context the context (may be <code>null</code>)
   * @param status the element's validation status
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private void processed(EObject eObject, Map<Object, Object> context, IStatus status) {
    if (context != null) {
      context.put(eObject, status);
    }
  }

  /**
   * Determines whether we have processed this <code>eObject</code> before,
   * by automatic recursion of the EMF Model Validation Service.  This is
   * only possible if we do, indeed, have a context.
   * 
   * @param eObject an element to be validated (we hope not)
   * @param context the context (may be <code>null</code>)
   * @return <code>true</code> if the context is not <code>null</code> and
   *     the <code>eObject</code> or one of its containers has already been
   *     validated;  <code>false</code>, otherwise
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean hasProcessed(EObject eObject, Map<Object, Object> context) {
    boolean result = false;
    if (context != null) {
      // this is O(NlogN) but there's no helping it
      while (eObject != null) {
        if (context.containsKey(eObject)) {
          result = true;
          eObject = null;
        } else {
          eObject = eObject.eContainer();
        }
      }
    }
    return result;
  }

  /**
   * Converts a status result from the EMF validation service to diagnostics.
   * 
   * @param status the EMF validation service's status result
   * @param diagnostics a diagnostic chain to accumulate results on
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private void appendDiagnostics(IStatus status, DiagnosticChain diagnostics) {
    if (status.isMultiStatus()) {
      IStatus[] children = status.getChildren();
      for (int i = 0; i < children.length; i++) {
        appendDiagnostics(children[i], diagnostics);
      }
    } else if (status instanceof IConstraintStatus) {
      diagnostics.add(new BasicDiagnostic(status.getSeverity(), status.getPlugin(), status.getCode(), status.getMessage(),
          ((IConstraintStatus) status).getResultLocus().toArray()));
    }
  }
} //FactoryComponentValidator