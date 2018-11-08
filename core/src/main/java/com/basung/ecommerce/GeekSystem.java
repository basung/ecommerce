package com.basung.ecommerce;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;

/**
 * Date: 2018-10-17-下午8:04
 */
public class GeekSystem {

    private static Map<String, String> properties = new HashMap();
    private static String hostname;
    private static final char[] ENCODER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    private static String home = null;
    private static String serverType;
    private static String identity = null;
    protected static Log log = LogFactory.getLog("geek.system");
    private static String libraryPath;
    private static String oSName;

    public GeekSystem() {
    }

    public static String getServerType() {
	  return serverType;
    }

    public static void setServerType(String serverType) {
	  serverType = serverType;
    }

    public static Collection<InetAddress> getIpAddresses() {
	  try {
		Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		ArrayList addresses = new ArrayList();

		while (allNetInterfaces.hasMoreElements()) {
		    NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
		    Enumeration en = netInterface.getInetAddresses();

		    while (en.hasMoreElements()) {
			  InetAddress ip = (InetAddress) en.nextElement();
			  addresses.add(ip);
		    }
		}

		return addresses;
	  } catch (Throwable var5) {
		log.warn("Can't get network interfaces:", var5);
		return CollectionUtils.EMPTY_COLLECTION;
	  }
    }

    public static String getJvmIdentity() {
	  return identity;
    }

    public static void setProperty(String key, String value) {
	  properties.put(key, value);
    }

    public static String getProperty(String key) {
	  String value = (String) properties.get(key);
	  if (value == null) {
		value = System.getProperty(key);
	  }

	  return value;
    }

    public static String getProperty(String key, String defValue) {
	  String value = (String) properties.get(key);
	  return value == null ? System.getProperty(key, defValue) : value;
    }

    public static Map<String, String> getProperties() {
	  return properties;
    }

    public static final String getHome() {
	  if (home == null) {
		home = getProperty("product.home", "/geek/product");
	  }

	  return home;
    }

    public static final String getHostName() {
	  return hostname;
    }

    public static final String getLibraryPath() {
	  if (libraryPath == null) {
		String home = getHome();
		if (home != null) {
		    StringBuilder sb = new StringBuilder(64);
		    sb.append(home).append(File.separatorChar);
		    sb.append("lib").append(File.separatorChar);
		    sb.append("native").append(File.separatorChar);
		    String osName = getOSName().toLowerCase();
		    sb.append(osName);
		    libraryPath = sb.toString();
		} else {
		    libraryPath = "/usr/lib";
		}
	  }

	  return libraryPath;
    }

    public static void loadLibrary(String libName) {
	  System.load(getLibraryFile(libName).getAbsolutePath());
    }

    public static File getLibraryFile(String libName) {
	  StringBuilder sb = new StringBuilder(getLibraryPath());
	  sb.append(File.separatorChar).append(libName);
	  return new File(sb.toString());
    }

    public static void sleep(long time) {
	  try {
		Thread.sleep(time);
	  } catch (Exception var3) {
		;
	  }

    }

    public static void sleep(long time, int nanos) {
	  try {
		Thread.sleep(time, nanos);
	  } catch (Exception var4) {
		;
	  }

    }

    public static String getOSName() {
	  if (oSName == null) {
		oSName = getProperty("os.name");
	  }

	  return oSName;
    }

    public static boolean isWindows() {
	  return getOSName().indexOf("indows") >= 0;
    }

    public static String getOSVersion() {
	  return getProperty("os.version");
    }

    public static String getJavaVersion() {
	  return getProperty("java.version");
    }

    public static String getJavaSpecificationVersion() {
	  return getProperty("java.specification.version");
    }

    public static Log getLog() {
	  return log;
    }

    static {
	  StringBuilder key = new StringBuilder();

	  try {
		InetAddress localhost = InetAddress.getLocalHost();
		String host = localhost.getHostAddress();
		hostname = localhost.getHostName();
		key.append(host);
	  } catch (Exception var6) {
		key.append(var6.getMessage());
	  }

	  long time = System.currentTimeMillis();
	  key.append(time);
	  key.append((new Random(time)).nextInt());
	  byte[] md5 = DigestUtils.md5(key.toString());
	  StringBuilder sb = new StringBuilder(8);
	  int i = 0;

	  while (i < md5.length) {
		sb.append(ENCODER[(md5[i++] & 48 | md5[i++] & 15) % 36]);
	  }

	  identity = sb.toString();
	  if (hostname == null) {
		hostname = identity;
	  }

	  oSName = null;
    }

}
