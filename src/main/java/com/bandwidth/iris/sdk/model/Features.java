package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
