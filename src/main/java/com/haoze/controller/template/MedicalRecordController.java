package com.haoze.controller.template;

import com.haoze.common.annotation.Note;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.Tree;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import com.haoze.model.system.department.entity.EmrDepartmentEntity;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.model.system.user.vo.EmrUserVO;
import com.haoze.service.emr.EmrCataLogService;
import com.haoze.service.system.enumeration.user.UserCreateStatusEnum;
import com.haoze.utils.MD5Util;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 病历目录管理控制器。
 * @author maxl
 * @time 2018-06-14。
 */
@RequestMapping("/template/medicalrecord")
@Controller
public class MedicalRecordController {

    @Autowired
    EmrCataLogService emrCataLogService;

    private String prefix = "template/medicalrecord";

    @RequiresPermissions("template:medicalrecord:medicalrecord")
    @GetMapping("/medicalrecord")
    String medicalrecord(Model model) {
        return prefix + "/medicalrecord";
    }

    @RequiresPermissions("template:medicalrecord:medicalrecord")
    @GetMapping("/catalogTree")
    String catalogTree(Model model) {
        return prefix + "/emrcatalog";
    }

    //@RequiresPermissions("template:medicalrecord:add")
    @GetMapping("/add")
    String add(Model model) {
        return prefix + "/add";
    }

    //@RequiresPermissions("template:medicalrecord:add")
    @PostMapping("/save")
    @ResponseBody
    ResponseResult save(EmrCataLogEntity emrCataLogEntity) {
        emrCataLogService.insert(emrCataLogEntity);
        return null;
    }

    @PostMapping("/exist")
    @ResponseBody
    boolean exist(@RequestParam Map<String, Object> params) {
        int count = emrCataLogService.count(new QueryParam(params));
        return count == 0;
    }

    @GetMapping("/tree")
    @ResponseBody
    public Tree<EmrCataLogEntity> tree() {
        Tree<EmrCataLogEntity> tree = emrCataLogService.getTree();
        return tree;
    }
}
