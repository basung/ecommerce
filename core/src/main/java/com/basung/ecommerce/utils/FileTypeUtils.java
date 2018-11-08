package com.basung.ecommerce.utils;

import javax.activation.FileTypeMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2018-10-17-下午8:02
 */
public class FileTypeUtils {
    public static final String DEFAULT_TYPE = "application/octet-stream";
    public static Map<String, String> typeToExtMap = new HashMap();
    public static Map<String, String> extToTypeMap = new HashMap();

    public FileTypeUtils() {
    }

    public static final String getContentType(String fileName) {
	  String type = FileTypeMap.getDefaultFileTypeMap().getContentType(fileName);
	  return StringUtilsEx.isNotBlank(type) ? type : "application/octet-stream";
    }

    public static String getExtName(String contentType) {
	  return (String) typeToExtMap.get(contentType.toLowerCase());
    }

    static {
	  typeToExtMap.put("image/jpeg", "jpg");
	  typeToExtMap.put("image/png", "png");
	  typeToExtMap.put("image/gif", "gif");
	  typeToExtMap.put("image/tiff", "au");
	  typeToExtMap.put("audio/basic", "tiff");
	  typeToExtMap.put("audio/midi", "midi");
	  typeToExtMap.put("audio/x-aifc", "aifc");
	  typeToExtMap.put("audio/x-aiff", "aif");
	  typeToExtMap.put("audio/x-mpeg", "mpeg");
	  typeToExtMap.put("audio/x-wav", "wav");
	  typeToExtMap.put("video/mpeg", "mpeg");
	  typeToExtMap.put("video/mp4", "mp4");
	  typeToExtMap.put("video/quicktime", "mov");
	  typeToExtMap.put("video/x-msvideo", "avi");
    }
}
