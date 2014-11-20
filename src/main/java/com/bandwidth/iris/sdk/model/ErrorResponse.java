package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/20/14.
 */
@XmlRootElement(name = "ErrorResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse {
    @XmlElement(name = "irisStatus")
    private IrisStatus irisStatus;

    public IrisStatus getIrisStatus() {
        return irisStatus;
    }

    public void setIrisStatus(IrisStatus irisStatus) {
        this.irisStatus = irisStatus;
    }
}
