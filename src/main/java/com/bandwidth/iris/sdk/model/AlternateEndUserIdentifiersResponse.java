package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "AlternateEndUserIdentifiersResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class AlternateEndUserIdentifiersResponse {

    @XmlElement(name = "TotalCount")
    private int totalCount;

    @XmlElement(name = "Links")
    private Links links;

    @XmlElementWrapper(name = "AlternateEndUserIdentifiers")
    @XmlElement(name = "AlternateEndUserIdentifier")
    private List<AlternateEndUserIdentifier> alternateEndUserIdentifiers;


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

    public List<AlternateEndUserIdentifier> getAlternateEndUserIdentifiers() {
        return alternateEndUserIdentifiers;
    }

    public void setAlternateEndUserIdentifiers(List<AlternateEndUserIdentifier> alternateEndUserIdentifiers) {
        this.alternateEndUserIdentifiers = alternateEndUserIdentifiers;
    }

}
