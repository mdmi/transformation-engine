/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.mdmi.ConversionRule;
import org.mdmi.SemanticElement;
import org.mdmi.core.IElementValue;
import org.mdmi.core.IElementValue.ElementValueVisitor;
import org.mdmi.core.engine.MdmiUow.Reference;
import org.slf4j.Logger;

/**
 * Single-file Visitor + Cycle Detection implementation
 */
public class ReferenceVisitorExample {

	/*
	 * =====================================================
	 * Model Interfaces (assumed existing)
	 * =====================================================
	 */

	// public static class Reference {
	// public Reference(IElementValue target, IElementValue source, SemanticElement child) {
	// }
	// }

	/*
	 * =====================================================
	 * Visitor Implementation WITH cycle detection
	 * =====================================================
	 */
	public static class ReferenceBuildingVisitor implements ElementValueVisitor {

		private final Collection<IElementValue> allTargetValues;

		private final Map<IElementValue, IElementValue> targetToSource;

		private final List<Reference> referencesToCreate;

		private final Logger logger;

		// 🔁 Cycle detection (identity-based)
		private final Set<IElementValue> visited = Collections.newSetFromMap(new IdentityHashMap<>());

		// public ReferenceBuildingVisitor(Collection<IElementValue> allTargetValues,
		// Map<IElementValue, IElementValue> targetToSource, List<Reference> referencesToCreate, Logger logger) {
		//
		// this.allTargetValues = allTargetValues;
		// this.targetToSource = targetToSource;
		// this.referencesToCreate = referencesToCreate;
		// this.logger = logger;
		// }

		/**
		 * @param trgValues
		 * @param targettosource2
		 * @param referencesToCreate2
		 * @param logger2
		 */
		public ReferenceBuildingVisitor(List<IElementValue> trgValues,
				HashMap<IElementValue, IElementValue> targettosource2,
				List<org.mdmi.core.engine.MdmiUow.Reference> referencesToCreate2, Logger logger2) {

			this.allTargetValues = trgValues;
			this.targetToSource = targettosource2;
			this.referencesToCreate = referencesToCreate2;
			this.logger = logger2;
		}

		@Override
		public void visit(IElementValue trgVal) {

			// 🔒 cycle guard
			if (!visited.add(trgVal)) {
				logger.trace("Cycle detected at {}", trgVal.getSemanticElement().getName());
				return;
			}

			if (!isContainer(trgVal)) {
				return;
			}

			System.err.println("Target Container to check " + trgVal.getSemanticElement().getName());

			SemanticElement trgSemantic = trgVal.getSemanticElement();

			for (SemanticElement child : trgSemantic.getChildren()) {
				for (ConversionRule refRule : child.getMapFromMdmi()) {

					if (!isReferenceRule(refRule)) {
						continue;
					}

					System.err.println("Target Container to check " + child.getName());

					IElementValue sourceElement = targetToSource.get(trgVal);

					System.err.println("Target References to " + child.getName());

					if (sourceElement == null) {
						continue;
					}

					System.err.println("sourceElement " + sourceElement.getSemanticElement().getName());

					if (child.isMultipleInstances()) {
						handleMultiple(trgVal, sourceElement, child, refRule);
					} else {
						handleSingle(trgVal, child, refRule);
					}

					for (IElementValue sourceElementChildredn : sourceElement.getChildren()) {
						this.visit(sourceElementChildredn);
					}

				}
			}
		}

		/* ================= Helper methods ================= */

		private boolean isContainer(IElementValue val) {
			return val.getSemanticElement().getDatatype() != null &&
					"Container".equals(val.getSemanticElement().getDatatype().getName());
		}

		private boolean isReferenceRule(ConversionRule rule) {
			return rule.getRule() != null && rule.getRule().startsWith("REFERENCE:");
		}

		private boolean matches(ConversionRule a, ConversionRule b) {
			return a.getBusinessElement().getUniqueIdentifier().equals(b.getBusinessElement().getUniqueIdentifier());
		}

		private void handleMultiple(IElementValue trgVal, IElementValue sourceElement, SemanticElement child,
				ConversionRule refRule) {

			// identity-based cycle detection
			Set<IElementValue> visited = Collections.newSetFromMap(new IdentityHashMap<>());

			visitSourceChildren(trgVal, sourceElement, child, refRule, visited);
		}

		private void visitSourceChildren(IElementValue trgVal, IElementValue current, SemanticElement child,
				ConversionRule refRule, Set<IElementValue> visited) {

			// 🔁 cycle guard
			if (!visited.add(current)) {
				return;
			}

			for (IElementValue srcChild : current.getChildren()) {

				if (!isContainer(srcChild)) {
					continue;
				}

				System.err.println("Checking src elements " + srcChild.getSemanticElement().getName());

				// original matching logic
				for (ConversionRule subRule : srcChild.getSemanticElement().getMapToMdmi()) {

					if (matches(refRule, subRule)) {
						logger.trace("Found Matching Reference {}", srcChild.getSemanticElement().getName());

						referencesToCreate.add(new Reference(trgVal, srcChild, child));
					}
				}

				// 🔁 recurse deeper
				visitSourceChildren(trgVal, srcChild, child, refRule, visited);
			}
		}

		private void handleMultiples(IElementValue trgVal, IElementValue sourceElement, SemanticElement child,
				ConversionRule refRule) {

			for (IElementValue srcChild : sourceElement.getChildren()) {

				if (!isContainer(srcChild)) {
					continue;
				}

				System.err.println("Checking src elements " + srcChild.getSemanticElement().getName());

				for (ConversionRule subRule : srcChild.getSemanticElement().getMapToMdmi()) {

					if (matches(refRule, subRule)) {
						logger.trace("Found Matching Reference {}", srcChild.getSemanticElement().getName());

						referencesToCreate.add(new Reference(trgVal, srcChild, child));
					}
				}
			}
		}

		private void handleSingle(IElementValue trgVal, SemanticElement child, ConversionRule refRule) {

			for (IElementValue single : allTargetValues) {

				if (!isContainer(single)) {
					continue;
				}

				for (ConversionRule subRule : single.getSemanticElement().getMapToMdmi()) {

					if (matches(refRule, subRule)) {
						logger.trace("Found Matching Reference {}", single.getSemanticElement().getName());

						referencesToCreate.add(new Reference(trgVal, single, child));
					}
				}
			}
		}
	}

	/*
	 * =====================================================
	 * Usage
	 * =====================================================
	 */
	// public static void run(Collection<IElementValue> trgValues, Map<IElementValue, IElementValue> targetToSource,
	// List<Reference> referencesToCreate, Logger logger) {
	//
	// ReferenceBuildingVisitor visitor = new ReferenceBuildingVisitor(
	// trgValues, targetToSource, referencesToCreate, logger);
	//
	// for (IElementValue trgVal : trgValues) {
	// trgVal.accept(visitor);
	// }
	// }
}
