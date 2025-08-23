/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mdmi.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.mdmi.core.util.FileUtil;
import org.mdmi.core.util.XmlParser;
import org.mdmi.core.util.XmlUtil;
import org.mdmi.core.util.XmlWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class MdmiValueSetsHandler {
	public static final String FILE_EXTENSION = ".valuesets.xml";

	private static final String VALUE_SETS_TAG = "valueSets";

	private static final String VALUE_SET_MAPS_TAG = "valueSetMaps";

	private File sourceFile;

	private HashMap<String, MdmiValueSet> valueSets;

	private HashMap<String, MdmiValueSetMap> valueSetMaps;

	protected MdmiValueSetsHandler() {
		valueSets = new HashMap<>();
		valueSetMaps = new HashMap<>();
	}

	// TODO: made public for testing (shouldn't check in)
	// protected MdmiValueSetsHandler( File sourceFile ) {
	public MdmiValueSetsHandler(File sourceFile) {
		this();
		if (null != sourceFile && sourceFile.exists() && sourceFile.isFile()) {
			this.sourceFile = sourceFile;
			fromXml();
		}
	}

	public MdmiValueSet getValueSet(String name) {
		return valueSets.get(name);
	}

	public boolean containsValueSet(String name) {
		return null != valueSets.get(name);
	}

	public void addValueSet(MdmiValueSet valueSet) {
		if (null == valueSet) {
			throw new IllegalArgumentException("Invalid null value for the value set!");
		}
		valueSets.put(valueSet.getName(), valueSet);
	}

	public void removeValueSet(String name) {
		valueSets.remove(name);
	}

	public Collection<MdmiValueSet> getAllValueSets() {
		return valueSets.values();
	}

	public MdmiValueSetMap getValueSetMap(String name) {
		return valueSetMaps.get(name);
	}

	public boolean containsValueSetMap(String name) {
		return null != valueSetMaps.get(name);
	}

	public void addValueSetMap(MdmiValueSetMap valueSetMap) {
		if (null == valueSetMap) {
			throw new IllegalArgumentException("Invalid null value for the value set map!");
		}
		valueSetMaps.put(valueSetMap.getName(), valueSetMap);
	}

	public void removeValueSetMap(String name) {
		valueSetMaps.remove(name);
	}

	public void save() {
		if (null == sourceFile) {
			throw new IllegalArgumentException("null or empty source file!");
		}
		save(sourceFile);
	}

	public void save(File sourceFile) {
		if (null == this.sourceFile) {
			this.sourceFile = sourceFile;
		}
		if (null == this.sourceFile) {
			throw new IllegalArgumentException("null or empty source file!");
		}
		if (this.sourceFile.exists()) {
			FileUtil.backup(this.sourceFile);
		}
		XmlParser p = new XmlParser();
		Document doc = p.newDocument();
		Element root = doc.createElement("mdmiValueSets");
		doc.appendChild(root);
		Element vss = XmlUtil.addElement(root, VALUE_SETS_TAG);
		for (MdmiValueSet vs : valueSets.values()) {
			vs.toXml(vss);
		}
		Element mss = XmlUtil.addElement(root, VALUE_SET_MAPS_TAG);
		for (MdmiValueSetMap ms : valueSetMaps.values()) {
			ms.toXml(mss);
		}
		XmlWriter w = new XmlWriter(this.sourceFile.getAbsolutePath());
		w.write(doc);
	}

	private void fromXml() {
		XmlParser p = new XmlParser();
		Document doc = p.parse(sourceFile);
		Element root = doc.getDocumentElement();
		Element vss = XmlUtil.getElement(root, VALUE_SETS_TAG);
		if (null != vss) {
			ArrayList<Element> evs = XmlUtil.getElements(vss, MdmiValueSet.TAG);
			for (int i = 0; i < evs.size(); i++) {
				Element e = evs.get(i);
				MdmiValueSet v = new MdmiValueSet(this, e);
				valueSets.put(v.getName(), v);
			}
		}
		Element mss = XmlUtil.getElement(root, VALUE_SET_MAPS_TAG);
		if (null != mss) {
			ArrayList<Element> evs = XmlUtil.getElements(mss, MdmiValueSetMap.TAG);
			for (int i = 0; i < evs.size(); i++) {
				Element e = evs.get(i);
				MdmiValueSetMap v = new MdmiValueSetMap(this, e);
				valueSetMaps.put(v.getName(), v);
			}
		}
	}

	public static void main(String[] args) {
		File f = new File("MdmiValueSetTest.valuesets.xml");
		MdmiValueSetsHandler vsh = new MdmiValueSetsHandler(f);
		MdmiValueSet vs1 = new MdmiValueSet(vsh, "Colors");
		vs1.addValue("RED", null);
		vs1.addValue("BLUE", null);
		vs1.addValue("WHITE", null);
		vsh.addValueSet(vs1);
		MdmiValueSet vs2 = new MdmiValueSet(vsh, "ColorCodes");
		vs2.addValue("R", null);
		vs2.addValue("B", null);
		vs2.addValue("W", null);
		vsh.addValueSet(vs2);
		MdmiValueSetMap vsm1 = new MdmiValueSetMap(vsh, vs1, vs2);
		vsm1.addMapping("RED", "R");
		vsm1.addMapping("BLUE", "B");
		vsm1.addMapping("WHITE", "W");
		vsh.addValueSetMap(vsm1);
		MdmiValueSetMap vsm2 = new MdmiValueSetMap(vsh, vs2, vs1);
		vsm2.addMapping("R", "RED");
		vsm2.addMapping("B", "BLUE");
		vsm2.addMapping("W", "WHITE");
		vsh.addValueSetMap(vsm2);
		vsh.save();
	}
} // MdmiValueSetsHandler
