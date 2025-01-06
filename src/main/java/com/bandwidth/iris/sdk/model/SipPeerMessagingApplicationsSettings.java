package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ApplicationSettings")
public class SipPeerMessagingApplicationsSettings extends BaseModel {
    @XmlElement(name = "HttpMessagingV2AppId")
    String applicationId;

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
