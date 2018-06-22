package com.haoze.service.emr.bom;

import com.haoze.common.model.QueryParam;
import com.haoze.model.emr.emrwriting.po.HisResponseDataPO;
import com.haoze.service.emr.enumeration.HisCallTypeEnum;
import com.haoze.utils.GsonUtil;
import com.haoze.utils.JsoupHttpRequest;
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
    /*public static List<? extends HisResponseDataPO> listHisResponseData(Map<String,Object> params) throws IOException {

        HisResponseData hisResponseData = HisResponseDataFactory.getHisResponseData(String.valueOf(params.get("hisCallType")));
        List<? extends HisResponseDataPO> hisResponseDatas = hisResponseData.getHisResponseDatas(params);
        return hisResponseDatas;

    }*/

    /**
     * 获取HIS返回接口数据
     * @param params
     * @return
     * @throws IOException
     */
    public static List<Map> listHisResponseData(QueryParam params) throws IOException {

        HisRequestParam hisRequestParam = HisRequestParamFactory.createHisRequestParam(HisCallTypeEnum.fromValue(String.valueOf(params.get("hisCallType"))));
        if(hisRequestParam == null){
            return null;
        }
        //调用HIS接口
        Connection.Response response = JsoupHttpRequest.sendHttpRequest(hisRequestParam.getUrl(),"",params);
        Map responseDataMap = GsonUtil.fromJson(response.body(),Map.class);
        //返回对应数据列表
        List<Map> advice = GsonUtil.fromJson(GsonUtil.toJson((responseDataMap.get(hisRequestParam.getResponseDataKey()))),new ArrayList<Map>().getClass());
        return advice;
    }
}
