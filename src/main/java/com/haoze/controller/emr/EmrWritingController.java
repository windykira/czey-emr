package com.haoze.controller.emr;

import com.haoze.common.controller.BaseController;
import com.haoze.service.emr.bom.HisResponseDataService;
import com.haoze.utils.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
/**
 * 书写病历控制器信息。
 * @author maxl
 * @time 2018-05-31。
 */
@RequestMapping("emr/emrwriting")
@Controller
public class EmrWritingController extends BaseController{

    private String prefix="emr/emrwriting";

    @GetMapping("/templatetable")
    String test(Model model){
        return prefix + "/templatetable";
    }

    @GetMapping("/emrwrite")
    String emrWrite(Model model){

        model.addAttribute("footerName",getUser().getUserName() + " " + CurrentUser.getDepartmentNames() +
                " " + CurrentUser.getUserRoleNames());
        return prefix + "/emrwrite";
    }

    @GetMapping("/reportimport/{hisCallType}")
    String reportImport(Model model,@PathVariable("hisCallType") String hisCallType){
        model.addAttribute("hisCallType",hisCallType);
        return prefix + "/reportimport";
    }

    @GetMapping("/listHisResponseDatas")
    @ResponseBody
    List<Map> listHisResponseDatas(Model model, @RequestParam Map<String,Object> params){

        try {
            params.put("visitId",1);
            params.put("repeatIndicator",1);
            //params.put("patientId","955635");
            //List<? extends HisResponseDataPO> advice = HisResponseDataService.listHisResponseData(params);
            List<Map> advice = HisResponseDataService.listHisResponseData(params);
            return advice;
        }catch (Exception e){
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

}
