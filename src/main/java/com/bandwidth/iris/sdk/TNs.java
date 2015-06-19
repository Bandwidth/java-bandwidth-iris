package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.Links;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 6/18/15.
 */
@XmlRootElement(name="TNs")
@XmlAccessorType(XmlAccessType.FIELD)
public class TNs {
    @XmlElement(name="TotalCount")
    private int totalCount;

    @XmlElement(name="Links")
    private Links links;

    @XmlElementWrapper(name="TelephoneNumbers")
    @XmlElement(name="TelephoneNumber")
    private List<String> telephoneNumbers = new ArrayList<String>();

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<String> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }
}
