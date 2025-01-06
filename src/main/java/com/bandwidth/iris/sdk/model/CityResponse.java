package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "CityResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityResponse {
    @XmlElement(name = "ResultCount")
    private int resultCount;

    @XmlElementWrapper(name = "Cities")
    @XmlElement(name = "City")
    private List<City> cities = new ArrayList<City>();

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
