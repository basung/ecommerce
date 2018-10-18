package com.basung.ecommerce.common.controller;

import com.basung.ecommerce.exception.GlobalException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtils {

    public ResponseUtils() {
    }

    protected static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    public static void writeSuccessResult(HttpServletResponse response) throws Exception {
        writeSuccessResult(response, (Object)null);
    }

    public static void writeSuccessResult(HttpServletResponse response, Object data) throws Exception {
        ObjectMapper objectMapper = getObjectMapper();
        Map resultMap = new HashMap();
        resultMap.put("status", 200);
        if (data != null) {
            resultMap.put("data", data);
        }
        response.setContentType("application/json; charset=utf-8");
        objectMapper.writeValue(response.getWriter(), resultMap);
    }

    /** @deprecated */
    @Deprecated
    public static void writeSuccessPagingResult(HttpServletResponse response, int offset, int pageSize, Object data, int totalCount) throws Exception {
        ObjectMapper objectMapper = getObjectMapper();
        Map resultMap = new HashMap();
        resultMap.put("status", 200);
        resultMap.put("offset", offset);
        resultMap.put("pageSize", pageSize);
        resultMap.put("totalCount", totalCount);
        resultMap.put("data", data);
        response.setContentType("application/json; charset=utf-8");
        objectMapper.writeValue(response.getWriter(), resultMap);
    }

    /** @deprecated */
    @Deprecated
    public static void writeSuccessPagingResult(HttpServletResponse response, int offset, int pageSize, Object data, int totalCount, Map<String, Object> params) throws Exception {
        ObjectMapper objectMapper = getObjectMapper();
        Map resultMap = new HashMap();
        resultMap.put("status", 200);
        resultMap.put("offset", offset);
        resultMap.put("pageSize", pageSize);
        resultMap.put("totalCount", totalCount);
        resultMap.put("data", data);
        resultMap.put("params", params);
        response.setContentType("application/json; charset=utf-8");
        objectMapper.writeValue(response.getWriter(), resultMap);
    }

    public static void writeSuccessPagingResult(HttpServletResponse response, PagingResult result) throws Exception {
        ObjectMapper objectMapper = getObjectMapper();
        response.setContentType("application/json; charset=utf-8");
        objectMapper.writeValue(response.getWriter(), result);
    }

    public static void writeErrorResult(HttpServletResponse response, int status, String errorMessage) throws Exception {
        ObjectMapper objectMapper = getObjectMapper();
        Map resultMap = new HashMap();
        resultMap.put("status", status);
        resultMap.put("message", errorMessage);
        response.setContentType("application/json; charset=utf-8");
        objectMapper.writeValue(response.getWriter(), resultMap);
    }

    public static void writeErrorResult(HttpServletResponse response, GlobalException e) throws Exception {
        writeErrorResult(response, e.getCode(), e.getMessage());
    }

}
