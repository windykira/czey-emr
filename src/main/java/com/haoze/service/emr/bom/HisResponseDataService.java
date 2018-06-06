package com.haoze.service.emr.bom;

import com.alibaba.fastjson.JSON;
import com.haoze.model.emr.emrwriting.po.HisDoctorAdvicePO;
import com.haoze.model.emr.emrwriting.po.HisResponseDataPO;
import com.haoze.service.emr.enumeration.HisCallTypeEnum;
import com.haoze.utils.GsonUtil;
import com.haoze.utils.JsoupHttpRequest;
import com.haoze.utils.SystemConfigParseUtil;
import org.jsoup.Connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HIS接口数据服务。
 * @author maxl
 * @time 2018-06-03。
 */
public final class HisResponseDataService {

    /**
     * 获取HIS返回接口数据
     * @param params
     * @return
     * @throws IOException
     */
    public static List<HisResponseDataPO> listHisResponseData(Map<String,Object> params) throws IOException {

        HisRequestParam<List<HisResponseDataPO>> hisRequestParam = HisRequestParamFactory.createHisRequestParam(HisCallTypeEnum.fromValue(String.valueOf(params.get("hisCallType"))));
        if(hisRequestParam == null){
            return null;
        }
        //调用HIS接口
        Connection.Response response = JsoupHttpRequest.sendHttpRequest(hisRequestParam.getUrl(),"",params);
        Map responseDataMap = GsonUtil.fromJson(response.body(),Map.class);
        //返回对应数据列表
        List<HisResponseDataPO> advice = GsonUtil.fromJson(GsonUtil.toJson((responseDataMap.get(hisRequestParam.getResponseDataKey())))
                ,hisRequestParam.getClazz());
        return advice;
    }
}
