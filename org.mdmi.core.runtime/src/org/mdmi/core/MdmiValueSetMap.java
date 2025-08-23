/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

package org.mdmi.core;

import java.util.ArrayList;

import org.mdmi.core.MdmiValueSet.Value;
import org.mdmi.core.util.XmlUtil;
import org.w3c.dom.Element;

public class MdmiValueSetMap {
	public static final String TAG = "valueSetMap";

	private static final String MAPPINGS_TAG = "mappings";

	public class Mapping {
		public static final String TAG = "mapping";

		private Value source;

		private Value target;

		public Mapping(String source, String target) {
			if (null == source || source.trim().length() <= 0) {
				throw new IllegalArgumentException("Source is null");
			}
			if (null == target || target.trim().length() <= 0) {
				throw new IllegalArgumentException("Target is null");
			}
			if (null == sourceSet) {
				throw new IllegalArgumentException("Source set is null!");
			}
			if (null == targetSet) {
				throw new IllegalArgumentException("Target set is null!");
			}
			Value v = sourceSet.getValue(source);
			if (null == v) {
				throw new IllegalArgumentException("Source set does not contain value " + source);
			}
			this.source = v;
			v = targetSet.getValue(target);
			if (null == v) {
				throw new IllegalArgumentException("Target set does not contain value " + target);
			}
			this.target = v;
		}

		public Mapping(Value source, Value target) {
			if (null == source) {
				throw new IllegalArgumentException("Source is null");
			}
			if (null == target) {
				throw new IllegalArgumentException("Target is null");
			}
			this.source = source;
			this.target = target;
		}

		protected Mapping(Element root) {
			fromXml(root);
		}

		public Value getSource() {
			return source;
		}

		public void setSource(Value source) {
			if (null == source) {
				throw new IllegalArgumentException("Source is null");
			}
			this.source = source;
		}

		public Value getTarget() {
			return target;
		}

		public void setTarget(Value target) {
			if (null == target) {
				throw new IllegalArgumentException("Target is null");
			}
			this.target = target;
		}

		protected void fromXml(Element root) {
			if (null == sourceSet) {
				throw new IllegalArgumentException("Source set is null, must set it first!");
			}
			if (null == targetSet) {
				throw new IllegalArgumentException("Target set is null, must set it first!");
			}
			String src = root.getAttribute("source");
			String trg = root.getAttribute("target");
			source = sourceSet.getValue(src);
			target = targetSet.getValue(trg);
		}

		protected void toXml(Element owner) {
			Element root = XmlUtil.addElement(owner, TAG);
			root.setAttribute("source", source.getCode());
			root.setAttribute("target", target.getCode());
		}
	} // Mapping

	private MdmiValueSetsHandler owner;

	private MdmiValueSet sourceSet;

	private MdmiValueSet targetSet;

	private ArrayList<Mapping> mappings;

	public MdmiValueSetMap(MdmiValueSetsHandler owner, MdmiValueSet sourceSet, MdmiValueSet targetSet) {
		if (null == owner) {
			throw new IllegalArgumentException("Owner cannot be null!");
		}
		if (null == sourceSet) {
			throw new IllegalArgumentException("Source set is null!");
		}
		if (null == targetSet) {
			throw new IllegalArgumentException("Target set is null!");
		}
		this.owner = owner;
		this.sourceSet = sourceSet;
		this.targetSet = targetSet;
		mappings = new ArrayList<>();
	}

	protected MdmiValueSetMap(MdmiValueSetsHandler owner, Element root) {
		if (null == owner) {
			throw new IllegalArgumentException("Owner cannot be null!");
		}
		this.owner = owner;
		mappings = new ArrayList<>();
		fromXml(root);
	}

	public String getName() {
		return getMapName(sourceSet.getName(), targetSet.getName());
	}

	public static String getMapName(String sourceSetName, String targetSetName) {
		return sourceSetName + "." + targetSetName;
	}

