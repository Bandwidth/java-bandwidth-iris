package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "A2pSettings")
@XmlAccessorType(XmlAccessType.FIELD)
public class A2pSettings extends BaseModel {

    @XmlElement(name = "MessageClass")
    private String messageClass;

    @XmlElement(name = "CampaignId")
    private String campaignId;

    @XmlElement(name = "Action")
    private String action;

    public String getMessageClass() {
        return messageClass;
    }

    public void setMessageClass(String messageClass) {
        this.messageClass = messageClass;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
