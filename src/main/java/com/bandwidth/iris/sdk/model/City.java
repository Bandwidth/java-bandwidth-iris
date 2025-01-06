package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "City")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlElement(name = "RcAbbreviation")
    private String rcAbbreviation;
    @XmlElement(name = "Name")
    private String name;

    public static List<City> list(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildModelUri(new String[] {
                IrisPath.CITIES_URI_PATH }, query), CityResponse.class).getCities();
    }

    public String getRcAbbreviation() {
        return rcAbbreviation;
    }

    public void setRcAbbreviation(String rcAbbreviation) {
        this.rcAbbreviation = rcAbbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
