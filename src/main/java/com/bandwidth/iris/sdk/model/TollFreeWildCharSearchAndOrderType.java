package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TollFreeWildCharSearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class TollFreeWildCharSearchAndOrderType extends BaseOrderType {
    @XmlElement(name = "TollFreeWildCharPattern")
    private String tollFreeWildCharPattern;

    public String getTollFreeWildCharPattern() {
        return tollFreeWildCharPattern;
    }

    public void setTollFreeWildCharPattern(String tollFreeWildCharPattern) {
        this.tollFreeWildCharPattern = tollFreeWildCharPattern;
    }
}
