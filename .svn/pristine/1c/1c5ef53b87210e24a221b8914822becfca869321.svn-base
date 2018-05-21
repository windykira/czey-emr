package com.haoze.service.kb;

import com.haoze.common.model.ResponseResult;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 知识库症状服务接口。
 * @author daiyiming
 * @time 2018-05-09。
 */
@Service
public interface EmrSympService {

    /**
     * 新增角色
     * @param role
     * @return
     */
    ResponseResult save(EmrRoleEntity role);

    /**
     *删除角色
     * @param roleId
     * @return
     */
    ResponseResult remove(String roleId);

    /**
     * 批量删除角色
     * @param ids
     */
    ResponseResult batchRemove(String[] ids);

    /**
     * 更新角色
     * @param role
     */
    ResponseResult update(EmrRoleEntity role);

    /**
     * 查询角色列表
     * @return
     */
    List<EmrRoleEntity> listRoles();

    /**
     * 获取角色信息
     * @param roleId
     * @return
     */
    EmrRoleEntity get(String roleId);
}
