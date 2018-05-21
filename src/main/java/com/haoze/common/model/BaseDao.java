package com.haoze.common.model;

import com.github.pagehelper.Page;

/**
 * 基本数据操作接口。
 * @author maxl
 * @time 2018-05-16。
 */
public interface BaseDao<T,K> {

    void save(T t);
    void delete(K k);
    void update(T t);
    T get(K k);
    Page<T> list(QueryParam queryParam);
    int count(QueryParam queryParam);
}
