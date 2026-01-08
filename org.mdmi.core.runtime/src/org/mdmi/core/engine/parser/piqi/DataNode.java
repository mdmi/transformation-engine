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

import java.util.Objects;

public class DataNode {

	private String nodeId;

	private String type;

	private String canonicalPath;

	private Source source;

	private String value;

	private String rawValue;

	private Metadata metadata;

	private Context context;

	public DataNode() {
	}

	public DataNode(String nodeId, String type, String canonicalPath, Source source, String value, String rawValue,
			Metadata metadata, Context context) {
		this.nodeId = nodeId;
		this.type = type;
		this.canonicalPath = canonicalPath;
		this.source = source;
		this.value = value;
		this.rawValue = rawValue;
		this.metadata = metadata;
		this.context = context;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCanonicalPath() {
		return canonicalPath;
	}

	public void setCanonicalPath(String canonicalPath) {
		this.canonicalPath = canonicalPath;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRawValue() {
		return rawValue;
	}

	public void setRawValue(String rawValue) {
		this.rawValue = rawValue;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof DataNode))
			return false;
		DataNode dataNode = (DataNode) o;
		return Objects.equals(nodeId, dataNode.nodeId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nodeId);
	}
}
