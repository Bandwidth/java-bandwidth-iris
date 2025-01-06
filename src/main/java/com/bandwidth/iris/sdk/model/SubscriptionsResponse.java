package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "SubscriptionsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscriptionsResponse extends BaseResponse {
    @XmlElementWrapper(name = "Subscriptions")
    @XmlElement(name = "Subscription")
    private List<Subscription> subscriptions = new ArrayList<Subscription>();

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
