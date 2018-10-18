package com.basung.ecommerce.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagingResult {
    private int status = 200;
    private long total;
    private Object[] rows;
    private Map<String, Object> params;
    private int pageIndex;
    private int pageSize;
    private String callback;

    public PagingResult() {
    }

    public static <T> PagingResult getResult(PagingList<T> list) {
        return getResult(list, (long)list.getTotalCount());
    }

    public static <T> PagingResult getResult(List<T> list, long totalCount) {
        PagingResult result = new PagingResult();
        result.setRows(list);
        result.setTotal(totalCount);
        return result;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object[] getRows() {
        return this.rows;
    }

    public void setRows(Object[] rows) {
        this.rows = rows;
    }

    public <T> void setRows(List<T> data) {
        this.rows = new Object[data.size()];

        for(int i = 0; i < data.size(); ++i) {
            this.rows[i] = data.get(i);
        }

    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public void setParam(String key, Object value) {
        if (this.params == null) {
            this.params = new HashMap();
        }

        this.params.put(key, value);
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getCallback() {
        return this.callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
