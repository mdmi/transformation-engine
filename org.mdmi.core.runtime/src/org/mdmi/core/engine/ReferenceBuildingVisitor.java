/*******************************************************************************
 * Copyright (c) 2026 seanmuir.
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
import org.slf4j.LoggerFactory;

/*
 * =====================================================
 * Visitor Implementation WITH cycle detection
 * =====================================================
 */
public class ReferenceBuildingVisitor implements ElementValueVisitor {

	private final Collection<IElementValue> allTargetValues;

	private final Map<IElementValue, IElementValue> targetToSource;

	private final List<Reference> referencesToCreate;

	public static Logger logger = LoggerFactory.getLogger(ReferenceBuildingVisitor.class);

	private final Set<IElementValue> visited = Collections.newSetFromMap(new IdentityHashMap<>());

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

		if (!visited.add(trgVal)) {
			logger.trace("Cycle detected at {}", trgVal.getSemanticElement().getName());
			return;
		}

		if (!isContainer(trgVal)) {
			return;
		}

		logger.trace("Target Container to check " + trgVal.getSemanticElement().getName());

		SemanticElement trgSemantic = trgVal.getSemanticElement();

		for (SemanticElement child : trgSemantic.getChildren()) {
			for (ConversionRule refRule : child.getMapFromMdmi()) {

				if (!isReferenceRule(refRule)) {
					continue;
				}

				logger.trace("Target Container to check " + child.getName());

				IElementValue sourceElement = targetToSource.get(trgVal);

				logger.trace("Target References to " + child.getName());

				if (sourceElement == null) {
					continue;
				}

				logger.trace("sourceElement " + sourceElement.getSemanticElement().getName());

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

		Set<IElementValue> visited = Collections.newSetFromMap(new IdentityHashMap<>());

		visitSourceChildren(trgVal, sourceElement, child, refRule, visited);
	}

	private void visitSourceChildren(IElementValue trgVal, IElementValue current, SemanticElement child,
			ConversionRule refRule, Set<IElementValue> visited) {

		if (!visited.add(current)) {
			return;
		}

		for (IElementValue srcChild : current.getChildren()) {

			if (!isContainer(srcChild)) {
				continue;
			}

			logger.trace("Checking src elements " + srcChild.getSemanticElement().getName());

			for (ConversionRule subRule : srcChild.getSemanticElement().getMapToMdmi()) {

				if (matches(refRule, subRule)) {
					logger.trace("Found Matching Reference {}", srcChild.getSemanticElement().getName());

					referencesToCreate.add(new Reference(trgVal, srcChild, child));
				}
			}

			visitSourceChildren(trgVal, srcChild, child, refRule, visited);
		}
	}

	private void handleMultiples(IElementValue trgVal, IElementValue sourceElement, SemanticElement child,
			ConversionRule refRule) {

		for (IElementValue srcChild : sourceElement.getChildren()) {

			if (!isContainer(srcChild)) {
				continue;
			}

			logger.trace("Checking src elements " + srcChild.getSemanticElement().getName());

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
