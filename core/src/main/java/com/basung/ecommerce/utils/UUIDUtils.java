package com.basung.ecommerce.utils;

/**
 * Date: 2018-10-18-上午9:58
 */

import java.util.UUID;

/**
 * UUID 工具类
 */
public class UUIDUtils {

    public static String getUUID() {
	  return UUID.randomUUID().toString().replace("-", "");
    }

}