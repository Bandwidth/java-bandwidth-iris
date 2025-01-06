package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "AlternateEndUserIdentifierResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class AlternateEndUserIdentifierResponse {

    @XmlElement(name = "AlternateEndUserIdentifier")
    private AlternateEndUserIdentifier alternateEndUserIdentifier;


    public AlternateEndUserIdentifier getAlternateEndUserIdentifier() {
        return alternateEndUserIdentifier;
    }

    public void setAlternateEndUserIdentifier(AlternateEndUserIdentifier alternateEndUserIdentifier) {
        this.alternateEndUserIdentifier = alternateEndUserIdentifier;
    }
}
