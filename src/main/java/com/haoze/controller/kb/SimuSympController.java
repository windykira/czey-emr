package com.haoze.controller.kb;/*
package com.haoze.controller.kb;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haoze.common.controller.BaseController;
import com.haoze.model.system.role.entity.RoleEntity;
import com.haoze.service.system.RoleService;

*/
/**
 * 知识库伴随症状字典控制器信息。
 * @author daiyiming
 * @time 2018-05-03。
 *//*

@RequestMapping("emrsys/kb/simusymp/")
@Controller
public class SimuSympController extends BaseController{

    String prefix = "emrsys/kb/symp/";
    @Autowired
    RoleService roleService;

    @RequiresPermissions("kb:symp:symp")
    @GetMapping()
    String symp() {
        return prefix + "/symp";
    }

    @RequiresPermissions("kb:symp:symp")
    @GetMapping("/list")
    @ResponseBody()
    List<RoleEntity> list() {
        List<RoleEntity> roles = roleService.list();
        return roles;
    }

//    @Note("添加角色")
//    @RequiresPermissions("sys:role:add")
//    @GetMapping("/add")
//    String add() {
//        return prefix + "/add";
//    }
//
//    @Note("编辑角色")
//    @RequiresPermissions("sys:role:edit")
//    @GetMapping("/edit/{id}")
//    String edit(@PathVariable("id") Long id, Model model) {
//        RoleEntity roleDO = roleService.get(id);
//        model.addAttribute("role", roleDO);
//        return prefix + "/edit";
//    }
//
//    @Note("保存角色")
//    @RequiresPermissions("sys:role:add")
//    @PostMapping("/save")
//    @ResponseBody()
//    ResponseResult save(RoleEntity role) {
//        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//            return ResponseResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
//        }
//        if (roleService.save(role) > 0) {
//            return ResponseResult.success();
//        } else {
//            return ResponseResult.failure(1, "保存失败");
//        }
//    }
//
//    @Note("更新角色")
//    @RequiresPermissions("sys:role:edit")
//    @PostMapping("/update")
//    @ResponseBody()
//    ResponseResult update(RoleEntity role) {
//        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//            return ResponseResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
//        }
//        if (roleService.update(role) > 0) {
//            return ResponseResult.success();
//        } else {
//            return ResponseResult.failure(1, "保存失败");
//        }
//    }
}
*/
