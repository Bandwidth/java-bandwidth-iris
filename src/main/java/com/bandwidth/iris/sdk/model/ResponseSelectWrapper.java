package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResponseSelectWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseSelectWrapper {
    @XmlElement(name = "ListOrderIdUserIdDate")
    private ListOrderIdUserIdDate orderIdUserIdDate;

    public ListOrderIdUserIdDate getOrderIdUserIdDate() {
        return orderIdUserIdDate;
    }

    public void setOrderIdUserIdDate(ListOrderIdUserIdDate orderIdUserIdDate) {
        this.orderIdUserIdDate = orderIdUserIdDate;
    }
}
