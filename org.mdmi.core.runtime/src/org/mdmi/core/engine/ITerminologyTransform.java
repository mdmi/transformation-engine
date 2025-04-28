/*******************************************************************************
 * Copyright (c) 2016 seanmuir.
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

/**
 * @author seanmuir
 *
 */
public interface ITerminologyTransform {

	boolean healthCheck();

	TransformCode transform(String sourceURI, String sourceCode, String targetURI);

	public static class TransformCode {
		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * @param code
		 *            the code to set
		 */
		public void setCode(String code) {
			this.code = code;
		}

		public String code;

		public String system;

		/**
		 * @param code
		 * @param system
		 * @param displayName
		 */
		public TransformCode(String code, String system, String displayName) {
			super();
			this.code = code;
			this.system = system;
			this.displayName = displayName;
		}

		public String displayName;
	}

}
