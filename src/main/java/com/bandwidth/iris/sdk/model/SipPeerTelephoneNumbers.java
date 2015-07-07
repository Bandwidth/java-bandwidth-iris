package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "SipPeerTelephoneNumbers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SipPeerTelephoneNumbers extends BaseModel {
    @XmlElement(name = "FullNumber")
    private List<String> fullNumbers = new ArrayList<String>();

    public List<String> getFullNumbers() {
        return fullNumbers;
    }

    public void setFullNumbers(List<String> fullNumbers) {
        this.fullNumbers = fullNumbers;
    }
}
