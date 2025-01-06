package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "CoveredRateCenter")
@XmlAccessorType(XmlAccessType.FIELD)
public class CoveredRateCenter {
    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Abbreviation")
    private String abbreviation;

    @XmlElement(name = "State")
    private String state;

    @XmlElement(name = "Lata")
    private String lata;

    @XmlElement(name = "AvailableNumberCount")
    private int availableNumberCount;

    @XmlElementWrapper(name = "ZipCodes")
    @XmlElement(name = "ZipCode")
    private List<String> zipCodes = new ArrayList<String>();

    @XmlElementWrapper(name = "Cities")
    @XmlElement(name = "City")
    private List<String> cities = new ArrayList<String>();

    @XmlElementWrapper(name = "Tiers")
    @XmlElement(name = "Tier")
    private List<String> tiers = new ArrayList<String>();

    @XmlElementWrapper(name = "NpaNxxXs")
    @XmlElement(name = "NpaNxxX")
    private List<String> npaNxxXs = new ArrayList<String>();

    @XmlElement(name = "Id")
    private String id;

    public static List<CoveredRateCenter> list(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildModelUri(
                new String[] { IrisPath.COVERED_RATE_CENTER_URI_PATH }, query), CoveredRateCenters.class)
                .getCoveredRateCenters();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLata() {
        return lata;
    }

    public void setLata(String lata) {
        this.lata = lata;
    }

    public int getAvailableNumberCount() {
        return availableNumberCount;
    }

    public void setAvailableNumberCount(int availableNumberCount) {
        this.availableNumberCount = availableNumberCount;
    }

    public List<String> getZipCodes() {
        return zipCodes;
    }

    public void setZipCodes(List<String> zipCodes) {
        this.zipCodes = zipCodes;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<String> getTiers() {
        return tiers;
    }

    public void setTiers(List<String> tiers) {
        this.tiers = tiers;
    }

    public List<String> getNpaNxxXs() {
        return npaNxxXs;
    }

    public void setNpaNxxXs(List<String> npaNxxXs) {
        this.npaNxxXs = npaNxxXs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
