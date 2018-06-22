package com.haoze.model.emr.emrwriting.vo;

import com.haoze.common.model.PaginationResult;
import com.haoze.model.emr.emrwriting.entity.EmrFileEntity;

/**
 * 病历文件信息。
 * @author maxl
 * @time 2018-06-22。
 */
public class EmrFileVO {

    private EmrFileEntity emrFile = new EmrFileEntity();
    private String xmlContent;//XML文件
    private String catalogName;//目录名称

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public EmrFileEntity getEmrFile() {
        return emrFile;
    }

    public void setEmrFile(EmrFileEntity emrFile) {
        this.emrFile = emrFile;
    }

    public String getXmlContent() {
        return xmlContent;
    }

    public void setXmlContent(String xmlContent) {
        this.xmlContent = xmlContent;
    }
}
