/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.mdmi.core.engine.converter.to;

import java.math.BigInteger;
import java.util.HashMap;

import org.mdmi.DTSPrimitive;
import org.mdmi.core.engine.XDT;
import org.mdmi.core.engine.converter.from.ConvertFromFactory;
import org.mdmi.impl.MDMIPackageImpl;

public class ConvertToFactory {
	// Map of converters
	private static final HashMap<String, HashMap<XDT, IConvertToString>> CONVERT_MAP = new HashMap<>();

	// Converters. These are state-less, so they can be shared.
	private static final ToStringConverter CONV_STRING = new ToStringConverter();

	private static final ByteToStringConverter CONV_BYTE = new ByteToStringConverter();

	private static final ShortToStringConverter CONV_SHORT = new ShortToStringConverter();

	private static final IntegerToStringConverter CONV_INT = new IntegerToStringConverter();

	private static final LongToStringConverter CONV_LONG = new LongToStringConverter();

	private static final FloatToStringConverter CONV_FLOAT = new FloatToStringConverter();

	private static final DoubleToStringConverter CONV_DOUBLE = new DoubleToStringConverter();

	private static final ToBase64Converter CONV_BASE64 = new ToBase64Converter();

	private static final BinaryToHexConverter CONV_HEXBINARY = new BinaryToHexConverter();

	private static final ToHexStringConverter CONV_HEX = new ToHexStringConverter();

	private static final BooleanToNumberConverter CONV_BOOLNUM = new BooleanToNumberConverter();

	private static final ToDateTimeConverter CONV_DATETIME = new ToDateTimeConverter();

	private static final ToDateConverter CONV_DATE = new ToDateConverter();

	private static final ToTimeConverter CONV_TIME = new ToTimeConverter();

	private static final BinaryToStringConverter CONV_BINARY = new BinaryToStringConverter();

	private static final ArrayToAnyConverter CONV_ARRAY = new ArrayToAnyConverter(CONV_STRING);

	// Constrained int converters
	private static final ConstrainedIntegerConverter CONV_NEG = new ConstrainedIntegerConverter(null, -1);

	private static final ConstrainedIntegerConverter CONV_NONNEG = new ConstrainedIntegerConverter(0, null);

	private static final ConstrainedIntegerConverter CONV_POS = new ConstrainedIntegerConverter(1, null);

	private static final ConstrainedIntegerConverter CONV_NONPOS = new ConstrainedIntegerConverter(null, 0);

	private static final ConstrainedIntegerConverter CONV_UBYTE = new ConstrainedIntegerConverter(0, 255);

	private static final ConstrainedIntegerConverter CONV_UINT = new ConstrainedIntegerConverter(
		BigInteger.ZERO, new BigInteger("4294967295"));

	private static final ConstrainedIntegerConverter CONV_ULONG = new ConstrainedIntegerConverter(
		BigInteger.ZERO, new BigInteger("18446744073709551615"));

	private static final ConstrainedIntegerConverter CONV_USHORT = new ConstrainedIntegerConverter(0, 65535);

	private static final BooleanToNumberConverter CONV_NEGBOOL = new BooleanToNumberConverter("-1");

	public static final ConvertToFactory INSTANCE = new ConvertToFactory();

	public IConvertToString getConverter(XDT toType, DTSPrimitive fromType) {
		HashMap<XDT, IConvertToString> fromMap = CONVERT_MAP.get(fromType.getTypeName());
		return fromMap == null
				? null
				: fromMap.get(toType);
	}

