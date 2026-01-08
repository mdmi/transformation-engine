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
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISyntacticParser#serialize(org.mdmi.MessageModel, org.mdmi.core.MdmiMessage, org.mdmi.core.ISyntaxNode, java.lang.String)
	 */
	@Override
	public void serialize(MessageModel mdl, MdmiMessage msg, ISyntaxNode root, String transformComment) {

		// DataNode node = new DataNode(
		// "dn-v2-000201", "date", "Patient.birthDate", new HL7V2Source("HL7v2", "PID", "PID-7", "PID[1].7"),
		// "1980-03-12", "19800312", new Metadata("TS", "day", null), new Context("ADT^A01", "MSG00001"));
		msg.setData(this.serialize());
	}

	String serialize() {

		// Create a set of DataNodes
		Set<DataNode> dataNodes = new HashSet<>();

		// Example DataNode 1
		DataNode node1 = new DataNode(
			"dn-cda-000101", "date", "Patient.birthDate",
			new CDASource(
				"CDA", "/ClinicalDocument/recordTarget/patientRole/patient/birthTime/@value", "recordTarget",
				"cda-12345"),
			"1980-03-12", "19800312", new Metadata("TS", "day", null), new Context("CDA Document", "cda-12345"));

		// Example DataNode 2
		DataNode node2 = new DataNode(
			"dn-cda-000102", "code", "Patient.gender",
			new CDASource(
				"CDA", "/ClinicalDocument/recordTarget/patientRole/patient/administrativeGenderCode", "recordTarget",
				"cda-12345"),
			"male", "M", new Metadata("CE", null, null), new Context("CDA Document", "cda-12345"));

		dataNodes.add(node1);
		dataNodes.add(node2);

		// Serialize to JSON
		JSONArray jsonArray = new JSONArray();
		for (DataNode node : dataNodes) {
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("nodeId", node.getNodeId());
			jsonObject.put("type", node.getType());
			jsonObject.put("canonicalPath", node.getCanonicalPath());

			// Serialize Source
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

			// Serialize Metadata
			JSONObject metadataJson = new JSONObject();
			metadataJson.put("hl7Type", node.getMetadata().getHl7Type());
			metadataJson.put("precision", node.getMetadata().getPrecision());
			metadataJson.put("timezone", node.getMetadata().getTimezone());
			jsonObject.put("metadata", metadataJson);

			// Serialize Context
			JSONObject contextJson = new JSONObject();
			contextJson.put("messageType", node.getContext().getMessageType());
			contextJson.put("messageControlId", node.getContext().getMessageControlId());
			jsonObject.put("context", contextJson);

			jsonArray.add(jsonObject);
		}

		// Convert JSONArray to string
		String jsonString = jsonArray.toJSONString();
		System.out.println(jsonString);
		return jsonString;
	}

}
