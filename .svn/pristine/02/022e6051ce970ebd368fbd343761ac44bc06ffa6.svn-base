package com.haoze.controller.system;

import com.github.pagehelper.Page;
import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.enumeration.system.user.UserCreateStatusEnum;
import com.haoze.common.model.PaginationResult;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.system.department.entity.EmrDepartmentEntity;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.model.system.role.vo.EmrRoleVO;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.model.system.user.vo.EmrUserVO;
import com.haoze.service.system.EmrDepartmentService;
import com.haoze.service.system.EmrHisEmpService;
import com.haoze.service.system.EmrRoleService;
import com.haoze.service.system.EmrUserService;
import com.haoze.utils.FullNameUtil;
import com.haoze.utils.MD5Util;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 用户控制器信息。
 *
 * @author maxl
 * @time 2018-05-07。
 */
@RequestMapping("/emrsys/user")
@Controller
public class EmrUserController extends BaseController {

    @Autowired
    EmrUserService emrUserService;
    @Autowired
    EmrRoleService emrRoleService;
    @Autowired
    EmrDepartmentService emrDepartmentService;
    @Autowired
    EmrHisEmpService emrHisEmpService;

    private String prefix = "emrsys/user";

    @RequiresPermissions("sys:user:user")
    @GetMapping("")
    String user(Model model) {
        return prefix + "/emruser.html";
    }

    @GetMapping("/list")
    @ResponseBody
    PaginationResult list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        QueryParam queryParam = new QueryParam(params);
        Page<EmrUserEntity> sysUserList = emrUserService.listUsers(queryParam);
        int total = emrUserService.countUsers(queryParam);
        PaginationResult paginationResult = new PaginationResult(sysUserList,total);
        return paginationResult;
    }

    @RequiresPermissions("sys:user:add")
    @Note("添加用户")
    @GetMapping("/add/{empId}")
    String add(Model model, @PathVariable("empId") String empId) {
        List<EmrRoleEntity> roles = emrRoleService.listRoles();
        EmrHisEmpEntity emrHisEmpEntity = emrHisEmpService.get(empId);
        model.addAttribute("hisEmp",emrHisEmpEntity);
        model.addAttribute("roles", roles);
        return prefix + "/add";
    }

    @Note("保存用户")
    @RequiresPermissions("sys:user:add")
    @PostMapping("/save")
    @ResponseBody
    ResponseResult save(EmrUserVO userVO) {

        EmrUserEntity emrUser = userVO.getEmrUser();
        emrUser.setPassWord(MD5Util.encrypt(emrUser.getAccount(), emrUser.getPassWord()));
        userVO.setEmrUser(emrUser);

        EmrHisEmpEntity emrHisEmpEntity = new EmrHisEmpEntity();
        emrHisEmpEntity.setPkEmp(userVO.getEmpId());
        emrHisEmpEntity.setCreateStatus(UserCreateStatusEnum.Created.getEnumValue());
        ResponseResult responseResult = emrHisEmpService.update(emrHisEmpEntity);
        if(responseResult.get("code").equals("0")){
            return ResponseResult.failure();
        }
        return emrUserService.save(userVO);
    }

    @Note("删除用户")
    @RequiresPermissions("sys:user:remove")
    @PostMapping("/remove")
    @ResponseBody
    ResponseResult remove(String userId) {
        return emrUserService.remove(userId);
    }

    @Note("编辑用户")
    @RequiresPermissions("sys:user:edit")
    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable("id") String id) {

        EmrUserEntity emrUserEntity = emrUserService.get(id);
        model.addAttribute("emrUser", emrUserEntity);
        List<EmrDepartmentEntity> departments = emrDepartmentService.listEmrDepartmentsByUserId(id);
        String departmentNames = FullNameUtil.getFullDepartmentName(departments);
        model.addAttribute("departmentNames", departmentNames);
        List<EmrRoleVO> roles = emrRoleService.listUserRoles(id);
        model.addAttribute("roles", roles);
        return prefix + "/edit";
    }

    @Note("请求更改用户密码")
    @RequiresPermissions("sys:user:resetPwd")
    @GetMapping("/resetPassWord/{id}")
    String resetPassWord(@PathVariable("id") String userId, Model model) {

        EmrUserEntity emrUserEntity = new EmrUserEntity();
        emrUserEntity.setID(userId);
        model.addAttribute("user", emrUserEntity);
        return prefix + "/resetpwd";
    }

    @Note("提交更改用户密码")
    @RequiresPermissions("sys:user:resetPwd")
    @PostMapping("/postResetPassWord")
    @ResponseBody
    ResponseResult postResetPassWord(EmrUserVO emrUserVO) {

        return emrUserService.resetPassWord(emrUserVO.getEmrUser());
    }

    @Note("更新用户")
    @RequiresPermissions("sys:user:edit")
    @PostMapping("/update")
    @ResponseBody
    ResponseResult update(EmrUserVO emrUserVO) {

        return emrUserService.update(emrUserVO);
    }

}
