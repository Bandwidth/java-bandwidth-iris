package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ImportTnCheckerResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTnCheckerResponse {

    @XmlElement(name = "ImportTnCheckerPayload")
    private ImportTnCheckerPayload importTnCheckerPayload;

    public ImportTnCheckerPayload getImportTnCheckerPayload() {
        return importTnCheckerPayload;
    }

    public void setImportTnCheckerPayload(ImportTnCheckerPayload importTnCheckerPayload) {
        this.importTnCheckerPayload = importTnCheckerPayload;
    }
}
