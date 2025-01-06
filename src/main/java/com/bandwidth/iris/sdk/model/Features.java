package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Features")
@XmlAccessorType(XmlAccessType.FIELD)
public class Features {

    @XmlElement(name = "E911")
    private E911 e911;

    public E911 getE911() {
        return e911;
    }

    public void setE911(E911 e911) {
        this.e911 = e911;
    }
}
