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
import com.haoze.utils.UUIDUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 病历文件服务实现类。
 * @author maxl
 * @time 2018-06-21。
 */
@Service
public class EmrFileServiceImpl implements EmrFileService{

    @Autowired
    EmrFileDao emrFileDao;

    @Override
    @Transactional
    public ResponseResult insert(EmrFileEntity emrFileEntity) {
        try {
            emrFileDao.insert(emrFileEntity);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0,"保存失败。");
        }
    }

    @Override
    @Transactional
    public ResponseResult delete(String emrFileId) {
        try {
            emrFileDao.delete(emrFileId);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0,"删除失败。");
        }
    }

    @Override
    public ResponseResult update(EmrFileEntity emrFileEntity) {
        return null;
    }

    @Override
    public EmrFileEntity get(String emrFileId) {
        return emrFileDao.get(emrFileId);
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
        EmrFilePO topEmrFilePO = new EmrFilePO();
        topEmrFilePO.setCatalogId(UUIDUtil.randomString());
        topEmrFilePO.setCatalogName("病程");
        topEmrFilePO.setParentCatalogId("0");

        //加载默认根节点
        ZTree<EmrFilePO> rootTree = new ZTree();
        rootTree.setId(topEmrFilePO.getCatalogId());
        rootTree.setName(topEmrFilePO.getCatalogName());
        rootTree.setpId(topEmrFilePO.getParentCatalogId());
        zTrees.add(rootTree);

        if(emrFilePOs.size() != 0){
            List<String> catalogIds = new ArrayList();
            emrFilePOs.forEach(emrFilePO -> {

                ZTree<EmrFilePO> zTree = new ZTree();
                zTree.setId(emrFilePO.getEmrFileId());
                zTree.setName(emrFilePO.getEmrFileName());
                zTree.setpId(emrFilePO.getCatalogId());
                zTrees.add(zTree);

                if(!catalogIds.contains(emrFilePO.getCatalogId())){
                    ZTree<EmrFilePO> parentZTree = new ZTree();
                    parentZTree.setId(emrFilePO.getCatalogId());
                    parentZTree.setName(emrFilePO.getCatalogName());
                    parentZTree.setpId(emrFilePO.getParentCatalogId());
                    zTrees.add(parentZTree);
                    catalogIds.add(emrFilePO.getCatalogId());
                }

                if(!catalogIds.contains(emrFilePO.getParentCatalogId())){
                    ZTree<EmrFilePO> topZTree = new ZTree();
                    topZTree.setId(emrFilePO.getParentCatalogId());
                    topZTree.setName(emrFilePO.getParentCatalogName());
                    topZTree.setpId(rootTree.getId());
                    zTrees.add(topZTree);
                    catalogIds.add(emrFilePO.getParentCatalogId());
                }

            });
        }
        return zTrees;
    }
}
