package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlElement;

public class ImportTnOrderSummary {

    @XmlElement(name = "accountId")
    private int accountId;
    @XmlElement(name = "CountOfTNs")
    private int countOfTNs;
    @XmlElement(name = "userId")
    private String userId;
    @XmlElement(name = "lastModifiedDate")
    private String lastModifiedDate;
    @XmlElement(name = "OrderDate")
    private String orderDate;
    @XmlElement(name = "OrderStatus")
    private String orderStatus;
    @XmlElement(name = "OrderId")
    private String orderId;
}
