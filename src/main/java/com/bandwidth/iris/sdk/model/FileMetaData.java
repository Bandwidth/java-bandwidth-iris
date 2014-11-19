package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/17/14.
 */
@XmlRootElement(name="FileMetaData")
@XmlAccessorType(XmlAccessType.FIELD)
public class FileMetaData extends BaseModel {
    @XmlElement(name="DocumentName")
    private String documentName;

    @XmlElement(name="DocumentType")
    private String documentType;

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}
