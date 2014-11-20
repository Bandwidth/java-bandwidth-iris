package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 10/9/14.
 */
@XmlRootElement(name = "Site")
@XmlAccessorType(XmlAccessType.FIELD)
public class Site extends BaseModel {

    @XmlElement(name = "Id")
    private String id;
    @XmlElement(name = "Name")
    private String name;
    @XmlElement(name = "Description")
    private String description;
    @XmlElement(name = "Address")
    private Address address;

    public static Site get(IrisClient client, String siteId) throws Exception {
        IrisResponse response = client.get(client.buildUserModelUri(new String[] { IrisConstants.SITES_URI_PATH, siteId }));
        SiteResponse siteResponse = XmlUtils.fromXml(response.getResponseBody(), SiteResponse.class);
        client.checkResponse(siteResponse);
        Site s = siteResponse.getSite();
        s.setClient(client);
        return s;
    }

    public static Site create(IrisClient client, Site site) throws Exception {
        IrisResponse response = client.post(client.buildUserModelUri(new String[] { IrisConstants.SITES_URI_PATH }), site);
        String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
        return get(client, id);
    }

    public static List<Site> list(IrisClient client) throws Exception {
        List<Site> sites = new ArrayList<Site>();
        IrisResponse irisResponse = client.get(client.buildUserModelUri(new String[] { IrisConstants.SITES_URI_PATH }));
        SitesResponse sitesResponse = XmlUtils.fromXml(irisResponse.getResponseBody(), SitesResponse.class);
        client.checkResponse(sitesResponse);
        sites = sitesResponse.getSites();
        for (Site s : sites) {
            s.setClient(client);
        }
        return sites;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void delete() throws Exception {
        client.delete(client.buildUserModelUri(new String[] { IrisConstants.SITES_URI_PATH, id }));
    }

}
