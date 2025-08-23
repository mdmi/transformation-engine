/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core;

import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reference to an MdmiModel. It can be constructed based on the group and message names and resolved later.
 */
public final class MdmiModelRef {

	private static Logger logger = LoggerFactory.getLogger(MdmiModelRef.class);

	private String m_groupName;

	private String m_modelName;

	private MessageModel m_model;

	/**
	 * Constructor with a qualified name string, for example 'group.message'.
	 *
	 * @param qualifiedName
	 *            The qualified mdoel name, formatted as 'groupName.messageName'.
	 */
	public MdmiModelRef(String qualifiedName) {
		String[] a = qualifiedName.split("\\.", 2);
		if (a == null || a.length != 2) {
			throw new IllegalArgumentException("Invalid model ID: must be formatted as 'group.model'");
		}
		m_groupName = a[0];
		m_modelName = a[1];
	}

	/**
	 * Construct an instance with the given group and model names.
	 *
	 * @param groupName
	 *            The MessageGroup name.
	 * @param modelName
	 *            The MessageModel name.
	 */
	public MdmiModelRef(String groupName, String modelName) {
		m_groupName = groupName;
		m_modelName = modelName;
	}

	/**
	 * Return the message group name.
	 *
	 * @return The message group name.
	 */
	public String getGroupName() {
		return m_groupName;
	}

	/**
	 * Return the message model name.
	 *
	 * @return The message model name.
	 */
	public String getModelName() {
		return m_modelName;
	}

	/**
	 * Get the actual message group. If the resolve was not called, it will be called now.
	 * This method will throw an exception if it cannot resolve the group or message names.
	 *
	 * @return The actual message group.
	 */
	public MessageGroup getGroup() {
		if (m_model == null) {
			resolve();
		}
		return m_model.getGroup();
	}

	/**
	 * Get the actual message model. If the resolve was not called, it will be called now.
	 * This method will throw an exception if it cannot resolve the group or message names.
	 *
	 * @return The actual message model.
	 */
	public MessageModel getModel() {
		if (m_model == null) {
			resolve();
		}
		return m_model;
	}

	/**
	 * Get the qualified message model name as 'groupName.modelName'.
	 *
	 * @return The qualified message model name as 'groupName.modelName'.
	 */
	public String getQualifiedName() {
		return m_groupName + '.' + m_modelName;
	}

	/**
	 * Return true if the model is resolved.
	 *
	 * @return True if the model is resolved.
	 */
	public boolean isResolved() {
		return null != m_model;
	}

	/**
	 * Resolve the references. Will call the MdmiResolver, which must be initialized.
	 * Resolve will NOT attempt to load the map, must be already loaded.
	 */
	public void resolve() {
		// if (m_groupName == null || m_groupName.length() <= 0) {
		// throw new MdmiException("Invalid call, message group name was not set!");
		// }
		// if (m_modelName == null || m_modelName.length() <= 0) {
		// throw new MdmiException("Invalid call, message model name was not set!");
		// }

		m_model = Mdmi.INSTANCE().getResolver().getModel(m_groupName, m_modelName);
		if (m_model == null) {
			throw new MdmiException("Cannot resolve reference model {0}.{1}", m_groupName, m_modelName);
		}
		logger.debug("Resolved model ref: '" + m_groupName + "." + m_modelName + "'.");
	}

	@Override
	public String toString() {
		return m_groupName + "." + m_modelName + "[isResolved=" + (isResolved()
				? "true"
				: "false");
	}
} // MdmiModelRef
