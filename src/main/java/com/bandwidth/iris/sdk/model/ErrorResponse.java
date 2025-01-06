package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
