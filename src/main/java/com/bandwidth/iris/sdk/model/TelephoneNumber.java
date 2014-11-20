package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TelephoneNumber")
@XmlAccessorType(XmlAccessType.FIELD)
public class TelephoneNumber {

    @XmlElement(name = "FullNumber")
    protected String fullNumber;

    public TelephoneNumber() {
    }

    public String getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(String fullNumber) {
        this.fullNumber = fullNumber;
    }
}


