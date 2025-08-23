/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.runtime;

import java.util.HashMap;

public class MdmiNetTransferInfo {

	public String sourceMap;

	public String sourceModel;

	public String targetMap;

	public String targetModel;

	public String sourceMessage; // base 64 encoded bytes

	public String targetMessage; // base 64 encoded bytes, may be null

	public String elements; // may be null, comma separated BER names or IDs

	public HashMap<String, String> sourceProperties = new HashMap<>();

	public HashMap<String, String> targetProperties = new HashMap<>();

	public String toXml() {

		return "";
	}

}
