/*******************************************************************************
 * Copyright (c) 2025 seanmuir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     seanmuir - initial API and implementation
 *
 *******************************************************************************/
package org.mdmi.core.engine.parser.piqi;

import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mdmi.MessageModel;
import org.mdmi.core.ISyntacticParser;
import org.mdmi.core.ISyntaxNode;
import org.mdmi.core.MdmiMessage;

/**
 * @author seanmuir
 *
 */
public class PiqiSyntaxParser implements ISyntacticParser {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISyntacticParser#parse(org.mdmi.MessageModel, org.mdmi.core.MdmiMessage)
	 */
	@Override
	public ISyntaxNode parse(MessageModel mdl, MdmiMessage msg) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISyntacticParser#serialize(org.mdmi.MessageModel, org.mdmi.core.MdmiMessage, org.mdmi.core.ISyntaxNode, java.lang.String)
	 */
	@Override
	public void serialize(MessageModel mdl, MdmiMessage msg, ISyntaxNode root, String transformComment) {

		msg.setData(this.serialize());
	}

	String serialize() {

		Set<DataNode> dataNodes = new HashSet<>();

		DataNode node1 = new DataNode(
			"dn-cda-000101", "date", "Patient.birthDate",
			new CDASource(
				"CDA", "/ClinicalDocument/recordTarget/patientRole/patient/birthTime/@value", "recordTarget",
				"cda-12345"),
			"1980-03-12", "19800312", new Metadata("TS", "day", null), new Context("CDA Document", "cda-12345"));

		DataNode node2 = new DataNode(
			"dn-cda-000102", "code", "Patient.gender",
			new CDASource(
				"CDA", "/ClinicalDocument/recordTarget/patientRole/patient/administrativeGenderCode", "recordTarget",
				"cda-12345"),
			"male", "M", new Metadata("CE", null, null), new Context("CDA Document", "cda-12345"));

		dataNodes.add(node1);
		dataNodes.add(node2);

		JSONArray jsonArray = new JSONArray();
		for (DataNode node : dataNodes) {
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("nodeId", node.getNodeId());
			jsonObject.put("type", node.getType());
			jsonObject.put("canonicalPath", node.getCanonicalPath());

			JSONObject sourceJson = new JSONObject();
			sourceJson.put("format", node.getSource().getFormat());
			if (node.getSource() instanceof CDASource cdaSrc) {
				sourceJson.put("xpath", cdaSrc.getXpath());
				sourceJson.put("section", cdaSrc.getSection());
				sourceJson.put("documentId", cdaSrc.getDocumentId());
			}
			jsonObject.put("source", sourceJson);

			jsonObject.put("value", node.getValue());
			jsonObject.put("rawValue", node.getRawValue());

			JSONObject metadataJson = new JSONObject();
			metadataJson.put("hl7Type", node.getMetadata().getHl7Type());
			metadataJson.put("precision", node.getMetadata().getPrecision());
			metadataJson.put("timezone", node.getMetadata().getTimezone());
			jsonObject.put("metadata", metadataJson);

			JSONObject contextJson = new JSONObject();
			contextJson.put("messageType", node.getContext().getMessageType());
			contextJson.put("messageControlId", node.getContext().getMessageControlId());
			jsonObject.put("context", contextJson);

			jsonArray.add(jsonObject);
		}

		String jsonString = jsonArray.toJSONString();
		System.out.println(jsonString);
		return jsonString;
	}

}
