package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TollFreeVanitySearchAndOrderType")
public class TollFreeVanitySearchAndOrderType extends BaseOrderType {
    @XmlElement(name = "TollFreeVanity")
    private String tollFreeVanity;

    public String getTollFreeVanity() {
        return tollFreeVanity;
    }

    public void setTollFreeVanity(String tollFreeVanity) {
        this.tollFreeVanity = tollFreeVanity;
    }
}
