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
package org.mdmi.core.engine;

import java.util.Base64;
import java.util.List;

/**
 * @author seanmuir
 *
 */
public class UnspecifiedNode {

	/**
	 * @param element
	 * @param contents
	 * @param messageLocation
	 * @param modelLocation
	 * @param nodes
	 */
	public UnspecifiedNode(String element, String contents, String messageLocation, String modelLocation,
			List<String> nodes) {
		super();
		this.element = element;
		this.contents = contents;
		this.messageLocation = messageLocation;
		this.modelLocation = modelLocation;
		this.nodes = nodes;
	}

	public String getMessageLocation() {
		return messageLocation;
	}

	public void setMessageLocation(String messageLocation) {
		this.messageLocation = messageLocation;
	}

	public String getModelLocation() {
		return modelLocation;
	}

	public void setModelLocation(String modelLocation) {
		this.modelLocation = modelLocation;
	}

	public List<String> getNodes() {
		return nodes;
	}

	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}

	String element;

	String contents;

	String messageLocation;

	String modelLocation;

	List<String> nodes;

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {

		contents = Base64.getEncoder().encodeToString(contents.getBytes());
	}
}
