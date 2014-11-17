package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 11/17/14.
 */
@XmlRootElement(name="SearchResultForAvailableNpaNxx")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchResultForAvailableNpaNxx extends BaseModel {
    @XmlElementWrapper(name="AvailableNpaNxxList")
    @XmlElement(name="AvailableNpaNxx")
    private List<AvailableNpaNxx> availableNpaNxxList = new ArrayList<AvailableNpaNxx>();

    public List<AvailableNpaNxx> getAvailableNpaNxxList() {
        return availableNpaNxxList;
    }

    public void setAvailableNpaNxxList(List<AvailableNpaNxx> availableNpaNxxList) {
        this.availableNpaNxxList = availableNpaNxxList;
    }
}
