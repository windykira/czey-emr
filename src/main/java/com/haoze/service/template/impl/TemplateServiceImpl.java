package com.haoze.service.template.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.enumeration.common.DelFlagEnum;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.dao.template.TemplateDao;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import com.haoze.model.system.user.entity.EmrUserDepartmentEntity;
import com.haoze.model.system.user.entity.EmrUserRoleEntity;
import com.haoze.model.template.temp.entity.TemplateEntity;
import com.haoze.service.template.TemplateService;
import com.haoze.utils.HumpUnderlineUtil;
import com.haoze.utils.MyFileUtil;
import com.haoze.utils.ShiroUtil;
import com.haoze.utils.UUIDUtil;

/**
 * 模板管理实现类。
 * @author yangyb
 * @time 2018-05-19。
 */
@SuppressWarnings("rawtypes")
@Service
public class TemplateServiceImpl implements TemplateService {
	
	@Value("${filePath}")
	private String filePath;
	
    @Autowired
    private TemplateDao dao;
    
    @Override
    public List<Map> getTypes() {
    	return dao.getTypes();
    }
    
    @Override
    public ResponseResult save(TemplateEntity entity,String xml) {
    	
    	 try {
    		 dao.insert(entity);
    		 String code = entity.getCodeTmp();
    		 String path = entity.getContent();
    		 String id = entity.getPkTemplate();
    		 MyFileUtil.writeFile(filePath+"template\\",id+code+".xml",xml);
             return ResponseResult.success();
         }catch (Exception e){
             e.printStackTrace();
             TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
             return ResponseResult.failure(0, "新增失败");
         }
    }
    

    @Override
    public Page<TemplateEntity> list(QueryParam queryParam) {
    	PageHelper.startPage(queryParam.getPage(),queryParam.getLimit());
    	if(queryParam.get("sort") != null){
            queryParam.put("sort",HumpUnderlineUtil.humpToLine(queryParam.get("sort").toString()));
        }
        return dao.list(queryParam);
    }
    
    @Override
    public int count(QueryParam queryParam) {
    	return dao.count(queryParam);
    }
}
