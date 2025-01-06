package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
