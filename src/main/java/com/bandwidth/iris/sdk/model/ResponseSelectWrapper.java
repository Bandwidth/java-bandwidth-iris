package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sbarstow on 6/18/15.
 */
@XmlRootElement(name="ResponseSelectWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseSelectWrapper {
    @XmlElement(name="ListOrderIdUserIdDate")
    private ListOrderIdUserIdDate orderIdUserIdDate;

    public ListOrderIdUserIdDate getOrderIdUserIdDate() {
        return orderIdUserIdDate;
    }

    public void setOrderIdUserIdDate(ListOrderIdUserIdDate orderIdUserIdDate) {
        this.orderIdUserIdDate = orderIdUserIdDate;
    }
}
