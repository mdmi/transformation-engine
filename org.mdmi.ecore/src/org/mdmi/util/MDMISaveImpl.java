/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mdmi.util;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class MDMISaveImpl extends XMISaveImpl {
	private static final String CDATA_OPEN_BRACKET = "<![CDATA[";

	private Escape domEscape = null;

	public MDMISaveImpl(XMLHelper helper) {
		super(helper);
	}

	@Override
	protected Object writeTopObject(EObject top) {
		return writeTopObjects(Collections.singletonList(top));
	}

	@Override
	protected void init(XMLResource resource, Map<?, ?> options) {
		super.init(resource, options);
		if (toDOM) {
			domEscape = new Escape();
			domEscape.setUseCDATA(Boolean.TRUE.equals(options.get(XMLResource.OPTION_ESCAPE_USING_CDATA)));
		}
	}

	@Override
	protected void saveElement(EObject o, Object value, EStructuralFeature f) {
		if (value == null) {
			saveNil(o, f);
		} else {
			String svalue = getDatatypeValue(value, f, false);
			if (!toDOM) {
				doc.saveDataValueElement(helper.getQName(f), svalue);
			} else {
				helper.populateNameInfo(nameInfo, f);
				Element elem = document.createElementNS(nameInfo.getNamespaceURI(), nameInfo.getQualifiedName());
				Node text = null;
				String converted = domEscape.convertText(svalue);
				if (converted != null && converted.startsWith(CDATA_OPEN_BRACKET)) {
					text = document.createCDATASection(svalue);
				} else {
					text = document.createTextNode(svalue);
				}
				elem.appendChild(text);
				currentNode.appendChild(elem);
				handler.recordValues(elem, o, f, value);
				handler.recordValues(text, o, f, value);
			}
		}
	}
}
