package com.haoze.dao.template;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.model.template.temp.entity.TemplateEntity;

public interface TemplateDao {

	List<Map> getTypes();

	void insert(TemplateEntity e);

	int count(QueryParam queryParam);

	Page<TemplateEntity> list(QueryParam queryParam);

}