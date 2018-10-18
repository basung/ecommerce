package com.basung.ecommerce.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date: 2018-10-17-下午8:12
 */
public class DataUtils {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final String TYPE_STR = "str";
    public static final String TYPE_INT = "int";
    public static final String TYPE_BOOL = "bool";
    public static final String TYPE_BYTE = "byte";
    public static final String TYPE_CHAR = "char";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_INTEGER = "integer";
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_CHARACTER = "character";
    public static final String TYPE_LONG = "long";
    public static final String TYPE_FLOAT = "float";
    public static final String TYPE_DOUBLE = "double";
    public static final String TYPE_SHORT = "short";
    public static final String TYPE_DATE = "date";
    public static final String TYPE_TIME = "time";
    public static final String TYPE_TIMESTAMP = "timestamp";
    public static final String TYPE_SIMPLE_DATE = "simple_date";
    public static final String TYPE_SIMPLE_TIME = "simple_time";
    public static final String TYPE_SIMPLE_DATE_TIME = "simple_date_time";
    public static final String TYPE_INTS = "ints";
    public static final String TYPE_INT_ARRAY = "int_array";
    public static final String TYPE_INT_JAVA_ARRAY = "int[]";
    public static final String TYPE_INTEGER_ARRAY = "integer_array";
    public static final String TYPE_BYTES = "bytes";
    public static final String TYPE_BYTE_JAVA_ARRAY = "byte[]";
    public static final String TYPE_BYTE_ARRAY = "byte_array";
    public static final String TYPE_CHARS = "chars";
    public static final String TYPE_CHAR_JAVA_ARRAY = "char[]";
    public static final String TYPE_CHAR_ARRAY = "char_array";
    public static final String TYPE_SHORT_ARRAY = "short_array";
    public static final String TYPE_SHORT_JAVA_ARRAY = "short[]";
    public static final String TYPE_LONG_ARRAY = "long_array";
    public static final String TYPE_LONG_JAVA_ARRAY = "long[]";
    public static final String TYPE_FLOAT_ARRAY = "float_array";
    public static final String TYPE_FLOAT_JAVA_ARRAY = "float[]";
    public static final String TYPE_DOUBLE_ARRAY = "double_array";
    public static final String TYPE_DOUBLE_JAVA_ARRAY = "double[]";
    public static final String TYPE_STRS = "strs";
    public static final String TYPE_STRINGS = "strings";
    public static final String TYPE_STRING_JAVA_ARRAY = "String[]";
    public static final String TYPE_STRING_ARRAY = "string_array";
    public static final String TYPE_BOOL_ARRAY = "bool_array";
    public static final String TYPE_BOOLEAN_JAVA_ARRAY = "boolean[]";
    public static final String TYPE_BOOLEAN_ARRAY = "boolean_array";
    public static final String TYPE_OBJECT = "object";
    public static final String TYPE_OBJECTS = "objects";
    public static final String TYPE_OBJECT_JAVA_ARRAY = "Object[]";
    public static final String TYPE_OBJECT_ARRAY = "object_array";
    public static final String TYPE_INET_ADDRESS = "inet_address";

    public DataUtils() {
    }

    public static final boolean getBoolean(Object value, boolean defValue) {
	  if (value == null) {
		return defValue;
	  } else {
		boolean result;
		if (value instanceof Boolean) {
		    result = (Boolean) value;
		} else if (value instanceof String) {
		    Boolean bool = BooleanUtils.toBoolean((String) value);
		    result = bool != null ? bool : defValue;
		} else if (value instanceof boolean[]) {
		    boolean[] bools = (boolean[]) ((boolean[]) value);
		    result = bools.length > 0 ? bools[0] : defValue;
		} else if (value instanceof Number) {
		    long l = ((Number) value).longValue();
		    result = l != 0L;
		} else {
		    result = defValue;
		}

		return result;
	  }
    }

    public static final byte getByte(Object value, byte defValue) {
	  if (value == null) {
		return defValue;
	  } else {
		int result;
		if (value instanceof Number) {
		    result = ((Number) value).byteValue();
		} else if (value instanceof String) {
		    String str = (String) value;

		    try {
			  int radix = 10;
			  if (str.length() > 2 && str.charAt(0) == '0') {
				char c = str.charAt(1);
				switch (c) {
				    case 'B':
				    case 'b':
					  radix = 2;
					  break;
				    case 'O':
				    case 'o':
					  radix = 8;
					  break;
				    case 'X':
				    case 'x':
					  radix = 16;
				}

				if (radix != 10) {
				    str = str.substring(2);
				}
			  }

			  result = (byte) Integer.parseInt(str, radix);
		    } catch (Exception var6) {
			  result = defValue;
		    }
		} else if (value instanceof String[]) {
		    String[] strs = (String[]) ((String[]) value);
		    if (strs.length > 0) {
			  result = getByte(strs[0], defValue);
		    } else {
			  result = defValue;
		    }
		} else if (value instanceof Boolean) {
		    result = (Boolean) value ? 1 : 0;
		} else {
		    result = defValue;
		}

		return (byte) result;
	  }
    }

