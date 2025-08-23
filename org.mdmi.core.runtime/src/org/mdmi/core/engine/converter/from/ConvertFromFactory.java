/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.from;

import java.util.HashMap;

import org.mdmi.DTSPrimitive;
import org.mdmi.core.engine.XDT;
import org.mdmi.impl.MDMIPackageImpl;

public class ConvertFromFactory {
	// Map of converters
	private static final HashMap<XDT, HashMap<String, IConvertFromString>> CONVERT_MAP = new HashMap<>();

	// Converters- they are state-less, so we only need one of each.
	public static final BooleanConverter CONV_BOOL = new BooleanConverter();

	public static final BinaryConverter CONV_BINARY = new BinaryConverter();

	public static final BigDecimalConverter CONV_DEC = new BigDecimalConverter();

	public static final BigIntegerConverter CONV_INT = new BigIntegerConverter();

	public static final StringConverter CONV_STRING = new StringConverter();

	public static final StringConverter CONV_DATETIME = new StringConverter();

	public static final StringConverter CONV_DATE = new StringConverter();

	public static final StringConverter CONV_TIME = new StringConverter();

	public static final GDayConverter CONV_DAY = new GDayConverter();

	public static final GMonthDayConverter CONV_MONTHDAY = new GMonthDayConverter();

	public static final GMonthConverter CONV_MONTH = new GMonthConverter();

	public static final GYearMonthConverter CONV_YEARMONTH = new GYearMonthConverter();

	public static final GYearConverter CONV_YEAR = new GYearConverter();

	public static final DecimalHexConverter CONV_DECHEX = new DecimalHexConverter();

	public static final IntegerHexConverter CONV_INTHEX = new IntegerHexConverter();

	public static final DateHexMillisConverter CONV_DATEHEX = new DateHexMillisConverter();

	public static final BinaryHexConverter CONV_BINHEX = new BinaryHexConverter();

	public static final Base64ByteConverter CONV_BASE64 = new Base64ByteConverter();

	public static final ArrayConverter CONV_STRINGARR = new ArrayConverter(CONV_STRING);

	private static final IntegerBooleanConverter CONV_INTBOOL = new IntegerBooleanConverter(CONV_BOOL);

	private static final IntegerHexBooleanConverter CONV_INTHEXBOOL = new IntegerHexBooleanConverter();

	private static final DecimalBooleanConverter CONV_DOUBLEBOOL = new DecimalBooleanConverter(CONV_BOOL);

	public static final ConvertFromFactory INSTANCE = new ConvertFromFactory();

	public IConvertFromString getConverter(XDT fromType, DTSPrimitive toType) {
		HashMap<String, IConvertFromString> fromMap = CONVERT_MAP.get(fromType);
		return fromMap == null
				? null
				: fromMap.get(toType.getTypeName());
	}

