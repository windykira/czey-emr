package com.haoze.service.template.impl;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.dao.template.EmrTemplateClassDao;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.service.template.EmrTemplateClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 病历模板类型接口实现类。
 * @author maxl
 * @time 2018-05-31。
 */
@Service
public class EmrTemplateClassServiceImpl implements EmrTemplateClassService {

    @Autowired
    EmrTemplateClassDao emrTemplateClassDao;

    @Override
    public void insert(EmrTemplateClassEntity emrTemplateClassEntity) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void update(EmrTemplateClassEntity emrTemplateClassEntity) {

    }

    @Override
    public EmrTemplateClassEntity get(String s) {
        return null;
    }

    @Override
    public Page<EmrTemplateClassEntity> list(QueryParam queryParam) {
        return emrTemplateClassDao.list(queryParam);
    }

    @Override
    public int count(QueryParam queryParam) {
        return 0;
    }
}
