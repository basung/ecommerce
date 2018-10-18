package com.basung.ecommerce.context;

import java.util.Locale;

/**
 * Date: 2018-10-17-下午8:06
 */
public class ApplicationContextUtils {

    private static GeekApplicationContext applicationContext;

    public ApplicationContextUtils() {
    }

    public static GeekApplicationContext getApplicationContext() {
	  return applicationContext;
    }

    public static void setApplicationContext(GeekApplicationContext context) {
	  applicationContext = context;
    }

    public static <T> T getBean(String name) {
	  return applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> tClass) {
	  return applicationContext.getBean(name, tClass);
    }

    public static <T> T getBean(Class<T> tClass) {
	  return applicationContext.getBean(tClass);
    }

    public static boolean containsBean(String name) {
	  return applicationContext.containsBean(name);
    }

    public static String getMessage(String code, Locale loc, Object... args) {
	  return applicationContext.getMessage(code, loc, args);
    }
}
