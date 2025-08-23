/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
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