package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "SitesResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SitesResponse extends BaseResponse {

    @XmlElementWrapper(name = "Sites")
    @XmlElement(name = "Site")
    private List<Site> sites = new ArrayList<Site>();

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}