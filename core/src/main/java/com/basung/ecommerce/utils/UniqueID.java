package com.basung.ecommerce.utils;

import java.util.Random;

/**
 * Date: 2018-10-17-下午8:01
 */
public class UniqueID {

    private static final String[] ASCII_ARRAY = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static final int DEFAULT_LENGTH = 6;
    private static Random factory = new Random();

    public UniqueID() {
    }

    public static final String nextString(String prefix) {
	  StringBuilder sb = new StringBuilder(prefix.length() + 10);
	  sb.append(factory.nextLong() & 9223372036854775807L);
	  return sb.toString();
    }

    public static final String nextString() {
	  return String.valueOf(factory.nextLong() & 9223372036854775807L);
    }

    public static final long next() {
	  return factory.nextLong() & 9223372036854775807L;
    }

    public static final int nextInt() {
	  return factory.nextInt() & 2147483647;
    }

    public static final int nextInt(int max) {
	  return factory.nextInt(max);
    }

    public static final String nextCode() {
	  return nextCode(6);
    }

    public static final String nextCode(boolean ascii) {
	  return nextCode(6, ascii);
    }

    public static final String nextCode(int len) {
	  if (len <= 0) {
		return nextCode();
	  } else {
		StringBuilder code = new StringBuilder(len);

		for (int i = 0; i < len; ++i) {
		    code.append(ASCII_ARRAY[factory.nextInt(10)]);
		}

		return code.toString();
	  }
    }

    public static final String nextCode(int len, boolean ascii) {
	  if (len <= 0) {
		return nextCode(ascii);
	  } else if (!ascii) {
		return nextCode(len);
	  } else {
		StringBuilder code = new StringBuilder(len);

		for (int i = 0; i < len; ++i) {
		    code.append(ASCII_ARRAY[factory.nextInt(ASCII_ARRAY.length)]);
		}

		return code.toString();
	  }
    }

}
