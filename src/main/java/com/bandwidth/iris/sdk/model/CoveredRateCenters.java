package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "CoveredRateCenters")
@XmlAccessorType(XmlAccessType.FIELD)
public class CoveredRateCenters {
    @XmlElement(name = "TotalCount")
    private int totalCount;

    @XmlElement(name = "Links")
    private Links links;

    @XmlElement(name = "CoveredRateCenter")
    private List<CoveredRateCenter> coveredRateCenters = new ArrayList<CoveredRateCenter>();

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

    public List<CoveredRateCenter> getCoveredRateCenters() {
        return coveredRateCenters;
    }

    public void setCoveredRateCenters(List<CoveredRateCenter> coveredRateCenters) {
        this.coveredRateCenters = coveredRateCenters;
    }
}
