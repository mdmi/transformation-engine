/*******************************************************************************
 * Copyright (c) 2025 seanmuir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     seanmuir - initial API and implementation
 *     
 *******************************************************************************/
package org.mdmi.core.engine.parser.piqi;

import org.mdmi.MessageModel;
import org.mdmi.core.ElementValueSet;
import org.mdmi.core.engine.semanticprocessors.ISemanticProcessor;

/**
 * @author seanmuir
 *
 */
public class PiqiSemanticEngine implements ISemanticProcessor {

	/* (non-Javadoc)
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#getName()
	 */
	@Override
	public String getName() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#canProcess(org.mdmi.MessageModel)
	 */
	@Override
	public boolean canProcess(MessageModel messageModel) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.mdmi.core.engine.semanticprocessors.ISemanticProcessor#processSemanticModel(org.mdmi.core.ElementValueSet)
	 */
	@Override
	public void processSemanticModel(ElementValueSet semanticModel) {

	}

}
