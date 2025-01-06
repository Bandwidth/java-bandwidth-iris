package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;
import com.bandwidth.iris.sdk.IrisResponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

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
        SiteResponse siteResponse = client.get(client.buildAccountModelUri(
                new String[] { IrisPath.SITES_URI_PATH, siteId }), SiteResponse.class);
        Site s = siteResponse.getSite();
        s.setClient(client);
        return s;
    }

    public static Site create(IrisClient client, Site site) throws Exception {
        IrisResponse response = client.post(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH }), site);
        String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
        return get(client, id);
    }

    public static List<Site> list(IrisClient client) throws Exception {
        SitesResponse sitesResponse = client
                .get(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH }), SitesResponse.class);
        List<Site> sites = sitesResponse.getSites();
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
        client.delete(client.buildAccountModelUri(new String[] { IrisPath.SITES_URI_PATH, id }));
    }

    public void update() throws Exception {
        client.put(client.buildModelUri(new String[] { IrisPath.SITES_URI_PATH, id }), this);
    }

}