	public MdmiValueSet getSourceSet() {
		return sourceSet;
	}

	public void setSourceSet(MdmiValueSet sourceSet) {
		if (sourceSet != this.sourceSet) {
			mappings.clear();
		}
		this.sourceSet = sourceSet;
	}

	public MdmiValueSet getTargetSet() {
		return targetSet;
	}

	public void setTargetSet(MdmiValueSet targetSet) {
		if (targetSet != this.targetSet) {
			mappings.clear();
		}
		this.targetSet = targetSet;
	}

	public ArrayList<Mapping> getMappings() {
		return mappings;
	}

	public Mapping getMappingBySource(String sourceCode) {
		for (Mapping map : mappings) {
			if (map.source.getCode().equalsIgnoreCase(sourceCode)) {
				return map;
			}
		}
		return null;
	}

	public void addMapping(Mapping mapping) {
		if (null == mapping) {
			throw new IllegalArgumentException("Mapping is null");
		}
		if (null == sourceSet) {
			throw new IllegalArgumentException("Source set is null, must set it first!");
		}
		if (null == targetSet) {
			throw new IllegalArgumentException("Target set is null, must set it first!");
		}
		if (!containsMapping(mapping)) {
			if (!sourceSet.containsValue(mapping.source.getCode())) {
				throw new IllegalArgumentException("Invalid mapping source not in the source set!");
			}
			if (!targetSet.containsValue(mapping.target.getCode())) {
				throw new IllegalArgumentException("Invalid mapping target not in the target set!");
			}
			this.mappings.add(mapping);
		}
	}

	public void addMapping(String srcCode, String trgCode) {
		if (null == srcCode || srcCode.trim().length() <= 0) {
			throw new IllegalArgumentException("Source code is null!");
		}
		if (null == trgCode || trgCode.trim().length() <= 0) {
			throw new IllegalArgumentException("Target code is null!");
		}
		if (null == sourceSet) {
			throw new IllegalArgumentException("Source set is null, must set it first!");
		}
		if (null == targetSet) {
			throw new IllegalArgumentException("Target set is null, must set it first!");
		}
		Mapping mapping = new Mapping(srcCode, trgCode);
		if (!containsMapping(mapping)) {
			this.mappings.add(mapping);
		}
	}

	public void removeMapping(Mapping mapping) {
		if (containsMapping(mapping)) {
			this.mappings.remove(mapping);
		}
	}

	public boolean containsMapping(Mapping mapping) {
		for (Mapping m : mappings) {
			if (m.source == mapping.source && m.target == mapping.target) {
				return true;
			}
		}
		return false;
	}

	protected void fromXml(Element root) {
		String src = root.getAttribute("sourceSet");
		sourceSet = owner.getValueSet(src);
		if (null == sourceSet) {
			throw new IllegalArgumentException("Source set not found: " + src);
		}
		String trg = root.getAttribute("targetSet");
		targetSet = owner.getValueSet(trg);
		if (null == targetSet) {
			throw new IllegalArgumentException("Target set not found: " + trg);
		}
		Element vs = XmlUtil.getElement(root, MAPPINGS_TAG);
		if (null != vs) {
			ArrayList<Element> evs = XmlUtil.getElements(vs, Mapping.TAG);
			for (int i = 0; i < evs.size(); i++) {
				Element e = evs.get(i);
				Mapping m = new Mapping(e);
				mappings.add(m);
			}
		}
	}

	protected void toXml(Element owner) {
		Element root = XmlUtil.addElement(owner, TAG);
		root.setAttribute("sourceSet", sourceSet.getName());
		root.setAttribute("targetSet", targetSet.getName());
		Element ms = XmlUtil.addElement(root, MAPPINGS_TAG);
		for (Mapping m : mappings) {
			m.toXml(ms);
		}
	}
} // MdmiValueSetMap
