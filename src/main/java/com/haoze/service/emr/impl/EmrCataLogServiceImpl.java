package com.haoze.service.emr.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.enumeration.common.DelFlagEnum;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ZTree;
import com.haoze.dao.emr.EmrCataLogDao;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import com.haoze.service.emr.EmrCataLogService;
import com.haoze.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 病历目录数据服务实现类。
 *
 * @author maxl
 * @time 2018-05-31。
 */
@Service
public class EmrCataLogServiceImpl implements EmrCataLogService {

    @Autowired
    EmrCataLogDao emrCataLogDao;

    @Override
    public void insert(EmrCataLogEntity emrCataLogEntity) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public void update(EmrCataLogEntity emrCataLogEntity) {

    }

    @Override
    public EmrCataLogEntity get(String s) {
        return null;
    }

    @Override
    public Page<EmrCataLogEntity> list(QueryParam queryParam) {
        return null;
    }

    @Override
    public List<ZTree> getZtree(QueryParam queryParam) {

        PageHelper.startPage(queryParam.getPage(), queryParam.getLimit());
        queryParam.put("delFlag", DelFlagEnum.Not_Deleted.getEnumValue());
        Page<EmrCataLogEntity> emrCataLogEntities = emrCataLogDao.list(queryParam);
        EmrCataLogEntity topCataLog = new EmrCataLogEntity();
        topCataLog.setID(UUIDUtil.randomString());
        topCataLog.setNameCatalog("病程");
        topCataLog.setPkFather("0");

        List<ZTree> zTrees = new ArrayList();
        Map<String, List<EmrCataLogEntity>> children = new HashMap();
        for (EmrCataLogEntity emrCataLogEntity : emrCataLogEntities) {

            List<EmrCataLogEntity> list;
            if (emrCataLogEntity.getPkFather() == null) {
                emrCataLogEntity.setPkFather(topCataLog.getID());
            }

            if (children.get(emrCataLogEntity.getPkFather()) == null) {
                list = new ArrayList();
            } else {
                list = children.get(emrCataLogEntity.getPkFather());
            }
            list.add(emrCataLogEntity);
            children.put(emrCataLogEntity.getPkFather(), list);
        }

        emrCataLogEntities.add(topCataLog);
        for (EmrCataLogEntity emrCataLogEntity : emrCataLogEntities) {
            ZTree<EmrCataLogEntity> zTree = new ZTree();
            zTree.setId(emrCataLogEntity.getID());
            zTree.setpId(emrCataLogEntity.getPkFather());
            zTree.setName(emrCataLogEntity.getNameCatalog());
            if(children.get(emrCataLogEntity.getID()) == null || children.get(emrCataLogEntity.getID()).size() == 0){
                zTree.setIsParent(false);
            }else{
                zTree.setIsParent(true);
            }
            zTree.setOpen(false);
            zTrees.add(zTree);
        }
        return zTrees;
    }


    @Override
    public int count(QueryParam queryParam) {
        return 0;
    }
}
