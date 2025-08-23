/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mdmi.core.MdmiException;
import org.mdmi.core.util.XmlUtil;

public class ToTimeConverter implements IConvertToString {
	@Override
	public String convertToString(Object obj, String format) {
		if (!(obj instanceof Date)) {
			throw new IllegalArgumentException("Object is not a java.util.Date type.");
		}

		if (format != null && 0 < format.length() && !format.equals("TIME")) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				return sdf.format((Date) obj);
			} catch (Exception ex) {
				throw new MdmiException(ex, "ToTimeConverter.convertToString({0}, {1}) failed.", obj, format);
			}
		}

		return XmlUtil.formatDateHMSMZ((Date) obj);
	}
}
