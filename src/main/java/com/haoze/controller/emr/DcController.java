package com.haoze.controller.emr;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haoze.common.controller.BaseController;
import com.haoze.service.emr.SymptomService;
import com.haoze.utils.PageUtil;

/**
 * 用户相关控制器信息。
 * @author maxl
 * @time 2018-05-02。
 */
@RequestMapping("emr/dc")
@Controller
public class DcController extends BaseController {

    @Autowired
    private SymptomService service;
    
    private String prefix="emr/dc";

//    @RequiresPermissions("sys:user:user")
    @GetMapping("index")
    String index(Model model) {
        return prefix + "/index";
    }

    @GetMapping("fontMenu")
    String fontMenu(Model model) {
        return prefix + "/fontMenu";
    }

    @GetMapping("sizeMenu")
    String sizeMenu(Model model) {
        return prefix + "/sizeMenu";
    }

    @GetMapping("colorMenu")
    String colorMenu(Model model) {
        return prefix + "/colorMenu";
    }

    @GetMapping("bgcolorMenu")
    String bgcolorMenu(Model model) {
        return prefix + "/bgcolorMenu";
    }

    @GetMapping("getSympTree")
    @ResponseBody
    List<Map> getSympTree(Model model) {
    	return service.getSympTree();
    }

    @SuppressWarnings("rawtypes")
	@GetMapping("getSympInfo")
    @ResponseBody
    List<Map> getSympInfo(Model model) {
    	List list = service.getSympInfo();
    	return list;
    }

    @GetMapping("getSimuInfo")
    @ResponseBody
    List<Map> getSimuInfo(Model model) {
    	return service.getSimuInfo();
    }

    @GetMapping("getSympAndSimuInfo")
    @ResponseBody
    Map getSympAndSimuInfo(Model model) {
    	Map m = service.getSympAndSimuInfo();
    	return m;
    }

    @RequestMapping(value="/getXML/{fileName}")
    @ResponseBody
    public String getXML(HttpServletRequest request, @PathVariable String fileName){
    	InputStreamReader isr = null;
    	StringBuilder sb = new StringBuilder();
        //File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/cab/past.xml");
    	try {
            // File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/cab/past.xml");
            //reader = new FileReader(path+"\\xml\\1.xml");
        	isr = new InputStreamReader(new FileInputStream("C:\\dc\\"+fileName+".xml"),"UTF-8");
        	int len;
        	char[] buf = new char[1024];
        	
        	while ((len=isr.read(buf))!=-1){
        		System.out.println(buf);
        		sb.append(buf);
        		buf=new char[1024];
        	}
//    	bufferedReader = new BufferedReader(reader);
//    	String result = null;
//    	
//			while (  (result = bufferedReader.readLine() ) != null ){
//				sb.append(result);
//			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return  sb.toString();
    }
}

