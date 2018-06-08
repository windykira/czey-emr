package com.haoze.service.kb;

import java.util.List;

import org.springframework.stereotype.Service;

import com.haoze.common.model.ResponseResult;
import com.haoze.model.kb.symp.entity.SympEntity;

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
	ResponseResult save(SympEntity role);

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
    ResponseResult update(SympEntity role);

    /**
     * 查询角色列表
     * @return
     */
    List<SympEntity> listRoles();

    /**
     * 获取角色信息
     * @param roleId
     * @return
     */
    SympEntity get(String roleId);
}
