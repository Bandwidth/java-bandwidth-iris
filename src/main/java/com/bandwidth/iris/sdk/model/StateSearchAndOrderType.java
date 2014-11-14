package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 11/14/14.
 */
@XmlRootElement(name="StateSearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateSearchAndOrderType {
    @XmlElement(name="State")
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
