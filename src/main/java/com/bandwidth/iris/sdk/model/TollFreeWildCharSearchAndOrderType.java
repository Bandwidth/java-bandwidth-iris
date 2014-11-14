package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/14/14.
 */
@XmlRootElement(name="TollFreeWildCharSearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class TollFreeWildCharSearchAndOrderType extends BaseOrderType {
    @XmlElement(name="TollFreeWildCharPattern")
    private String tollFreeWildCharPattern;

    public String getTollFreeWildCharPattern() {
        return tollFreeWildCharPattern;
    }

    public void setTollFreeWildCharPattern(String tollFreeWildCharPattern) {
        this.tollFreeWildCharPattern = tollFreeWildCharPattern;
    }
}
