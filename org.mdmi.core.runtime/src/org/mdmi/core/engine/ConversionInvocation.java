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

import java.util.ArrayList;

import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.SemanticElement;

/**
 * Each instance of this class wraps one conversion, from one source SE to
 * one or more target SEs, through a source and target BER.
 *
 * @author goancea
 */
public class ConversionInvocation {
	public SemanticElement target; // target message element

	public MDMIBusinessElementReference trgBER; // target business element reference

	public MDMIBusinessElementReference srcBER; // source business element reference (same unique ID as target)

	ArrayList<SemanticElement> source; // source message elements

	public ConversionInvocation(SemanticElement target, MDMIBusinessElementReference trgBER,
			MDMIBusinessElementReference srcBER) {
		this.target = target;
		this.trgBER = trgBER;
		this.srcBER = srcBER;
		this.source = new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	ConversionInvocation(ConversionInvocation src) {
		target = src.target;
		trgBER = src.trgBER;
		srcBER = src.srcBER;
		source = (ArrayList<SemanticElement>) src.source.clone();
	}

	@Override
	public ConversionInvocation clone() {
		return new ConversionInvocation(this);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (source.size() == 1) {
			sb.append(source.get(0).getName() + " -> ");
		} else {
			sb.append("[ ");
			for (int i = 0; i < source.size(); i++) {
				if (i > 0) {
					sb.append(", ");
				}
				sb.append(source.get(i).getName());
			}
			sb.append(" ] -> ");
		}
		sb.append(
			(trgBER == null
					? "null"
					: trgBER.getName()) + " -> ");
		sb.append(
			(target == null
					? "null"
					: target.getName()));
		return sb.toString();
	}
} // Conversion$ConversionInfo