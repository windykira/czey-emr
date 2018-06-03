package com.haoze.controller.template;

import com.github.pagehelper.Page;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.system.menu.entity.EmrMenuEntity;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.model.template.temp.entity.TemplateEntity;
import com.haoze.service.system.EmrMenuService;
import com.haoze.service.template.TemplateService;
import com.haoze.utils.PageUtil;
import com.haoze.utils.ShiroUtil;
import com.haoze.utils.UUIDUtil;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 病历模板Controller。
 * @author yangyb
 * @time 2018-05-19。
 */
@RequestMapping("template/temp")
@Controller
public class TemplateController extends BaseController{

	@Value("${filePath}")
	private String filePath;
    @Autowired
    TemplateService templateService;
    @Autowired
    EmrMenuService emrMenuService;
    private String prefix="template/temp";

    @GetMapping("index")
    String index(Model model) {
        return prefix + "/index";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtil list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        QueryParam queryParam = new QueryParam(params);
        Page<TemplateEntity> list = templateService.list(queryParam);
        int total = templateService.count(queryParam);
        PageUtil pageUtil = new PageUtil(list, total);
        return pageUtil;
    }

    @GetMapping("/getTypes")
    @ResponseBody
    List<Map> getTypes() {
    	List<Map> list = templateService.getTypes();
    	return list;
    }

    @GetMapping("/add")
    String add(){
        return prefix+"/add";
    }
    @PostMapping("/save")
    @ResponseBody
    ResponseResult save(HttpServletRequest request){
    	String xml = request.getParameter("xml");
    	EmrUserEntity user =  ShiroUtil.getUser();

    	TemplateEntity e = new TemplateEntity();
    	e.setPkTemplate(UUIDUtil.randomString());
    	e.setCreator(user.getID());
    	e.setDelFlag("0");
    	e.setNameTmp(request.getParameter("templateName"));
    	e.setPkDept("9DC5168174974A8FAC3836EF07C4EAD0");//需要改成dept
    	e.setPkOrg("e736c3b028cd4fb599a0175c00f6266c");//gggggggggggggggggggggg
    	e.setPkTmpClass(request.getParameter("typeSel"));
    	e.setPkUser(user.getID());
    	e.setRange(request.getParameter("rangeSel"));
    	e.setStopFlag("0");

    	return templateService.save(e,xml);

//    	String name = request.getParameter("templateName");
//    	String range = request.getParameter("rangeSel");
//    	String type = request.getParameter("typeSel");
//    	System.out.println(filePath);
//    	MyFileUtil.writeFile(filePath+"dcdc\\","xxx.xml",xml);
    }


    @GetMapping("/submenu/{menuId}")
    String submenu(Model model,@PathVariable("menuId") String menuId ) {
        Map<String,Object> paramMap = new HashedMap();
        paramMap.put("parentMenu",menuId);
        List<EmrMenuEntity> menus = emrMenuService.listMenus(paramMap);
        model.addAttribute("menus",menus);
        model.addAttribute("userId", getUser().getID());
        return "template/submenu";
    }
}
