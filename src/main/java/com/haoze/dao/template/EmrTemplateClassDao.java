package com.haoze.dao.template;

import com.github.pagehelper.Page;
import com.haoze.common.model.BaseDao;
import com.haoze.common.model.QueryParam;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.model.template.templateclass.po.EmrTemplateClassVO;

/**
 * 模板类型数据操作类。
 * @author maxl
 * @time 2018-05-31。
 */
public interface EmrTemplateClassDao extends BaseDao<EmrTemplateClassEntity,String>{

    /**
     * 查询模板相关信息
     * @param queryParam
     * @return
     */
    Page<EmrTemplateClassVO> listEmrTemplateClass(QueryParam queryParam);
}