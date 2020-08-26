package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
}
