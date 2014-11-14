package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisClientException;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 10/9/14.
 */
@XmlRootElement(name = "Site")
@XmlAccessorType(XmlAccessType.FIELD)
public class Site extends BaseModel {

    private static final Logger LOG = Logger.getLogger(Site.class);

    public static Site get(IrisClient client, String siteId) throws IrisClientException {
        Site s = null;
        try {
            IrisResponse response = client.get(client.buildModelUri(new String[] {IrisConstants.SITES_URI_PATH, siteId}));
            s = ((SiteResponse) XmlUtils.fromXml(response.getResponseBody(), SiteResponse.class)).getSite();
            s.setClient(client);
        }catch(Exception e){
            LOG.error("Could not retrieve site: " + e.getMessage());
            throw new IrisClientException(e);
        }
        return s;
    }

    public static Site create(IrisClient client, Site site)throws IrisClientException {
        Site result = null;
        try {
            IrisResponse response = client.post(client.buildModelUri(new String[]{IrisConstants.SITES_URI_PATH}), site);
            if(response.isOK()) {
                String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
                result = get(client, id);
            } else {
                throw new IrisClientException(response.getResponseBody());
            }
        }catch(Exception e){
            LOG.error("Error creating site: " + e.getMessage());
            throw new IrisClientException(e);
        }
        return result;
    }

    public static List<Site> list(IrisClient client) throws IrisClientException {
        SitesResponse result = new SitesResponse();
        List<Site> sites = new ArrayList<Site>();
        try {
            IrisResponse irisResponse = client.get(client.buildModelUri(new String[]{IrisConstants.SITES_URI_PATH}));
            result = (SitesResponse)XmlUtils.fromXml(irisResponse.getResponseBody(), SitesResponse.class);
            sites = result.getSites();
            for(Site s : sites){
                s.setClient(client);
            }
        }catch(Exception e){
            LOG.error("Error in getSites: " + e.getMessage());
            throw new IrisClientException(e);
        }
        return sites;
    }


    @XmlElement(name="Id")
    private String id;

    @XmlElement(name="Name")
    private String name;

    @XmlElement(name="Description")
    private String description;

    @XmlElement(name="Address")
    private Address address;

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

    public void delete()throws IrisClientException {
        try {
            client.delete(client.buildModelUri(new String[]{IrisConstants.SITES_URI_PATH, id}));
        }catch(Exception e){
            LOG.error("Error deleting Sip Peer: " + e.getMessage());
            throw new IrisClientException(e);
        }
    }

}
