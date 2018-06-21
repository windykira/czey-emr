package com.haoze.service.emr.impl;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.ZTree;
import com.haoze.dao.emr.EmrFileDao;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import com.haoze.model.emr.emrwriting.entity.EmrFileEntity;
import com.haoze.model.emr.emrwriting.po.EmrFilePO;
import com.haoze.service.emr.EmrFileService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 病历文件服务实现类。
 * @author maxl
 * @time 2018-06-21。
 */
public class EmrFileServiceImpl implements EmrFileService{

    @Autowired
    EmrFileDao emrFileDao;

    @Override
    public ResponseResult insert(EmrFileEntity emrFileEntity) {
        return null;
    }

    @Override
    public ResponseResult delete(String s) {
        return null;
    }

    @Override
    public ResponseResult update(EmrFileEntity emrFileEntity) {
        return null;
    }

    @Override
    public EmrFileEntity get(String s) {
        return null;
    }

    @Override
    public Page<EmrFileEntity> list(QueryParam queryParam) {
        return null;
    }

    @Override
    public int count(QueryParam queryParam) {
        return 0;
    }

    @Override
    public List<ZTree> getZtree(QueryParam queryParam) {

        List<ZTree> zTrees = new ArrayList();
        List<EmrFilePO> emrFilePOs = emrFileDao.listEmrFiles(queryParam);
        emrFilePOs.forEach(emrFilePO -> {

            ZTree<EmrFilePO> zTree = new ZTree();
            zTree.setId(emrFilePO.getEmrFileId());
            zTree.setName(emrFilePO.getEmrFileName());
            zTree.setpId(emrFilePO.getCatalogId());
            zTrees.add(zTree);

            ZTree<EmrFilePO> parentZTree = new ZTree();
            parentZTree.setId(emrFilePO.getCatalogId());
            parentZTree.setName(emrFilePO.getCatalogName());
            parentZTree.setpId(emrFilePO.getParentCatalogId());
            zTrees.add(parentZTree);
        });
        return zTrees;
    }
}
