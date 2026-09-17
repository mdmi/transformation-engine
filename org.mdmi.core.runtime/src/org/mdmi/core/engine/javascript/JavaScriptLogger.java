/*******************************************************************************
 * Copyright (c) 2026 seanmuir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     seanmuir - initial API and implementation
 *
 *******************************************************************************/
package org.mdmi.core.engine.javascript;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaScriptLogger {

	private static final Logger LOGGER = LoggerFactory.getLogger("JAVASCRIPT_DEBUG");

	/**
	 * Print a message to the dedicated JavaScript debug log.
	 *
	 * JavaScript usage:
	 * jsLogger.print("Hello");
	 */
	public void print(Object message) {
		LOGGER.debug(String.valueOf(message));
	}

	/**
	 * Print a message with a simple prefix.
	 *
	 * JavaScript usage:
	 * jsLogger.print("CWE1 = " + cwe1);
	 */
	public void debug(Object message) {
		LOGGER.debug(String.valueOf(message));
	}

	/**
	 * Print an error message.
	 */
	public void error(Object message) {
		LOGGER.error(String.valueOf(message));
	}

	/**
	 * Print a warning message.
	 */
	public void warn(Object message) {
		LOGGER.warn(String.valueOf(message));
	}
}
