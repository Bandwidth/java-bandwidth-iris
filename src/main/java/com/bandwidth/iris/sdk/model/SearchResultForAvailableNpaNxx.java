package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "SearchResultForAvailableNpaNxx")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResultForAvailableNpaNxx extends BaseModel {
    @XmlElementWrapper(name = "AvailableNpaNxxList")
    @XmlElement(name = "AvailableNpaNxx")
    private List<AvailableNpaNxx> availableNpaNxxList = new ArrayList<AvailableNpaNxx>();

    public List<AvailableNpaNxx> getAvailableNpaNxxList() {
        return availableNpaNxxList;
    }

    public void setAvailableNpaNxxList(List<AvailableNpaNxx> availableNpaNxxList) {
        this.availableNpaNxxList = availableNpaNxxList;
    }
}
