package com.haoze;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.service.template.EmrTemplateClassService;
import com.haoze.utils.JsoupHttpRequest;
import com.haoze.utils.MyFileUtil;
import com.haoze.utils.SystemConfigParseUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haoz-dev4 on 2018/5/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmrTemplateClassTest {

    @Autowired
    EmrTemplateClassService emrTemplateClassService;

    @Test
    public void list(){
        QueryParam queryParam = QueryParam.getDefaultQueryParam();
        queryParam.put("cataLogId","3e21a79d81ce4f00824276280f30eb9c");
        Page<EmrTemplateClassEntity> list = emrTemplateClassService.list(queryParam);
        assert list != null;
    }

    @Test
    public void testJsoup() throws IOException {

        Map map = new HashMap();
        map.put("deptCode","211601");
        JsoupHttpRequest.sendHttpRequest("http://172.20.91.56:8181/getPatietInfoNew","",map);
    }

    @Test
    public void test(){
        Resource resource = new ClassPathResource("/static/cab/index.xml");
        //MyFileUtil.readFile("/static/cab/index.xml");
    }
}
