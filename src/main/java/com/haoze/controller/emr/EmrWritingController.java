package com.haoze.controller.emr;

import com.haoze.common.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 书写病历控制器信息。
 * @author maxl
 * @time 2018-05-31。
 */
@RequestMapping("emr/emrwriting")
@Controller
public class EmrWritingController extends BaseController{

    private String prefix="emr/emrwriting";

    @GetMapping("/emrwrite")
    String emrWrite(Model model){

        return prefix + "/emrwrite";
    }
}
