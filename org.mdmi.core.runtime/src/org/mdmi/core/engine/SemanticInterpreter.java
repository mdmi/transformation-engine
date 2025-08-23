/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementRelationship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.Result;
import com.google.javascript.jscomp.SourceFile;
import com.google.javascript.rhino.StaticSourceFile.SourceKind;

/**
 * @author seanmuir
 *
 */
public class SemanticInterpreter {

	private static Logger logger = LoggerFactory.getLogger(SemanticInterpreter.class);

	ScriptEngineManager manager;

	ScriptEngine engine;

	Invocable inv;

	public HashMap<String, Exception> exceptions = new HashMap<>();

	public static String getFunctionName(SemanticElement from, SemanticElement to) {
		return from.getName() + "_to_" + to.getName() + "RollUp";
	}

	/**
	 *
	 */
	public SemanticInterpreter(MessageGroup messgaeGroup) {
		super();
		// date.js
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("JavaScript");

		boolean createdNullFlavor = false;

		StringBuffer sb = new StringBuffer();

		sb.append("try {\n load(\"nashorn:mozilla_compat.js\");\n} \ncatch (e) \n{ \n}\n");

		sb.append("importPackage(org.mdmi.core.engine.javascript);\n");

		for (MessageModel messageModel : messgaeGroup.getModels()) {

			for (SemanticElement semanticElement : messageModel.getElementSet().getSemanticElements()) {

				if (semanticElement.isComputed() && !semanticElement.isNullFlavor()) {

					String rule = semanticElement.getComputedValue().getExpression();

					if (rule.equals("SEMANTICROLLUP")) {

						for (SemanticElementRelationship relationship : semanticElement.getRelationships()) {
							String rollupRule = relationship.getRule();
							/*
							 * Make sure it is not a function
							 * and is a rollup
							 * relationship.getRelatedSemanticElement().getName() + "_to_" +
							 * semanticElement.getName()
							 */
							if (!StringUtils.isEmpty(rollupRule) &&
									(!rollupRule.startsWith("SEMANTICROLLUPFUNCTION:") &&
											rollupRule.contains("value.getXValue()"))) {

								StringBuffer function = new StringBuffer();
								function.append(
									"function " +
											getFunctionName(relationship.getRelatedSemanticElement(), semanticElement) +
											"(value,param1) {");

								function.append(rollupRule.replace("'<<LOCALSEMANTICVALUE>>>'", "param1"));
								function.append("}");
								sb.append(function.toString());
							}
						}
					} else if (rule.startsWith("UPDATEVALUE:")) {

						StringBuffer function = new StringBuffer();

						function.append("function " + semanticElement.getName() + "_UPDATEVALUE" + "(value) {");

						function.append(rule.replace("UPDATEVALUE:", ""));
						function.append("}");
						sb.append(function.toString());
					} else {

						StringBuffer function = new StringBuffer();

						function.append("function " + semanticElement.getName() + "_COMPUTED" + "(value) {");

						function.append(rule);
						function.append("}");
						sb.append(function.toString());
					}

				} else if (semanticElement.isNullFlavor()) {
					String computedInExpression = semanticElement.getComputedValue().getExpression();
					if (!StringUtils.isEmpty(computedInExpression)) {
						StringBuffer function = new StringBuffer();
						function.append("function " + "setNullFlavorFor" + semanticElement.getName() + "(value) {");
						function.append(computedInExpression);
						function.append("}");
						sb.append(function.toString());
					}

				} else if (semanticElement.isComputedIn()) {

					String computedInExpression = semanticElement.getComputedInValue().getExpression();

					if (!StringUtils.isEmpty(computedInExpression)) {
						StringBuffer function = new StringBuffer();

						function.append("function " + semanticElement.getName() + "_COMPUTEDIN" + "(value) {");

						function.append(computedInExpression);
						function.append("}");
						sb.append(function.toString());
					}

				} else if (semanticElement.isComputedOut()) {

					String computedOutExpression = semanticElement.getComputedOutValue().getExpression();

					if (!StringUtils.isEmpty(computedOutExpression)) {
						StringBuffer function = new StringBuffer();

						function.append("function " + semanticElement.getName() + "_COMPUTEDOUT" + "(value) {");

						function.append(computedOutExpression);
						function.append("}");
						sb.append(function.toString());
					}

				}
			}
		}

		try {
			if (logger.isTraceEnabled()) {
				logger.trace(sb.toString());
				try {
					Files.write(
						Paths.get("./logs/" + messgaeGroup.getName() + "semanticRollups.js"), sb.toString().getBytes());
				} catch (IOException e) {
					// Ignore issue
				}

			}

			engine.eval(compile(sb.toString()));
		} catch (ScriptException e) {
			logger.error(e.getLocalizedMessage());
		}

		inv = (Invocable) engine;
	}

