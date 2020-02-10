package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="OrderHistoryWrapper")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderHistoryWrapper {

    @XmlElement(name = "OrderHistory")
    private List<OrderHistory> orderHistoryList;

    public List<OrderHistory> getOrderHistoryList() {
        return orderHistoryList;
    }

    public void setOrderHistoryList(List<OrderHistory> orderHistoryList) {
        this.orderHistoryList = orderHistoryList;
    }
}
