package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class OrderHistoryWrapper {

    @XmlElement(name = "OrderHistory")
    private List<OrderHistory> orderHistoryList;
}
