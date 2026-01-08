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

import java.util.Properties;

import org.json.simple.JSONObject;
import org.mdmi.MessageModel;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.IElementValue;
import org.mdmi.core.ISemanticParser;
import org.mdmi.core.ISyntaxNode;

/**
 * @author seanmuir
 *
 */
public class PiqiParser implements ISemanticParser {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISemanticParser#buildSemanticModel(org.mdmi.MessageModel, org.mdmi.core.ISyntaxNode, org.mdmi.core.ElementValueSet,
	 * java.util.Properties, org.json.simple.JSONObject)
	 */
	@Override
	public void buildSemanticModel(MessageModel mdl, ISyntaxNode root, ElementValueSet eset, Properties properties,
			JSONObject values) {
		System.err.println("aaaa");
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISemanticParser#createNewSyntacticModel(org.mdmi.MessageModel, org.mdmi.core.ElementValueSet, java.util.Properties)
	 */
	@Override
	public ISyntaxNode createNewSyntacticModel(MessageModel mdl, ElementValueSet eset, Properties properties) {
		// TODO Auto-generated method stub
		System.err.println("bbbb");
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISemanticParser#updateTargetSemanticModel(org.mdmi.MessageModel, org.mdmi.core.ElementValueSet, org.mdmi.core.ISyntaxNode,
	 * java.util.Properties, org.json.simple.JSONObject)
	 */
	@Override
	public void updateTargetSemanticModel(MessageModel mdl, ElementValueSet eset, ISyntaxNode yroot,
			Properties properties, JSONObject targetValues) {

		for (IElementValue element : eset.getAllElementValues()) {
			System.err.println(element.getSemanticElement().getName());
		}
		System.err.println("cccc");

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.core.ISemanticParser#updateSyntacticModel(org.mdmi.MessageModel, org.mdmi.core.ElementValueSet, org.mdmi.core.ISyntaxNode,
	 * java.util.Properties)
	 */
	@Override
	public void updateSyntacticModel(MessageModel mdl, ElementValueSet eset, ISyntaxNode yroot, Properties properties) {
		System.err.println("dddd");

	}

}
