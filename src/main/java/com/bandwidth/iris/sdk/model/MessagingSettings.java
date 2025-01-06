package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "MessagingSettings")
@XmlAccessorType(XmlAccessType.FIELD)
public class MessagingSettings extends BaseModel {

    @XmlElement(name = "A2pState")
    private String a2pState;

    @XmlElement(name = "AssignedNnRoute")
    private AssignedNnRoute assignedNnRoute;

    @XmlElement(name = "CampaignId")
    private String campaignId;

    @XmlElement(name = "MessageClass")
    private String messageClass;

    @XmlElement(name = "SmsEnabled")
    private String smsEnabled;


    public String getA2pState() {
        return a2pState;
    }

    public void setA2pState(String a2pState) {
        this.a2pState = a2pState;
    }

    public AssignedNnRoute getAssignedNnRoute() {
        return assignedNnRoute;
    }

    public void setAssignedNnRoute(AssignedNnRoute assignedNnRoute) {
        this.assignedNnRoute = assignedNnRoute;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getMessageClass() {
        return messageClass;
    }

    public void setMessageClass(String messageClass) {
        this.messageClass = messageClass;
    }

    public String getSmsEnabled() {
        return smsEnabled;
    }

    public void setSmsEnabled(String smsEnabled) {
        this.smsEnabled = smsEnabled;
    }
}
