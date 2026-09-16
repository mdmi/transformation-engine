import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.mdmi.Bag;
import org.mdmi.LeafSyntaxTranslator;
import org.mdmi.MDMIDatatype;
import org.mdmi.MDMIFactory;
import org.mdmi.MDMIPackage;
import org.mdmi.MessageGroup;
import org.mdmi.MessageModel;
import org.mdmi.Node;
import org.mdmi.SemanticElement;
import org.mdmi.SemanticElementSet;
import org.mdmi.util.MDMIResourceFactoryImpl;
import org.mdmi.util.MDMIResourceImpl;

public class ZSegmentMdmiEnricher {

	public static void main(String[] args) throws IOException {
		String input = args.length > 0
				? args[0]
				: "/Users/seanmuir/git/com.imat.v2tofhir/src/main/resources/maps/ORUR01CONTENT.mdmi";

		MDMIPackage.eINSTANCE.getMessageGroup();

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(MDMIPackage.eNS_URI, MDMIPackage.eINSTANCE);
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("mdmi", new MDMIResourceFactoryImpl());

		URI uri = URI.createFileURI(input);
		MDMIResourceImpl resource = (MDMIResourceImpl) resourceSet.getResource(uri, true);
		MessageGroup group = (MessageGroup) resource.getContents().get(0);

		boolean changed = false;
		for (MessageModel model : group.getModels()) {
			Bag root = (Bag) model.getSyntaxModel().getRoot();
			if (root == null) {
				continue;
			}
			if (hasChild(root, "ZSEGMENT")) {
				System.out.println("ZSEGMENT already present under " + root.getName());
				continue;
			}

			SemanticElementSet elementSet = model.getElementSet();
			SemanticElement rootSemantic = findSemanticElement(elementSet, root);
			if (rootSemantic == null) {
				System.err.println("No semantic element for root " + root.getName());
				continue;
			}

			MDMIDatatype containerType = group.getDatatype("Container");
			MDMIDatatype stringType = group.getDatatype("String");
			if (containerType == null || stringType == null) {
				System.err.println("Container or String datatype missing");
				continue;
			}

			Bag zsegmentBag = createBag("ZSEGMENT", "ZSEGMENT", 0, -1);
			LeafSyntaxTranslator zidNode = createLeaf("ZID", "ZID", 0, 1);
			LeafSyntaxTranslator zvalueNode = createLeaf("ZVALUE", "ZVALUE", 0, 1);
			zsegmentBag.getNodes().add(zidNode);
			zsegmentBag.getNodes().add(zvalueNode);
			root.getNodes().add(zsegmentBag);

			SemanticElement zsegmentSe = createSemanticElement("ZSEGMENT", "99999999", containerType, zsegmentBag);
			SemanticElement zidSe = createSemanticElement("ZID", "99999999", stringType, zidNode);
			SemanticElement zvalueSe = createSemanticElement("ZVALUE", "99999999", stringType, zvalueNode);

			rootSemantic.getChildren().add(zsegmentSe);
			zsegmentSe.getChildren().add(zidSe);
			zsegmentSe.getChildren().add(zvalueSe);

			elementSet.getSemanticElements().add(zsegmentSe);
			elementSet.getSemanticElements().add(zidSe);
			elementSet.getSemanticElements().add(zvalueSe);

			changed = true;
			System.out.println("Added ZSEGMENT structure to " + root.getName());
		}

		if (changed) {
			Map<Object, Object> options = new HashMap<>();
			options.put(XMLResource.OPTION_FLUSH_THRESHOLD, Integer.valueOf(0x01000000));
			options.put(XMLResource.OPTION_USE_FILE_BUFFER, Boolean.TRUE);
			resource.save(options);
			System.out.println("Saved " + input);
		} else {
			System.out.println("No changes made");
		}
	}

	private static boolean hasChild(Bag bag, String location) {
		for (Node child : bag.getNodes()) {
			if (location.equals(child.getLocation())) {
				return true;
			}
		}
		return false;
	}

	private static SemanticElement findSemanticElement(SemanticElementSet set, Bag root) {
		for (SemanticElement se : set.getSemanticElements()) {
			if (se.getSyntaxNode() == root) {
				return se;
			}
		}
		return null;
	}

	private static Bag createBag(String name, String location, int minOccurs, int maxOccurs) {
		Bag bag = MDMIFactory.eINSTANCE.createBag();
		bag.setName(name);
		bag.setDescription("99999999");
		bag.setLocation(location);
		bag.setFieldName(name);
		bag.setMinOccurs(minOccurs);
		bag.setMaxOccurs(maxOccurs);
		return bag;
	}

	private static LeafSyntaxTranslator createLeaf(String name, String location, int minOccurs, int maxOccurs) {
		LeafSyntaxTranslator leaf = MDMIFactory.eINSTANCE.createLeafSyntaxTranslator();
		leaf.setName(name);
		leaf.setDescription("99999999");
		leaf.setLocation(location);
		leaf.setFieldName(name);
		leaf.setMinOccurs(minOccurs);
		leaf.setMaxOccurs(maxOccurs);
		return leaf;
	}

	private static SemanticElement createSemanticElement(String name, String description, MDMIDatatype type, Node syntaxNode) {
		SemanticElement se = MDMIFactory.eINSTANCE.createSemanticElement();
		se.setName(name);
		se.setDescription(description);
		se.setElementType("LOCAL");
		se.setDatatype(type);
		syntaxNode.setSemanticElement(se);
		return se;
	}
}
