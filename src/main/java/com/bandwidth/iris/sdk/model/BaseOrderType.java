package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by sbarstow on 11/14/14.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseOrderType {
    @XmlElement(name = "Quantity")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
