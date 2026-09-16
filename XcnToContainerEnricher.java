import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.mdmi.Bag;
import org.mdmi.ConversionRule;
import org.mdmi.DTCStructured;
import org.mdmi.Field;
import org.mdmi.MDMIBusinessElementReference;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIExpression;
import org.mdmi.MDMIFactory;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementRelationship;
import org.mdmi.SemanticElementSet;
import org.mdmi.util.MDMIResourceFactoryImpl;
import org.mdmi.util.MDMIResourceImpl;

public class XcnToContainerEnricher {

	private static MDMIDatatype containerType;
	private static MDMIDatatype stringType;
	private static MDMIDatatype personNameType;
	private static MDMIBusinessElementReference practitionerName;
	private static MDMIBusinessElementReference practitionerIdentifier;

	private static final Map<String, String> XCN_NAME_FIELDS = new HashMap<>();
	static {
		XCN_NAME_FIELDS.put("XCN.2", "family");
		XCN_NAME_FIELDS.put("XCN.3", "given");
		XCN_NAME_FIELDS.put("XCN.4", "middle");
		XCN_NAME_FIELDS.put("XCN.5", "suffix");
		XCN_NAME_FIELDS.put("XCN.6", "prefix");
		XCN_NAME_FIELDS.put("XCN.19", "PeriodEnd");
		XCN_NAME_FIELDS.put("XCN.20", "PeriodStart");
		XCN_NAME_FIELDS.put("XCN.21", "suffix");
	}

	public static void main(String[] args) throws IOException {
		String mapsDir = args.length > 0
				? args[0]
				: "/Users/seanmuir/git/com.imat.v2tofhir/src/main/resources/maps";

		File dir = new File(mapsDir);
		File[] files = dir.isFile()
				? new File[] { dir }
				: dir.listFiles((d, name) -> name.endsWith(".mdmi"));
		if (files == null || files.length == 0) {
			System.err.println("No .mdmi files found in " + mapsDir);
			return;
		}

		for (File file : files) {
			process(file);
		}
	}

