package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.BaseModel;
import com.bandwidth.iris.sdk.model.BaseResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.xml.stream.XMLInputFactory;
import java.util.Optional;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class IrisClient {

    public static final String USER_AGENT = "java-bandwidth-iris-" + IrisClient.class.getPackage().getSpecificationVersion();

    private static final String defaultUri = "https://dashboard.bandwidth.com/api";
    private static final String defaultVersion = "v1.0";
    private final String baseAccountUrl;
    private final String baseUrl;
    private final String uri;
    private final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    protected DefaultHttpClient httpClient;

    private String accessToken;
    private Long accessTokenExpiration;
    private String clientId;
    private String clientSecret;

    public IrisClient(String uri, String accountId,
            String username, String password, String version) {
        this(new DefaultHttpClient(), uri, accountId, username, password, version);
    }

    public IrisClient(String accountId, String username, String password) {
        this(defaultUri, accountId, username, password, defaultVersion);
    }

    public IrisClient(DefaultHttpClient httpClient, String uri, String accountId, String username, String password) {
        this(httpClient, uri, accountId, username, password, defaultVersion);
    }

    // Constructor with custom httpClient
    // should be base for all other constructors
    public IrisClient(DefaultHttpClient httpClient, String uri, String accountId, String username, String password, String version) {
        this.uri = uri;
        this.baseUrl = "/" + version + "/";
        this.baseAccountUrl = this.baseUrl + "accounts/" + accountId + "/";
        initHttpClient(httpClient, username, password);
        this.httpClient = httpClient;
    }

    // Constructor with custom httpClient and OAuth client credentials
    public IrisClient(DefaultHttpClient httpClient, String uri, String accountId, String username, String password,
                      String clientId, String clientSecret) {
        this(httpClient, uri, accountId, username, password);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    // Constructor with pre-configured access token
    public IrisClient(String accountId, String username, String password,
                      String accessToken, Long accessTokenExpiration) {
        this(defaultUri, accountId, username, password, defaultVersion);
        this.accessToken = accessToken;
        this.accessTokenExpiration = accessTokenExpiration;
    }

    // Constructor with full URI customization and pre-configured access token
    public IrisClient(String uri, String accountId, String username, String password, 
                      String version, String accessToken, Long accessTokenExpiration) {
        this(uri, accountId, username, password, version);
        this.accessToken = accessToken;
        this.accessTokenExpiration = accessTokenExpiration;
    }

    // Constructor with full URI customization and OAuth credentials
    public IrisClient(String uri, String accountId, String username, String password, 
                      String version, String clientId, String clientSecret) {
        this(uri, accountId, username, password, version);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    // Constructor with all OAuth fields
    public IrisClient(String accountId, String username, String password,
                      String version, String clientId, String clientSecret,
                      String accessToken, Long accessTokenExpiration) {
        this(defaultUri, accountId, username, password, version);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.accessToken = accessToken;
        this.accessTokenExpiration = accessTokenExpiration;
    }

    // Constructor with custom httpClient and full OAuth fields
    public IrisClient(DefaultHttpClient httpClient, String accountId, String username,
                      String password, String version, String clientId, String clientSecret,
                      String accessToken, Long accessTokenExpiration) {
        this(httpClient, defaultUri, accountId, username, password, version, clientId,
                clientSecret, accessToken, accessTokenExpiration);
    }

    // Constructor with ALL fields - full customization
    public IrisClient(DefaultHttpClient httpClient, String uri, String accountId, String username,
                      String password, String version, String clientId, String clientSecret,
                      String accessToken, Long accessTokenExpiration) {
        this(httpClient, uri, accountId, username, password, version);
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.accessToken = accessToken;
        this.accessTokenExpiration = accessTokenExpiration;
    }

    private void initHttpClient(DefaultHttpClient httpClient, String username, String password) {
        Credentials credentials = new UsernamePasswordCredentials(username, password);
        httpClient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);
    }

    private <T> T processResponse(IrisResponse response, Class<T> returnType) throws Exception {
        T parsedResponse = XmlUtils.fromXml(response.getResponseBody(), returnType);
        if (parsedResponse instanceof BaseResponse) {
            BaseResponse baseResponse = (BaseResponse) parsedResponse;
            if (baseResponse.getResponseStatus() != null) {
                throw new IrisClientException(response.getStatusCode(), baseResponse.getResponseStatus().getErrorCode(),
                        baseResponse.getResponseStatus().getDescription());
            }
        }
        return parsedResponse;
    }

    public <T> T get(String uri, Class<T> returnType) throws Exception {
        IrisResponse response = get(uri);
        return processResponse(response, returnType);
    }

    public byte[] getFile(String uri) throws Exception {
        HttpGet get = new HttpGet(uri);
        HttpResponse response = httpClient.execute(get);
        
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new IrisClientException( response.getStatusLine().getStatusCode(), "Status code getting LOAS file:  " + response.getStatusLine().getStatusCode(), "");
        }
        return response.getEntity() != null ? EntityUtils.toByteArray(response.getEntity()) : new byte[]{};
    }

    public IrisResponse get(String uri) throws Exception {
        HttpGet get = new HttpGet(uri);
        return executeRequest(get);
    }

    public <T> T post(String uri, BaseModel data, Class<T> returnType) throws Exception {
        IrisResponse response = post(uri, data);
        return processResponse(response, returnType);
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
        return processResponse(response, returnType);
    }

    public IrisResponse put(String uri, BaseModel data) throws Exception {
        HttpPut put = new HttpPut(uri);
        StringEntity putBody = new StringEntity(XmlUtils.toXml(data));
        put.addHeader("Content-Type", "application/xml");
        put.setEntity(putBody);
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

    public String buildAccountModelUri(String uriSuffix, Map<String, Object> query) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(this.uri);
        builder.setPath(baseAccountUrl + uriSuffix);
        if (query != null) {
            for (String key : query.keySet()) {
                builder.addParameter(key, query.get(key).toString());
            }
        }
        return builder.build().toString();
    }

    public String buildAccountModelUri(String[] tokens) throws URISyntaxException {
        return buildAccountModelUri(StringUtils.join(tokens, "/"), null);
    }

    public String buildAccountModelUri(String[] tokens, Map<String, Object> query) throws URISyntaxException {
        return buildAccountModelUri(StringUtils.join(tokens, "/"), query);
    }

    public String buildModelUri(String[] tokens, Map<String, Object> query) throws URISyntaxException {
        URIBuilder builder = new URIBuilder(this.uri);
        builder.setPath(baseUrl + StringUtils.join(tokens, "/"));
        if (query != null) {
            for (Map.Entry<String, Object> parameter : query.entrySet()) {
                builder.addParameter(parameter.getKey(), parameter.getValue().toString());
            }
        }
        return builder.build().toString();
    }

    public String buildModelUri(String[] tokens) throws URISyntaxException {
        return buildModelUri(tokens, null);
    }

    protected IrisResponse executeRequest(HttpUriRequest request) throws Exception {
        request.addHeader("User-Agent", USER_AGENT);
        configureAuth(request);

        Map<String, String> headers = new HashMap<String, String>();
        IrisResponse irisResponse = new IrisResponse();
        HttpResponse response = httpClient.execute(request);
        irisResponse.setResponseBody(response.getEntity() != null ? EntityUtils.toString(response.getEntity()) : "");
        irisResponse.setStatusCode(response.getStatusLine().getStatusCode());
        for (Header h : response.getHeaders("Location")) {
            headers.put(h.getName(), h.getValue());
        }
        irisResponse.setHeaders(headers);

        if (!irisResponse.isOK()) {
            throw new IrisClientException(irisResponse.getStatusCode(), "", irisResponse.getResponseBody());
        }
        return irisResponse;
    }

    public String getIdFromLocationHeader(String locationHeader) {
        return locationHeader.substring(locationHeader.lastIndexOf("/") + 1);
    }

    public void checkResponse( IrisResponse response, BaseResponse baseResponse ) throws IrisClientException{
        if(baseResponse.getResponseStatus() != null ){
            throw new IrisClientException(response.getStatusCode(),baseResponse.getResponseStatus().getErrorCode(),
                    baseResponse.getResponseStatus().getDescription());
        }
    }

    private void configureAuth (HttpUriRequest request) {
        if (this.accessToken != null && (this.accessTokenExpiration == null || this.accessTokenExpiration > System.currentTimeMillis()/1000 + 60)) {
            request.addHeader("Authorization", "Bearer " + this.accessToken);
        } else if (this.clientId != null && this.clientSecret != null) {
            HttpPost tokenRequest = new HttpPost("https://api.bandwidth.com/api/v1/oauth2/token");
            StringEntity tokenBody = new StringEntity("grant_type=client_credentials", "UTF-8");
            tokenRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
            tokenRequest.setEntity(tokenBody);
            String auth = this.clientId + ":" + this.clientSecret;
            String encodedAuth = java.util.Base64.getEncoder().encodeToString(auth.getBytes());
            tokenRequest.addHeader("Authorization", "Basic " + encodedAuth);
            try {
                HttpResponse tokenResponse = httpClient.execute(tokenRequest);
                String responseString = EntityUtils.toString(tokenResponse.getEntity());
                JSONParser parser = new JSONParser();
                JSONObject tokenData = (JSONObject) parser.parse(responseString);
                this.accessToken = (String) tokenData.get("access_token");
                Long expiresIn = (Long) tokenData.get("expires_in");
                this.accessTokenExpiration = System.currentTimeMillis()/1000 + expiresIn;
                request.addHeader("Authorization", "Bearer " + this.accessToken);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public Long getAccessTokenExpiration() {
        return accessTokenExpiration;
    }
    public void setAccessTokenExpiration(Long accessTokenExpiration) {
        this.accessTokenExpiration = accessTokenExpiration;
    }
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getClientSecret() {
        return clientSecret;
    }
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}
