/*******************************************************************************
* Copyright (c) 2012, 2017, 2018 MDIX Inc
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     MDIX Inc - initial API and implementation
*
* Author:
*     Gabriel Oancea
*
*******************************************************************************/
package org.mdmi.core;

import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MessageGroup;

/**
 * One transformation set - a collection of Message Elements to transfer from one message to the other, together with
 * the map references, and messages.
 */
public class MdmiTransferInfo {
	/** The source model describing the source message. */
	public MdmiModelRef sourceModel;

	/** The source message. */
	public MdmiMessage sourceMessage;

	/** The target model describing the target message. */
	public MdmiModelRef targetModel;

	/** The target message. */
	public MdmiMessage targetMessage;

	/** A list of target element names to be transfered. May be Semantic Element names or Business Element names, depending upon the useDictionary. */
	public ArrayList<MDMIBusinessElementReference> targetElements;

	public Properties sourceProperties = new Properties();

	public Properties targetProperties = new Properties();

	public JSONObject sourceValues;

	public JSONObject targetValues;

	/**
	 * Construct a new transfer info instance. By default the useDictionary is false, meaning that the
	 * target element names are Semantic Element names.
	 *
	 * @param sourceModel
	 *            The source model describing the source message.
	 * @param sourceMessage
	 *            The source message.
	 * @param targetModel
	 *            The target model describing the target message.
	 * @param targetMessage
	 *            The target message.
	 * @param elements
	 *            The target element names to be transfered.
	 */
	public MdmiTransferInfo(MdmiModelRef sourceModel, MdmiMessage sourceMessage, MdmiModelRef targetModel,
			MdmiMessage targetMessage, ArrayList<MDMIBusinessElementReference> elements) {
		this.sourceModel = sourceModel;
		this.sourceMessage = sourceMessage;
		this.targetModel = targetModel;
		this.targetMessage = targetMessage;
		this.targetElements = elements;
	}

	/**
	 * Copy ctor.
	 *
	 * @param src
	 *            Source of the copy.
	 */
	public MdmiTransferInfo(MdmiTransferInfo src) {
		this.sourceModel = src.sourceModel;
		this.sourceMessage = src.sourceMessage;
		this.targetModel = src.targetModel;
		this.targetMessage = src.targetMessage;
		this.targetElements = src.targetElements;
	}

	/**
	 * Get the source message group.
	 *
	 * @return The source message group.
	 */
	public MessageGroup getSourceMessageGroup() {
		return sourceModel.getGroup();
	}

	/**
	 * Get the target message group.
	 *
	 * @return The target message group.
	 */
	public MessageGroup getTargetMessageGroup() {
		return targetModel.getGroup();
	}

	@Override
	public String toString() {
		try {

			return "TRANFORM FROM: " + sourceModel.toString() + "[" + sourceMessage.toString() + "]\r\n" + "TO: " +
					targetModel.toString() + "[" + targetMessage.toString() + "]\r\n";
		} catch (Exception ignored) {
		}
		return super.toString();
	}

} // MdmiTransformInfo
