package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
