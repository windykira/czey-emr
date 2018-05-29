package com.haoze.service.template;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.model.template.temp.entity.TemplateEntity;

/**
 * 模板管理接口。
 * @author yangyb
 * @time 2018-05-19。
 */
@Service
public interface TemplateService {
	List<Map> getTypes();

	ResponseResult save(TemplateEntity e, String xml);

	Page<TemplateEntity> list(QueryParam queryParam);

	int count(QueryParam queryParam);
}
