package com.haoze.common.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数。
 * @author maxl
 * @time 2018-04-27。
 */
public class QueryParam extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    private int limit;
    private int page;

    public QueryParam(Map<String, Object> params) {
        this.putAll(params);
        // 分页参数
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.page = Integer.parseInt(params.get("page").toString());
        this.put("page", page);
        this.put("limit", limit);
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
