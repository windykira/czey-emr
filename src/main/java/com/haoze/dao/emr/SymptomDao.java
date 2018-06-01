package com.haoze.dao.emr;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 部门数据操作类。
 * @author maxl
 * @time 2018-04-27。
 */
public interface SymptomDao {

	List<Map> getSympTree();
	List<Map> getSimuInfo();
	List<Map> getSympInfo();
}
