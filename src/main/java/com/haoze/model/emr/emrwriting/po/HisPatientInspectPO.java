package com.haoze.model.emr.emrwriting.po;

/**
 * HIS病人检验信息。
 * @author maxl
 * @time 2018-06-03。
 */
public class HisPatientInspectPO implements HisResponseDataPO{

    private String applyTime;//提供时间
    private String checkClass;//检查类型
    private String checkNo;//检查编号
    private String resultStatus;//
    private String state;//
    private String status;//

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getCheckClass() {
        return checkClass;
    }

    public void setCheckClass(String checkClass) {
        this.checkClass = checkClass;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
