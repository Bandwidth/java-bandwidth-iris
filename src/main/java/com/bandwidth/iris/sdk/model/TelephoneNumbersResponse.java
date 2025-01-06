package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "TelephoneNumbersResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class TelephoneNumbersResponse {
    @XmlElement(name = "TelephoneNumberCount")
    private int telephoneNumberCount;

    @XmlElement(name = "Links")
    private Links links;

    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<TelephoneNumber> telephoneNumbers = new ArrayList<TelephoneNumber>();

    public int getTelephoneNumberCount() {
        return telephoneNumberCount;
    }

    public void setTelephoneNumberCount(int telephoneNumberCount) {
        this.telephoneNumberCount = telephoneNumberCount;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<TelephoneNumber> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<TelephoneNumber> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }
}
