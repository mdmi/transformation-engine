/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.from;

public class BooleanConverter implements IConvertFromString {
	@Override
	public Object convertFromString(String value, String format) {
		if ("0".equals(value)) {
			value = "false";
		} else if ("1".equals(value)) {
			value = "true";
		}
		return Boolean.valueOf(value);
	}
}
