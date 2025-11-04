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
import java.util.HashSet;
import java.util.Properties;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.lang3.StringUtils;
import org.mdmi.ConversionRule;
import org.mdmi.DatatypeMap;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.SemanticElement;
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
public class DatamapInterpreter {

	private static String sourceCheckFilter = "function sourceCheckFilter(target,properties) { " +
			"if (properties.containsKey('VALUESET')) { " +
			"    if (properties.get('VALUESET').containsKey(target)) { " + "         " + "        return true; " +
			"    } " + "} " + "  " + "return false " + "} ";

	private static String targetCheckFilter = "function targetCheckFilter(target,properties) { " +
			"if (properties.containsKey('VALUESET')) { " +
			"    if (properties.get('VALUESET').containsKey(target.value())) { " + "         " +
			"        return true; " + "    } " + "} " + "  " + "return false " + "} ";

	private static Logger logger = LoggerFactory.getLogger(DatamapInterpreter.class);

	ScriptEngineManager manager;

	ScriptEngine engine;

	Invocable inv;

	public HashMap<String, Exception> exceptions = new HashMap<>();

	/**
	 * @param messageGropu
	 * @param target
	 */
	public DatamapInterpreter(MessageGroup messageGropu) {
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("JavaScript");

		if (engine == null) {
			throw new RuntimeException("Unable to Load Script");
		}

		/**
		 * Make sure no overlap of datatype maps - relying on name might have to rely on function name
		 *
		 */
		HashSet<String> added = new HashSet<>();

		StringBuffer sb = new StringBuffer();

		sb.append("try {\n load(\"nashorn:mozilla_compat.js\");\n} \ncatch (e) \n{ \n}\n");

		sb.append("importPackage(org.mdmi.core.engine.javascript);\n");

		for (DatatypeMap dm : messageGropu.getDatatypeMaps()) {

			added.add(dm.getName());

			if (dm.getToMDMI() != null && !dm.getToMDMI().isEmpty()) {
				sb.append(dm.getToMDMI());
			}

			if (dm.getFromMDMI() != null && !dm.getFromMDMI().isEmpty()) {
				sb.append(dm.getFromMDMI());
			}

		}

		for (MessageModel mm : messageGropu.getModels()) {
			for (SemanticElement se : mm.getElementSet().getSemanticElements()) {
				if (se.getRelationshipByName("QUALIFIER") != null) {
					if (!StringUtils.isEmpty(se.getRelationshipByName("QUALIFIER").getRule())) {
						sb.append(se.getRelationshipByName("QUALIFIER").getRule());
					}
				}
			}
			sb.append(sourceCheckFilter);
			sb.append(targetCheckFilter);
		}

		try {
			if (logger.isTraceEnabled()) {
				try {
					Files.createDirectories(Paths.get("./logs"));
					Files.write(
						Paths.get("./logs/" + messageGropu.getName() + "datatypemaps.js"), sb.toString().getBytes());
				} catch (IOException e) {
					logger.trace("Unable to log datatypes");
					// e.printStackTrace();
				}
			}
			engine.eval(compile(sb.toString()));
		} catch (ScriptException e) {
			logger.error("aaaaaaINVALID JAVA SCRIPT", e.getMessage());
		}

		inv = (Invocable) engine;
	}

	/**
	 * @param datatypemappings
	 */
	public DatamapInterpreter(String datatypemappings) {

		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("JavaScript");

		if (engine == null) {
			throw new RuntimeException("Unable to Load Script");
		}

		try {

			engine.eval(compile(datatypemappings.toString()));
		} catch (ScriptException e) {
			logger.error("INVALID JAVA SCRIPT", e.getMessage());
		}

		inv = (Invocable) engine;
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
		sf = SourceFile.fromCode("mappings.js", code, SourceKind.STRONG);
		ArrayList<SourceFile> inputFiles = new ArrayList<>();
		inputFiles.add(sf);

		Result result = compiler.compile(new ArrayList<SourceFile>(), inputFiles, options);

		return compiler.toSource();

	}

	public boolean execute(String function, Object source, Object target, Properties properties,
			ConversionRule conversionRule) {

		// synchronized (inv) {
		try {
			/*
			 * @TODO Fix Editor Whitespace
			 * Editor is adding on white space chars causing issues with method invocation
			 */
			logger.trace("Executing Method " + function);
			inv.invokeFunction(function.replaceAll("\\s+", ""), source, target, properties, conversionRule);

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

		// synchronized (inv) {
		try {
			logger.trace("Executing Method " + function);
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
