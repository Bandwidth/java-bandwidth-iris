package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ActivationStatusResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivationStatusResponse extends BaseModel {
    @XmlElement(name = "ActivationStatus")
    private ActivationStatus activationStatus;

    public ActivationStatus getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(ActivationStatus activationStatus) {
        this.activationStatus = activationStatus;
    }
}