    public static final short getShort(Object value, short defValue) {
	  if (value == null) {
		return defValue;
	  } else {
		short result;
		if (value instanceof Number) {
		    result = ((Number) value).shortValue();
		} else if (value instanceof String) {
		    String str = (String) value;

		    try {
			  int radix = 10;
			  if (str.length() > 2 && str.charAt(0) == '0') {
				char c = str.charAt(1);
				switch (c) {
				    case 'B':
				    case 'b':
					  radix = 2;
					  break;
				    case 'O':
				    case 'o':
					  radix = 8;
					  break;
				    case 'X':
				    case 'x':
					  radix = 16;
				}

				if (radix != 10) {
				    str = str.substring(2);
				}
			  }

			  result = Short.parseShort(str, radix);
		    } catch (Exception var6) {
			  result = defValue;
		    }
		} else if (value instanceof String[]) {
		    String[] strs = (String[]) ((String[]) value);
		    if (strs.length > 0) {
			  result = getShort(strs[0], defValue);
		    } else {
			  result = defValue;
		    }
		} else {
		    result = defValue;
		}

		return result;
	  }
    }

//    public static final char getChar(Object value, char defValue) {
//	  char result = false;
//	  int result;
//	  if (value != null) {
//		if (value instanceof Character) {
//		    result = (Character) value;
//		} else if (value instanceof String) {
//		    String str = (String) value;
//		    if (str.length() > 0) {
//			  result = str.charAt(0);
//		    } else {
//			  result = defValue;
//		    }
//		} else if (value instanceof Boolean) {
//		    boolean bool = (Boolean) value;
//		    result = bool ? 89 : 78;
//		} else {
//		    result = defValue;
//		}
//	  } else {
//		result = defValue;
//	  }
//
//	  return (char) result;
//    }

    public static final int getInt(Object value, int defValue) {
	  if (value == null) {
		return defValue;
	  } else {
		int result;
		if (value instanceof Number) {
		    result = ((Number) value).intValue();
		} else if (value instanceof String) {
		    String str = (String) value;

		    try {
			  int radix = 10;
			  if (str.length() > 2 && str.charAt(0) == '0') {
				char c = str.charAt(1);
				switch (c) {
				    case 'B':
				    case 'b':
					  radix = 2;
					  break;
				    case 'O':
				    case 'o':
					  radix = 8;
					  break;
				    case 'X':
				    case 'x':
					  radix = 16;
				}

				if (radix != 10) {
				    str = str.substring(2);
				}
			  }

			  result = Integer.parseInt(str, radix);
		    } catch (Exception var6) {
			  result = defValue;
		    }
		} else if (value instanceof String[]) {
		    String[] strs = (String[]) ((String[]) value);
		    if (strs.length > 0) {
			  result = getInt(strs[0], defValue);
		    } else {
			  result = defValue;
		    }
		} else {
		    if (value instanceof Boolean) {
			  Boolean b = (Boolean) value;
			  return b ? 1 : 0;
		    }

		    result = defValue;
		}

		return result;
	  }
    }

    public static final long getLong(Object value, long defValue) {
	  if (value == null) {
		return defValue;
	  } else {
		long result;
		if (value instanceof Number) {
		    result = ((Number) value).longValue();
		} else if (value instanceof String) {
		    String str = (String) value;

		    try {
			  int radix = 10;
			  if (str.length() > 2 && str.charAt(0) == '0') {
				char c = str.charAt(1);
				switch (c) {
				    case 'B':
				    case 'b':
					  radix = 2;
					  break;
				    case 'O':
				    case 'o':
					  radix = 8;
					  break;
				    case 'X':
				    case 'x':
					  radix = 16;
				}

				if (radix != 10) {
				    str = str.substring(2);
				}
			  }

			  result = Long.parseLong(str, radix);
		    } catch (Exception var8) {
			  result = defValue;
		    }
		} else if (value instanceof String[]) {
		    String[] strs = (String[]) ((String[]) value);
		    if (strs.length > 0) {
			  result = getLong(strs[0], defValue);
		    } else {
			  result = defValue;
		    }
		} else {
		    if (value instanceof Boolean) {
			  Boolean b = (Boolean) value;
			  return b ? 1L : 0L;
		    }

		    result = defValue;
		}

		return result;
	  }
    }

