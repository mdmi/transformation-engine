/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.script.ScriptEngine;

import org.mdmi.SemanticElement;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;
import org.mdmi.core.IExpressionInterpreter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsAdapter implements IExpressionInterpreter {

	private static Logger logger = LoggerFactory.getLogger(JsAdapter.class);

	private ElementValueSet m_eset;

	private String m_name;

	private XValue m_value;

	// final static ScriptEngineManager factory = new ScriptEngineManager();

	// final static engine = factory.getEngineByName("JavaScript");

	ThreadLocal<ScriptEngine> engine = new ThreadLocal<>();

	final static String PACKAGES = " importPackage(Packages.org.mdmi.core);" + System.getProperty("line.separator") +
			"importPackage(Packages.org.mdmi.core.engine);" + System.getProperty("line.separator") +
			"importPackage(Packages.org.mdmi.core.model);" + System.getProperty("line.separator") +
			"importPackage(Packages.org.mdmi.core.engine.javascript);" + System.getProperty("line.separator");

	private static Double javaVersion = null;

	private static String loadPrefix = "";

	public static void setJavaVersion(Double javaVersion) {
		JsAdapter.javaVersion = javaVersion;
	}

	public JsAdapter(ElementValueSet eset, String name, XValue value) {
		initialize(eset, null, name, value);
	}

	/*
	 * If the version of java is greater the 1.7, need to add load compatibility
	 * see https://wiki.openjdk.java.net/display/Nashorn/Rhino+Migration+Guide
	 *
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.IExpressionInterpreter#initialize(org.mdmi.ElementValueSet,
	 * org.mdmi.engine.XElementValue, java.lang.String, org.mdmi.engine.XValue)
	 */
	@Override
	public void initialize(ElementValueSet eset, XElementValue context, String name, XValue value) {
		m_eset = eset;
		m_name = name;
		m_value = value;
		if (javaVersion == null) {
			javaVersion = Double.parseDouble(System.getProperty("java.specification.version"));
			if (javaVersion > 1.7) {
				loadPrefix = "load(\"nashorn:mozilla_compat.js\");";
			}
		}
	}

	@Override
	public void evalAction(IElementValue context, String rule, Properties properties) {
		ArrayList<Exception> lex = new ArrayList<>();
		eval(context, rule, lex, properties);
	}

	@Override
	public List<String> compileAction(SemanticElement se, String rule) {
		return compile(se, rule);
	}

	private List<String> compile(SemanticElement se, String rule) {
		ArrayList<String> ler = new ArrayList<>();
		ArrayList<Exception> lex = new ArrayList<>();
		IElementValue context = new XElementValue(
			se, m_eset == null
					? new ElementValueSet()
					: m_eset);
		eval(context, rule, lex, null);
		for (Exception ex : lex) {
			ler.add(ex.getMessage());
		}
		return ler;
	}

	private boolean eval(IElementValue context, String rule, ArrayList<Exception> lex, Properties properties) {
		// rule = addPackages(rule);
		// boolean returnValue = false;
		// try {
		// engine.put("value", context);
		// engine.put("properties", properties);
		// if (null != m_name && 0 < m_name.length()) {
		// engine.put(m_name, m_value);
		// }
		// engine.put("returnValue", returnValue);
		// engine.eval(rule);
		// } catch (Exception ex) {
		// logger.error("Error executing rule ", ex);
		// lex.add(ex);
		// }
		// return returnValue;
		return true;
	}

	private String addPackages(String rule) {
		return loadPrefix + PACKAGES + rule;
	}
} // JsAdapter
