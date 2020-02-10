package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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
