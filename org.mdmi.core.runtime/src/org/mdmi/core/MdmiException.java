/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;

/**
 * Base class for the exceptions thrown by the mdmi package.
 *
 * @author goancea
 */
public class MdmiException extends RuntimeException {
	private static final long serialVersionUID = 2231623837656351663L;

	/**
	 * Construct a new instance from an exception message.
	 *
	 * @param message
	 *            The exception message.
	 */
	public MdmiException(String message) {
		super(message);
	}

	/**
	 * Construct a new instance from a message, and some parameters. For example "The file {0} cannot be found",
	 * "someFile.txt"
	 *
	 * @param message
	 *            The exception message. May contain parameter place-holders.
	 * @param params
	 *            An array of parameters used as replacements in the message.
	 */
	public MdmiException(String message, Object... params) {
		super(MessageFormat.format(message, params));
	}

	/**
	 * Construct a new instance from an exception message and an inner exception (cause).
	 *
	 * @param cause
	 *            The caught exception that caused this instance to be created
	 * @param message
	 *            The exception message.
	 */
	public MdmiException(Throwable cause, String message) {
		super(message, cause);
	}

	/**
	 * Construct a new instance from a message, some parameters, and an inner exception (cause). For example
	 * "The file {0} cannot be found", "someFile.txt"
	 *
	 * @param cause
	 *            The caught exception that caused this instance to be created
	 * @param message
	 *            The exception message. May contain parameter place-holders.
	 * @param params
	 *            An array of parameters used as replacements in the message.
	 */
	public MdmiException(Throwable cause, String message, Object... params) {
		super(MessageFormat.format(message, params), cause);
	}

	/**
	 * Description of the exception, including the messages from the nested exceptions, but not the stack trace.
	 *
	 * @param ex
	 *            Exception for which the description is built.
	 * @return Description of the exception, including the nested exceptions.
	 */
	public static String getDescription(Exception ex) {
		StringBuffer sb = new StringBuffer(2048);
		getDescription(sb, ex);
		Throwable cause = ex.getCause();
		while (cause != null) {
			sb.append("\nCaused by:\n");
			getDescription(sb, cause);
			cause = cause.getCause();
		}
		return sb.toString();
	}

	/**
	 * Description of the exception, including the messages from the nested exceptions, but not the stack trace.
	 *
	 * @return Description of the exception, including the nested exceptions.
	 */
	public String getDescription() {
		return getDescription(this);
	}

	/**
	 * Full description of the exception, including the messages from the nested exceptions, and the full stack trace.
	 *
	 * @param ex
	 *            Exception for which the description is built.
	 * @return Full exception description including the stack traces.
	 */
	public static String getFullDescription(Exception ex) {
		StringBuffer sb = new StringBuffer(getDescription(ex));
		sb.append('\n');
		PrintWriter pw = null;
		try {
			StringWriter sw = new StringWriter(1024);
			pw = new PrintWriter(sw, true);
			ex.printStackTrace(pw);
			pw.flush();
			sb.append(sw.toString());
			pw.close();
		} catch (Exception ignored) {
		}
		return sb.toString();
	}

	/**
	 * Full description of the exception, including the messages from the nested exceptions, and the full stack trace.
	 *
	 * @return Full exception description including the stack traces.
	 */
	public String getFullDescription() {
		return getFullDescription(this);
	}

	/**
	 * Class name and exception message text for the specified exception.
	 *
	 * @param sb
	 *            String buffer to place the description into.
	 * @param t
	 *            The exception.
	 */
	protected static void getDescription(StringBuffer sb, Throwable t) {
		sb.append("Error: ");
		sb.append(t.getClass().getName());
		sb.append("\r\nMessage: ");
		sb.append(t.getMessage());
		sb.append("\r\n");
	}
} // MdmiException
