package com.haoze.controller.emr;

import com.haoze.common.controller.BaseController;
import com.haoze.utils.CurrentUser;
import com.haoze.utils.JsoupHttpRequest;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.jsoup.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 病人控制器信息。
 * @author maxl
 * @time 2018-05-23。
 */
@RequestMapping("emr/patient")
@Controller
public class EmrPatientController extends BaseController{

    private String prefix = "emr/patient/";

    @GetMapping("/patients/{menuId}")
    String index(Model model,@PathVariable("menuId") String menuId) {
        return prefix + "patients";
    }

    @GetMapping("getPatientList")
    @ResponseBody
    String getPatientList(Model model, HttpServletRequest request) {


        String name = request.getParameter("name");
        String bedNo = request.getParameter("bedNo");
        String type = request.getParameter("type");
        String patientId = request.getParameter("patientId");
        name=name==null?"":name;
        bedNo=bedNo==null?"":bedNo;
        type=type==null?"":type;
        patientId=patientId==null?"":patientId;
        String empNo = "";
        String deptNo = "";
        if(type.equals(1)){
            empNo = CurrentUser.getUser().getUserCode();
        }
        if(type.equals(2)){
            deptNo =  CurrentUser.getCurrentUserDepartment();
        }
        String res = "";
        try {
            Connection.Response response = (Connection.Response) JsoupHttpRequest.sendHttpRequest("http://172.20.91.56:8181/getPatietInfoNew?deptCode=211003&costEmpNo=857&patientId=950677&name=%E5%80%AA%E5%9B%BD%E9%87%91&bedNo=23", "",null);
            res = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
