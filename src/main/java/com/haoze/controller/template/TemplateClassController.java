package com.haoze.controller.template;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.QueryParam;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.service.template.EmrTemplateClassService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 模板类型控制器。
 * @author maxl
 * @time 2018-05-31。
 */
@RequestMapping("/template/class")
@Controller
public class TemplateClassController extends BaseController{

    @Autowired
    EmrTemplateClassService emrTemplateClassService;

    private String prefix = "template/templateclass";

    @GetMapping("/list/{cataLogId}")
    @ResponseBody
    List<EmrTemplateClassEntity> list(Model model, @PathVariable("cataLogId") String cataLogId) {
        QueryParam queryParam = QueryParam.getDefaultQueryParam();
        queryParam.put("cataLogId",cataLogId);
        return emrTemplateClassService.list(queryParam);
    }
}
