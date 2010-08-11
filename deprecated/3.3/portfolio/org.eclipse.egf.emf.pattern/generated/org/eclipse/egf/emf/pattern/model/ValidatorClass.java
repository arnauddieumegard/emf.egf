package org.eclipse.egf.emf.pattern.model;

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

public class ValidatorClass extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
    protected static String nl;

    public static synchronized ValidatorClass create(String lineSeparator) {
        nl = lineSeparator;
        ValidatorClass result = new ValidatorClass();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL + "package ";
    protected final String TEXT_3 = ";" + NL;
    protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * The <b>Validator</b> for the model." + NL + " * <!-- end-user-doc -->" + NL + " * @see ";
    protected final String TEXT_5 = NL + " * @generated" + NL + " */" + NL + "public class ";
    protected final String TEXT_6 = " extends ";
    protected final String TEXT_7 = NL + "{";
    protected final String TEXT_8 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
    protected final String TEXT_9 = " copyright = ";
    protected final String TEXT_10 = ";";
    protected final String TEXT_11 = NL;
    protected final String TEXT_12 = NL + "\t/**" + NL + "\t * The cached model package" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
    protected final String TEXT_13 = " INSTANCE = new ";
    protected final String TEXT_14 = "();" + NL + "" + NL + "\t/**" + NL + "\t * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see org.eclipse.emf.common.util.Diagnostic#getSource()" + NL + "\t * @see org.eclipse.emf.common.util.Diagnostic#getCode()" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String DIAGNOSTIC_SOURCE = \"";
    protected final String TEXT_15 = "\";";
    protected final String TEXT_16 = NL;
    protected final String TEXT_17 = NL + "\t/**" + NL + "\t * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint '";
    protected final String TEXT_18 = "' of '";
    protected final String TEXT_19 = "'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int ";
    protected final String TEXT_20 = " = ";
    protected final String TEXT_21 = ";" + NL;
    protected final String TEXT_22 = NL + "\t/**" + NL + "\t * A constant with a fixed name that can be used as the base value for additional hand written constants." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final int GENERATED_DIAGNOSTIC_CODE_COUNT = ";
    protected final String TEXT_23 = ";" + NL + "" + NL + "\t/**" + NL + "\t * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;" + NL;
    protected final String TEXT_24 = NL + "\t/**" + NL + "\t * The cached base package validator." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
    protected final String TEXT_25 = " ";
    protected final String TEXT_26 = "Validator;" + NL;
    protected final String TEXT_27 = NL + "\t/**" + NL + "\t * Creates an instance of the switch." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
    protected final String TEXT_28 = "()" + NL + "\t{" + NL + "\t\tsuper();";
    protected final String TEXT_29 = NL + "\t\t";
    protected final String TEXT_30 = "Validator = ";
    protected final String TEXT_31 = ".INSTANCE;";
    protected final String TEXT_32 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns the package of this validator switch." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_33 = NL + "\t@Override";
    protected final String TEXT_34 = NL + "\tprotected EPackage getEPackage()" + NL + "\t{" + NL + "\t  return ";
    protected final String TEXT_35 = ".eINSTANCE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Calls <code>validateXXX</code> for the corresponding classifier of the model." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_36 = NL + "\t@Override";
    protected final String TEXT_37 = NL + "\t@SuppressWarnings(\"unchecked\")";
    protected final String TEXT_38 = NL + "\tprotected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, ";
    protected final String TEXT_39 = " context)" + NL + "\t{" + NL + "\t\tswitch (classifierID)" + NL + "\t\t{";
    protected final String TEXT_40 = NL + "\t\t\tcase ";
    protected final String TEXT_41 = ".";
    protected final String TEXT_42 = ":";
    protected final String TEXT_43 = NL + "\t\t\t\treturn validate";
    protected final String TEXT_44 = "(((";
    protected final String TEXT_45 = ")value).";
    protected final String TEXT_46 = "(), diagnostics, context);";
    protected final String TEXT_47 = NL + "\t\t\t\treturn validate";
    protected final String TEXT_48 = "(value, diagnostics, context);";
    protected final String TEXT_49 = NL + "\t\t\t\treturn validate";
    protected final String TEXT_50 = "((";
    protected final String TEXT_51 = ")value, diagnostics, context);";
    protected final String TEXT_52 = NL + "\t\t\t\treturn validate";
    protected final String TEXT_53 = "((";
    protected final String TEXT_54 = ")value, diagnostics, context);";
    protected final String TEXT_55 = NL + "\t\t\tdefault: " + NL + "\t\t\t\treturn true;" + NL + "\t\t}" + NL + "\t}" + NL;
    protected final String TEXT_56 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean validate";
    protected final String TEXT_57 = "(";
    protected final String TEXT_58 = " ";
    protected final String TEXT_59 = ", DiagnosticChain ";
    protected final String TEXT_60 = ", ";
    protected final String TEXT_61 = " ";
    protected final String TEXT_62 = ")" + NL + "\t{";
    protected final String TEXT_63 = NL + "\t\treturn true;";
    protected final String TEXT_64 = NL + "\t\treturn validate_EveryDefaultConstraint(";
    protected final String TEXT_65 = "(";
    protected final String TEXT_66 = ")";
    protected final String TEXT_67 = ", ";
    protected final String TEXT_68 = ", ";
    protected final String TEXT_69 = ");";
    protected final String TEXT_70 = NL + "\t\tboolean ";
    protected final String TEXT_71 = " = ";
    protected final String TEXT_72 = "validate";
    protected final String TEXT_73 = "_";
    protected final String TEXT_74 = "(";
    protected final String TEXT_75 = ", ";
    protected final String TEXT_76 = ", ";
    protected final String TEXT_77 = ");";
    protected final String TEXT_78 = NL + "\t\tif (";
    protected final String TEXT_79 = " || ";
    protected final String TEXT_80 = " != null) result &= ";
    protected final String TEXT_81 = "validate";
    protected final String TEXT_82 = "_";
    protected final String TEXT_83 = "(";
    protected final String TEXT_84 = ", ";
    protected final String TEXT_85 = ", ";
    protected final String TEXT_86 = ");";
    protected final String TEXT_87 = NL + "\t\treturn ";
    protected final String TEXT_88 = ";";
    protected final String TEXT_89 = NL + "\t}" + NL;
    protected final String TEXT_90 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
    protected final String TEXT_91 = "_";
    protected final String TEXT_92 = NL + "\t */" + NL + "\tpublic static final ";
    protected final String TEXT_93 = " ";
    protected final String TEXT_94 = "__VALUE = ";
    protected final String TEXT_95 = ";" + NL;
    protected final String TEXT_96 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
    protected final String TEXT_97 = "_";
    protected final String TEXT_98 = NL + "\t */" + NL + "\tpublic static final ";
    protected final String TEXT_99 = " ";
    protected final String TEXT_100 = "__VALUE = ";
    protected final String TEXT_101 = ";" + NL;
    protected final String TEXT_102 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
    protected final String TEXT_103 = "_";
    protected final String TEXT_104 = NL + "\t */" + NL + "\tpublic static final ";
    protected final String TEXT_105 = " ";
    protected final String TEXT_106 = "__UPPER_BOUND = ";
    protected final String TEXT_107 = ";" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
    protected final String TEXT_108 = "_";
    protected final String TEXT_109 = NL + "\t */" + NL + "\tpublic static final ";
    protected final String TEXT_110 = " ";
    protected final String TEXT_111 = "__LOWER_BOUND = ";
    protected final String TEXT_112 = ";" + NL;
    protected final String TEXT_113 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
    protected final String TEXT_114 = "_";
    protected final String TEXT_115 = NL + "\t */" + NL + "\tpublic static final  PatternMatcher [][] ";
    protected final String TEXT_116 = "__VALUES =" + NL + "\t\tnew PatternMatcher [][] " + NL + "\t\t{";
    protected final String TEXT_117 = NL + "\t\t\tnew PatternMatcher [] " + NL + "\t\t\t{";
    protected final String TEXT_118 = NL + "\t\t\t\t";
    protected final String TEXT_119 = ".createPatternMatcher(";
    protected final String TEXT_120 = ")";
    protected final String TEXT_121 = NL + "\t\t\t}";
    protected final String TEXT_122 = NL + "\t\t};" + NL;
    protected final String TEXT_123 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @see #validate";
    protected final String TEXT_124 = "_";
    protected final String TEXT_125 = NL + "\t */" + NL + "\tpublic static final ";
    protected final String TEXT_126 = " ";
    protected final String TEXT_127 = "__VALUES =" + NL + "\t\twrapEnumerationValues" + NL + "\t\t\t(new Object[] " + NL + "\t\t\t {";
    protected final String TEXT_128 = NL + "\t\t\t\t ";
    protected final String TEXT_129 = "new ";
    protected final String TEXT_130 = "(";
    protected final String TEXT_131 = ")";
    protected final String TEXT_132 = NL + "\t\t\t });" + NL;
    protected final String TEXT_133 = NL + "\t/**" + NL + "\t * Validates the ";
    protected final String TEXT_134 = " constraint of '<em>";
    protected final String TEXT_135 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean validate";
    protected final String TEXT_136 = "_";
    protected final String TEXT_137 = "(";
    protected final String TEXT_138 = " ";
    protected final String TEXT_139 = ", DiagnosticChain ";
    protected final String TEXT_140 = ", ";
    protected final String TEXT_141 = " ";
    protected final String TEXT_142 = ")" + NL + "\t{";
    protected final String TEXT_143 = NL + "\t\tboolean ";
    protected final String TEXT_144 = " = true;" + NL + "\t\tfor (";
    protected final String TEXT_145 = " i = ";
    protected final String TEXT_146 = ".iterator(); i.hasNext() && (result || diagnostics != null); )" + NL + "\t\t{" + NL + "\t\t\tObject item = i.next();";
    protected final String TEXT_147 = NL + "\t\t\tif (";
    protected final String TEXT_148 = ".isInstance(item))" + NL + "\t\t\t{" + NL + "\t\t\t\tresult &= ";
    protected final String TEXT_149 = "validate";
    protected final String TEXT_150 = "(";
    protected final String TEXT_151 = "(";
    protected final String TEXT_152 = "(";
    protected final String TEXT_153 = ")";
    protected final String TEXT_154 = ").";
    protected final String TEXT_155 = "()";
    protected final String TEXT_156 = ", ";
    protected final String TEXT_157 = ", ";
    protected final String TEXT_158 = ");" + NL + "\t\t\t}" + NL + "\t\t\telse";
    protected final String TEXT_159 = NL + "\t\t\tif (!";
    protected final String TEXT_160 = ".isInstance(item))";
    protected final String TEXT_161 = NL + "\t\t\t{" + NL + "\t\t\t\tresult = false;" + NL + "\t\t\t\treportDataValueTypeViolation(";
    protected final String TEXT_162 = ", item, ";
    protected final String TEXT_163 = ", ";
    protected final String TEXT_164 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;";
    protected final String TEXT_165 = NL + "\t\tif (diagnostics != null)" + NL + "\t\t{" + NL + "\t\t\t";
    protected final String TEXT_166 = " tempDiagnostics = new BasicDiagnostic();";
    protected final String TEXT_167 = NL + "\t\t\tif (";
    protected final String TEXT_168 = "validate";
    protected final String TEXT_169 = "(";
    protected final String TEXT_170 = ", tempDiagnostics, ";
    protected final String TEXT_171 = ")) return true;";
    protected final String TEXT_172 = NL + "\t\t\tif (";
    protected final String TEXT_173 = ".isInstance(";
    protected final String TEXT_174 = "))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
    protected final String TEXT_175 = "if (";
    protected final String TEXT_176 = "validate";
    protected final String TEXT_177 = "(";
    protected final String TEXT_178 = "(";
    protected final String TEXT_179 = "(";
    protected final String TEXT_180 = ")";
    protected final String TEXT_181 = ").";
    protected final String TEXT_182 = "()";
    protected final String TEXT_183 = ", tempDiagnostics, ";
    protected final String TEXT_184 = ")) ";
    protected final String TEXT_185 = "return true;" + NL + "\t\t\t}";
    protected final String TEXT_186 = NL + "\t\t\tfor (";
    protected final String TEXT_187 = " diagnostic : tempDiagnostics.getChildren())" + NL + "\t\t\t{" + NL + "\t\t\t\tdiagnostics.add(diagnostic);" + NL + "\t\t\t}";
    protected final String TEXT_188 = NL + "\t\t\t";
    protected final String TEXT_189 = " children = tempDiagnostics.getChildren();" + NL + "\t\t\tfor (int i = 0; i < children.size(); i++)" + NL + "\t\t\t{" + NL + "\t\t\t\tdiagnostics.add((";
    protected final String TEXT_190 = ")children.get(i));" + NL + "\t\t\t}";
    protected final String TEXT_191 = NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{";
    protected final String TEXT_192 = NL + "\t\t\tif (";
    protected final String TEXT_193 = "validate";
    protected final String TEXT_194 = "(";
    protected final String TEXT_195 = ", null, ";
    protected final String TEXT_196 = ")) return true;";
    protected final String TEXT_197 = NL + "\t\t\tif (";
    protected final String TEXT_198 = ".isInstance(";
    protected final String TEXT_199 = "))" + NL + "\t\t\t{" + NL + "\t\t\t\t";
    protected final String TEXT_200 = "if (";
    protected final String TEXT_201 = "validate";
    protected final String TEXT_202 = "(";
    protected final String TEXT_203 = "(";
    protected final String TEXT_204 = "(";
    protected final String TEXT_205 = ")";
    protected final String TEXT_206 = ").";
    protected final String TEXT_207 = "()";
    protected final String TEXT_208 = ", null, ";
    protected final String TEXT_209 = ")) ";
    protected final String TEXT_210 = "return true;" + NL + "\t\t\t}";
    protected final String TEXT_211 = NL + "\t\t}" + NL + "\t\treturn false;";
    protected final String TEXT_212 = NL + "\t\treturn validatePattern(";
    protected final String TEXT_213 = ", ";
    protected final String TEXT_214 = "new ";
    protected final String TEXT_215 = "(";
    protected final String TEXT_216 = ")";
    protected final String TEXT_217 = ", ";
    protected final String TEXT_218 = "__VALUES, ";
    protected final String TEXT_219 = ", ";
    protected final String TEXT_220 = ");";
    protected final String TEXT_221 = NL + "\t\t";
    protected final String TEXT_222 = " ";
    protected final String TEXT_223 = " = new ";
    protected final String TEXT_224 = "(";
    protected final String TEXT_225 = ");";
    protected final String TEXT_226 = NL + "\t\tboolean ";
    protected final String TEXT_227 = " = ";
    protected final String TEXT_228 = "__VALUES.contains(";
    protected final String TEXT_229 = ");" + NL + "\t\tif (!";
    protected final String TEXT_230 = " && ";
    protected final String TEXT_231 = " != null) " + NL + "\t\t\treportEnumerationViolation(";
    protected final String TEXT_232 = ", ";
    protected final String TEXT_233 = ", ";
    protected final String TEXT_234 = "__VALUES, ";
    protected final String TEXT_235 = ", ";
    protected final String TEXT_236 = ");" + NL + "\t\treturn ";
    protected final String TEXT_237 = "; ";
    protected final String TEXT_238 = NL + "\t\tboolean ";
    protected final String TEXT_239 = " = ";
    protected final String TEXT_240 = " ";
    protected final String TEXT_241 = " ";
    protected final String TEXT_242 = "__VALUE;" + NL + "\t\tif (!";
    protected final String TEXT_243 = " && ";
    protected final String TEXT_244 = " != null) " + NL + "\t\t\treportMinViolation(";
    protected final String TEXT_245 = ", new ";
    protected final String TEXT_246 = "(";
    protected final String TEXT_247 = "), new ";
    protected final String TEXT_248 = "(";
    protected final String TEXT_249 = "__VALUE), ";
    protected final String TEXT_250 = ", ";
    protected final String TEXT_251 = ", ";
    protected final String TEXT_252 = ");" + NL + "\t\treturn ";
    protected final String TEXT_253 = ";";
    protected final String TEXT_254 = NL + "\t\tint ";
    protected final String TEXT_255 = " = ";
    protected final String TEXT_256 = ".compareCalendar(";
    protected final String TEXT_257 = ", ";
    protected final String TEXT_258 = "__VALUE);" + NL + "\t\tboolean ";
    protected final String TEXT_259 = " = ";
    protected final String TEXT_260 = " == 0 || ";
    protected final String TEXT_261 = " == 1;";
    protected final String TEXT_262 = NL + "\t\tint ";
    protected final String TEXT_263 = " = ";
    protected final String TEXT_264 = ".compareDuration(";
    protected final String TEXT_265 = ", ";
    protected final String TEXT_266 = "__VALUE);" + NL + "\t\tboolean ";
    protected final String TEXT_267 = " = ";
    protected final String TEXT_268 = " == 0 || ";
    protected final String TEXT_269 = " == 1;";
    protected final String TEXT_270 = NL + "\t\tboolean ";
    protected final String TEXT_271 = " = ";
    protected final String TEXT_272 = ".compareTo(";
    protected final String TEXT_273 = "__VALUE) ";
    protected final String TEXT_274 = " 0;";
    protected final String TEXT_275 = NL + "\t\tif (!";
    protected final String TEXT_276 = " && ";
    protected final String TEXT_277 = " != null) " + NL + "\t\t\treportMinViolation(";
    protected final String TEXT_278 = ", ";
    protected final String TEXT_279 = ", ";
    protected final String TEXT_280 = "__VALUE, ";
    protected final String TEXT_281 = ", ";
    protected final String TEXT_282 = ", ";
    protected final String TEXT_283 = ");" + NL + "\t\treturn ";
    protected final String TEXT_284 = "; ";
    protected final String TEXT_285 = NL + "\t\tboolean ";
    protected final String TEXT_286 = " = ";
    protected final String TEXT_287 = " ";
    protected final String TEXT_288 = " ";
    protected final String TEXT_289 = "__VALUE;" + NL + "\t\tif (!";
    protected final String TEXT_290 = " && ";
    protected final String TEXT_291 = " != null) " + NL + "\t\t\treportMaxViolation(";
    protected final String TEXT_292 = ", new ";
    protected final String TEXT_293 = "(";
    protected final String TEXT_294 = "), new ";
    protected final String TEXT_295 = "(";
    protected final String TEXT_296 = "__VALUE), ";
    protected final String TEXT_297 = ", ";
    protected final String TEXT_298 = ", ";
    protected final String TEXT_299 = ");" + NL + "\t\treturn ";
    protected final String TEXT_300 = "; ";
    protected final String TEXT_301 = NL + "\t\tint ";
    protected final String TEXT_302 = " = ";
    protected final String TEXT_303 = ".compareCalendar(";
    protected final String TEXT_304 = ", ";
    protected final String TEXT_305 = "__VALUE);" + NL + "\t\tboolean ";
    protected final String TEXT_306 = " = ";
    protected final String TEXT_307 = " == 0 || ";
    protected final String TEXT_308 = " == -1;";
    protected final String TEXT_309 = NL + "\t\tint ";
    protected final String TEXT_310 = " = ";
    protected final String TEXT_311 = ".compareDuration(";
    protected final String TEXT_312 = ", ";
    protected final String TEXT_313 = "__VALUE);" + NL + "\t\tboolean ";
    protected final String TEXT_314 = " = ";
    protected final String TEXT_315 = " == 0 || ";
    protected final String TEXT_316 = " == -1;";
    protected final String TEXT_317 = NL + "\t\tboolean ";
    protected final String TEXT_318 = " = ";
    protected final String TEXT_319 = ".compareTo(";
    protected final String TEXT_320 = "__VALUE) ";
    protected final String TEXT_321 = " 0;";
    protected final String TEXT_322 = NL + "\t\tif (!";
    protected final String TEXT_323 = " && ";
    protected final String TEXT_324 = " != null) " + NL + "\t\t\treportMaxViolation(";
    protected final String TEXT_325 = ", ";
    protected final String TEXT_326 = ", ";
    protected final String TEXT_327 = "__VALUE, ";
    protected final String TEXT_328 = ", ";
    protected final String TEXT_329 = ", ";
    protected final String TEXT_330 = ");" + NL + "\t\treturn ";
    protected final String TEXT_331 = "; ";
    protected final String TEXT_332 = NL + "\t\tint length = ";
    protected final String TEXT_333 = ".";
    protected final String TEXT_334 = ";  " + NL + "\t\tboolean ";
    protected final String TEXT_335 = " = length >= ";
    protected final String TEXT_336 = ";" + NL + "\t\tif (!";
    protected final String TEXT_337 = " && ";
    protected final String TEXT_338 = " != null) " + NL + "\t\t\treportMinLengthViolation(";
    protected final String TEXT_339 = ", ";
    protected final String TEXT_340 = ", length, ";
    protected final String TEXT_341 = ", ";
    protected final String TEXT_342 = ", ";
    protected final String TEXT_343 = ");" + NL + "\t\treturn ";
    protected final String TEXT_344 = ";";
    protected final String TEXT_345 = NL + "\t\tint length = ";
    protected final String TEXT_346 = ".";
    protected final String TEXT_347 = ";  " + NL + "\t\tboolean ";
    protected final String TEXT_348 = " = length <= ";
    protected final String TEXT_349 = ";" + NL + "\t\tif (!";
    protected final String TEXT_350 = " && ";
    protected final String TEXT_351 = " != null) " + NL + "\t\t\treportMaxLengthViolation(";
    protected final String TEXT_352 = ", ";
    protected final String TEXT_353 = ", length, ";
    protected final String TEXT_354 = ", ";
    protected final String TEXT_355 = ", ";
    protected final String TEXT_356 = ");" + NL + "\t\treturn ";
    protected final String TEXT_357 = ";";
    protected final String TEXT_358 = NL + "\t\tboolean ";
    protected final String TEXT_359 = " = ";
    protected final String TEXT_360 = " > ";
    protected final String TEXT_361 = "__LOWER_BOUND && ";
    protected final String TEXT_362 = " < ";
    protected final String TEXT_363 = "__UPPER_BOUND;" + NL + "\t\tif (!";
    protected final String TEXT_364 = " && ";
    protected final String TEXT_365 = " != null) " + NL + "\t\t\treportTotalDigitsViolation(";
    protected final String TEXT_366 = ", new ";
    protected final String TEXT_367 = "(";
    protected final String TEXT_368 = "), ";
    protected final String TEXT_369 = ", ";
    protected final String TEXT_370 = ", ";
    protected final String TEXT_371 = ");";
    protected final String TEXT_372 = NL + "\t\tboolean ";
    protected final String TEXT_373 = " = ";
    protected final String TEXT_374 = ".unscaledValue().abs().toString().length() <= ";
    protected final String TEXT_375 = ";" + NL + "\t\tif (!";
    protected final String TEXT_376 = " && ";
    protected final String TEXT_377 = " != null) " + NL + "\t\t\treportTotalDigitsViolation(";
    protected final String TEXT_378 = ", ";
    protected final String TEXT_379 = ", ";
    protected final String TEXT_380 = ", ";
    protected final String TEXT_381 = ", ";
    protected final String TEXT_382 = ");";
    protected final String TEXT_383 = NL + "\t\tboolean ";
    protected final String TEXT_384 = " = ";
    protected final String TEXT_385 = ".compareTo(";
    protected final String TEXT_386 = "__LOWER_BOUND) > 0 && ";
    protected final String TEXT_387 = ".compareTo(";
    protected final String TEXT_388 = "__UPPER_BOUND) < 0;" + NL + "\t\tif (!";
    protected final String TEXT_389 = " && ";
    protected final String TEXT_390 = " != null) " + NL + "\t\t\treportTotalDigitsViolation(";
    protected final String TEXT_391 = ", ";
    protected final String TEXT_392 = ", ";
    protected final String TEXT_393 = ", ";
    protected final String TEXT_394 = ", ";
    protected final String TEXT_395 = ");";
    protected final String TEXT_396 = NL + "\t\treturn ";
    protected final String TEXT_397 = "; ";
    protected final String TEXT_398 = NL + "\t\tboolean ";
    protected final String TEXT_399 = " = ";
    protected final String TEXT_400 = ".scale() <= ";
    protected final String TEXT_401 = ";" + NL + "\t\tif (!";
    protected final String TEXT_402 = " && ";
    protected final String TEXT_403 = " != null) " + NL + "\t\t\treportFractionDigitsViolation(";
    protected final String TEXT_404 = ", ";
    protected final String TEXT_405 = ", ";
    protected final String TEXT_406 = ", ";
    protected final String TEXT_407 = ", ";
    protected final String TEXT_408 = ");" + NL + "\t\treturn ";
    protected final String TEXT_409 = "; ";
    protected final String TEXT_410 = NL + "\t\t// TODO override the constraint, if desired" + NL + "\t\t// -> uncomment the scaffolding" + NL + "\t\t// -> specify the condition that violates the constraint" + NL + "\t\t// -> verify the diagnostic details, including severity, code, and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
    protected final String TEXT_411 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
    protected final String TEXT_412 = ".add" + NL + "\t\t\t\t\t(new ";
    protected final String TEXT_413 = NL + "\t\t\t\t\t\t(";
    protected final String TEXT_414 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t ";
    protected final String TEXT_415 = ".INSTANCE.getString(\"_UI_GenericConstraint_diagnostic\", new Object[] { \"";
    protected final String TEXT_416 = "\", getValueLabel(";
    protected final String TEXT_417 = ", ";
    protected final String TEXT_418 = ", ";
    protected final String TEXT_419 = ") }),";
    protected final String TEXT_420 = NL + "\t\t\t\t\t\t new Object[] { ";
    protected final String TEXT_421 = " }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn ";
    protected final String TEXT_422 = "validate";
    protected final String TEXT_423 = "_";
    protected final String TEXT_424 = "(";
    protected final String TEXT_425 = ", ";
    protected final String TEXT_426 = ", ";
    protected final String TEXT_427 = ");";
    protected final String TEXT_428 = NL + "\t\t// TODO implement the constraint" + NL + "\t\t// -> specify the condition that violates the constraint" + NL + "\t\t// -> verify the diagnostic details, including severity, code, and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
    protected final String TEXT_429 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
    protected final String TEXT_430 = ".add" + NL + "\t\t\t\t\t(new ";
    protected final String TEXT_431 = NL + "\t\t\t\t\t\t(";
    protected final String TEXT_432 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t ";
    protected final String TEXT_433 = ".INSTANCE.getString(\"_UI_GenericConstraint_diagnostic\", new Object[] { \"";
    protected final String TEXT_434 = "\", getValueLabel(";
    protected final String TEXT_435 = ", ";
    protected final String TEXT_436 = ", ";
    protected final String TEXT_437 = ") }),";
    protected final String TEXT_438 = NL + "\t\t\t\t\t\t new Object[] { ";
    protected final String TEXT_439 = " }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
    protected final String TEXT_440 = NL + "\t\t// TODO override the constraint, if desired" + NL + "\t\t// -> uncomment the scaffolding" + NL + "\t\t// -> specify the condition that violates the constraint" + NL + "\t\t// -> verify the diagnostic details, including severity, code, and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
    protected final String TEXT_441 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
    protected final String TEXT_442 = ".add" + NL + "\t\t\t\t\t(new ";
    protected final String TEXT_443 = NL + "\t\t\t\t\t\t(";
    protected final String TEXT_444 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t ";
    protected final String TEXT_445 = ".INSTANCE.getString(\"_UI_GenericConstraint_diagnostic\", new Object[] { \"";
    protected final String TEXT_446 = "\", getObjectLabel(";
    protected final String TEXT_447 = ", ";
    protected final String TEXT_448 = ") }),";
    protected final String TEXT_449 = NL + "\t\t\t\t\t\t new Object[] { ";
    protected final String TEXT_450 = " }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn ";
    protected final String TEXT_451 = "validate";
    protected final String TEXT_452 = "_";
    protected final String TEXT_453 = "(";
    protected final String TEXT_454 = ", ";
    protected final String TEXT_455 = ", ";
    protected final String TEXT_456 = ");";
    protected final String TEXT_457 = NL + "\t\treturn ";
    protected final String TEXT_458 = ".";
    protected final String TEXT_459 = "(";
    protected final String TEXT_460 = ", ";
    protected final String TEXT_461 = ");";
    protected final String TEXT_462 = NL + "\t\t// TODO implement the constraint" + NL + "\t\t// -> specify the condition that violates the constraint" + NL + "\t\t// -> verify the diagnostic details, including severity, code, and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
    protected final String TEXT_463 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
    protected final String TEXT_464 = ".add" + NL + "\t\t\t\t\t(new ";
    protected final String TEXT_465 = NL + "\t\t\t\t\t\t(";
    protected final String TEXT_466 = ".ERROR," + NL + "\t\t\t\t\t\t DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t 0," + NL + "\t\t\t\t\t\t ";
    protected final String TEXT_467 = ".INSTANCE.getString(\"_UI_GenericConstraint_diagnostic\", new Object[] { \"";
    protected final String TEXT_468 = "\", getObjectLabel(";
    protected final String TEXT_469 = ", ";
    protected final String TEXT_470 = ") }),";
    protected final String TEXT_471 = NL + "\t\t\t\t\t\t new Object[] { ";
    protected final String TEXT_472 = " }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
    protected final String TEXT_473 = NL + "\t}" + NL;
    protected final String TEXT_474 = NL + "} //";
    protected final String TEXT_475 = NL;
    protected final String TEXT_476 = NL;
    protected final String TEXT_477 = NL;

    public ValidatorClass() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> parameterList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) parameterParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_476);
        stringBuffer.append(TEXT_477);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        method_preGenerate(ictx.getBuffer(), ictx);

        method_doGenerate(ictx.getBuffer(), ictx);
        {
            ictx.setExecutionCurrentIndex(ictx.getBuffer().length());
            ictx.getExecutionBuffer().append(ictx.getBuffer());
            final Map<String, Object> parameters = getParameters();
            CallbackContext ctx_callback = new CallbackContext(ictx);
            CallHelper.callBack(ctx_callback, parameters);
        }

        method_postGenerate(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("parameter", this.parameter);
        return parameters;
    }

    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenPackage genPackage = parameter;
        targetPath = genPackage.getGenModel().getModelDirectory();
        packageName = genPackage.getUtilitiesPackageName();
        className = genPackage.getValidatorClassName();

    }

    protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenPackage genPackage = parameter;
        argument = parameter;

    }

    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        /**
         * <copyright>
         *
         * Copyright (c) 2002-2006 IBM Corporation and others.
         * All rights reserved.   This program and the accompanying materials
         * are made available under the terms of the Eclipse Public License v1.0
         * which accompanies this distribution, and is available at
         * http://www.eclipse.org/legal/epl-v10.html
         *
         * Contributors:
         *   IBM - Initial API and implementation
         *
         * </copyright>
         */

        GenPackage genPackage = (GenPackage) argument;
        GenModel genModel = genPackage.getGenModel();
        final String singleWildcard = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50 ? "<?>" : "";
        stringBuffer.append(TEXT_1);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("argument", parameter);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(genPackage.getUtilitiesPackageName());
        stringBuffer.append(TEXT_3);
        genModel.addImport("java.util.Map");
        final String _Map = genModel.useGenerics() ? "Map<" + genModel.getImportedName("java.lang.Object") + ", " + genModel.getImportedName("java.lang.Object") + ">" : "Map";
        genModel.addImport("org.eclipse.emf.common.util.DiagnosticChain");
        genModel.addImport("org.eclipse.emf.ecore.EPackage");
        if (!genPackage.hasJavaLangConflict() && !genPackage.getUtilitiesPackageName().equals(genPackage.getInterfacePackageName()))
            genModel.addImport(genPackage.getInterfacePackageName() + ".*");
        genModel.markImportLocation(stringBuffer);
        genModel.addPseudoImport("org.eclipse.emf.ecore.EValidator.Descriptor");
        genModel.addPseudoImport("org.eclipse.emf.ecore.EValidator.Registry");
        genModel.addPseudoImport("org.eclipse.emf.ecore.EValidator.SubstitutionLabelProvider");
        genModel.addPseudoImport("org.eclipse.emf.ecore.EValidator.PatternMatcher");
        stringBuffer.append(TEXT_4);
        stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(genPackage.getValidatorClassName());
        stringBuffer.append(TEXT_6);
        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
        stringBuffer.append(TEXT_7);
        if (genModel.hasCopyrightField()) {
            stringBuffer.append(TEXT_8);
            stringBuffer.append(genModel.getImportedName("java.lang.String"));
            stringBuffer.append(TEXT_9);
            stringBuffer.append(genModel.getCopyrightFieldLiteral());
            stringBuffer.append(TEXT_10);
            stringBuffer.append(genModel.getNonNLS());
            stringBuffer.append(TEXT_11);
        }
        stringBuffer.append(TEXT_12);
        stringBuffer.append(genPackage.getValidatorClassName());
        stringBuffer.append(TEXT_13);
        stringBuffer.append(genPackage.getValidatorClassName());
        stringBuffer.append(TEXT_14);
        stringBuffer.append(genPackage.getInterfacePackageName());
        stringBuffer.append(TEXT_15);
        stringBuffer.append(genModel.getNonNLS());
        stringBuffer.append(TEXT_16);
        int count = 0;
        for (GenClass genClass : genPackage.getGenClasses()) {
            for (GenOperation genOperation : genClass.getInvariantOperations()) {
                stringBuffer.append(TEXT_17);
                stringBuffer.append(genOperation.getFormattedName());
                stringBuffer.append(TEXT_18);
                stringBuffer.append(genClass.getFormattedName());
                stringBuffer.append(TEXT_19);
                stringBuffer.append(genClass.getOperationID(genOperation));
                stringBuffer.append(TEXT_20);
                stringBuffer.append(++count);
                stringBuffer.append(TEXT_21);
            }
        }
        stringBuffer.append(TEXT_22);
        stringBuffer.append(count);
        stringBuffer.append(TEXT_23);
        for (GenPackage baseGenPackage : genPackage.getAllValidatorBaseGenPackages()) {
            stringBuffer.append(TEXT_24);
            stringBuffer.append(baseGenPackage.getImportedValidatorClassName());
            stringBuffer.append(TEXT_25);
            stringBuffer.append(genPackage.getValidatorPackageUniqueSafeName(baseGenPackage));
            stringBuffer.append(TEXT_26);
        }
        stringBuffer.append(TEXT_27);
        stringBuffer.append(genPackage.getValidatorClassName());
        stringBuffer.append(TEXT_28);
        for (GenPackage baseGenPackage : genPackage.getAllValidatorBaseGenPackages()) {
            stringBuffer.append(TEXT_29);
            stringBuffer.append(genPackage.getValidatorPackageUniqueSafeName(baseGenPackage));
            stringBuffer.append(TEXT_30);
            stringBuffer.append(baseGenPackage.getImportedValidatorClassName());
            stringBuffer.append(TEXT_31);
        }
        stringBuffer.append(TEXT_32);
        if (genModel.useClassOverrideAnnotation()) {
            stringBuffer.append(TEXT_33);
        }
        stringBuffer.append(TEXT_34);
        stringBuffer.append(genPackage.getImportedPackageInterfaceName());
        stringBuffer.append(TEXT_35);
        if (genModel.useClassOverrideAnnotation()) {
            stringBuffer.append(TEXT_36);
        }
        for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
            if (genClassifier.isUncheckedCast()) {
                stringBuffer.append(TEXT_37);
                break;
            }
        }
        stringBuffer.append(TEXT_38);
        stringBuffer.append(_Map);
        stringBuffer.append(TEXT_39);
        for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
            stringBuffer.append(TEXT_40);
            stringBuffer.append(genPackage.getImportedPackageInterfaceName());
            stringBuffer.append(TEXT_41);
            stringBuffer.append(genPackage.getClassifierID(genClassifier));
            stringBuffer.append(TEXT_42);
            if (genClassifier instanceof GenDataType) {
                GenDataType genDataType = (GenDataType) genClassifier;
                if (genDataType.isPrimitiveType()) {
                    stringBuffer.append(TEXT_43);
                    stringBuffer.append(genDataType.getName());
                    stringBuffer.append(TEXT_44);
                    stringBuffer.append(genDataType.getObjectInstanceClassName());
                    stringBuffer.append(TEXT_45);
                    stringBuffer.append(genDataType.getPrimitiveValueFunction());
                    stringBuffer.append(TEXT_46);
                } else if (genDataType.isObjectType()) {
                    stringBuffer.append(TEXT_47);
                    stringBuffer.append(genDataType.getName());
                    stringBuffer.append(TEXT_48);
                } else {
                    stringBuffer.append(TEXT_49);
                    stringBuffer.append(genDataType.getName());
                    stringBuffer.append(TEXT_50);
                    stringBuffer.append(genDataType.getImportedWildcardInstanceClassName());
                    stringBuffer.append(TEXT_51);
                }
            } else {
                GenClass genClass = (GenClass) genClassifier;
                stringBuffer.append(TEXT_52);
                stringBuffer.append(genClass.getName());
                stringBuffer.append(TEXT_53);
                stringBuffer.append(genClass.getImportedWildcardInstanceClassName());
                stringBuffer.append(TEXT_54);
            }
        }
        stringBuffer.append(TEXT_55);
        for (GenClassifier genClassifier : genPackage.getGenClassifiers()) {
            String result = "result".equals(genClassifier.getSafeUncapName()) ? "theResult" : "result";
            String diagnostics = "diagnostics".equals(genClassifier.getSafeUncapName()) ? "theDiagnostics" : "diagnostics";
            String item = "item".equals(genClassifier.getSafeUncapName()) ? "theItem" : "item";
            String context = "context".equals(genClassifier.getSafeUncapName()) ? "theContext" : "context";
            stringBuffer.append(TEXT_56);
            stringBuffer.append(genClassifier.getName());
            stringBuffer.append(TEXT_57);
            stringBuffer.append(genClassifier.getImportedWildcardInstanceClassName());
            stringBuffer.append(TEXT_58);
            stringBuffer.append(genClassifier.getSafeUncapName());
            stringBuffer.append(TEXT_59);
            stringBuffer.append(diagnostics);
            stringBuffer.append(TEXT_60);
            stringBuffer.append(_Map);
            stringBuffer.append(TEXT_61);
            stringBuffer.append(context);
            stringBuffer.append(TEXT_62);
            if (genClassifier.getAllGenConstraints().isEmpty()) {
                stringBuffer.append(TEXT_63);
            } else if (genClassifier.hasOnlyDefaultConstraints()) {
                stringBuffer.append(TEXT_64);
                if (!((GenClass) genClassifier).isEObjectExtension()) {
                    stringBuffer.append(TEXT_65);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EObject"));
                    stringBuffer.append(TEXT_66);
                }
                stringBuffer.append(genClassifier.getSafeUncapName());
                stringBuffer.append(TEXT_67);
                stringBuffer.append(diagnostics);
                stringBuffer.append(TEXT_68);
                stringBuffer.append(context);
                stringBuffer.append(TEXT_69);
            } else {
                boolean first = true;
                for (String constraint : genClassifier.getAllGenConstraints()) {
                    GenClassifier constraintImplementor = genClassifier.getConstraintImplementor(constraint);
                    String delegate = constraintImplementor == null || constraintImplementor.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(constraintImplementor.getGenPackage()) + "Validator.";
                    String cast = constraintImplementor == null && genClassifier instanceof GenClass && !((GenClass) genClassifier).isEObjectExtension() ? "(" + genModel.getImportedName("org.eclipse.emf.ecore.EObject") + ")" : "";
                    String accessor = constraintImplementor != null && genClassifier instanceof GenDataType && !((GenDataType) genClassifier).isPrimitiveType() && ((GenDataType) constraintImplementor).isPrimitiveType() ? "." + ((GenDataType) constraintImplementor).getPrimitiveValueFunction() + "()" : "";
                    if (first) {
                        first = false;
                        stringBuffer.append(TEXT_70);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_71);
                        stringBuffer.append(delegate);
                        stringBuffer.append(TEXT_72);
                        stringBuffer.append(constraintImplementor == null ? "" : constraintImplementor.getName());
                        stringBuffer.append(TEXT_73);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_74);
                        stringBuffer.append(cast);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(accessor);
                        stringBuffer.append(TEXT_75);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_76);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_77);
                    } else {
                        stringBuffer.append(TEXT_78);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_79);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_80);
                        stringBuffer.append(delegate);
                        stringBuffer.append(TEXT_81);
                        stringBuffer.append(constraintImplementor == null ? "" : constraintImplementor.getName());
                        stringBuffer.append(TEXT_82);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_83);
                        stringBuffer.append(cast);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(accessor);
                        stringBuffer.append(TEXT_84);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_85);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_86);
                    }
                }
                stringBuffer.append(TEXT_87);
                stringBuffer.append(result);
                stringBuffer.append(TEXT_88);
            }
            stringBuffer.append(TEXT_89);
            for (String constraint : genClassifier.getGenConstraints()) {
                GenClassifier constraintDelegate = genClassifier.getConstraintDelegate(constraint);
                String constant = genClassifier.getClassifierID() + "__" + CodeGenUtil.format(constraint, '_', null, false, false).toUpperCase();
                String delegate = constraintDelegate == null || constraintDelegate.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(constraintDelegate.getGenPackage()) + "Validator.";
                String cast = constraintDelegate == null && genClassifier instanceof GenClass && !((GenClass) genClassifier).isEObjectExtension() ? "(" + genModel.getImportedName("org.eclipse.emf.ecore.EObject") + ")" : "";
                String accessor = constraintDelegate != null && genClassifier instanceof GenDataType && !((GenDataType) genClassifier).isPrimitiveType() && ((GenDataType) constraintDelegate).isPrimitiveType() ? "." + ((GenDataType) constraintDelegate).getPrimitiveValueFunction() + "()" : "";
                if (genClassifier instanceof GenDataType) {
                    GenDataType genDataType = (GenDataType) genClassifier;
                    if (constraint.equals("Min") && genDataType.getMinLiteral() != null) {
                        stringBuffer.append(TEXT_90);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_91);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_92);
                        stringBuffer.append(genDataType.getImportedInstanceClassName());
                        stringBuffer.append(TEXT_93);
                        stringBuffer.append(constant);
                        stringBuffer.append(TEXT_94);
                        stringBuffer.append(genDataType.getStaticValue(genDataType.getMinLiteral()));
                        stringBuffer.append(TEXT_95);
                    } else if (constraint.equals("Max") && genDataType.getMaxLiteral() != null) {
                        stringBuffer.append(TEXT_96);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_97);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_98);
                        stringBuffer.append(genDataType.getImportedInstanceClassName());
                        stringBuffer.append(TEXT_99);
                        stringBuffer.append(constant);
                        stringBuffer.append(TEXT_100);
                        stringBuffer.append(genDataType.getStaticValue(genDataType.getMaxLiteral()));
                        stringBuffer.append(TEXT_101);
                    } else if (constraint.equals("TotalDigits") && genDataType.getTotalDigits() != -1 && !"java.math.BigDecimal".equals(genDataType.getQualifiedInstanceClassName())) {
                        String value = "1";
                        for (int digitCount = genDataType.getTotalDigits(); digitCount > 0; --digitCount)
                            value += "0";
                        stringBuffer.append(TEXT_102);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_103);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_104);
                        stringBuffer.append(genDataType.getImportedInstanceClassName());
                        stringBuffer.append(TEXT_105);
                        stringBuffer.append(constant);
                        stringBuffer.append(TEXT_106);
                        stringBuffer.append(genDataType.getStaticValue(value));
                        stringBuffer.append(TEXT_107);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_108);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_109);
                        stringBuffer.append(genDataType.getImportedInstanceClassName());
                        stringBuffer.append(TEXT_110);
                        stringBuffer.append(constant);
                        stringBuffer.append(TEXT_111);
                        stringBuffer.append(genDataType.getStaticValue("-" + value));
                        stringBuffer.append(TEXT_112);
                    } else if (constraint.equals("Pattern") && !genDataType.getPatterns().isEmpty()) {
                        stringBuffer.append(TEXT_113);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_114);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_115);
                        stringBuffer.append(constant);
                        stringBuffer.append(TEXT_116);
                        for (Iterator<List<String>> k = genDataType.getPatterns().iterator(); k.hasNext();) {
                            List<String> patternList = k.next();
                            stringBuffer.append(TEXT_117);
                            for (Iterator<String> p = patternList.iterator(); p.hasNext();) {
                                String pattern = p.next();
                                stringBuffer.append(TEXT_118);
                                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
                                stringBuffer.append(TEXT_119);
                                stringBuffer.append(pattern);
                                stringBuffer.append(TEXT_120);
                                stringBuffer.append(p.hasNext() ? "," : "");
                            }
                            stringBuffer.append(TEXT_121);
                            stringBuffer.append(k.hasNext() ? "," : "");
                        }
                        stringBuffer.append(TEXT_122);
                    } else if (constraint.equals("Enumeration") && !genDataType.getEnumerationLiterals().isEmpty()) {
                        stringBuffer.append(TEXT_123);
                        stringBuffer.append(genDataType.getName());
                        stringBuffer.append(TEXT_124);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_125);
                        stringBuffer.append(genModel.getImportedName("java.util.Collection"));
                        stringBuffer.append(TEXT_126);
                        stringBuffer.append(constant);
                        stringBuffer.append(TEXT_127);
                        for (Iterator<String> k = genDataType.getEnumerationLiterals().iterator(); k.hasNext();) {
                            String literal = k.next();
                            stringBuffer.append(TEXT_128);
                            if (genDataType.isPrimitiveType()) {
                                stringBuffer.append(TEXT_129);
                                stringBuffer.append(genDataType.getObjectInstanceClassName());
                                stringBuffer.append(TEXT_130);
                            }
                            stringBuffer.append(genDataType.getStaticValue(literal));
                            if (genDataType.isPrimitiveType()) {
                                stringBuffer.append(TEXT_131);
                            }
                            stringBuffer.append(k.hasNext() ? "," : "");
                        }
                        stringBuffer.append(TEXT_132);
                    }
                }
                stringBuffer.append(TEXT_133);
                stringBuffer.append(constraint);
                stringBuffer.append(TEXT_134);
                stringBuffer.append(genClassifier.getFormattedName());
                stringBuffer.append(TEXT_135);
                stringBuffer.append(genClassifier.getName());
                stringBuffer.append(TEXT_136);
                stringBuffer.append(constraint);
                stringBuffer.append(TEXT_137);
                stringBuffer.append(genClassifier.getImportedWildcardInstanceClassName());
                stringBuffer.append(TEXT_138);
                stringBuffer.append(genClassifier.getSafeUncapName());
                stringBuffer.append(TEXT_139);
                stringBuffer.append(diagnostics);
                stringBuffer.append(TEXT_140);
                stringBuffer.append(_Map);
                stringBuffer.append(TEXT_141);
                stringBuffer.append(context);
                stringBuffer.append(TEXT_142);
                if (genClassifier instanceof GenDataType) {
                    GenDataType genDataType = (GenDataType) genClassifier;
                    if (constraint.equals("ItemType") && genDataType.getItemType() != null) {
                        GenDataType itemType = genDataType.getItemType();
                        String itemDelegate = itemType.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(itemType.getGenPackage()) + "Validator.";
                        stringBuffer.append(TEXT_143);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_144);
                        stringBuffer.append(genModel.getImportedName("java.util.Iterator"));
                        stringBuffer.append(singleWildcard);
                        stringBuffer.append(TEXT_145);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(TEXT_146);
                        if (itemType.getGenPackage().hasConstraints()) {
                            stringBuffer.append(TEXT_147);
                            stringBuffer.append(itemType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_148);
                            stringBuffer.append(itemDelegate);
                            stringBuffer.append(TEXT_149);
                            stringBuffer.append(itemType.getName());
                            stringBuffer.append(TEXT_150);
                            if (itemType.isPrimitiveType()) {
                                stringBuffer.append(TEXT_151);
                            }
                            if (!itemType.isObjectType()) {
                                stringBuffer.append(TEXT_152);
                                stringBuffer.append(itemType.getObjectInstanceClassName());
                                stringBuffer.append(TEXT_153);
                            }
                            stringBuffer.append(item);
                            if (itemType.isPrimitiveType()) {
                                stringBuffer.append(TEXT_154);
                                stringBuffer.append(itemType.getPrimitiveValueFunction());
                                stringBuffer.append(TEXT_155);
                            }
                            stringBuffer.append(TEXT_156);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_157);
                            stringBuffer.append(context);
                            stringBuffer.append(TEXT_158);
                        } else {
                            stringBuffer.append(TEXT_159);
                            stringBuffer.append(itemType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_160);
                        }
                        stringBuffer.append(TEXT_161);
                        stringBuffer.append(itemType.getQualifiedClassifierAccessor());
                        stringBuffer.append(TEXT_162);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_163);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_164);
                    } else if (constraint.equals("MemberTypes") && !genDataType.getMemberTypes().isEmpty()) {
                        stringBuffer.append(TEXT_165);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
                        stringBuffer.append(TEXT_166);
                        for (ListIterator<GenDataType> k = genDataType.getMemberTypes().listIterator(); k.hasNext();) {
                            GenDataType memberType = k.next();
                            String memberDelegate = memberType.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(memberType.getGenPackage()) + "Validator.";
                            if (genDataType.isPrimitiveType()) {
                                stringBuffer.append(TEXT_167);
                                stringBuffer.append(memberDelegate);
                                stringBuffer.append(TEXT_168);
                                stringBuffer.append(memberType.getName());
                                stringBuffer.append(TEXT_169);
                                stringBuffer.append(genClassifier.getSafeUncapName());
                                stringBuffer.append(TEXT_170);
                                stringBuffer.append(context);
                                stringBuffer.append(TEXT_171);
                            } else {
                                stringBuffer.append(TEXT_172);
                                stringBuffer.append(memberType.getQualifiedClassifierAccessor());
                                stringBuffer.append(TEXT_173);
                                stringBuffer.append(genClassifier.getSafeUncapName());
                                stringBuffer.append(TEXT_174);
                                if (memberType.getGenPackage().hasConstraints()) {
                                    stringBuffer.append(TEXT_175);
                                    stringBuffer.append(memberDelegate);
                                    stringBuffer.append(TEXT_176);
                                    stringBuffer.append(memberType.getName());
                                    stringBuffer.append(TEXT_177);
                                    if (memberType.isPrimitiveType()) {
                                        stringBuffer.append(TEXT_178);
                                    }
                                    if (!memberType.isObjectType() && !memberType.getQualifiedInstanceClassName().equals(genDataType.getQualifiedInstanceClassName())) {
                                        stringBuffer.append(TEXT_179);
                                        stringBuffer.append(memberType.getImportedWildcardObjectInstanceClassName());
                                        stringBuffer.append(TEXT_180);
                                    }
                                    stringBuffer.append(genClassifier.getSafeUncapName());
                                    if (memberType.isPrimitiveType()) {
                                        stringBuffer.append(TEXT_181);
                                        stringBuffer.append(memberType.getPrimitiveValueFunction());
                                        stringBuffer.append(TEXT_182);
                                    }
                                    stringBuffer.append(TEXT_183);
                                    stringBuffer.append(context);
                                    stringBuffer.append(TEXT_184);
                                }
                                stringBuffer.append(TEXT_185);
                            }
                        }
                        if (genModel.useGenerics()) {
                            stringBuffer.append(TEXT_186);
                            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
                            stringBuffer.append(TEXT_187);
                        } else {
                            stringBuffer.append(TEXT_188);
                            stringBuffer.append(genModel.getImportedName("java.util.List"));
                            stringBuffer.append(TEXT_189);
                            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
                            stringBuffer.append(TEXT_190);
                        }
                        stringBuffer.append(TEXT_191);
                        for (ListIterator<GenDataType> k = genDataType.getMemberTypes().listIterator(); k.hasNext();) {
                            GenDataType memberType = k.next();
                            String memberDelegate = memberType.getGenPackage() == genPackage ? "" : genPackage.getValidatorPackageUniqueSafeName(memberType.getGenPackage()) + "Validator.";
                            if (genDataType.isPrimitiveType()) {
                                stringBuffer.append(TEXT_192);
                                stringBuffer.append(memberDelegate);
                                stringBuffer.append(TEXT_193);
                                stringBuffer.append(memberType.getName());
                                stringBuffer.append(TEXT_194);
                                stringBuffer.append(genClassifier.getSafeUncapName());
                                stringBuffer.append(TEXT_195);
                                stringBuffer.append(context);
                                stringBuffer.append(TEXT_196);
                            } else {
                                stringBuffer.append(TEXT_197);
                                stringBuffer.append(memberType.getQualifiedClassifierAccessor());
                                stringBuffer.append(TEXT_198);
                                stringBuffer.append(genClassifier.getSafeUncapName());
                                stringBuffer.append(TEXT_199);
                                if (memberType.getGenPackage().hasConstraints()) {
                                    stringBuffer.append(TEXT_200);
                                    stringBuffer.append(memberDelegate);
                                    stringBuffer.append(TEXT_201);
                                    stringBuffer.append(memberType.getName());
                                    stringBuffer.append(TEXT_202);
                                    if (memberType.isPrimitiveType()) {
                                        stringBuffer.append(TEXT_203);
                                    }
                                    if (!memberType.isObjectType() && !memberType.getQualifiedInstanceClassName().equals(genDataType.getQualifiedInstanceClassName())) {
                                        stringBuffer.append(TEXT_204);
                                        stringBuffer.append(memberType.getImportedWildcardObjectInstanceClassName());
                                        stringBuffer.append(TEXT_205);
                                    }
                                    stringBuffer.append(genClassifier.getSafeUncapName());
                                    if (memberType.isPrimitiveType()) {
                                        stringBuffer.append(TEXT_206);
                                        stringBuffer.append(memberType.getPrimitiveValueFunction());
                                        stringBuffer.append(TEXT_207);
                                    }
                                    stringBuffer.append(TEXT_208);
                                    stringBuffer.append(context);
                                    stringBuffer.append(TEXT_209);
                                }
                                stringBuffer.append(TEXT_210);
                            }
                        }
                        stringBuffer.append(TEXT_211);
                    } else if (constraint.equals("Pattern") && !genDataType.getPatterns().isEmpty()) {
                        stringBuffer.append(TEXT_212);
                        stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                        stringBuffer.append(TEXT_213);
                        if (genDataType.isPrimitiveType()) {
                            stringBuffer.append(TEXT_214);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_215);
                        }
                        stringBuffer.append(genDataType.getSafeUncapName());
                        if (genDataType.isPrimitiveType()) {
                            stringBuffer.append(TEXT_216);
                        }
                        stringBuffer.append(TEXT_217);
                        stringBuffer.append(constant);
                        stringBuffer.append(TEXT_218);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_219);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_220);
                    } else if (constraint.equals("Enumeration") && !genDataType.getEnumerationLiterals().isEmpty()) {
                        String variable = genDataType.getSafeUncapName();
                        if (genDataType.isPrimitiveType()) {
                            variable = variable + "Object";
                            stringBuffer.append(TEXT_221);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_222);
                            stringBuffer.append(variable);
                            stringBuffer.append(TEXT_223);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_224);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_225);
                        }
                        stringBuffer.append(TEXT_226);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_227);
                        stringBuffer.append(constant);
                        stringBuffer.append(TEXT_228);
                        stringBuffer.append(variable);
                        stringBuffer.append(TEXT_229);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_230);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_231);
                        stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                        stringBuffer.append(TEXT_232);
                        stringBuffer.append(variable);
                        stringBuffer.append(TEXT_233);
                        stringBuffer.append(constant);
                        stringBuffer.append(TEXT_234);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_235);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_236);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_237);
                    } else if (constraint.equals("Min") && genDataType.getMinLiteral() != null) {
                        if (genDataType.isPrimitiveType()) {
                            stringBuffer.append(TEXT_238);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_239);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_240);
                            stringBuffer.append(genDataType.isMinInclusive() ? ">=" : ">");
                            stringBuffer.append(TEXT_241);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_242);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_243);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_244);
                            stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_245);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_246);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_247);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_248);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_249);
                            stringBuffer.append(genDataType.isMinInclusive() ? "true" : "false");
                            stringBuffer.append(TEXT_250);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_251);
                            stringBuffer.append(context);
                            stringBuffer.append(TEXT_252);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_253);
                        } else {
                            String comparison = "comparison".equals(genClassifier.getSafeUncapName()) ? "theComparison" : "comparison";
                            if (genDataType.isXMLCalendar()) {
                                stringBuffer.append(TEXT_254);
                                stringBuffer.append(comparison);
                                stringBuffer.append(TEXT_255);
                                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
                                stringBuffer.append(TEXT_256);
                                stringBuffer.append(genDataType.getSafeUncapName());
                                stringBuffer.append(TEXT_257);
                                stringBuffer.append(constant);
                                stringBuffer.append(TEXT_258);
                                stringBuffer.append(result);
                                stringBuffer.append(TEXT_259);
                                if (genDataType.isMinInclusive()) {
                                    stringBuffer.append(comparison);
                                    stringBuffer.append(TEXT_260);
                                }
                                stringBuffer.append(comparison);
                                stringBuffer.append(TEXT_261);
                            } else if (genDataType.isXMLDuration()) {
                                stringBuffer.append(TEXT_262);
                                stringBuffer.append(comparison);
                                stringBuffer.append(TEXT_263);
                                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
                                stringBuffer.append(TEXT_264);
                                stringBuffer.append(genDataType.getSafeUncapName());
                                stringBuffer.append(TEXT_265);
                                stringBuffer.append(constant);
                                stringBuffer.append(TEXT_266);
                                stringBuffer.append(result);
                                stringBuffer.append(TEXT_267);
                                if (genDataType.isMinInclusive()) {
                                    stringBuffer.append(comparison);
                                    stringBuffer.append(TEXT_268);
                                }
                                stringBuffer.append(comparison);
                                stringBuffer.append(TEXT_269);
                            } else {
                                stringBuffer.append(TEXT_270);
                                stringBuffer.append(result);
                                stringBuffer.append(TEXT_271);
                                stringBuffer.append(genDataType.getSafeUncapName());
                                stringBuffer.append(TEXT_272);
                                stringBuffer.append(constant);
                                stringBuffer.append(TEXT_273);
                                stringBuffer.append(genDataType.isMinInclusive() ? ">=" : ">");
                                stringBuffer.append(TEXT_274);
                            }
                            stringBuffer.append(TEXT_275);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_276);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_277);
                            stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_278);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_279);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_280);
                            stringBuffer.append(genDataType.isMinInclusive() ? "true" : "false");
                            stringBuffer.append(TEXT_281);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_282);
                            stringBuffer.append(context);
                            stringBuffer.append(TEXT_283);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_284);
                        }
                    } else if (constraint.equals("Max") && genDataType.getMaxLiteral() != null) {
                        if (genDataType.isPrimitiveType()) {
                            stringBuffer.append(TEXT_285);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_286);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_287);
                            stringBuffer.append(genDataType.isMaxInclusive() ? "<=" : "<");
                            stringBuffer.append(TEXT_288);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_289);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_290);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_291);
                            stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_292);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_293);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_294);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_295);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_296);
                            stringBuffer.append(genDataType.isMaxInclusive() ? "true" : "false");
                            stringBuffer.append(TEXT_297);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_298);
                            stringBuffer.append(context);
                            stringBuffer.append(TEXT_299);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_300);
                        } else {
                            String comparison = "comparison".equals(genClassifier.getSafeUncapName()) ? "theComparison" : "comparison";
                            if (genDataType.isXMLCalendar()) {
                                stringBuffer.append(TEXT_301);
                                stringBuffer.append(comparison);
                                stringBuffer.append(TEXT_302);
                                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
                                stringBuffer.append(TEXT_303);
                                stringBuffer.append(genDataType.getSafeUncapName());
                                stringBuffer.append(TEXT_304);
                                stringBuffer.append(constant);
                                stringBuffer.append(TEXT_305);
                                stringBuffer.append(result);
                                stringBuffer.append(TEXT_306);
                                if (genDataType.isMaxInclusive()) {
                                    stringBuffer.append(comparison);
                                    stringBuffer.append(TEXT_307);
                                }
                                stringBuffer.append(comparison);
                                stringBuffer.append(TEXT_308);
                            } else if (genDataType.isXMLDuration()) {
                                stringBuffer.append(TEXT_309);
                                stringBuffer.append(comparison);
                                stringBuffer.append(TEXT_310);
                                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil"));
                                stringBuffer.append(TEXT_311);
                                stringBuffer.append(genDataType.getSafeUncapName());
                                stringBuffer.append(TEXT_312);
                                stringBuffer.append(constant);
                                stringBuffer.append(TEXT_313);
                                stringBuffer.append(result);
                                stringBuffer.append(TEXT_314);
                                if (genDataType.isMaxInclusive()) {
                                    stringBuffer.append(comparison);
                                    stringBuffer.append(TEXT_315);
                                }
                                stringBuffer.append(comparison);
                                stringBuffer.append(TEXT_316);
                            } else {
                                stringBuffer.append(TEXT_317);
                                stringBuffer.append(result);
                                stringBuffer.append(TEXT_318);
                                stringBuffer.append(genDataType.getSafeUncapName());
                                stringBuffer.append(TEXT_319);
                                stringBuffer.append(constant);
                                stringBuffer.append(TEXT_320);
                                stringBuffer.append(genDataType.isMaxInclusive() ? "<=" : "<");
                                stringBuffer.append(TEXT_321);
                            }
                            stringBuffer.append(TEXT_322);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_323);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_324);
                            stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_325);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_326);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_327);
                            stringBuffer.append(genDataType.isMaxInclusive() ? "true" : "false");
                            stringBuffer.append(TEXT_328);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_329);
                            stringBuffer.append(context);
                            stringBuffer.append(TEXT_330);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_331);
                        }
                    } else if (constraint.equals("MinLength") && genDataType.getMinLength() != -1) {
                        stringBuffer.append(TEXT_332);
                        stringBuffer.append(genDataType.getSafeUncapName());
                        stringBuffer.append(TEXT_333);
                        stringBuffer.append(genDataType.getLengthAccessorFunction());
                        stringBuffer.append(TEXT_334);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_335);
                        stringBuffer.append(genDataType.getMinLength());
                        stringBuffer.append(TEXT_336);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_337);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_338);
                        stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                        stringBuffer.append(TEXT_339);
                        stringBuffer.append(genDataType.getSafeUncapName());
                        stringBuffer.append(TEXT_340);
                        stringBuffer.append(genDataType.getMinLength());
                        stringBuffer.append(TEXT_341);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_342);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_343);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_344);
                    } else if (constraint.equals("MaxLength") && genDataType.getMaxLength() != -1) {
                        stringBuffer.append(TEXT_345);
                        stringBuffer.append(genDataType.getSafeUncapName());
                        stringBuffer.append(TEXT_346);
                        stringBuffer.append(genDataType.getLengthAccessorFunction());
                        stringBuffer.append(TEXT_347);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_348);
                        stringBuffer.append(genDataType.getMaxLength());
                        stringBuffer.append(TEXT_349);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_350);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_351);
                        stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                        stringBuffer.append(TEXT_352);
                        stringBuffer.append(genDataType.getSafeUncapName());
                        stringBuffer.append(TEXT_353);
                        stringBuffer.append(genDataType.getMaxLength());
                        stringBuffer.append(TEXT_354);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_355);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_356);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_357);
                    } else if (constraint.equals("TotalDigits") && genDataType.getTotalDigits() != -1) {
                        if (genDataType.isPrimitiveType()) {
                            stringBuffer.append(TEXT_358);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_359);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_360);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_361);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_362);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_363);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_364);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_365);
                            stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_366);
                            stringBuffer.append(genDataType.getObjectInstanceClassName());
                            stringBuffer.append(TEXT_367);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_368);
                            stringBuffer.append(genDataType.getTotalDigits());
                            stringBuffer.append(TEXT_369);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_370);
                            stringBuffer.append(context);
                            stringBuffer.append(TEXT_371);
                        } else if ("java.math.BigDecimal".equals(genDataType.getQualifiedInstanceClassName())) {
                            stringBuffer.append(TEXT_372);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_373);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_374);
                            stringBuffer.append(genDataType.getTotalDigits());
                            stringBuffer.append(TEXT_375);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_376);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_377);
                            stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_378);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_379);
                            stringBuffer.append(genDataType.getTotalDigits());
                            stringBuffer.append(TEXT_380);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_381);
                            stringBuffer.append(context);
                            stringBuffer.append(TEXT_382);
                        } else {
                            stringBuffer.append(TEXT_383);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_384);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_385);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_386);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_387);
                            stringBuffer.append(constant);
                            stringBuffer.append(TEXT_388);
                            stringBuffer.append(result);
                            stringBuffer.append(TEXT_389);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_390);
                            stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                            stringBuffer.append(TEXT_391);
                            stringBuffer.append(genDataType.getSafeUncapName());
                            stringBuffer.append(TEXT_392);
                            stringBuffer.append(genDataType.getTotalDigits());
                            stringBuffer.append(TEXT_393);
                            stringBuffer.append(diagnostics);
                            stringBuffer.append(TEXT_394);
                            stringBuffer.append(context);
                            stringBuffer.append(TEXT_395);
                        }
                        stringBuffer.append(TEXT_396);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_397);
                    } else if (constraint.equals("FractionDigits") && genDataType.getFractionDigits() != -1 && "java.math.BigDecimal".equals(genDataType.getQualifiedInstanceClassName())) {
                        stringBuffer.append(TEXT_398);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_399);
                        stringBuffer.append(genDataType.getSafeUncapName());
                        stringBuffer.append(TEXT_400);
                        stringBuffer.append(genDataType.getFractionDigits());
                        stringBuffer.append(TEXT_401);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_402);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_403);
                        stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                        stringBuffer.append(TEXT_404);
                        stringBuffer.append(genDataType.getSafeUncapName());
                        stringBuffer.append(TEXT_405);
                        stringBuffer.append(genDataType.getFractionDigits());
                        stringBuffer.append(TEXT_406);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_407);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_408);
                        stringBuffer.append(result);
                        stringBuffer.append(TEXT_409);
                    } else if (constraintDelegate != null) {
                        stringBuffer.append(TEXT_410);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_411);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_412);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
                        stringBuffer.append(TEXT_413);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
                        stringBuffer.append(TEXT_414);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
                        stringBuffer.append(TEXT_415);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_416);
                        stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                        stringBuffer.append(TEXT_417);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(TEXT_418);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_419);
                        stringBuffer.append(genModel.getNonNLS());
                        stringBuffer.append(genModel.getNonNLS(2));
                        stringBuffer.append(TEXT_420);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(TEXT_421);
                        stringBuffer.append(delegate);
                        stringBuffer.append(TEXT_422);
                        stringBuffer.append(constraintDelegate.getName());
                        stringBuffer.append(TEXT_423);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_424);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(accessor);
                        stringBuffer.append(TEXT_425);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_426);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_427);
                    } else {
                        stringBuffer.append(TEXT_428);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_429);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_430);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
                        stringBuffer.append(TEXT_431);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
                        stringBuffer.append(TEXT_432);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
                        stringBuffer.append(TEXT_433);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_434);
                        stringBuffer.append(genDataType.getQualifiedClassifierAccessor());
                        stringBuffer.append(TEXT_435);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(TEXT_436);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_437);
                        stringBuffer.append(genModel.getNonNLS());
                        stringBuffer.append(genModel.getNonNLS(2));
                        stringBuffer.append(TEXT_438);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(TEXT_439);
                    }
                } else if (constraintDelegate != null) {
                    stringBuffer.append(TEXT_440);
                    stringBuffer.append(diagnostics);
                    stringBuffer.append(TEXT_441);
                    stringBuffer.append(diagnostics);
                    stringBuffer.append(TEXT_442);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
                    stringBuffer.append(TEXT_443);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
                    stringBuffer.append(TEXT_444);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
                    stringBuffer.append(TEXT_445);
                    stringBuffer.append(constraint);
                    stringBuffer.append(TEXT_446);
                    stringBuffer.append(genClassifier.getSafeUncapName());
                    stringBuffer.append(TEXT_447);
                    stringBuffer.append(context);
                    stringBuffer.append(TEXT_448);
                    stringBuffer.append(genModel.getNonNLS());
                    stringBuffer.append(genModel.getNonNLS(2));
                    stringBuffer.append(TEXT_449);
                    stringBuffer.append(genClassifier.getSafeUncapName());
                    stringBuffer.append(TEXT_450);
                    stringBuffer.append(delegate);
                    stringBuffer.append(TEXT_451);
                    stringBuffer.append(constraintDelegate.getName());
                    stringBuffer.append(TEXT_452);
                    stringBuffer.append(constraint);
                    stringBuffer.append(TEXT_453);
                    stringBuffer.append(cast);
                    stringBuffer.append(genClassifier.getSafeUncapName());
                    stringBuffer.append(TEXT_454);
                    stringBuffer.append(diagnostics);
                    stringBuffer.append(TEXT_455);
                    stringBuffer.append(context);
                    stringBuffer.append(TEXT_456);
                } else {
                    GenOperation genOperation = ((GenClass) genClassifier).getInvariantOperation(constraint);
                    if (genOperation != null) {
                        stringBuffer.append(TEXT_457);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(TEXT_458);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_459);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_460);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_461);
                    } else {
                        stringBuffer.append(TEXT_462);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_463);
                        stringBuffer.append(diagnostics);
                        stringBuffer.append(TEXT_464);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
                        stringBuffer.append(TEXT_465);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
                        stringBuffer.append(TEXT_466);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
                        stringBuffer.append(TEXT_467);
                        stringBuffer.append(constraint);
                        stringBuffer.append(TEXT_468);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(TEXT_469);
                        stringBuffer.append(context);
                        stringBuffer.append(TEXT_470);
                        stringBuffer.append(genModel.getNonNLS());
                        stringBuffer.append(genModel.getNonNLS(2));
                        stringBuffer.append(TEXT_471);
                        stringBuffer.append(genClassifier.getSafeUncapName());
                        stringBuffer.append(TEXT_472);
                    }
                }
                stringBuffer.append(TEXT_473);
            }
        }
        stringBuffer.append(TEXT_474);
        stringBuffer.append(genPackage.getValidatorClassName());
        genModel.emitSortedImports();
        stringBuffer.append(TEXT_475);
    }

    public boolean preCondition() throws Exception {
        GenPackage genPackage = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
        canGenerate = canGenerate && (genPackage.hasClassifiers() && genPackage.hasConstraints());
        return canGenerate;
    }
}