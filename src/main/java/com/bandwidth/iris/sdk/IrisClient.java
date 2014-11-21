package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.BaseModel;
import com.bandwidth.iris.sdk.model.BaseResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.xml.stream.XMLInputFactory;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sbarstow on 9/22/14.
 */
public class IrisClient {

    private static String defaultUri = "https://api.inetwork.com/v1.0";
    private static String defaultVersion = "v1.0";
    protected DefaultHttpClient httpClient;
    private String baseUserUrl;
    private String baseUrl;
    private String accountId;
    private String uri;
    private String userName;
    private String password;
    private String version;
    private XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

    public IrisClient(String uri, String accountId,
            String userName, String password, String version) {
        this.uri = uri;
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.version = version;

        httpClient = new DefaultHttpClient();
        Credentials credentials = new UsernamePasswordCredentials(userName, password);
        httpClient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
        this.baseUrl = "/" + version + "/";
        this.baseUserUrl = this.baseUrl + "accounts/" + this.accountId + "/";

    }

    public IrisClient(String accountId, String userName, String password) {
        this(defaultUri, accountId, userName, password, defaultVersion);
    }

    private <T> T processResponse(String responseBody, Class<T> returnType) throws Exception {
        T parsedResponse = XmlUtils.fromXml(responseBody, returnType);
        if (parsedResponse instanceof BaseResponse){
            BaseResponse baseResponse = (BaseResponse) parsedResponse;
            if(baseResponse.getResponseStatus() != null){
                throw new IrisClientException(baseResponse.getResponseStatus().getErrorCode(),
                        baseResponse.getResponseStatus().getDescription());
            }
        }
        return parsedResponse;
    }

    public <T> T get(String uri, Class<T> returnType) throws Exception {
        IrisResponse response = get(uri);
        return processResponse(response.getResponseBody(), returnType);
    }

    public IrisResponse get(String uri) throws Exception {
        HttpGet get = new HttpGet(uri);
        return executeRequest(get);
    }

    public <T> T post(String uri, BaseModel data, Class<T> returnType) throws Exception {
        IrisResponse response = post(uri, data);
        return processResponse(response.getResponseBody(), returnType);
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

    public <T> T put(String uri, BaseModel data, Class<T> returnType) throws Exception {
        IrisResponse response = put(uri, data);
        return processResponse(response.getResponseBody(), returnType);
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

    public String buildUserModelUri(String uriSuffix, Map<String, Object> query) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(this.uri);
        builder.setPath(baseUserUrl + uriSuffix);
        if (query != null) {
            for (String key : query.keySet()) {
                builder.addParameter(key, query.get(key).toString());
            }
        }
        return builder.build().toString();
    }

    public String buildUserModelUri(String[] tokens) throws URISyntaxException {
        return buildUserModelUri(StringUtils.join(tokens, "/"), null);
    }

    public String buildUserModelUri(String[] tokens, Map<String, Object> query) throws URISyntaxException {
        return buildUserModelUri(StringUtils.join(tokens, "/"), query);
    }

    public String buildModelUri(String[] tokens, Map<String, Object> query) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(this.uri);
        builder.setPath(baseUrl + StringUtils.join(tokens, "/"));
        if (query != null) {
            for (String key : query.keySet()) {
                builder.addParameter(key, query.get(key).toString());
            }
        }
        return builder.build().toString();
    }

    public String buildModelUri(String[] tokens) throws URISyntaxException {
        return buildModelUri(tokens, null);
    }

    protected IrisResponse executeRequest(HttpUriRequest request) throws Exception {
        HttpResponse response;
        Map<String, String> headers = new HashMap<String, String>();
        IrisResponse irisResponse = new IrisResponse();
        response = httpClient.execute(request);
        irisResponse.setResponseBody(response.getEntity() != null ? EntityUtils.toString(response.getEntity()) : "");
        irisResponse.setStatusCode(response.getStatusLine().getStatusCode());
        for (Header h : response.getHeaders("Location")) {
            headers.put(h.getName(), h.getValue());
        }
        irisResponse.setHeaders(headers);

        if (!irisResponse.isOK()) {
            throw new IrisClientException(irisResponse.getResponseBody());
        }
        return irisResponse;
    }

    public String getIdFromLocationHeader(String locationHeader) {
        return locationHeader.substring(locationHeader.lastIndexOf("/") + 1);
    }

    public void checkResponse(BaseResponse response) throws IrisClientException {
        if (response.getResponseStatus() != null) {
            throw new IrisClientException(response.getResponseStatus().getErrorCode(),
                    response.getResponseStatus().getDescription());
        }
    }

}
