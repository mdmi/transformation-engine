/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
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
