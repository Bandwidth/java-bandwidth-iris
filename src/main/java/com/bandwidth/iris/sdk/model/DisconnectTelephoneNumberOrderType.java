package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "DisconnectTelephoneNumberOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class DisconnectTelephoneNumberOrderType {
    @XmlElementWrapper(name = "TelephoneNumberList")
    @XmlElement(name = "TelephoneNumber")
    private List<String> telephoneNumberList = new ArrayList<String>();

    @XmlElement(name = "DisconnectMode")
    private String disconnectMode;

    public List<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public String getDisconnectMode() {
        return disconnectMode;
    }

    public void setDisconnectMode(String disconnectMode) {
        this.disconnectMode = disconnectMode;
    }
}
