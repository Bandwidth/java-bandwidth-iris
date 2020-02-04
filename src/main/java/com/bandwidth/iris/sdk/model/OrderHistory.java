package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlElement;

public class OrderHistory {

    @XmlElement(name = "OrderDate")
    private String orderDate;
    @XmlElement(name = "Note")
    private String note;
    @XmlElement(name = "Author")
    private String author;
    @XmlElement(name = "Status")
    private String status;
}
