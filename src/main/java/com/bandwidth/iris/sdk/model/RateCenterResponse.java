package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 11/20/14.
 */
@XmlRootElement(name = "RateCenterResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class RateCenterResponse {

    @XmlElement(name = "ResultCount")
    private int resultCount;

    @XmlElementWrapper(name = "RateCenters")
    @XmlElement(name = "RateCenter")
    private List<RateCenter> rateCenters = new ArrayList<RateCenter>();

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<RateCenter> getRateCenters() {
        return rateCenters;
    }

    public void setRateCenters(List<RateCenter> rateCenters) {
        this.rateCenters = rateCenters;
    }
}
