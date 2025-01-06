package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ImportTnOrdersResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTnOrdersResponse {

    @XmlElement(name = "ImportTnOrder")
    private ImportTnOrder importTnOrder;

    public ImportTnOrder getImportTnOrder() {
        return importTnOrder;
    }

    public void setImportTnOrder(ImportTnOrder importTnOrder) {
        this.importTnOrder = importTnOrder;
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
