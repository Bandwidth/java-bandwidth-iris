package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "RateCenter")
@XmlAccessorType(XmlAccessType.FIELD)
public class RateCenter {

    @XmlElement(name = "Abbreviation")
    private String abbreviation;
    @XmlElement(name = "Name")
    private String name;

    public static List<RateCenter> list(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildModelUri(
                new String[] { IrisPath.RATECENTERS_URI_PATH }, query), RateCenterResponse.class).getRateCenters();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