	private ConvertToFactory() {

		/*********** Integer *****************/
		HashMap<XDT, IConvertToString> local = new HashMap<>();
		CONVERT_MAP.put(MDMIPackageImpl.INTEGER.getTypeName(), local);
		local.put(XDT.BASE64BINARY, CONV_BASE64);
		local.put(XDT.BOOLEAN, new IntegerToBooleanConverter());
		local.put(XDT.BYTE, CONV_BYTE);
		local.put(XDT.DECIMAL, CONV_STRING);
		local.put(XDT.DOUBLE, CONV_DOUBLE);
		local.put(XDT.FLOAT, CONV_FLOAT);
		local.put(XDT.HEXBINARY, CONV_HEX);
		local.put(XDT.ID, CONV_STRING);
		local.put(XDT.IDREF, CONV_STRING);
		local.put(XDT.INT, CONV_INT);
		local.put(XDT.INTEGER, CONV_STRING);
		local.put(XDT.LONG, CONV_LONG);
		local.put(XDT.NEGATIVEINTEGER, CONV_NEG);
		local.put(XDT.NONNEGATIVEINTEGER, CONV_NONNEG);
		local.put(XDT.NONPOSITIVEINTEGER, CONV_NONPOS);
		local.put(XDT.POSITIVEINTEGER, CONV_POS);
		local.put(XDT.SHORT, CONV_SHORT);
		local.put(XDT.STRING, CONV_STRING);
		local.put(XDT.UNSIGNEDBYTE, CONV_UBYTE);
		local.put(XDT.UNSIGNEDINT, CONV_UINT);
		local.put(XDT.UNSIGNEDLONG, CONV_ULONG);
		local.put(XDT.UNSIGNEDSHORT, CONV_USHORT);

		/*********** Decimal *****************/
		local = new HashMap<>();
		CONVERT_MAP.put(MDMIPackageImpl.DECIMAL.getTypeName(), local);
		local.put(XDT.BASE64BINARY, CONV_BASE64);
		local.put(XDT.BOOLEAN, new DecimalToBooleanConverter());
		local.put(XDT.BYTE, CONV_BYTE);
		local.put(XDT.DECIMAL, CONV_STRING);
		local.put(XDT.DOUBLE, CONV_DOUBLE);
		local.put(XDT.FLOAT, CONV_FLOAT);
		local.put(XDT.HEXBINARY, CONV_HEX);
		local.put(XDT.ID, CONV_STRING);
		local.put(XDT.IDREF, CONV_STRING);
		local.put(XDT.INT, CONV_INT);
		local.put(XDT.INTEGER, CONV_INT);
		local.put(XDT.LONG, CONV_LONG);
		local.put(XDT.NEGATIVEINTEGER, CONV_NEG);
		local.put(XDT.NONNEGATIVEINTEGER, CONV_NONNEG);
		local.put(XDT.NONPOSITIVEINTEGER, CONV_NONPOS);
		local.put(XDT.POSITIVEINTEGER, CONV_POS);
		local.put(XDT.SHORT, CONV_SHORT);
		local.put(XDT.STRING, CONV_STRING);
		local.put(XDT.UNSIGNEDBYTE, CONV_UBYTE);
		local.put(XDT.UNSIGNEDINT, CONV_UINT);
		local.put(XDT.UNSIGNEDLONG, CONV_ULONG);
		local.put(XDT.UNSIGNEDSHORT, CONV_USHORT);

		/*********** Boolean *****************/
		local = new HashMap<>();
		CONVERT_MAP.put(MDMIPackageImpl.BOOLEAN.getTypeName(), local);
		local.put(XDT.BASE64BINARY, CONV_BASE64);
		local.put(XDT.BOOLEAN, CONV_STRING);
		local.put(XDT.BYTE, CONV_BOOLNUM);
		local.put(XDT.DECIMAL, CONV_BOOLNUM);
		local.put(XDT.DOUBLE, CONV_BOOLNUM);
		local.put(XDT.FLOAT, CONV_BOOLNUM);
		local.put(XDT.HEXBINARY, new ToHexStringConverter(CONV_BOOLNUM));
		local.put(XDT.ID, CONV_STRING);
		local.put(XDT.IDREF, CONV_STRING);
		local.put(XDT.INT, CONV_BOOLNUM);
		local.put(XDT.INTEGER, CONV_BOOLNUM);
		local.put(XDT.LONG, CONV_BOOLNUM);
		local.put(XDT.NEGATIVEINTEGER, new BooleanNoFalseConverter(CONV_NEGBOOL));
		local.put(XDT.NONNEGATIVEINTEGER, CONV_BOOLNUM);
		local.put(XDT.NONPOSITIVEINTEGER, new BooleanToNumberConverter("-1"));
		local.put(XDT.POSITIVEINTEGER, new BooleanNoFalseConverter(CONV_BOOLNUM));
		local.put(XDT.SHORT, CONV_BOOLNUM);
		local.put(XDT.STRING, CONV_STRING);
		local.put(XDT.UNSIGNEDBYTE, CONV_BOOLNUM);
		local.put(XDT.UNSIGNEDINT, CONV_BOOLNUM);
		local.put(XDT.UNSIGNEDLONG, CONV_BOOLNUM);
		local.put(XDT.UNSIGNEDSHORT, CONV_BOOLNUM);

		/*********** Binary *****************/
		local = new HashMap<>();
		CONVERT_MAP.put(MDMIPackageImpl.BINARY.getTypeName(), local);
		local.put(XDT.ANYURI, CONV_BINARY);
		local.put(XDT.BASE64BINARY, CONV_BINARY);
		local.put(XDT.BOOLEAN, CONV_BINARY);
		local.put(XDT.BYTE, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_BYTE));
		local.put(XDT.DATE, CONV_BINARY);
		local.put(XDT.DATETIME, CONV_BINARY);
		local.put(XDT.DECIMAL, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_DEC, CONV_STRING));
		local.put(XDT.DOUBLE, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_DEC, CONV_DOUBLE));
		local.put(XDT.ENTITY, CONV_BINARY);
		local.put(XDT.ENTITIES, CONV_BINARY);
		local.put(XDT.FLOAT, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_DEC, CONV_FLOAT));
		local.put(XDT.GDAY, CONV_BINARY);
		local.put(XDT.GMONTH, CONV_BINARY);
		local.put(XDT.GMONTHDAY, CONV_BINARY);
		local.put(XDT.GYEAR, CONV_BINARY);
		local.put(XDT.GYEARMONTH, CONV_BINARY);
		local.put(XDT.HEXBINARY, CONV_HEXBINARY);
		local.put(XDT.ID, CONV_BINARY);
		local.put(XDT.IDREF, CONV_BINARY);
		local.put(XDT.IDREFS, CONV_BINARY);
		local.put(XDT.INT, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_INT));
		local.put(XDT.INTEGER, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_STRING));
		local.put(XDT.LANGUAGE, CONV_BINARY);
		local.put(XDT.LONG, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_LONG));
		local.put(XDT.NAME, CONV_BINARY);
		local.put(XDT.NCNAME, CONV_BINARY);
		local.put(XDT.NEGATIVEINTEGER, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_NEG));
		local.put(XDT.NMTOKEN, CONV_BINARY);
		local.put(XDT.NMTOKENS, CONV_BINARY);
		local.put(XDT.NONNEGATIVEINTEGER, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_NONNEG));
		local.put(XDT.NONPOSITIVEINTEGER, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_NONPOS));
		local.put(XDT.NORMALIZEDSTRING, CONV_BINARY);
		local.put(XDT.POSITIVEINTEGER, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_POS));
		local.put(XDT.QNAME, CONV_BINARY);
		local.put(XDT.SHORT, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_SHORT));
		local.put(XDT.STRING, CONV_BINARY);
		local.put(XDT.TIME, CONV_BINARY);
		local.put(XDT.TOKEN, CONV_BINARY);
		local.put(XDT.UNSIGNEDBYTE, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_UBYTE));
		local.put(XDT.UNSIGNEDINT, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_UINT));
		local.put(XDT.UNSIGNEDLONG, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_ULONG));
		local.put(XDT.UNSIGNEDSHORT, new ToAnyFromBinaryConverter(ConvertFromFactory.CONV_INT, CONV_USHORT));

		/*********** String *****************/
		local = new HashMap<>();
		CONVERT_MAP.put(MDMIPackageImpl.STRING.getTypeName(), local);
		local.put(XDT.ANYURI, CONV_STRING);
		local.put(XDT.BASE64BINARY, CONV_STRING);
		local.put(XDT.BOOLEAN, CONV_STRING);
		local.put(XDT.BYTE, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_BYTE));
		local.put(XDT.DATE, CONV_STRING);
		local.put(XDT.DATETIME, CONV_STRING);
		local.put(XDT.DECIMAL, new ToAnyFromStringConverter(ConvertFromFactory.CONV_DEC, CONV_STRING));
		local.put(XDT.DOUBLE, new ToAnyFromStringConverter(ConvertFromFactory.CONV_DEC, CONV_DOUBLE));
		local.put(XDT.ENTITY, CONV_STRING);
		local.put(XDT.FLOAT, new ToAnyFromStringConverter(ConvertFromFactory.CONV_DEC, CONV_FLOAT));
		local.put(XDT.GDAY, CONV_STRING);
		local.put(XDT.GMONTH, CONV_STRING);
		local.put(XDT.GMONTHDAY, CONV_STRING);
		local.put(XDT.GYEAR, CONV_STRING);
		local.put(XDT.GYEARMONTH, CONV_STRING);
		local.put(XDT.HEXBINARY, CONV_STRING);
		local.put(XDT.ID, CONV_STRING);
		local.put(XDT.IDREF, CONV_STRING);
		local.put(XDT.INT, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_INT));
		local.put(XDT.INTEGER, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_STRING));
		local.put(XDT.LANGUAGE, CONV_STRING);
		local.put(XDT.LONG, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_LONG));
		local.put(XDT.NAME, CONV_STRING);
		local.put(XDT.NCNAME, CONV_STRING);
		local.put(XDT.NEGATIVEINTEGER, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_NEG));
		local.put(XDT.NMTOKEN, CONV_STRING);
		local.put(XDT.NONNEGATIVEINTEGER, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_NONNEG));
		local.put(XDT.NONPOSITIVEINTEGER, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_NONPOS));
		local.put(XDT.NORMALIZEDSTRING, CONV_STRING);
		local.put(XDT.POSITIVEINTEGER, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_POS));
		local.put(XDT.QNAME, CONV_STRING);
		local.put(XDT.SHORT, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_SHORT));
		local.put(XDT.STRING, CONV_STRING);
		local.put(XDT.TIME, CONV_STRING);
		local.put(XDT.TOKEN, CONV_STRING);
		local.put(XDT.UNSIGNEDBYTE, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_UBYTE));
		local.put(XDT.UNSIGNEDINT, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_UINT));
		local.put(XDT.UNSIGNEDLONG, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_ULONG));
		local.put(XDT.UNSIGNEDSHORT, new ToAnyFromStringConverter(ConvertFromFactory.CONV_INT, CONV_USHORT));

		local.put(XDT.ENTITIES, CONV_ARRAY);
		local.put(XDT.IDREFS, CONV_ARRAY);
		local.put(XDT.NMTOKENS, CONV_ARRAY);

		/*********** DateTime *****************/
		local = new HashMap<>();
		CONVERT_MAP.put(MDMIPackageImpl.DATETIME.getTypeName(), local);
		local.put(XDT.BASE64BINARY, new ToBase64Converter(CONV_DATETIME));
		local.put(XDT.DATE, CONV_DATE);
		local.put(XDT.DATETIME, CONV_DATETIME);
		local.put(XDT.GDAY, new ToDatePatternConverter("ddZ"));
		local.put(XDT.GMONTH, new ToDatePatternConverter("MMZ"));
		local.put(XDT.GMONTHDAY, new ToDatePatternConverter("MM-ddZ"));
		local.put(XDT.GYEAR, new ToDatePatternConverter("yyyyZ"));
		local.put(XDT.GYEARMONTH, new ToDatePatternConverter("yyyy-MMZ"));
		local.put(XDT.HEXBINARY, new ToHexStringConverter(new ToMillisStringConverter()));
		local.put(XDT.STRING, CONV_DATETIME);
		local.put(XDT.TIME, CONV_TIME);
	}
}