	private ConvertFromFactory() {
		/*********** anyURI *****************/
		HashMap<String, IConvertFromString> local = createNewMap(XDT.ANYURI);
		local.put(MDMIPackageImpl.STRING.getTypeName(), CONV_STRING);

		/*********** base64Binary *****************/
		local = new HashMap<>();
		CONVERT_MAP.put(XDT.BASE64BINARY, local);
		local.put(MDMIPackageImpl.INTEGER.getTypeName(), new Base64Converter(CONV_INT));
		local.put(MDMIPackageImpl.DECIMAL.getTypeName(), new Base64Converter(CONV_DEC));
		local.put(MDMIPackageImpl.STRING.getTypeName(), new Base64Converter(CONV_STRING));
		local.put(MDMIPackageImpl.BOOLEAN.getTypeName(), new Base64Converter(CONV_BOOL));
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), new Base64Converter(CONV_DATETIME));
		local.put(MDMIPackageImpl.BINARY.getTypeName(), CONV_BASE64);

		/*********** boolean *****************/
		local = createNewMap(XDT.BOOLEAN);
		local.put(MDMIPackageImpl.BOOLEAN.getTypeName(), CONV_BOOL);
		local.put(MDMIPackageImpl.INTEGER.getTypeName(), new BooleanNumberConverter(CONV_INT));
		local.put(MDMIPackageImpl.DECIMAL.getTypeName(), new BooleanNumberConverter(CONV_DEC));
		local.put(MDMIPackageImpl.STRING.getTypeName(), CONV_STRING);

		/*********** byte *****************/
		local = createNewMap(XDT.BYTE);
		local.put(MDMIPackageImpl.BOOLEAN.getTypeName(), CONV_INTBOOL);
		local.put(MDMIPackageImpl.INTEGER.getTypeName(), CONV_INT);
		local.put(MDMIPackageImpl.DECIMAL.getTypeName(), CONV_DEC);
		local.put(MDMIPackageImpl.STRING.getTypeName(), CONV_STRING);

		/*********** date *****************/
		local = createStringConversions(XDT.DATE);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_DATE);

		/*********** datetime *****************/
		local = createStringConversions(XDT.DATETIME);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_DATETIME);

		/*********** decimal *****************/
		createDecimalConversions(XDT.DECIMAL);

		/*********** double *****************/
		createDecimalConversions(XDT.DOUBLE);

		/*********** entities *****************/
		local = createNewMap(XDT.ENTITIES);
		local.put(MDMIPackageImpl.STRING.getTypeName(), CONV_STRINGARR);

		/*********** entity *****************/
		createStringConversions(XDT.ENTITY);

		/*********** float *****************/
		createDecimalConversions(XDT.FLOAT);

		/*********** gday *****************/
		local = createStringConversions(XDT.GDAY);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_DAY);

		/*********** gmonth *****************/
		local = createStringConversions(XDT.GMONTH);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_MONTH);

		/*********** gmonthday *****************/
		local = createStringConversions(XDT.GMONTHDAY);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_MONTHDAY);

		/*********** gyear *****************/
		local = createStringConversions(XDT.GYEAR);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_YEAR);

		/*********** gyearmonth *****************/
		local = createStringConversions(XDT.GYEARMONTH);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_YEARMONTH);

		/*********** hexbinary *****************/
		local = new HashMap<>();
		CONVERT_MAP.put(XDT.HEXBINARY, local);
		local.put(MDMIPackageImpl.INTEGER.getTypeName(), CONV_INTHEX);
		local.put(MDMIPackageImpl.DECIMAL.getTypeName(), CONV_DECHEX);
		local.put(MDMIPackageImpl.STRING.getTypeName(), CONV_STRING);
		local.put(MDMIPackageImpl.BOOLEAN.getTypeName(), CONV_INTHEXBOOL);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_DATEHEX);
		local.put(MDMIPackageImpl.BINARY.getTypeName(), CONV_BINHEX);

		/*********** id *****************/
		createIntegerConversions(XDT.ID);

		/*********** idref *****************/
		createIntegerConversions(XDT.IDREF);

		/*********** idrefs *****************/
		local = createNewMap(XDT.IDREFS);
		local.put(MDMIPackageImpl.INTEGER.getTypeName(), new ArrayConverter(CONV_INT));
		local.put(MDMIPackageImpl.DECIMAL.getTypeName(), new ArrayConverter(CONV_DEC));
		local.put(MDMIPackageImpl.BOOLEAN.getTypeName(), new ArrayConverter(CONV_INTBOOL));
		local.put(MDMIPackageImpl.STRING.getTypeName(), CONV_STRINGARR);

		/*********** int *****************/
		createIntegerConversions(XDT.INT);

		/*********** integer *****************/
		createIntegerConversions(XDT.INTEGER);

		/*********** language *****************/
		createStringConversions(XDT.LANGUAGE);

		/*********** long *****************/
		createIntegerConversions(XDT.LONG);

		/*********** name *****************/
		createStringConversions(XDT.NAME);

		/*********** ncname *****************/
		createStringConversions(XDT.NCNAME);

		/*********** negative integer *****************/
		createIntegerConversions(XDT.NEGATIVEINTEGER);

		/*********** nmtoken *****************/
		createStringConversions(XDT.NMTOKEN);

		/*********** nmtokens *****************/
		local = createNewMap(XDT.NMTOKENS);
		local.put(MDMIPackageImpl.STRING.getTypeName(), CONV_STRINGARR);

		/*********** nonnegative integer *****************/
		createIntegerConversions(XDT.NONNEGATIVEINTEGER);

		/*********** nonpositive integer *****************/
		createIntegerConversions(XDT.NONPOSITIVEINTEGER);

		/*********** normalized string *****************/
		createStringConversions(XDT.NORMALIZEDSTRING);

		/*********** positive integer *****************/
		createIntegerConversions(XDT.POSITIVEINTEGER);

		/*********** qname *****************/
		createStringConversions(XDT.QNAME);

		/*********** short *****************/
		createIntegerConversions(XDT.SHORT);

		/*********** string *****************/
		local = createStringConversions(XDT.STRING);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_DATETIME);

		/*********** time *****************/
		local = createStringConversions(XDT.TIME);
		local.put(MDMIPackageImpl.DATETIME.getTypeName(), CONV_TIME);

		/*********** token *****************/
		createStringConversions(XDT.TOKEN);

		/*********** unsigned byte *****************/
		createIntegerConversions(XDT.UNSIGNEDBYTE);

		/*********** unsigned int *****************/
		createIntegerConversions(XDT.UNSIGNEDINT);

		/*********** unsigned long *****************/
		createIntegerConversions(XDT.UNSIGNEDLONG);

		/*********** unsigned short *****************/
		createIntegerConversions(XDT.UNSIGNEDSHORT);
	}

	private HashMap<String, IConvertFromString> createNewMap(XDT xmlType) {
		HashMap<String, IConvertFromString> local = new HashMap<>();
		CONVERT_MAP.put(xmlType, local);
		local.put(MDMIPackageImpl.BINARY.getDescription(), CONV_BINARY);
		return local;
	}

	private HashMap<String, IConvertFromString> createNumericConversions(XDT xdt) {
		HashMap<String, IConvertFromString> local = createNewMap(xdt);
		local.put(MDMIPackageImpl.INTEGER.getTypeName(), CONV_INT);
		local.put(MDMIPackageImpl.DECIMAL.getTypeName(), CONV_DEC);
		local.put(MDMIPackageImpl.STRING.getTypeName(), CONV_STRING);
		return local;
	}

	private HashMap<String, IConvertFromString> createIntegerConversions(XDT xdt) {
		HashMap<String, IConvertFromString> local = createNumericConversions(xdt);
		local.put(MDMIPackageImpl.BOOLEAN.getTypeName(), CONV_INTBOOL);
		return local;
	}

	private HashMap<String, IConvertFromString> createDecimalConversions(XDT xdt) {
		HashMap<String, IConvertFromString> local = createNumericConversions(xdt);
		local.put(MDMIPackageImpl.BOOLEAN.getTypeName(), CONV_DOUBLEBOOL);
		return local;
	}

	private HashMap<String, IConvertFromString> createStringConversions(XDT xdt) {
		HashMap<String, IConvertFromString> local = createNewMap(xdt);
		local.put(MDMIPackageImpl.STRING.getTypeName(), CONV_STRING);
		return local;
	}
}
