package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 10/13/14.
 */
@XmlRootElement(name = "ResponseStatus")
@XmlAccessorType(XmlAccessType.FIELD)

public class ResponseStatus {
    @XmlElement(name="ErrorCode")
    private String errorCode;

    @XmlElement(name="Description")
    private String description;


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
