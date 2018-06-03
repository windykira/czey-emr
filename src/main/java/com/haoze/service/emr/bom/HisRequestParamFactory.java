package com.haoze.service.emr.bom;

import com.haoze.common.enumeration.emr.HisCallTypeEnum;
import com.haoze.model.emr.emrwriting.po.HisDoctorAdvicePO;
import com.haoze.model.emr.emrwriting.po.HisPatientCheckupPO;
import com.haoze.model.emr.emrwriting.po.HisPatientInspectPO;
import com.haoze.model.emr.emrwriting.po.HisPatientPrescriptionPO;
import com.haoze.utils.SystemConfigParseUtil;

import java.io.IOException;
import java.util.ArrayList;

/**
 * HIS请求参数构造。
 * @author maxl
 * @time 2018-06-03。
 */
public class HisRequestParamFactory {

    /**
     * 构建HIS请求参数
     * @param hisCallTypeEnum
     * @return
     * @throws IOException
     */
    public static HisRequestParam createHisRequestParam(HisCallTypeEnum hisCallTypeEnum) throws IOException {

        //不同请求类型对应不同返回数据类型
        switch (hisCallTypeEnum.getEnumValue()){
            case "1":return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_DOCTOR_ADVICE")
                    ,HisResponseDataKey.DOCTOR_ADVICE,new ArrayList<HisDoctorAdvicePO>().getClass());
            case "2":return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_CHECKUP")
                    ,HisResponseDataKey.PATIENT_CHECKUP,new ArrayList<HisPatientCheckupPO>().getClass());
            case "3":return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_INSPECT")
                    ,HisResponseDataKey.PATIENT_INSPECT,new ArrayList<HisPatientInspectPO>().getClass());
            case "4":return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_PRESCRIPTION")
                    ,HisResponseDataKey.PRESCRIPTION,new ArrayList<HisPatientPrescriptionPO>().getClass());
        }
        return null;
    }
}
