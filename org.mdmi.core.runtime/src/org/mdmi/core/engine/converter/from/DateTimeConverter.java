/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.from;

import org.mdmi.core.util.DateUtil;

public class DateTimeConverter implements IConvertFromString {

	@Override
	public Object convertFromString(String value, String format) {

		String myFormat = "";
		if (format != null && 0 < format.length()) {
			myFormat = DateUtil.getLongestWithoutSemiColons(format);
		}
		return DateUtil.parseDateImplicitOptional(myFormat, value);
	}
}