	void trace(String context, Object object) {
		logger.trace(context);
		if (object instanceof XDataStruct) {
			XDataStruct struct = (XDataStruct) object;

			logger.trace(struct.getDatatype().getName());
			for (String field : struct.getFields()) {
				logger.trace(field + " " + struct.getValue(field));
			}
		} else {

			logger.trace(object.toString());
		}

	}

	/**
	 * @param code
	 *            JavaScript source code to compile.
	 * @return The compiled version of the code.
	 */
	private static String compile(String code) {
		Compiler compiler = new Compiler();

		CompilerOptions options = new CompilerOptions();
		// Advanced mode is used here, but additional options could be set, too.
		CompilationLevel.ADVANCED_OPTIMIZATIONS.setOptionsForCompilationLevel(options);

		SourceFile sf;
		// try {
		sf = SourceFile.fromCode("mappings.js", code, SourceKind.STRONG);
		// sf = SourceFile.fromInputStream(
		// "mappings.js", new ByteArrayInputStream(code.getBytes()), StandardCharsets.UTF_8);
		ArrayList<SourceFile> inputFiles = new ArrayList<>();
		inputFiles.add(sf);

		Result result = compiler.compile(new ArrayList<SourceFile>(), inputFiles, options);

		if (!result.success) {
			// throw new ProcessException("Failure when processing javascript files!");
		}

		return compiler.toSource();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		//
		// }
		//
		// return code;
	}

	void compare(String function, Object source, Object target) {

		if (source instanceof XDataStruct) {
			if (target instanceof XDataStruct) {

				/**
				 * @TODO Add better comparison
				 */
				// int sourceValueCounter = 0;
				// int targetValueCounter = 0;
				// for (String sourceField : sourceStruct.getFields()) {
				// Object sourceValue = sourceStruct.getValue(sourceField);
				// if (sourceValue != null) {
				// sourceValueCounter++;
				// }
				// }
				//
				// for (String targetField : targetStruct.getFields()) {
				// Object targetValue = targetStruct.getValue(targetField);
				// if (targetValue != null) {
				// targetValueCounter++;
				// }
				// }
				//
				// if (sourceValueCounter != targetValueCounter) {
				// logger.trace(function + " NOT EQUAL ");
				// logger.trace(" Source Had " + sourceValueCounter);
				// logger.trace(" Target Had " + targetValueCounter);
				//
				// for (String sourceField : sourceStruct.getFields()) {
				// Object sourceValue = sourceStruct.getValue(sourceField);
				// if (sourceValue != null) {
				// logger.trace(" Source Value " + sourceField + " == " + sourceValue);
				// }
				// }
				//
				// for (String targetField : targetStruct.getFields()) {
				// Object targetValue = targetStruct.getValue(targetField);
				// if (targetValue != null) {
				// logger.trace(" Target Value " + targetField + " == " + targetValue);
				// }
				// }
				//
				// }

			}
		}

	}

	public boolean execute(String function, Object value, Object param1) {

		try {
			/*
			 * @TODO Fix Editor Whitespace
			 * Editor is adding on white space chars causing issues with method invocation
			 */
			logger.trace("Executing Method with Param " + function);

			inv.invokeFunction(function.replaceAll("\\s+", ""), value, param1);
			return true;
		} catch (Exception e) {
			exceptions.put(function, e);
			logger.error("Failed executing function " + function + " := " + e.getMessage());
			return false;
		}

	}

	public boolean update(String function, Object value) {

		// synchronized (inv) {
		try {
			/*
			 * @TODO Fix Editor Whitespace
			 * Editor is adding on white space chars causing issues with method invocation
			 */
			logger.trace("Executing update Method " + function);

			inv.invokeFunction(function.replaceAll("\\s+", ""), value);
			return true;
			// compare(function, source, target);
		} catch (Exception e) {
			exceptions.put(function, e);
			logger.error("Failed executing function " + function + " := " + e.getMessage());
			// logger.error(e.getMessage(), e);
			return false;
		}
		// }
	}

	Boolean execute(String function, Object target, Properties properties) {
		try {
			logger.trace("Executing Method with properties " + function);
			return (Boolean) inv.invokeFunction(function.replaceAll("\\s+", ""), target, properties);
		} catch (Exception e) {
			exceptions.put(function, e);
			logger.error("Failed executing Executing " + function + " := " + e.getMessage());
			logger.error(e.getMessage(), e);
			return false;
		}
		// }
	}

}
