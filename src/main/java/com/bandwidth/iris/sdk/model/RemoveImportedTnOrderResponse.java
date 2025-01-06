package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
    
    @XmlElement(name = "ResponseStatus")
    private ResponseStatus responseStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
