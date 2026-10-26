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

/**
 * @author seanmuir
 *
 */
public class TestDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");

		String source = "19000101";
		System.out.println(
			org.mdmi.core.engine.javascript.Utils.FormatDate("yyyyMMddHHmmssZ", "yyyy-MM-dd'T'hh:mm:ss+zzzz", source));

	}

}
