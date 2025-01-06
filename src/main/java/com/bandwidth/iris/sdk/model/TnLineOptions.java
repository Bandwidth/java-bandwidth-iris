package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 6/16/15.
 */
@XmlRootElement(name = "TnLineOptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class TnLineOptions {
    @XmlElement(name = "TelephoneNumber")
    private String telephoneNumber;

    @XmlElement(name = "CallingNameDisplay")
    private String callingNameDisplay;

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getCallingNameDisplay() {
        return callingNameDisplay;
    }

    public void setCallingNameDisplay(String callingNameDisplay) {
        this.callingNameDisplay = callingNameDisplay;
    }
}
