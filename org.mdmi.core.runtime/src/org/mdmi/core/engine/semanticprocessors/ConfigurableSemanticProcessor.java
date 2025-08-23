/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mdmi.core.engine.semanticprocessors;

import java.util.ArrayList;

import org.mdmi.MessageModel;

public abstract class ConfigurableSemanticProcessor implements ISemanticProcessor {

	String name;

	ArrayList<String> groups;

	Object arguments;

	public void setName(String name) {
		this.name = name;
	}

	public void setGroups(ArrayList<String> groups) {
		this.groups = groups;
	}

	public void setArguments(Object arguments) {
		this.arguments = arguments;
	}

	@Override
	public boolean canProcess(MessageModel messageModel) {
		if (groups.contains(messageModel.getGroup().getName())) {
			return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
