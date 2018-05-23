package com.haoze.controller.emr;

import com.haoze.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 病人控制器信息。
 * @author maxl
 * @time 2018-05-23。
 */
@RequestMapping("emr/patient")
@Controller
public class EmrPatientController extends BaseController{

    private String prefix = "emr/patient/";

    @GetMapping("/patients")
    String index(Model model) {
        return prefix + "patients";
    }
}
