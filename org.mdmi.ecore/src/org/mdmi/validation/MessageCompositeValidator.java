/**
 *
 * $Id$
 */
package org.mdmi.validation;

import org.eclipse.emf.common.util.EList;
import org.mdmi.MessageComposite;

/**
 * A sample validator interface for {@link org.mdmi.MessageComposite}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MessageCompositeValidator {
	boolean validate();

	boolean validateComposites(EList<MessageComposite> value);

	boolean validateOwner(MessageComposite value);
}