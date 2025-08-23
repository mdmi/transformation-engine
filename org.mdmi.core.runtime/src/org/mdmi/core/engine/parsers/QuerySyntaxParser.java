/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.parsers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.mdmi.Bag;
import org.mdmi.LeafSyntaxTranslator;
import org.mdmi.MessageModel;
import org.mdmi.MessageSyntaxModel;
import org.mdmi.Node;
import org.mdmi.core.ISyntacticParser;
import org.mdmi.core.ISyntaxNode;
import org.mdmi.core.MdmiException;
import org.mdmi.core.MdmiMessage;
import org.mdmi.core.engine.YBag;
import org.mdmi.core.engine.YLeaf;
import org.mdmi.core.engine.YNode;
import org.mdmi.core.util.StringUtil;

/**
 * @author goancea
 *         [http[s]://]domain/ResourceType?name=value&...
 */
public class QuerySyntaxParser implements ISyntacticParser {
	public static String BASE = null;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.ISyntacticParser#parse(org.mdmi.model.MessageModel,
	 * org.mdmi.MdmiMessage)
	 */
	@Override
	public ISyntaxNode parse(MessageModel mdl, MdmiMessage msg) {
		if (mdl == null || msg == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		byte[] data = msg.getData();
		if (data == null) {
			return null; // <---- NOTE message can be empty
		}

		YNode yroot = null;
		try {
			Query q = parseQueryString(StringUtil.getString(data));
			if (null == q) {
				return null;
			}
			MessageSyntaxModel syn = mdl.getSyntaxModel();
			Node node = syn.getRoot();
			String nodeName = node.getName(); // for the root node it is its name
			if (q.queryStem.toLowerCase().indexOf(nodeName.toLowerCase()) < 0) {
				throw new MdmiException("Root node mismatch, found {0}, expected {1}", q.queryStem, nodeName);
			}
			yroot = new YBag((Bag) node, null);
			parseBag((YBag) yroot, q);
		} catch (MdmiException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MdmiException(ex, "Syntax.parse(): unexpected exception");
		}
		return yroot;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.mdmi.ISyntacticParser#serialize(org.mdmi.model.MessageModel,
	 * org.mdmi.MdmiMessage, org.mdmi.ISyntaxNode)
	 */
	@Override
	public void serialize(MessageModel mdl, MdmiMessage msg, ISyntaxNode yroot, String transformComment) {
		if (mdl == null || msg == null || yroot == null) {
			throw new IllegalArgumentException("Null argument!");
		}
		try {
			MessageSyntaxModel syn = mdl.getSyntaxModel();
			Node node = syn.getRoot();
			if (node != yroot.getNode()) {
				throw new MdmiException(
					"Invalid serialization attempt, expected node {0} forund node {1}", node.getName(),
					yroot.getNode().getName());
			}
			String queryStem = location(node); // for the root node it is its name
			Query q = new Query(getBaseUri(), queryStem);
			serializeBag((YBag) yroot, q);
			msg.setData(StringUtil.getBytes(q.toString()));
		} catch (MdmiException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MdmiException(ex, "Syntax.serialize(): unexpected exception");
		}
	}

	private void parseBag(YBag yroot, Query q) {
		Bag rootBag = yroot.getBag(); // descriptor of the contents
		Collection<Node> nodes = rootBag.getNodes();
		for (Iterator<Node> iterator = nodes.iterator(); iterator.hasNext();) {
			Node node = iterator.next();
			String name = location(node);
			LeafSyntaxTranslator leaf = (LeafSyntaxTranslator) node;
			if (name.equalsIgnoreCase("baseUri")) {
				YLeaf y = new YLeaf(leaf, yroot);
				yroot.addYNode(y);
				y.setValue(q.domain);
			} else {
				Param p = q.getParam(name);
				if (null != p) {
					YLeaf y = new YLeaf(leaf, yroot);
					yroot.addYNode(y);
					y.setValue(p.value);
				}
			}
		}
	}

	private void serializeBag(YBag yroot, Query q) {
		Bag rootBag = yroot.getBag();
		EList<Node> nodes = rootBag.getNodes();
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			String name = location(node);
			if (name.equalsIgnoreCase("baseUri")) {
				continue;
			}
			List<YNode> ynodes = yroot.getYNodesForNode(node);
			for (int j = 0; j < ynodes.size(); j++) {
				YLeaf y = (YLeaf) ynodes.get(j);
				Param p = new Param(y.getLeaf().getName(), y.getValue());
				q.params.add(p);
			}
		}
	}

	public static String getBaseUri() {
		if (StringUtil.isNullOrEmpty(BASE)) {
			try {
				BASE = System.getenv("FHIR_QUERY_BASE_URI");
			} catch (Exception ex) {
			}
		}
		return BASE;
	}

	// [http[s]://]domain/path?name=value&...
	public static Query parseQueryString(String q) {
		if (StringUtil.isNullOrEmpty(q)) {
			return null;
		}

		q = q.trim();
		if (q.toLowerCase().startsWith("http://")) {
			q = q.substring(7);
		} else if (q.toLowerCase().startsWith("https://")) {
			q = q.substring(8);
		}

		int p = q.indexOf('?');
		if (p <= 0) {
			throw new MdmiException("Invalid query string (missing ?): " + q);
		}
		String s = q.substring(0, p); // domain/path
		String z = q.substring(p + 1); // name=value&...

		int i = s.indexOf('/');
		if (i <= 0) {
			throw new MdmiException("Invalid query string (missing /queryStem): " + q);
		}
		String qs = i + 1 < s.length()
				? s.substring(i + 1)
				: "";
		s = s.substring(0, i);
		Query r = new Query(s.substring(0, i), qs);

		while (0 < z.length()) {
			i = z.indexOf('&');
			String pr;
			if (i < 0) {
				pr = z;
				z = "";
			} else {
				pr = z.substring(0, i);
				z = z.substring(i + 1);
			}
			i = pr.indexOf('=');
			if (i <= 0) {
				throw new MdmiException("Invalid parameter " + pr + " in query string: " + q);
			}
			String v = i + 1 < pr.length()
					? pr.substring(i + 1)
					: "";
			Param prm = new Param(pr.substring(0, i), decodeUriString(v));
			r.params.add(prm);
		}
		return r;
	}

	public static class Param {
		public String name;

		public String value;

		public Param() {
		}

		public Param(String name, String value) {
			this.name = name;
			this.value = value;
		}
	} // Param

	public static class Query {
		public String domain;

		public String queryStem;

		public final ArrayList<Param> params = new ArrayList<>();

		public Query() {
		}

		public Query(String domain, String queryStem) {
			this.domain = domain;
			this.queryStem = queryStem;
		}

		public Param getParam(String paramName) {
			for (int i = 0; i < params.size(); i++) {
				Param p = params.get(i);
				if (p.name.equalsIgnoreCase(paramName)) {
					return p;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer(domain + "/" + queryStem + "?");
			for (int i = 0; i < params.size(); i++) {
				Param p = params.get(i);
				if (0 < i) {
					sb.append('&');
				}
				sb.append(p.name).append('=').append(encodeUriString(p.value));
			}
			return sb.toString();
		}
	} // Query

	static String location(Node node) {
		String location = node.getLocation();
		if (location == null || location.trim().length() <= 0) {
			return null;
		}
		return location.trim();
	}

	private static String encodeUriString(String s) {
		if (StringUtil.isNullOrEmpty(s)) {
			return s;
		}
		String result;
		try {
			result = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException e) {
			result = s;
		}
		return result;
	}

	private static String decodeUriString(String s) {
		if (StringUtil.isNullOrEmpty(s)) {
			return s;
		}
		String result;
		try {
			result = URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			result = s;
		}
		return result;
	}

	public static void main(String[] args) {
		basicTests();
	}

	private static void basicTests() {
		BASE = "fhir-open-api-dstu2.smarthealthit.org";

		String t1 = "http://fhir-open-api-dstu2.smarthealthit.org/Patient?name=Smith";
		String t2 = "https://fhir-open-api-dstu2.smarthealthit.org/Patient?family=Smith&given=Joe";
		String t3 = "fhir-open-api-dstu2.smarthealthit.org/Patient?identifier=23";

		parseQueryString(t1);
		parseQueryString(t2);
		parseQueryString(t3);
	}
} // FhirQuerySyntaxParser