    public static final float getFloat(Object value, float defValue) {
	  if (value == null) {
		return defValue;
	  } else {
		float result;
		if (value instanceof Number) {
		    result = ((Number) value).floatValue();
		} else if (value instanceof String) {
		    String str = (String) value;

		    try {
			  result = Float.parseFloat(str);
		    } catch (Exception var5) {
			  result = defValue;
		    }
		} else if (value instanceof String[]) {
		    String[] strs = (String[]) ((String[]) value);
		    if (strs.length > 0) {
			  result = getFloat(strs[0], defValue);
		    } else {
			  result = defValue;
		    }
		} else {
		    if (value instanceof Boolean) {
			  Boolean b = (Boolean) value;
			  return b ? 1.0F : 0.0F;
		    }

		    result = defValue;
		}

		return result;
	  }
    }

    public static final double getDouble(Object value, double defValue) {
	  if (value == null) {
		return defValue;
	  } else {
		double result;
		if (value instanceof Number) {
		    result = ((Number) value).doubleValue();
		} else if (value instanceof String) {
		    String str = (String) value;

		    try {
			  result = Double.parseDouble(str);
		    } catch (Exception var7) {
			  result = defValue;
		    }
		} else if (value instanceof String[]) {
		    String[] strs = (String[]) ((String[]) value);
		    if (strs.length > 0) {
			  result = getDouble(strs[0], defValue);
		    } else {
			  result = defValue;
		    }
		} else {
		    if (value instanceof Boolean) {
			  Boolean b = (Boolean) value;
			  return b ? 1.0D : 0.0D;
		    }

		    result = defValue;
		}

		return result;
	  }
    }

    public static final String getString(Object value, String defValue) {
	  if (value == null) {
		return defValue;
	  } else {
		String str;
		if (value instanceof String) {
		    str = (String) value;
		} else if (value instanceof String[]) {
		    String[] values = (String[]) ((String[]) value);
		    str = values.length > 0 ? values[0] : value.toString();
		} else {
		    str = value.toString();
		}

		return str;
	  }
    }

//    public static final byte[] getByteArray(Object value) {
//	  return getBytes(value, (byte[]) null);
//    }

//    public static final byte[] getByteArray(Object value, byte[] defValue) {
//	  return getBytes(value, defValue);
//    }

//    public static final byte[] getBytes(Object value, byte[] defValue) {
//	  if (value == null) {
//		return defValue;
//	  } else {
//		byte[] result = null;
//		byte[] result;
//		if (value instanceof byte[]) {
//		    result = (byte[]) ((byte[]) value);
//		} else if (value instanceof String) {
//		    result = ((String) value).getBytes();
//		} else if (value instanceof Number) {
//		    result = new byte[]{getByte(value, (byte) 0)};
//		} else {
//		    int i;
//		    if (value instanceof Object[]) {
//			  Object[] array = (Object[]) ((Object[]) value);
//			  result = new byte[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getByte(array[i], (byte) 0);
//			  }
//		    } else if (value.getClass().isArray()) {
//			  int len = Array.getLength(value);
//			  result = new byte[len];
//
//			  for (i = 0; i < len; ++i) {
//				result[i] = getByte(Array.get(value, i), (byte) 0);
//			  }
//		    } else if (value instanceof Boolean) {
//			  result = new byte[]{getByte(value, (byte) 0)};
//		    } else {
//			  result = defValue;
//		    }
//		}
//
//		return result;
//	  }
//    }

//    public static final char[] getCharArray(Object value) {
//	  return getChars(value, (char[]) null);
//    }

//    public static final char[] getCharArray(Object value, char[] defValue) {
//	  return getChars(value, defValue);
//    }

//    public static final char[] getChars(Object value, char[] defValue) {
//	  char[] result = null;
//	  char[] result;
//	  if (value instanceof char[]) {
//		result = (char[]) ((char[]) value);
//	  } else if (value instanceof String) {
//		result = ((String) value).toCharArray();
//	  } else {
//		result = defValue;
//	  }
//
//	  return result;
//    }

