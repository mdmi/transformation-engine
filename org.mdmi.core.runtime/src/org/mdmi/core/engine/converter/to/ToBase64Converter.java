/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

import org.mdmi.core.util.StringUtil;

public class ToBase64Converter implements IConvertToString {
	private IConvertToString s_wrapped;

	public ToBase64Converter() {
		this(new ToStringConverter());
	}

	public ToBase64Converter(IConvertToString wrapped) {
		s_wrapped = wrapped;
	}

	@Override
	public String convertToString(Object obj, String format) {
		return StringUtil.encode(s_wrapped.convertToString(obj, format));
	}
}
