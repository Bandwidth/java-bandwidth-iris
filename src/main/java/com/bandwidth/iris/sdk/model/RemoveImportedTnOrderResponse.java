package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RemoveImportedTnOrdersResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class RemoveImportedTnOrderResponse {

    @XmlElement(name = "RemoveImportedTnOrder")
    private RemoveImportedTnOrder removeImportedTnOrder;

    public RemoveImportedTnOrder getRemoveImportedTnOrder() {
        return removeImportedTnOrder;
    }

    public void setRemoveImportedTnOrder(RemoveImportedTnOrder removeImportedTnOrder) {
        this.removeImportedTnOrder = removeImportedTnOrder;
    }
}
