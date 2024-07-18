package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ApplicationSettings")
public class SipPeerMessagingApplicationsSettings extends BaseModel {
    @XmlElement(name = "HttpMessagingV2AppId")
    String applicationId;

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
