package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "LidbTnGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class LidbTnGroup {
    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<String> telephoneNumberList = new ArrayList<String>();

    @XmlElement(name = "SubscriberInformation")
    private String subscriberInformation;

    @XmlElement(name = "UseType")
    private String useType;

    @XmlElement(name = "Visibility")
    private String visibility;

    public List<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public String getSubscriberInformation() {
        return subscriberInformation;
    }

    public void setSubscriberInformation(String subscriberInformation) {
        this.subscriberInformation = subscriberInformation;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}
