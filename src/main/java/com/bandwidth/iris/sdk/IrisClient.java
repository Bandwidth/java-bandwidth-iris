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
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.*;
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
    private String userName;
    private String password;
    private String version;
    private XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    private static String defaultUri = "https://api.inetwork.com/v1.0";
    private static String defaultVersion = "v1.0";

    protected DefaultHttpClient httpClient;

    public IrisClient(String uri, String accountId,
                      String userName, String password, String version){
        this.uri = uri;
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.version = version;

        httpClient = new DefaultHttpClient();
        Credentials credentials = new UsernamePasswordCredentials(userName, password);
        httpClient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
        this.baseUrl = "/" + version+ "/accounts/" + this.accountId + "/";
    }

    public IrisClient(String accountId, String userName, String password){
        this(defaultUri, accountId, userName, password, defaultVersion);
    }

    public IrisResponse get(String uri) throws Exception {
        HttpGet get = new HttpGet(uri);
        return executeRequest(get);
    }

    public IrisResponse post(String uri, BaseModel data) throws Exception {
        HttpPost post = new HttpPost(uri);
        StringEntity postBody = new StringEntity(XmlUtils.toXml(data));
        post.addHeader("Content-Type", "application/xml");
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

    public void postFile(String uri, File file, String contentType) throws Exception {
        HttpPost post = new HttpPost(uri);
        post.setEntity(contentType == null ? new FileEntity(file) : new FileEntity(file, ContentType.parse(contentType)));
        executeRequest(post);
    }

    public void putFile(String uri, File file, String contentType) throws Exception {
        HttpPut put = new HttpPut(uri);
        put.setEntity(contentType == null ? new FileEntity(file) : new FileEntity(file, ContentType.parse(contentType)));
        executeRequest(put);
    }

    public String buildModelUri(String uriSuffix, Map<String, Object> params) throws URISyntaxException{
        URIBuilder builder = new URIBuilder(this.uri);
        builder.setPath(baseUrl + uriSuffix);
        if(params != null){
            for(String key : params.keySet()){
                builder.addParameter(key, params.get(key).toString());
            }
        }
        LOG.info("Request URI: " + builder.build().toString());
        return builder.build().toString();
    }

    public String buildModelUri(String[] tokens) throws URISyntaxException {
        return buildModelUri(StringUtils.join(tokens, "/"), null);
    }

    public String buildModelUri(String[] tokens, Map<String, Object> params) throws URISyntaxException{
        return buildModelUri(StringUtils.join(tokens, "/"), params);
    }

    protected IrisResponse executeRequest(HttpUriRequest request) throws Exception {
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

            if(!irisResponse.isOK()){
                throw new IrisClientException(irisResponse.getResponseBody());
            }
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
