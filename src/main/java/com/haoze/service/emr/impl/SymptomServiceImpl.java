package com.haoze.service.emr.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haoze.dao.emr.SymptomDao;
import com.haoze.model.emr.symp.entity.SimuSympEntity;
import com.haoze.service.emr.SymptomService;

/**
 * 部门数据服务实现类。
 * @author maxl
 * @time 2018-05-02。
 */
@SuppressWarnings("rawtypes")
@Service
public class SymptomServiceImpl implements SymptomService {

    @Autowired
    private SymptomDao dao;

    public Map<String,String> getRecMap(String id, String name, String pid) {
    	Map<String,String> m = new HashMap<String,String>();
    	m.put("id", id);
    	m.put("name", name);
    	m.put("pid",pid);
    	return m;
    }
    
    @Override
    public List<Map> getSympTree() {
    	return dao.getSympTree();
    }
    @Override
    public List<Map> getSympInfo() {
    	return dao.getSympInfo();
    }
    @Override
    public List<Map> getSimuInfo() {
    	return dao.getSimuInfo();
    }
    
	@SuppressWarnings("unchecked")
	@Override
    public Map getSympAndSimuInfo() {
    	Map result = new HashMap();
    	result.put("symp", dao.getSympInfo());
    	result.put("simu", dao.getSimuInfo());
    	return result;
    }
}
