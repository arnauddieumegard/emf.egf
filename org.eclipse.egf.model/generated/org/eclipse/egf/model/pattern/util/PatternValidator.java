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
package org.eclipse.egf.model.pattern.util;

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.model.pattern.AbstractPatternCall;
import org.eclipse.egf.model.pattern.BasicQuery;
import org.eclipse.egf.model.pattern.Call;
import org.eclipse.egf.model.pattern.CustomQuery;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNature;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.model.pattern.StringQuery;
import org.eclipse.egf.model.pattern.SuperPatternCall;
import org.eclipse.egf.model.pattern.TypePatternExecutionReporter;
import org.eclipse.egf.model.types.util.TypesValidator;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.validation.service.ITraversalStrategy.Recursive;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc
 * -->
 * 
 * @see org.eclipse.egf.model.pattern.PatternPackage
 * @generated
 */
public class PatternValidator extends EObjectValidator {
    /**
     * The cached model package
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("hiding")
    public static final PatternValidator INSTANCE = new PatternValidator();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    @SuppressWarnings("hiding")
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.egf.model.pattern"; //$NON-NLS-1$

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Model Validation Service interface for batch validation of EMF elements.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private final IBatchValidator batchValidator;

    /**
     * The cached base package validator.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TypesValidator typesValidator;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public PatternValidator() {
        super();
        typesValidator = TypesValidator.INSTANCE;
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
        return PatternPackage.eINSTANCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
        switch (classifierID) {
        case PatternPackage.PATTERN:
            return validatePattern((Pattern) value, diagnostics, context);
        case PatternPackage.PATTERN_METHOD:
            return validatePatternMethod((PatternMethod) value, diagnostics, context);
        case PatternPackage.PATTERN_PARAMETER:
            return validatePatternParameter((PatternParameter) value, diagnostics, context);
        case PatternPackage.PATTERN_LIBRARY:
            return validatePatternLibrary((PatternLibrary) value, diagnostics, context);
        case PatternPackage.PATTERN_ELEMENT:
            return validatePatternElement((PatternElement) value, diagnostics, context);
        case PatternPackage.PATTERN_VIEWPOINT:
            return validatePatternViewpoint((PatternViewpoint) value, diagnostics, context);
        case PatternPackage.PATTERN_NATURE:
            return validatePatternNature((PatternNature) value, diagnostics, context);
        case PatternPackage.PATTERN_CALL:
            return validatePatternCall((PatternCall) value, diagnostics, context);
        case PatternPackage.SUPER_PATTERN_CALL:
            return validateSuperPatternCall((SuperPatternCall) value, diagnostics, context);
        case PatternPackage.PARAMERTER2_PARAMETER_MAP:
            return validateParamerter2ParameterMap((Map.Entry<?, ?>) value, diagnostics, context);
        case PatternPackage.CALL:
            return validateCall((Call) value, diagnostics, context);
        case PatternPackage.METHOD_CALL:
            return validateMethodCall((MethodCall) value, diagnostics, context);
        case PatternPackage.PATTERN_VARIABLE:
            return validatePatternVariable((PatternVariable) value, diagnostics, context);
        case PatternPackage.ABSTRACT_PATTERN_CALL:
            return validateAbstractPatternCall((AbstractPatternCall) value, diagnostics, context);
        case PatternPackage.PATTERN_INJECTED_CALL:
            return validatePatternInjectedCall((PatternInjectedCall) value, diagnostics, context);
        case PatternPackage.QUERY:
            return validateQuery((Query) value, diagnostics, context);
        case PatternPackage.BASIC_QUERY:
            return validateBasicQuery((BasicQuery) value, diagnostics, context);
        case PatternPackage.STRING_QUERY:
            return validateStringQuery((StringQuery) value, diagnostics, context);
        case PatternPackage.CUSTOM_QUERY:
            return validateCustomQuery((CustomQuery) value, diagnostics, context);
        case PatternPackage.STRING2_PATTERN_LIST:
            return validateString2PatternList((Map.Entry<?, ?>) value, diagnostics, context);
        case PatternPackage.STRING2_STRING:
            return validateString2String((Map.Entry<?, ?>) value, diagnostics, context);
        case PatternPackage.TYPE_PATTERN_EXECUTION_REPORTER:
            return validateTypePatternExecutionReporter((TypePatternExecutionReporter) value, diagnostics, context);
        case PatternPackage.BACK_CALL:
            return validateBackCall((BackCall) value, diagnostics, context);
        case PatternPackage.PATTERN_CONTEXT:
            return validatePatternContext((PatternContext) value, diagnostics, context);
        case PatternPackage.PATTERN_EXCEPTION:
            return validatePatternException((PatternException) value, diagnostics, context);
        case PatternPackage.EPATTERN_EXECUTION_REPORTER:
            return validateEPatternExecutionReporter((PatternExecutionReporter) value, diagnostics, context);
        default:
            return true;
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePattern(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(pattern, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(pattern, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(pattern, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(pattern, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(pattern, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(pattern, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(pattern, diagnostics, context);
        if (result || diagnostics != null)
            result &= validatePattern_HeaderMethod(pattern, diagnostics, context);
        if (result || diagnostics != null)
            result &= validatePattern_FooterMethod(pattern, diagnostics, context);
        return result;
    }

    /**
     * Validates the HeaderMethod constraint of '<em>Pattern</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validatePattern_HeaderMethod(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (pattern.getHeaderMethod() != null && pattern.getMethods().contains(pattern.getHeaderMethod()) == false) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] { "HeaderMethod", getObjectLabel(pattern, context), "Header Method should be a Pattern Method" }, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] { pattern }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * Validates the FooterMethod constraint of '<em>Pattern</em>'. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public boolean validatePattern_FooterMethod(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (pattern.getFooterMethod() != null && pattern.getMethods().contains(pattern.getFooterMethod()) == false) {
            if (diagnostics != null) {
                diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_EGFConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] { "FooterMethod", getObjectLabel(pattern, context), "Footer Method should be a Pattern Method" }, //$NON-NLS-1$ //$NON-NLS-2$
                        new Object[] { pattern }, context));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternMethod(PatternMethod patternMethod, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(patternMethod, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternParameter(PatternParameter patternParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(patternParameter, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternLibrary(PatternLibrary patternLibrary, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(patternLibrary, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternElement(PatternElement patternElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(patternElement, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternViewpoint(PatternViewpoint patternViewpoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(patternViewpoint, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternNature(PatternNature patternNature, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(patternNature, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternCall(PatternCall patternCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(patternCall, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSuperPatternCall(SuperPatternCall superPatternCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(superPatternCall, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateParamerter2ParameterMap(Map.Entry<?, ?> paramerter2ParameterMap, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject) paramerter2ParameterMap, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCall(Call call, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(call, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMethodCall(MethodCall methodCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(methodCall, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternVariable(PatternVariable patternVariable, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(patternVariable, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAbstractPatternCall(AbstractPatternCall abstractPatternCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(abstractPatternCall, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternInjectedCall(PatternInjectedCall patternInjectedCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(patternInjectedCall, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateQuery(Query query, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(query, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateBasicQuery(BasicQuery basicQuery, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(basicQuery, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateStringQuery(StringQuery stringQuery, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(stringQuery, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCustomQuery(CustomQuery customQuery, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(customQuery, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateString2PatternList(Map.Entry<?, ?> string2PatternList, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject) string2PatternList, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateString2String(Map.Entry<?, ?> string2String, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint((EObject) string2String, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateTypePatternExecutionReporter(TypePatternExecutionReporter typePatternExecutionReporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        boolean result = validate_EveryMultiplicityConforms(typePatternExecutionReporter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryDataValueConforms(typePatternExecutionReporter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryReferenceIsContained(typePatternExecutionReporter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryProxyResolves(typePatternExecutionReporter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_UniqueID(typePatternExecutionReporter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryKeyUnique(typePatternExecutionReporter, diagnostics, context);
        if (result || diagnostics != null)
            result &= validate_EveryMapEntryUnique(typePatternExecutionReporter, diagnostics, context);
        if (result || diagnostics != null)
            result &= typesValidator.validateTypeAbstractClass_LoadableValue(typePatternExecutionReporter, diagnostics, context);
        if (result || diagnostics != null)
            result &= typesValidator.validateTypeAbstractClass_ValidValue(typePatternExecutionReporter, diagnostics, context);
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateBackCall(BackCall backCall, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return validate_EveryDefaultConstraint(backCall, diagnostics, context);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternContext(PatternContext patternContext, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePatternException(PatternException patternException, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEPatternExecutionReporter(PatternExecutionReporter ePatternExecutionReporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
        return true;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return EGFModelPlugin.INSTANCE;
    }

    /**
     * If we have a context map, record this object's <code>status</code> in it
     * so that we will know later that we have processed it and its sub-tree.
     * 
     * @param eObject an element that we have validated
     * @param context the context (may be <code>null</code>)
     * @param status the element's validation status
     *          <!-- begin-user-doc --> <!--
     *          end-user-doc -->
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
     *         <!-- begin-user-doc -->
     *         <!-- end-user-doc -->
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
     * @param status
     *          the EMF validation service's status result
     * @param diagnostics
     *          a diagnostic chain to accumulate results on <!--
     *          begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    private void appendDiagnostics(IStatus status, DiagnosticChain diagnostics) {
        if (status.isMultiStatus()) {
            IStatus[] children = status.getChildren();
            for (int i = 0; i < children.length; i++) {
                appendDiagnostics(children[i], diagnostics);
            }
        } else if (status instanceof IConstraintStatus) {
            diagnostics.add(new BasicDiagnostic(status.getSeverity(), status.getPlugin(), status.getCode(), status.getMessage(), ((IConstraintStatus) status).getResultLocus().toArray()));
        }
    }
} // PatternValidator
