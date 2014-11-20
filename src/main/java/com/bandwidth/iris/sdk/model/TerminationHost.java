package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 10/14/14.
 */
@XmlRootElement(name = "TerminationHost")
@XmlAccessorType(XmlAccessType.FIELD)
public class TerminationHost extends Host {
    @XmlElement(name = "Port")
    private String port;

    @XmlElement(name = "CustomerTrafficAllowed")
    private String customerTrafficAllowed;

    @XmlElement(name = "DataAllowed")
    private boolean dataAllowed;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getCustomerTrafficAllowed() {
        return customerTrafficAllowed;
    }

    public void setCustomerTrafficAllowed(String customerTrafficAllowed) {
        this.customerTrafficAllowed = customerTrafficAllowed;
    }

    public boolean isDataAllowed() {
        return dataAllowed;
    }

    public void setDataAllowed(boolean dataAllowed) {
        this.dataAllowed = dataAllowed;
    }
}
