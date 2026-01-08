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

public class CDASource extends Source {

	private String format; // e.g., "CDA"

	private String xpath; // XPath to the element

	private String section; // CDA section name, if applicable

	private String documentId; // Optional: unique ID of the CDA document

	public CDASource() {
	}

	public CDASource(String format, String xpath, String section, String documentId) {
		this.format = format;
		this.xpath = xpath;
		this.section = section;
		this.documentId = documentId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	@Override
	public String toString() {
		return "CdaSource{" + "format='" + format + '\'' + ", xpath='" + xpath + '\'' + ", section='" + section + '\'' +
				", documentId='" + documentId + '\'' + '}';
	}
}
