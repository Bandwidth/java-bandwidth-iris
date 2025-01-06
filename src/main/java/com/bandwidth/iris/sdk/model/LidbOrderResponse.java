package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LidbOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class LidbOrderResponse extends BaseResponse {
    @XmlElement(name = "LidbOrder")
    private LidbOrder order;

    public LidbOrder getOrder() {
        return order;
    }

    public void setOrder(LidbOrder order) {
        this.order = order;
    }
}

