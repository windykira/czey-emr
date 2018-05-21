package com.haoze.service.emr.impl;

import com.haoze.dao.emr.SymptomDao;
import com.haoze.model.emr.symp.entity.SimuSympEntity;
import com.haoze.model.emr.symp.entity.SympEntity;
import com.haoze.service.emr.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Map<String,String>> listSympAndSimuSymp() {
    	List<SimuSympEntity> simuSympList = dao.listSimuSymp();
    	
    	List<SympEntity> symplist = dao.listSymp();
    	
    	List<Map<String,String>> result = new ArrayList<Map<String,String>>();
    	result.add(getRecMap("0","症状",""));
    	for(SympEntity e : symplist) {
    		result.add(getRecMap(e.getID(),e.getSympName(),"0"));
    	}
    	return null;
    }
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
