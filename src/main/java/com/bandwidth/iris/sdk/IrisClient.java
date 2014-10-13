package com.bandwidth.iris.sdk;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.bandwidth.iris.sdk.model.*;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.auth.Credentials;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.commons.lang3.StringUtils;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;


/**
 * Created by sbarstow on 9/22/14.
 */
public class IrisClient {

    private static final Logger LOG = Logger.getLogger(IrisClient.class);

    private String baseUrl;
    private String accountId;
    private String uri;
    private String siteId;
    private String userName;
    private String password;
    private String version;
    private XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();



    protected DefaultHttpClient httpClient;

    public IrisClient(String uri, String accountId,
                      String siteId, String userName, String password, String version){
        this.uri = uri;
        this.accountId = accountId;
        this.siteId = siteId;
        this.userName = userName;
        this.password = password;
        this.version = version;

        httpClient = new DefaultHttpClient();
        Credentials credentials = new UsernamePasswordCredentials(userName, password);
        httpClient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
        this.baseUrl = "/" + version+ "/accounts/" + this.accountId + "/";
    }


    public List<?> getAvailableNumbers(TelephoneNumberSearchFilters filters) throws IrisClientException {
        List<?> numbersList = new ArrayList<TelephoneNumber>();
        SearchResult result = null;
        try {
            String searchUri = buildSearchUri(filters);
            HttpGet get = new HttpGet(searchUri);
            IrisResponse response = executeRequest(get);
            LOG.debug("response " + response.getResponseBody());
            result = (SearchResult)fromXml(response.getResponseBody(), SearchResult.class);
            numbersList = filters.isReturnTelephoneNumberDetails() ? result.getTelephoneNumberDetailList() :
                    result.getTelephoneNumberList();
        }catch(Exception e){
            LOG.error("Error in getAvailableNumbers: " + e.getMessage());
            throw new IrisClientException(e);
        }
        return numbersList;
    }

    public List<Site> getSites() throws IrisClientException {
        SitesResponse result = new SitesResponse();
        List<Site> sites = new ArrayList<Site>();
        try {
            HttpGet get = new HttpGet(buildSitesUri());
            IrisResponse irisResponse = executeRequest(get);
            result = (SitesResponse)fromXml(irisResponse.getResponseBody(), SitesResponse.class);
            sites = result.getSites();
        }catch(Exception e){
            LOG.error("Error in getSites: " + e.getMessage());
            throw new IrisClientException(e);
        }
        return sites;
    }

    public Site getSite(String siteId){
        SiteResponse result = new SiteResponse();
        Site site = null;
        try {
            HttpGet get = new HttpGet(buildSitesUri() + "/" + siteId);
            IrisResponse irisResponse = executeRequest(get);
            result = (SiteResponse) fromXml(irisResponse.getResponseBody(), SiteResponse.class);
            site = result.getSite();
        }catch(Exception e){

        }
        return site;
    }

    public String createSite(Site site) throws IrisClientException {
        String siteId = null;
        try {
            HttpPost post = new HttpPost(buildSitesUri());
            StringEntity entity = new StringEntity(toXml(site), ContentType.APPLICATION_XML);
            post.setEntity(entity);
            IrisResponse response = executeRequest(post);
            if(response.getStatusCode() == HttpStatus.SC_OK){
                siteId = getIdFromLocationHeader(response.getHeaders().get("Location"));
            }
        }catch(Exception e){
            LOG.error("Error creating new site: " + e.getMessage());
            throw new IrisClientException(e);
        }
        return siteId;
    }

    public void deleteSite(String siteId) throws IrisClientException {
        try {
            HttpDelete delete = new HttpDelete(buildSitesUri() + "/" + siteId);
            IrisResponse response = executeRequest(delete);
            if(response.getStatusCode() != HttpStatus.SC_OK){
                throw new IrisClientException(response.getResponseBody());
            }
        }catch(Exception e){
            LOG.error("Error deleting site: " + e.getMessage());
            throw new IrisClientException(e);
        }
    }

    private String buildSitesUri() throws URISyntaxException {
        URIBuilder builder = new URIBuilder(this.uri);
        builder.setPath(baseUrl + "sites");
        return builder.build().toString();
    }



    private String buildSearchUri(TelephoneNumberSearchFilters filters)throws URISyntaxException{
        URIBuilder builder = new URIBuilder(this.uri);
        builder.setPath(baseUrl + "availableNumbers");
        if(!StringUtils.isEmpty(filters.getInAreaCode())){
            builder.addParameter("areaCode", filters.getInAreaCode());
        }
        builder.addParameter("enableTNDetail", String.valueOf(filters.isReturnTelephoneNumberDetails()));
        builder.addParameter("quantity", String.valueOf(filters.getQuantity()));

        LOG.debug("building uri: " + builder.build().toString());
        return builder.build().toString();
    }

    private String buildOrdersUri() throws URISyntaxException {
        URIBuilder builder = new URIBuilder(this.baseUrl);
        builder.setPath("/" + version+ "/accounts/" + this.accountId + "/orders");
        LOG.debug("building uri: " + builder.build().toString());
        return builder.build().toString();
    }

    protected IrisResponse executeRequest(HttpUriRequest request) throws IOException {
        HttpResponse response;
        Map<String, String> headers = new HashMap<String, String>();
        IrisResponse irisResponse = new IrisResponse();
        try {
            response = httpClient.execute(request);
            irisResponse.setResponseBody(response.getEntity() != null ? EntityUtils.toString(response.getEntity()) : "");
            irisResponse.setStatusCode(response.getStatusLine().getStatusCode());
            for(Header h : response.getHeaders("Location")){
                headers.put(h.getName(), h.getValue());
            }
            irisResponse.setHeaders(headers);
        }catch(ClientProtocolException cpe){
            LOG.error("Error in execute request: " + cpe.getMessage());
            throw new IOException(cpe);
        }
        return irisResponse;
    }

    private Object fromXml(String responseBody, Class c) throws JAXBException, XMLStreamException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(responseBody.getBytes());
        JAXBContext jaxbContext = JAXBContext.newInstance(c);
        XMLStreamReader xsr = xmlInputFactory.createXMLStreamReader(inputStream);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return jaxbUnmarshaller.unmarshal(xsr);
    }

    private String toXml(Object o) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(o, writer);
        LOG.debug("toXml: " + writer.toString());
        return writer.toString();
    }

    private String getIdFromLocationHeader(String locationHeader){
        return locationHeader.substring(locationHeader.lastIndexOf("/") + 1);
    }


}
