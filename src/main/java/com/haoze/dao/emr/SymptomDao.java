package com.haoze.dao.emr;

import com.haoze.model.emr.symp.entity.SimuSympEntity;
import com.haoze.model.emr.symp.entity.SympEntity;

import java.util.List;
import java.util.Map;

/**
 * 部门数据操作类。
 * @author maxl
 * @time 2018-04-27。
 */
public interface SymptomDao {

	List<SympEntity> listSymp();
	List<SimuSympEntity> listSimuSymp();
	List<Map> getSympTree();
	List<Map> getSimuInfo();
	List<Map> getSympInfo();
}
