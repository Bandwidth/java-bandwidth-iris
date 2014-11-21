package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

/**
 * Created by sbarstow on 11/20/14.
 */
@XmlRootElement(name = "City")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlElement(name = "RcAbbreviation")
    private String rcAbbreviation;
    @XmlElement(name = "Name")
    private String name;

    public static List<City> list(IrisClient client, Map<String, Object> query) throws Exception {
        return client.get(client.buildModelUri(new String[] {
                IrisConstants.CITIES_URI_PATH }, query), CityResponse.class).getCities();
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
