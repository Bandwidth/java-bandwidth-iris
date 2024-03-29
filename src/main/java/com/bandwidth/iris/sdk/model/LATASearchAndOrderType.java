package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LATASearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class LATASearchAndOrderType {
    @XmlElement(name = "LATA")
    private String lata;

    public String getLata() {
        return lata;
    }

    public void setLata(String lata) {
        this.lata = lata;
    }
}
