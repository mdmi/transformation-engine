/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.mdmi.Bag;
import org.mdmi.ConversionRule;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIFactory;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementRelationship;

/**
 * @author seanmuir
 *
 */
public class MDMIUtil {

	public static MessageGroup load(String modelUri) {
		MDMIPackage.eINSTANCE.getMessageGroup();
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(MDMIPackage.eNS_URI, MDMIPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("mdmi", new MDMIResourceFactoryImpl());
		MDMIResourceImpl mdmiResourceImp = (MDMIResourceImpl) resourceSet.getResource(
			URI.createFileURI(modelUri), true);
		MessageGroup messageGroup = (MessageGroup) mdmiResourceImp.getContents().get(0);
		return messageGroup;
	}

	public static MessageGroup loadFromWorkspace(String modelUri) {
		MDMIPackage.eINSTANCE.getMessageGroup();
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(MDMIPackage.eNS_URI, MDMIPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("mdmi", new MDMIResourceFactoryImpl());
		MDMIResourceImpl mdmiResourceImp = (MDMIResourceImpl) resourceSet.getResource(
			URI.createPlatformResourceURI(modelUri, false), true);
		MessageGroup messageGroup = (MessageGroup) mdmiResourceImp.getContents().get(0);
		return messageGroup;
	}

	/**
	 * @param inputStream
	 * @throws IOException
	 */
	public static MessageGroup load(InputStream inputStream) throws IOException {
		MDMIPackage.eINSTANCE.getMessageGroup();
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(MDMIPackage.eNS_URI, MDMIPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("mdmi", new MDMIResourceFactoryImpl());
		Resource resource = resourceSet.createResource(URI.createURI("model.mdmi"));
		resource.load(inputStream, null);
		// MDMIResourceImpl mdmiResourceImp = (MDMIResourceImpl) resource.getContents().get(0);
		MessageGroup messageGroup = (MessageGroup) resource.getContents().get(0);
		return messageGroup;

	}

	// --------------------------------------------
	// Datatypes
	// ------------------------------------------------

	/** Determine whether a datatype is used by a business element */
	public static boolean isReferentDatatype(MDMIDatatype datatype) {
		if (datatype.eContainer() instanceof MessageGroup) {
			MessageGroup group = (MessageGroup) datatype.eContainer();
			return isReferentDatatype(group, datatype);
		}
		return false;
	}

	/** Determine whether a datatype is used by a business element */
	public static boolean isReferentDatatype(MessageGroup messageGroup, MDMIDatatype datatype) {
		if (datatype == null) {
			return false;
		}
		// search business elements
		String typeName = datatype.getTypeName();
		for (MDMIBusinessElementReference ber : messageGroup.getDomainDictionary().getBusinessElements()) {
			// did we find one?
			if (ber.getReferenceDatatype() != null &&
					typeName.equalsIgnoreCase(ber.getReferenceDatatype().getTypeName())) {
				// found it
				return true;
			}
		}

		return false;
	}

	// public static List<MDMIBusinessElementReference> calculateReferences(MessageModel left, MessageModel right) {
	//
	// // MDMIBusinessElementReference[] found = WebServiceUtillity.findAllMDMIBusinessElementReferences(null, 0, null);
	//
	// HashMap<String, MDMIBusinessElementReference> elements = new HashMap<>();
	//
	// for (SemanticElement semanticElement : left.getElementSet().getSemanticElements()) {
	//
	// for (ConversionRule tse : semanticElement.getMapToMdmi()) {
	//
	// if (tse.getBusinessElement() != null) {
	// if (!elements.containsKey(tse.getBusinessElement().getUniqueIdentifier())) {
	// elements.put(tse.getBusinessElement().getUniqueIdentifier(), tse.getBusinessElement());
	// }
	// }
	//
	// }
	//
	// }
	//
	// for (SemanticElement semanticElement : right.getElementSet().getSemanticElements()) {
	//
	// for (ConversionRule tse : semanticElement.getMapToMdmi()) {
	//
	// if (tse.getBusinessElement() != null) {
	// if (!elements.containsKey(tse.getBusinessElement().getUniqueIdentifier())) {
	// elements.put(tse.getBusinessElement().getUniqueIdentifier(), tse.getBusinessElement());
	// }
	// }
	//
	// }
	//
	// }
	// List<MDMIBusinessElementReference> asdf = org.eclipse.ocl.util.CollectionUtil.createNewSequence();
	//
	// asdf.addAll(elements.values());
	//
	// return asdf;
	// // return org.eclipse.ocl.util.CollectionUtil.createNewSequence().addAll(elements.values());
	//
	// }

	public static SemanticElement searchForRollUp(SemanticElement rollup, SemanticElement semanticElement) {

		for (SemanticElementRelationship ser : semanticElement.getRelationships()) {

			if (ser.getRelatedSemanticElement() != null && ser.getRelatedSemanticElement().equals(rollup)) {
				return semanticElement;
			}

		}

		for (SemanticElement se : semanticElement.getChildren()) {
			SemanticElement result = searchForRollUp(rollup, se);
			if (result != null) {
				return result;
			}
		}

		return null;

	}

	public static SemanticElement getSemanticRollup(SemanticElement semanticElement) {

		if (semanticElement.getParent() != null) {

			SemanticElement theRoot = semanticElement.getParent();
			while (theRoot.getParent() != null) {
				theRoot = theRoot.getParent();
			}

			return searchForRollUp(semanticElement, theRoot);
		}

		return null;
		//
		// for (SemanticElement se : semanticElement.getChildren()) {
		//
		// semanticElement.getChildren();

	}

	public static String getSemanticName(SemanticElement semanticElement) {
		if (semanticElement != null) {
			String semanticName = semanticElement.getName();
			if (semanticName != null) {
				return semanticName.replaceAll("[0-9]", "");
			}

		}
		return "null";
	}

	public static String getSemanticRule(SemanticElement semanticElement) {

		if (semanticElement != null && semanticElement.getSyntaxNode() != null) {
			String rule = (semanticElement.getSyntaxNode().getLocation() != null
					? semanticElement.getSyntaxNode().getLocation()
					: "");
			return rule.replace(rule.split("\\[")[0], "").replace("not(@nullFlavor) and ", "").replace(
				"[not(@nullFlavor)]", "");

		}
		return "";

		// Stack<String> textStack = new Stack<String>();
		//
		// // String path = "";
		// // semanticElement.getSyntaxNode().getLocation();
		// SemanticElement current = semanticElement;
		// while (current != null) {
		// if (current.getSyntaxNode() != null) {
		//
		// textStack.push((current.getSyntaxNode().getLocation() != null
		// ? "/" + current.getSyntaxNode().getLocation()
		// : ""));
		// }
		// // path = current.getSyntaxNode().getLocation() + "/" + semanticElement.getSyntaxNode().getLocation();
		// current = current.getParent();
		// break;
		// }
		//
		// StringBuilder builder = new StringBuilder();
		// while (!textStack.empty()) {
		// builder.append(textStack.pop().replace("not(@nullFlavor) and ", "").replace("[not(@nullFlavor)]", ""));
		// }
		//
		// // get the final string
		// return builder.toString();

	}

	public String getContainerName(Node node) {

		// StringBuffer parentContainer= new StringBuffer();
		String prefix = "";
		if (node.getSemanticElement() != null && node.getSemanticElement().getParent() != null &&
				node.getSemanticElement().getParent().getSyntaxNode() != null) {
			Node parentName = node.getSemanticElement().getParent().getSyntaxNode();
			if (parentName.getName() != null) {
				String[] r = parentName.getName().split("(?=\\p{Lu})");
				StringBuffer sb = new StringBuffer();
				for (String r2 : r) {
					sb.append(Character.toUpperCase(r2.charAt(0)) + r2.substring(1)).append(" ");
				}
				prefix = sb.toString() + "/";
			} else {
				prefix = node.getLocation() + "/";
			}
		}

		if (node.getName() != null) {
			String[] r = node.getName().split("(?=\\p{Lu})");
			StringBuffer sb = new StringBuffer();
			for (String r2 : r) {
				sb.append(Character.toUpperCase(r2.charAt(0)) + r2.substring(1)).append(" ");
			}
			return prefix + sb.toString();
		} else {
			return prefix + node.getLocation();
		}

	}

	private static void sort(Bag bag) {
		boolean shouldSort = true;
		for (Node node : bag.getNodes()) {
			if (node instanceof Bag) {
				sort((Bag) node);
			}

			if (node.getDescription() == null || node.getDescription().length() == 0) {
				shouldSort = false;
			}
		}

		Comparator<? super Node> rimCompare = new Comparator<Node>() {

			public int compare(Node o1, Node o2) {
				return Integer.valueOf(o1.getDescription()).compareTo(Integer.valueOf(o2.getDescription()));
			}

		};

		if (shouldSort) {
			ECollections.sort(bag.getNodes(), rimCompare);
		}
	}

	public static List<Node> getNodes(Bag bag) {
		sort(bag);
		return bag.getNodes();
		// StringBuffer result = new StringBuffer();
		// // result.append("_").append(offset);
		// for (int i = 0; i < offset; i++) {
		// result.append(" ");
		// }
		// return result.toString();
	}

	public String getOffset(Integer offset) {
		StringBuffer result = new StringBuffer();
		// result.append("_").append(offset);
		for (int i = 0; i < offset; i++) {
			result.append(" ");
		}
		return result.toString();
	}

	public Bag walkbag(Bag b) {
		Bag result = null;
		// if (false) {
		//
		// }
		for (Node n : b.getNodes()) {
			if (n instanceof Bag) {
				Bag bb = walkbag((Bag) n);
				if (bb != null) {
					return b;
				}

			}
		}
		return result;
	}

	boolean ismapped(Bag bag, List<MDMIBusinessElementReference> elements) {
		boolean isMapped = false;
		if (bag.getSemanticElement() != null) {
			for (ConversionRule tbe : bag.getSemanticElement().getMapToMdmi()) {
				if (tbe.getBusinessElement() != null && tbe.getBusinessElement().getUniqueIdentifier() != null) {
					for (MDMIBusinessElementReference ber : elements) {
						if (tbe.getBusinessElement().getUniqueIdentifier().equals(ber.getUniqueIdentifier())) {
							isMapped = true;
						}
					}
				}
			}
		}
		return isMapped;
	}

	Bag getSP(Bag bag, List<MDMIBusinessElementReference> elements) {
		if (ismapped(bag, elements)) {
			return bag;
		} else {
			for (Node n : bag.getNodes()) {
				if (n instanceof Bag) {
					Bag b = getSP((Bag) n, elements);
					if (b != null) {
						return b;
					}
				}
			}
			return null;
		}
	}

	public Bag getStartingPoint(Node bag, List<MDMIBusinessElementReference> elements) {
		Bag b = (Bag) bag;

		Bag result = getSP(b, elements);
		// if (b.getSemanticElement() != null) {
		//
		// for (ToBusinessElement tbe : bag.getSemanticElement().getFromMdmi()) {
		// if (tbe.getBusinessElement() != null && tbe.getBusinessElement().getUniqueIdentifier() != null) {
		// for (MDMIBusinessElementReference ber : elements) {
		// if (tbe.getBusinessElement().getUniqueIdentifier().equals(ber.getUniqueIdentifier())) {
		// result = b;
		// }
		// }
		// } else {
		// // if (tbe.getBusinessElement() != null && tbe.getBusinessElement().getName() != null &&
		// // tbe.getBusinessElement().getName().equals(ber.getName())) {
		// // results.add(se);
		// // }
		// }
		//
		// }
		//
		// // if (!bag.getSemanticElement().getToMdmi().isEmpty()) {
		// //
		// //// for (ToSemanticElement tse : bag.getSemanticElement().getToMdmi()) {
		// ////
		// //// }
		// //
		// // }
		//
		// }

		return result != null
				? result
				: b;
	}

	public String getLocation(Node node) {
		if (node != null && node.getLocation() != null) {

			String s = node.getLocation().split("\\[")[0];
			return s;
			// String[] r = s.split("(?=\\p{Lu})");
			// StringBuffer sb = new StringBuffer();
			// for (String r2 : r) {
			// sb.append(Character.toUpperCase(r2.charAt(0)) + r2.substring(1)).append(" ");
			// }
			//
			// return sb.toString();
		} else {
			return "";
		}

	}

	public String getRule(Node node) {

		if (node == null) {
			return "null";
		}
		if (node.getSemanticElement() != null && node.getSemanticElement().getComputedInValue() != null &&
				node.getSemanticElement().getComputedInValue().getExpression() != null) {
			String script = node.getSemanticElement().getComputedInValue().getExpression();
			if (script.contains("value.getXValue().setValue('")) {
				return script.replace("value.getXValue().setValue('", "").replace("');", "");
			} else {
				StringBuffer sb = new StringBuffer();
				String s[] = script.split(";");

				for (String s1 : s) {
					sb.append(
						s1.replace("value.getXValue().addValue('", "").replace(")", "").replace("', ", "=")).append(
							" ");

				}
				return sb.toString();
			}

			/**
			 * @TODO Run the script at some point
			 */

		}

		if (node != null && node.getLocation() != null) {
			node.getLocation().split("\\[");

			int index = node.getLocation().indexOf("[");

			if (index > -1) {
				String rule = node.getLocation(); // StringEscapeUtils.escapeXml(node.getLocation().substring(index));
				return rule.replace(rule.split("\\[")[0], "").replace("not(@nullFlavor) and ", "").replace(
					"[not(@nullFlavor)]", "");

				/*
				 * return rule.replace(rule.split("\\[")[0], "").replace("not(@nullFlavor) and ", "").replace(
				 * "[not(@nullFlavor)]", "");
				 */

				// StringBuffer sb = new StringBuffer();
				// for (int i = 1; i < n.length; i++) {
				// sb.append(n[i]);
				// }
				// // return sb.toString();
				// return StringEscapeUtils.escapeXml(
				// n[1].replace("not(@nullFlavor) and ", "").replace("[not(@nullFlavor)]", "").replace(
				// "not(@nullFlavor)", "").replaceAll("\\]", ""));
			} else {

				return "";
			}
		}
		return "";

	}

	public static String getSemanticPath(SemanticElement semanticElement) {

		Stack<String> textStack = new Stack<>();

		// String path = "";
		// semanticElement.getSyntaxNode().getLocation();
		SemanticElement current = semanticElement;

		// if (current != null) {
		// current = current.getParent();
		// }
		while (current != null) {
			if (current.getSyntaxNode() != null) {

				if (textStack.isEmpty()) {
					textStack.push(
						(current.getSyntaxNode().getLocation() != null
								? "/" + current.getSyntaxNode().getLocation().split("\\[")[0]
								: ""));
				} else {
					textStack.push(
						(current.getSyntaxNode().getLocation() != null
								? "/" + current.getSyntaxNode().getLocation()
								: ""));
				}

				// if (textStack.size() ==) {
				//
				// }
			}
			// path = current.getSyntaxNode().getLocation() + "/" + semanticElement.getSyntaxNode().getLocation();
			current = current.getParent();
		}

		StringBuilder builder = new StringBuilder();
		while (!textStack.empty()) {
			builder.append(textStack.pop().replace("not(@nullFlavor) and ", "").replace("[not(@nullFlavor)]", ""));
		}

		// get the final string
		return builder.toString();

	}

	public static String getInteropabilityMeasure(SemanticElement leftSE, SemanticElement rightSE) {

		if (leftSE == null || rightSE == null) {
			return "Incongruent";
		}

		if (leftSE.getName().equals("NONE") && rightSE.getName().equals("NONE")) {
			return "Incongruent - Not Mapped ";
		}
		if (leftSE.getName().equals("NONE")) {
			return "Incongruent - Missing in source";
		}

		if (rightSE.getName().equals("NONE")) {
			return "Incongruent - Missing in target";
		}

		if (leftSE.getPropertyQualifier().isEmpty() && !rightSE.getPropertyQualifier().isEmpty()) {
			return "Incongruent - Missing terminology in source";
		}

		if (!leftSE.getPropertyQualifier().isEmpty() && rightSE.getPropertyQualifier().isEmpty()) {
			return "Incongruent  - Missing terminology in target";
		}

		if (!leftSE.getPropertyQualifier().isEmpty() && !rightSE.getPropertyQualifier().isEmpty()) {
			return "Check Terminology";
		}

		return "Congruent";
	}

	public static List<SemanticElement> getTo(MessageModel mmessageModel, MDMIBusinessElementReference ber) {

		List<SemanticElement> results = new ArrayList<>();

		for (SemanticElement se : mmessageModel.getElementSet().getSemanticElements()) {
			for (ConversionRule tbe : se.getMapFromMdmi()) {

				if (tbe.getBusinessElement() != null && tbe.getBusinessElement().getUniqueIdentifier() != null &&
						tbe.getBusinessElement().getUniqueIdentifier().equals(ber.getUniqueIdentifier())) {
					results.add(se);
				} else {

					if (tbe.getBusinessElement() != null && tbe.getBusinessElement().getName() != null &&
							tbe.getBusinessElement().getName().equals(ber.getName())) {
						results.add(se);
					}
				}

			}

		}

		if (results.isEmpty()) {
			SemanticElement none = MDMIFactory.eINSTANCE.createSemanticElement();

			MDMIDatatype value = MDMIFactory.eINSTANCE.createMDMIDatatype();
			value.setTypeName("NONE");
			none.setDatatype(value);

			none.setName("NONE");
			none.setDescription("NONE");
			results.add(none);
		}

		return results;
	}

	public static List<SemanticElement> getFrom(MessageModel mmessageModel, MDMIBusinessElementReference ber) {

		List<SemanticElement> results = new ArrayList<>();

		for (SemanticElement se : mmessageModel.getElementSet().getSemanticElements()) {
			for (ConversionRule tse : se.getMapToMdmi()) {

				if (tse.getBusinessElement() != null &&
						tse.getBusinessElement().getUniqueIdentifier().equals(ber.getUniqueIdentifier())) {
					results.add(se);
				} else {

					if (tse.getBusinessElement() != null && tse.getBusinessElement().getName().equals(ber.getName())) {
						results.add(se);
					}
				}
			}

		}

		if (results.isEmpty()) {
			SemanticElement none = MDMIFactory.eINSTANCE.createSemanticElement();

			MDMIDatatype value = MDMIFactory.eINSTANCE.createMDMIDatatype();
			value.setTypeName("NONE");
			none.setDatatype(value);

			none.setName("NONE");
			none.setDescription("NONE");
			results.add(none);
		}

		return results;
	}

}