	private static void process(File file) throws IOException {
		System.out.println("Processing " + file.getName());

		MDMIPackage.eINSTANCE.getMessageGroup();

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(MDMIPackage.eNS_URI, MDMIPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("mdmi", new MDMIResourceFactoryImpl());

		URI uri = URI.createFileURI(file.getAbsolutePath());
		MDMIResourceImpl resource = (MDMIResourceImpl) resourceSet.getResource(uri, true);
		MessageGroup group = (MessageGroup) resource.getContents().get(0);

		MDMIDatatype xcnType = group.getDatatype("XCN");
		containerType = group.getDatatype("Container");
		stringType = group.getDatatype("String");
		personNameType = group.getDatatype("PersonName");
		practitionerName = findBusinessElement(group, "PractitionerName");
		practitionerIdentifier = findBusinessElement(group, "PractitionerIdentifier");
		if (containerType == null || stringType == null || personNameType == null) {
			System.err.println("  Container, String or PersonName datatype missing, skipping");
			return;
		}
		if (practitionerName == null || practitionerIdentifier == null) {
			System.err.println("  PractitionerName or PractitionerIdentifier business element missing, skipping");
			return;
		}

		int converted = 0;
		int rollups = 0;
		int identifiers = 0;
		int children = 0;
		for (MessageModel model : group.getModels()) {
			SemanticElementSet elementSet = model.getElementSet();
			if (elementSet == null) {
				continue;
			}
			for (SemanticElement se : new ArrayList<>(elementSet.getSemanticElements())) {
				if (se.getDatatype() == xcnType) {
					se.setDatatype(containerType);
					converted++;
					System.out.println("  " + se.getName() + " -> Container");
				}
				if (se.getDatatype() == containerType && isXcnContainer(se)) {
					children += ensureChildren(se, elementSet, xcnType);
					if (!hasChild(se, "XCNName")) {
						addXcnNameRollup(se, elementSet);
						rollups++;
					}
				}
			}
			if (model.getSyntaxModel() != null && model.getSyntaxModel().getRoot() instanceof Bag) {
				identifiers += addIdentifierMappings((Bag) model.getSyntaxModel().getRoot(), elementSet);
			}
		}

		if (converted > 0 || rollups > 0 || identifiers > 0 || children > 0) {
			Map<Object, Object> options = new HashMap<>();
			options.put(XMLResource.OPTION_FLUSH_THRESHOLD, Integer.valueOf(0x01000000));
			options.put(XMLResource.OPTION_USE_FILE_BUFFER, Boolean.TRUE);
			resource.save(options);
			System.out.println("  Saved " + converted + " converted, " + rollups + " XCNName rollup(s), " + identifiers +
				" PractitionerIdentifier mapping(s), " + children + " child element(s) in " + file.getName());
		} else {
			System.out.println("  No changes");
		}
	}

	private static boolean isXcnContainer(SemanticElement se) {
		Node syntaxNode = se.getSyntaxNode();
		if (!(syntaxNode instanceof Bag)) {
			return false;
		}
		for (Node child : ((Bag) syntaxNode).getNodes()) {
			if (child.getLocation() != null && child.getLocation().startsWith("XCN.")) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasChild(SemanticElement se, String name) {
		for (SemanticElement child : se.getChildren()) {
			if (name.equals(child.getName())) {
				return true;
			}
		}
		return false;
	}

	private static void addXcnNameRollup(SemanticElement parent, SemanticElementSet elementSet) {
		SemanticElement rollup = MDMIFactory.eINSTANCE.createSemanticElement();
		rollup.setName("XCNName");
		rollup.setDatatype(personNameType);
		parent.getChildren().add(rollup);
		elementSet.getSemanticElements().add(rollup);

		for (SemanticElement child : parent.getChildren()) {
			Node node = child.getSyntaxNode();
			if (node == null) {
				continue;
			}
			String field = XCN_NAME_FIELDS.get(node.getLocation());
			if (field == null) {
				continue;
			}
			SemanticElementRelationship rel = MDMIFactory.eINSTANCE.createSemanticElementRelationship();
			rel.setName(child.getName());
			String rule = "value.getXValue().addValue('" + field + "', '<<LOCALSEMANTICVALUE>>>' );";
			if ("family".equals(field)) {
				rule = "value.getXValue().addValue('family', '<<LOCALSEMANTICVALUE>>>' ).getValue('FN1');";
			}
			rel.setRule(rule);
			rel.setContext(rollup);
			rel.setRelatedSemanticElement(child);
			rollup.getRelationships().add(rel);
		}

		MDMIExpression expression = MDMIFactory.eINSTANCE.createMDMIExpression();
		expression.setExpression("SEMANTICROLLUP");
		expression.setLanguage("JavaScript");
		rollup.setComputedValue(expression);

		ConversionRule from = MDMIFactory.eINSTANCE.createConversionRule();
		from.setName("MDMI2Message4XCNName");
		from.setBusinessElement(practitionerName);
		rollup.getMapFromMdmi().add(from);

		ConversionRule to = MDMIFactory.eINSTANCE.createConversionRule();
		to.setName("Message2MDMI4XCNName");
		to.setBusinessElement(practitionerName);
		rollup.getMapToMdmi().add(to);
	}

	private static int addIdentifierMappings(Bag bag, SemanticElementSet elementSet) {
		int count = 0;
		for (Node node : bag.getNodes()) {
			if ("XCN.1".equals(node.getLocation())) {
				SemanticElement se = node.getSemanticElement();
				if (se == null) {
					se = createSemanticElement(node, stringType);
					se.setName("PractitionerIdentifier");
					elementSet.getSemanticElements().add(se);
					SemanticElement parentSe = bag.getSemanticElement();
					if (parentSe != null && !parentSe.getChildren().contains(se)) {
						parentSe.getChildren().add(se);
					}
				}
				count += ensureIdentifierMaps(se);
			}
			if (node instanceof Bag) {
				count += addIdentifierMappings((Bag) node, elementSet);
			}
		}
		return count;
	}

	private static int ensureIdentifierMaps(SemanticElement se) {
		int added = 0;
		if (!hasMapRule(se.getMapFromMdmi(), "mapInstanceIdentifierToString")) {
			ConversionRule from = MDMIFactory.eINSTANCE.createConversionRule();
			from.setName("MDMI2Message4" + se.getName());
			from.setBusinessElement(practitionerIdentifier);
			from.setRule("DATATYPEMAP:mapInstanceIdentifierToString");
			se.getMapFromMdmi().add(from);
			added++;
		}
		if (!hasMapRule(se.getMapToMdmi(), "mapStringToInstanceIdentifier")) {
			ConversionRule to = MDMIFactory.eINSTANCE.createConversionRule();
			to.setName("Message2MDMI4" + se.getName());
			to.setBusinessElement(practitionerIdentifier);
			to.setRule("DATATYPEMAP:mapStringToInstanceIdentifier");
			se.getMapToMdmi().add(to);
			added++;
		}
		return added;
	}

	private static boolean hasMapRule(java.util.List<ConversionRule> rules, String rule) {
		for (ConversionRule r : rules) {
			if (r.getRule() != null && r.getRule().contains(rule)) {
				return true;
			}
		}
		return false;
	}

	private static MDMIBusinessElementReference findBusinessElement(MessageGroup group, String name) {
		if (group.getDomainDictionary() == null) {
			return null;
		}
		for (MDMIBusinessElementReference ber : group.getDomainDictionary().getBusinessElements()) {
			if (name.equals(ber.getName())) {
				return ber;
			}
		}
		return null;
	}

	private static int ensureChildren(SemanticElement se, SemanticElementSet elementSet, MDMIDatatype fieldSource) {
		Node syntaxNode = se.getSyntaxNode();
		if (!(syntaxNode instanceof Bag)) {
			return 0;
		}
		int changed = 0;
		for (Node child : ((Bag) syntaxNode).getNodes()) {
			MDMIDatatype childType = resolveFieldDatatype(fieldSource, child);
			SemanticElement childSe = child.getSemanticElement();
			if (childSe == null) {
				childSe = createSemanticElement(child, childType);
				elementSet.getSemanticElements().add(childSe);
				changed++;
			} else if (childType != containerType && childSe.getDatatype() == containerType) {
				childSe.setDatatype(childType);
				changed++;
			}
			if (!se.getChildren().contains(childSe)) {
				se.getChildren().add(childSe);
				changed++;
			}
			if (child instanceof Bag) {
				changed += pruneDeep((Bag) child, se, elementSet);
			}
		}
		return changed;
	}

	private static int pruneDeep(Bag bag, SemanticElement container, SemanticElementSet elementSet) {
		int changed = 0;
		for (Node node : bag.getNodes()) {
			if (node instanceof Bag) {
				changed += pruneDeep((Bag) node, container, elementSet);
			}
			SemanticElement deepSe = node.getSemanticElement();
			if (deepSe == null) {
				continue;
			}
			if (isGenerated(deepSe)) {
				node.setSemanticElement(null);
				SemanticElement parent = deepSe.getParent();
				if (parent != null) {
					parent.getChildren().remove(deepSe);
				}
				elementSet.getSemanticElements().remove(deepSe);
				changed++;
			} else if (!container.getChildren().contains(deepSe)) {
				container.getChildren().add(deepSe);
				changed++;
			}
		}
		return changed;
	}

	private static boolean isGenerated(SemanticElement se) {
		return "99999999".equals(se.getDescription()) &&
			"LOCAL".equals(se.getElementType()) &&
			se.getMapFromMdmi().isEmpty() && se.getMapToMdmi().isEmpty() &&
			se.getRelationships().isEmpty() && se.getBusinessRules().isEmpty() &&
			se.getDataRules().isEmpty() && se.getComputedValue() == null;
	}

	private static MDMIDatatype resolveFieldDatatype(MDMIDatatype fieldSource, Node node) {
		if (fieldSource instanceof DTCStructured && node.getFieldName() != null) {
			for (Field field : ((DTCStructured) fieldSource).getFields()) {
				if (node.getFieldName().equals(field.getName())) {
					return field.getDatatype();
				}
			}
		}
		return node instanceof Bag
				? containerType
				: stringType;
	}

	private static SemanticElement createSemanticElement(Node node, MDMIDatatype datatype) {
		SemanticElement se = MDMIFactory.eINSTANCE.createSemanticElement();
		se.setName(node.getName());
		se.setDescription("99999999");
		se.setElementType("LOCAL");
		se.setDatatype(datatype);
		node.setSemanticElement(se);
		return se;
	}
}
