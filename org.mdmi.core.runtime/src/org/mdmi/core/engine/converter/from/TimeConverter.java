/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.from;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.mdmi.core.MdmiException;
import org.mdmi.core.util.XmlUtil;

public class TimeConverter implements IConvertFromString {
	@Override
	public Object convertFromString(String value, String format) {
		if (format != null && 0 < format.length()) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				return sdf.parse(value);
			} catch (Exception ex) {
				throw new MdmiException(ex, "TimeConverter.convertFromString({0}, {1}) failed.", value, format);
			}
		}

		try {
			return XmlUtil.parseDateHMSMZ(value);
		} catch (ParseException ex) {
			throw new MdmiException(ex, "TimeConverter.convertFromString({0}, {1}) failed.", value, format);
		}
	}
}
