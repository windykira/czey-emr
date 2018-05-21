package com.haoze.service.kb.impl;

import com.haoze.common.model.ResponseResult;
import com.haoze.dao.system.EmrRoleDao;
import com.haoze.dao.system.EmrRoleMenuDao;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.model.system.role.entity.EmrRoleMenuEntity;
import com.haoze.service.kb.EmrSympService;
import com.haoze.utils.ShiroUtil;
import com.haoze.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 知识库症状数据服务接口实现类。
 * @author daiyiming
 * @time 2018-05-09。
 */
@Service
public class EmrSimuSympServiceImpl implements EmrSympService{

    @Autowired
    EmrRoleDao emrRoleMapper;
    @Autowired
    EmrRoleMenuDao emrRoleMenuMapper;

    @Transactional
    @Override
    public ResponseResult save(EmrRoleEntity role) {
        try {
            role.setID(UUIDUtil.randomString());
            //新增角色
            emrRoleMapper.save(role);
            //新增角色菜单关联关系
            List<String> menuIDs = role.getMenuIDs();
            List<EmrRoleMenuEntity> roleMenus = new ArrayList();
            for(String menuID : menuIDs){

                EmrRoleMenuEntity roleMenuEntity = new EmrRoleMenuEntity();
                roleMenuEntity.setPkRoleMenu(UUIDUtil.randomString());
                roleMenuEntity.setPkRole(role.getID());
                roleMenuEntity.setPkMenu(menuID);
                roleMenuEntity.setCreateTime(new Date());
                roleMenuEntity.setCreator(ShiroUtil.getUserId());
                roleMenuEntity.setModifier(ShiroUtil.getUserId());
                roleMenuEntity.setModifyTime(new Date());
                roleMenuEntity.setDelFlag("0");
                roleMenuEntity.setPkOrg(ShiroUtil.getUser().getUserOrganization());
                roleMenus.add(roleMenuEntity);
            }
            if(roleMenus.size() > 0){
                emrRoleMenuMapper.batchSave(roleMenus);
            }
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0, "保存失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult remove(String roleId) {
        try {
            //TODO 如果角色绑定用户 则该角色不能删除

            //删除角色菜单关联数据
            emrRoleMenuMapper.removeByRoleId(roleId);
            //删除角色信息
            emrRoleMapper.remove(roleId);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0,"删除失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult batchRemove(String[] ids) {
        try {
            //TODO 如果角色绑定用户 则该角色不能删除

            for(String id : ids){
                //删除角色菜单关联数据
                emrRoleMenuMapper.removeByRoleId(id);
                //删除角色信息
                emrRoleMapper.remove(id);
            }
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0,"删除失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult update(EmrRoleEntity role) {

        try {
            emrRoleMapper.update(role);
            //删除原先角色菜单关联关系
            emrRoleMenuMapper.removeByRoleId(role.getID());
            if(role.getMenuIDs() != null && role.getMenuIDs().size() > 0){
                //新增角色菜单关联关系
                List<String> menuIDs = role.getMenuIDs();
                List<EmrRoleMenuEntity> roleMenus = new ArrayList();
                for(String menuID : menuIDs){

                    EmrRoleMenuEntity roleMenuEntity = new EmrRoleMenuEntity();
                    roleMenuEntity.setPkRoleMenu(UUIDUtil.randomString());
                    roleMenuEntity.setPkRole(role.getID());
                    roleMenuEntity.setPkMenu(menuID);
                    roleMenuEntity.setCreateTime(new Date());
                    roleMenuEntity.setCreator(ShiroUtil.getUserId());
                    roleMenuEntity.setModifier(ShiroUtil.getUserId());
                    roleMenuEntity.setModifyTime(new Date());
                    roleMenuEntity.setDelFlag("0");
                    roleMenuEntity.setPkOrg(ShiroUtil.getUser().getUserOrganization());
                    roleMenus.add(roleMenuEntity);
                }
                if(roleMenus.size() > 0){
                    emrRoleMenuMapper.batchSave(roleMenus);
                }
            }
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @Override
    public List<EmrRoleEntity> listRoles() {
        return emrRoleMapper.listRoles(new HashMap());
    }

    @Override
    public EmrRoleEntity get(String roleId) {
        //查询角色信息
        EmrRoleEntity emrRoleEntity = emrRoleMapper.get(roleId);
        return emrRoleEntity;
    }
}
