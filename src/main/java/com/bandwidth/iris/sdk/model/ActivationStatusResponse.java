package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 6/16/15.
 */
@XmlRootElement(name = "ActivationStatusResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivationStatusResponse {
    @XmlElement(name="ActivationStatus")
    private ActivationStatus activationStatus;

    public ActivationStatus getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(ActivationStatus activationStatus) {
        this.activationStatus = activationStatus;
    }
}
