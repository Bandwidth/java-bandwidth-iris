package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 6/16/15.
 */
@XmlRootElement(name="TnLineOptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class TnLineOptions {
    @XmlElement(name="TelephoneNumber")
    private String telephoneNumber;

    @XmlElement(name="CallingNameDisplay")
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
