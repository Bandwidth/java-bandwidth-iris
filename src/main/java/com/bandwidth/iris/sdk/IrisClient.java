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
import com.bandwidth.iris.sdk.utils.XmlUtils;
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
import java.io.UnsupportedEncodingException;
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

    public IrisResponse get(String uri) throws Exception {
        HttpGet get = new HttpGet(uri);
        return executeRequest(get);
    }

    public IrisResponse post(String uri, BaseModel data) throws Exception {
        HttpPost post = new HttpPost(uri);
        StringEntity postBody = new StringEntity(XmlUtils.toXml(data));
        post.setEntity(postBody);
        return executeRequest(post);
    }

    public IrisResponse delete(String uri) throws Exception {
        HttpDelete delete = new HttpDelete(uri);
        return executeRequest(delete);
    }

    public IrisResponse put(String uri, BaseModel data) throws Exception {
        HttpPut put = new HttpPut(uri);
        return executeRequest(put);
    }

    public String buildModelUri(String uriSuffix) throws URISyntaxException{
        URIBuilder builder = new URIBuilder(this.uri);
        builder.setPath(baseUrl + uriSuffix);
        return builder.build().toString();
    }

    public String buildModelUri(String[] tokens) throws URISyntaxException {
        String path = StringUtils.join(tokens, "/");
        return buildModelUri(path);
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

    public String getIdFromLocationHeader(String locationHeader){
        return locationHeader.substring(locationHeader.lastIndexOf("/") + 1);
    }

    public void checkResponse(BaseResponse response) throws IrisClientException{
        if(response.getResponseStatus()!= null){
            throw new IrisClientException(response.getResponseStatus().getErrorCode(),
                    response.getResponseStatus().getDescription());
        }
    }


}
