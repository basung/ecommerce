package com.basung.ecommerce.context;

import java.util.Locale;

/**
 * Date: 2018-10-17-下午8:06
 */
public interface GeekApplicationContext {
    <T> T getBean(String var1);

    <T> T getBean(String var1, Class<T> var2);

    <T> T getBean(Class<T> var1);

    boolean containsBean(String var1);

    String getMessage(String var1, Locale var2, Object... var3);
}
