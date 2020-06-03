package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.List;

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
