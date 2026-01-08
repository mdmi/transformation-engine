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

public class Metadata {

	private String hl7Type;

	private String precision;

	private String timezone;

	public Metadata() {
	}

	public Metadata(String hl7Type, String precision, String timezone) {
		this.hl7Type = hl7Type;
		this.precision = precision;
		this.timezone = timezone;
	}

	public String getHl7Type() {
		return hl7Type;
	}

	public void setHl7Type(String hl7Type) {
		this.hl7Type = hl7Type;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
}
