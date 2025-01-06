package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AlternateEndUserIdentifier")
@XmlAccessorType(XmlAccessType.FIELD)
public class AlternateEndUserIdentifier {

    @XmlElement(name = "Identifier")
    private String identifier;

    @XmlElement(name = "CallbackNumber")
    private String cllbackNumber;

    @XmlElement(name = "E911")
    private E911 e911;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCllbackNumber() {
        return cllbackNumber;
    }

    public void setCllbackNumber(String cllbackNumber) {
        this.cllbackNumber = cllbackNumber;
    }

    public E911 getE911() {
        return e911;
    }

    public void setE911(E911 e911) {
        this.e911 = e911;
    }
}
