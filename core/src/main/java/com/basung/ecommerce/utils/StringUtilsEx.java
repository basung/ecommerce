package com.basung.ecommerce.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Date: 2018-10-17-下午8:02
 */
public class StringUtilsEx extends StringUtils {

    public static final String NULL = "null";
    public static final char[] NULL_CHARS = "null".toCharArray();
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final String EMPTY_STRING = "";

    public StringUtilsEx() {
    }

    public static final byte[] toBytes(String str) {
	  return toBytes(str, (String)null);
    }

    public static final byte[] toBytes(String str, String encoding) {
	  byte[] bytes = null;
	  if (str == null) {
		return null;
	  } else if (str.length() == 0) {
		return DataUtils.EMPTY_BYTE_ARRAY;
	  } else {
		byte[] bytesArr;
		if (encoding == null) {
		    bytesArr = str.getBytes();
		} else {
		    try {
			  bytesArr = str.getBytes(encoding);
		    } catch (Exception var4) {
			  bytesArr = str.getBytes();
		    }
		}

		return bytesArr;
	  }
    }

    public static final String toString(byte[] bytes, int off, int len, String encoding) {
	  String result = null;
	  if (bytes == null) {
		return null;
	  } else {
		if (encoding == null) {
		    result = new String(bytes, off, len);
		} else {
		    try {
			  result = new String(bytes, off, len, encoding);
		    } catch (Exception var6) {
			  result = new String(bytes, off, len);
		    }
		}

		return result;
	  }
    }

    public static final String toString(byte[] bytes, String encoding) {
	  return bytes == null ? null : toString(bytes, 0, bytes.length, encoding);
    }

    public static final String toString(byte[] bytes) {
	  return toString(bytes, (String)null);
    }
}