    public static final String[] getStringArray(Object object) {
	  return getStringArray(object, ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static final String[] getStringArray(Object object, String[] defValue) {
	  if (object == null) {
		return null;
	  } else {
		String[] result = null;
		if (object instanceof String[]) {
		    result = (String[]) ((String[]) object);
		} else if (object instanceof String) {
		    result = new String[]{(String) object};
		} else {
		    int i;
		    if (object instanceof Object[]) {
			  Object[] array = (Object[]) ((Object[]) object);
			  result = new String[array.length];

			  for (i = 0; i < array.length; ++i) {
				result[i] = getString(array[i], (String) null);
			  }
		    } else if (object.getClass().isArray()) {
			  int len = Array.getLength(object);
			  result = new String[len];

			  for (i = 0; i < len; ++i) {
				result[i] = getString(Array.get(object, i), (String) null);
			  }
		    } else if (!(object instanceof Number) && !(object instanceof Boolean) && !(object instanceof Character)) {
			  result = defValue;
		    } else {
			  result = new String[]{object.toString()};
		    }
		}

		return result;
	  }
    }

//    public static final boolean[] getBooleanArray(Object object, boolean[] defValue) {
//	  if (object == null) {
//		return defValue;
//	  } else {
//		boolean[] result = null;
//		boolean[] result;
//		if (object instanceof boolean[]) {
//		    result = (boolean[]) ((boolean[]) object);
//		} else if (object instanceof Boolean) {
//		    result = new boolean[]{(Boolean) object};
//		} else if (object instanceof Number) {
//		    result = new boolean[]{getBoolean(object, false)};
//		} else {
//		    int i;
//		    if (object instanceof Object[]) {
//			  Object[] array = (Object[]) ((Object[]) object);
//			  result = new boolean[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getBoolean(array[i], false);
//			  }
//		    } else if (object.getClass().isArray()) {
//			  int len = Array.getLength(object);
//			  result = new boolean[len];
//
//			  for (i = 0; i < len; ++i) {
//				result[i] = getBoolean(Array.get(object, i), false);
//			  }
//		    } else if (object instanceof String) {
//			  String[] array = StringUtils.split((String) object, ',');
//			  result = new boolean[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getBoolean(array[i], false);
//			  }
//		    } else {
//			  result = defValue;
//		    }
//		}
//
//		return result;
//	  }
//    }

//    public static final boolean[] getBooleanArray(Object object) {
//	  return getBooleanArray(object, (boolean[]) null);
//    }

//    public static final int[] getIntArray(Object object, int[] defValue) {
//	  if (object == null) {
//		return defValue;
//	  } else {
//		int[] result = null;
//		int[] result;
//		if (object instanceof int[]) {
//		    result = (int[]) ((int[]) object);
//		} else {
//		    int i;
//		    if (object instanceof String) {
//			  String[] array = StringUtils.split((String) object, ',');
//			  result = new int[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getInt(array[i], 0);
//			  }
//		    } else if (object instanceof Number) {
//			  result = new int[]{getInt(object, 0)};
//		    } else if (object instanceof Object[]) {
//			  Object[] array = (Object[]) ((Object[]) object);
//			  result = new int[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getInt(array[i], 0);
//			  }
//		    } else if (object.getClass().isArray()) {
//			  int len = Array.getLength(object);
//			  result = new int[len];
//
//			  for (i = 0; i < len; ++i) {
//				result[i] = getInt(Array.get(object, i), 0);
//			  }
//		    } else if (object instanceof Boolean) {
//			  result = new int[]{getInt(object, 0)};
//		    } else {
//			  result = defValue;
//		    }
//		}
//
//		return result;
//	  }
//    }

//    public static final int[] getIntArray(Object object) {
//	  return getIntArray(object, (int[]) null);
//    }

//    public static final short[] getShortArray(Object object, short[] defValue) {
//	  if (object == null) {
//		return defValue;
//	  } else {
//		short[] result = null;
//		short[] result;
//		if (object instanceof short[]) {
//		    result = (short[]) ((short[]) object);
//		} else {
//		    int i;
//		    if (object instanceof String) {
//			  String[] array = StringUtils.split((String) object, ',');
//			  result = new short[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getShort(array[i], (short) 0);
//			  }
//		    } else if (object instanceof Number) {
//			  result = new short[]{getShort(object, (short) 0)};
//		    } else if (object instanceof Object[]) {
//			  Object[] array = (Object[]) ((Object[]) object);
//			  result = new short[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getShort(array[i], (short) 0);
//			  }
//		    } else if (object.getClass().isArray()) {
//			  int len = Array.getLength(object);
//			  result = new short[len];
//
//			  for (i = 0; i < len; ++i) {
//				result[i] = getShort(Array.get(object, i), (short) 0);
//			  }
//		    } else if (object instanceof Boolean) {
//			  result = new short[]{getShort(object, (short) 0)};
//		    } else {
//			  result = defValue;
//		    }
//		}
//
//		return result;
//	  }
//    }

//    public static final short[] getShortArray(Object object) {
//	  return getShortArray(object, (short[]) null);
//    }

//    public static final long[] getLongArray(Object object, long[] defValue) {
//	  if (object == null) {
//		return defValue;
//	  } else {
//		long[] result = null;
//		long[] result;
//		if (object instanceof long[]) {
//		    result = (long[]) ((long[]) object);
//		} else {
//		    int i;
//		    if (object instanceof String) {
//			  String[] array = StringUtils.split((String) object, ',');
//			  result = new long[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getLong(array[i], 0L);
//			  }
//		    } else if (object instanceof Number) {
//			  result = new long[]{getLong(object, 0L)};
//		    } else if (object instanceof Object[]) {
//			  Object[] array = (Object[]) ((Object[]) object);
//			  result = new long[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getLong(array[i], 0L);
//			  }
//		    } else if (object.getClass().isArray()) {
//			  int len = Array.getLength(object);
//			  result = new long[len];
//
//			  for (i = 0; i < len; ++i) {
//				result[i] = getLong(Array.get(object, i), 0L);
//			  }
//		    } else if (object instanceof Boolean) {
//			  result = new long[]{getLong(object, 0L)};
//		    } else {
//			  result = defValue;
//		    }
//		}
//
//		return result;
//	  }
//    }

//    public static final long[] getLongArray(Object object) {
//	  return getLongArray(object, (long[]) null);
//    }

//    public static final float[] getFloatArray(Object object, float[] defValue) {
//	  if (object == null) {
//		return defValue;
//	  } else {
//		float[] result = null;
//		float[] result;
//		if (object instanceof float[]) {
//		    result = (float[]) ((float[]) object);
//		} else {
//		    int i;
//		    if (object instanceof String) {
//			  String[] array = StringUtils.split((String) object, ',');
//			  result = new float[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getFloat(array[i], 0.0F);
//			  }
//		    } else if (object instanceof Number) {
//			  result = new float[]{getFloat(object, 0.0F)};
//		    } else if (object instanceof Object[]) {
//			  Object[] array = (Object[]) ((Object[]) object);
//			  result = new float[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getFloat(array[i], 0.0F);
//			  }
//		    } else if (object.getClass().isArray()) {
//			  int len = Array.getLength(object);
//			  result = new float[len];
//
//			  for (i = 0; i < len; ++i) {
//				result[i] = getFloat(Array.get(object, i), 0.0F);
//			  }
//		    } else if (object instanceof Boolean) {
//			  result = new float[]{getFloat(object, 0.0F)};
//		    } else {
//			  result = defValue;
//		    }
//		}
//
//		return result;
//	  }
//    }

//    public static final float[] getFloatArray(Object object) {
//	  return getFloatArray(object, (float[]) null);
//    }

//    public static final double[] getDoubleArray(Object object, double[] defValue) {
//	  if (object == null) {
//		return defValue;
//	  } else {
//		double[] result = null;
//		double[] result;
//		if (object instanceof double[]) {
//		    result = (double[]) ((double[]) object);
//		} else {
//		    int i;
//		    if (object instanceof String) {
//			  String[] array = StringUtils.split((String) object, ',');
//			  result = new double[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getDouble(array[i], 0.0D);
//			  }
//		    } else if (object instanceof Number) {
//			  result = new double[]{getDouble(object, 0.0D)};
//		    } else if (object instanceof Object[]) {
//			  Object[] array = (Object[]) ((Object[]) object);
//			  result = new double[array.length];
//
//			  for (i = 0; i < array.length; ++i) {
//				result[i] = getDouble(array[i], 0.0D);
//			  }
//		    } else if (object.getClass().isArray()) {
//			  int len = Array.getLength(object);
//			  result = new double[len];
//
//			  for (i = 0; i < len; ++i) {
//				result[i] = getDouble(Array.get(object, i), 0.0D);
//			  }
//		    } else if (object instanceof Boolean) {
//			  result = new double[]{getDouble(object, 0.0D)};
//		    } else {
//			  result = defValue;
//		    }
//		}
//
//		return result;
//	  }
//    }

//    public static final double[] getDoubleArray(Object object) {
//	  return getDoubleArray(object, (double[]) null);
//    }

    public static final Date getDate(Object obj) {
	  return getDate(obj, (Date) null);
    }

    public static final Date getDate(Object obj, Date defValue) {
	  return getDate(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), defValue);
    }

    public static final Date getDate(Object obj, DateFormat format) {
	  return getDate(obj, format, (Date) null);
    }

    public static final Date getDate(Object obj, DateFormat format, Date defValue) {
	  if (obj instanceof Date) {
		return (Date) obj;
	  } else if (obj instanceof Timestamp) {
		Timestamp timestamp = (Timestamp) obj;
		return new Date(timestamp.getTime() + (long) (timestamp.getNanos() / 1000000));
	  } else if (obj instanceof Long) {
		return new Date((Long) obj);
	  } else if (obj instanceof String) {
		try {
		    return format.parse((String) obj);
		} catch (Exception var4) {
		    return defValue;
		}
	  } else {
		return defValue;
	  }
    }

    public static final Timestamp getTimestamp(Object obj) {
	  return getTimestamp(obj, (Timestamp) null);
    }

    public static final Timestamp getTimestamp(Object obj, Timestamp defValue) {
	  if (obj instanceof Timestamp) {
		return (Timestamp) obj;
	  } else if (obj instanceof Date) {
		return new Timestamp(((Date) obj).getTime());
	  } else if (obj instanceof Long) {
		return new Timestamp((Long) obj);
	  } else if (obj instanceof String) {
		try {
		    return Timestamp.valueOf((String) obj);
		} catch (Exception var3) {
		    return defValue;
		}
	  } else {
		return defValue;
	  }
    }

    public static final Time getTime(Object obj) {
	  return getTime(obj, (Time) null);
    }

    public static final Time getTime(Object obj, Time defValue) {
	  if (obj instanceof Time) {
		return (Time) obj;
	  } else if (obj instanceof Date) {
		return new Time(((Date) obj).getTime());
	  } else if (obj instanceof Long) {
		return new Time((Long) obj);
	  } else if (obj instanceof String) {
		try {
		    return Time.valueOf((String) obj);
		} catch (Exception var3) {
		    return defValue;
		}
	  } else {
		return defValue;
	  }
    }

    private static boolean isAllZeros(String s) {
	  if (s == null) {
		return true;
	  } else {
		for (int i = s.length() - 1; i >= 0; --i) {
		    if (s.charAt(i) != '0') {
			  return false;
		    }
		}

		return s.length() > 0;
	  }
    }

    public static final boolean isNumberClass(Class clazz) {
	  return clazz == Byte.class || clazz == Byte.TYPE || clazz == Short.class || clazz == Short.TYPE || clazz == Integer.class || clazz == Integer.TYPE || clazz == Long.class || clazz == Long.TYPE || clazz == Float.class || clazz == Float.TYPE || clazz == Double.class || clazz == Double.TYPE || clazz == BigInteger.class || clazz == BigDecimal.class;
    }

    public static final boolean isFloatingPointType(Object pObject) {
	  return pObject != null && isFloatingPointType(pObject.getClass());
    }

    public static final boolean isFloatingPointType(Class pClass) {
	  return pClass == Float.class || pClass == Float.TYPE || pClass == Double.class || pClass == Double.TYPE;
    }

    public static final boolean isFloatingPointString(Object pObject) {
	  if (!(pObject instanceof String)) {
		return false;
	  } else {
		String str = (String) pObject;
		int len = str.length();

		for (int i = 0; i < len; ++i) {
		    char ch = str.charAt(i);
		    if (ch == '.' || ch == 'e' || ch == 'E') {
			  return true;
		    }
		}

		return false;
	  }
    }

    public static final boolean isIntegerType(Object pObject) {
	  return pObject != null && isIntegerType(pObject.getClass());
    }

    public static final boolean isIntegerType(Class pClass) {
	  return pClass == Byte.class || pClass == Byte.TYPE || pClass == Short.class || pClass == Short.TYPE || pClass == Character.class || pClass == Character.TYPE || pClass == Integer.class || pClass == Integer.TYPE || pClass == Long.class || pClass == Long.TYPE;
    }

    public static final boolean isBigInteger(Object pObject) {
	  return pObject != null && pObject instanceof BigInteger;
    }

    public static final boolean isBigDecimal(Object pObject) {
	  return pObject != null && pObject instanceof BigDecimal;
    }
}
