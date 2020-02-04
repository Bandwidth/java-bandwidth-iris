package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlElement;

public class ImportTnOrderResponse {

    @XmlElement(name = "TmportTnOrder")
    private ImportTnOrder importTnOrder;

    public ImportTnOrder getImportTnOrder() {
        return importTnOrder;
    }

    public void setImportTnOrder(ImportTnOrder importTnOrder) {
        this.importTnOrder = importTnOrder;
    }
}
