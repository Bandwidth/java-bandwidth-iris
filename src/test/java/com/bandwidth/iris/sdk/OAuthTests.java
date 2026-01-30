package com.bandwidth.iris.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Rule;
import org.junit.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.*;

import java.security.cert.X509Certificate;

public class OAuthTests {
    
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(8090).enableBrowserProxying(true));

    /**
     * Create an HTTP client configured to use WireMock as a proxy with SSL verification disabled.
     */
    private DefaultHttpClient createProxyHttpClient() throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        
        HttpHost proxy = new HttpHost("localhost", 8090);
        httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
        
        // Disable SSL certificate verification
        TrustStrategy trustAll = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] chain, String authType) {
                return true;
            }
        };
        
        SSLSocketFactory socketFactory = new SSLSocketFactory(trustAll, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        Scheme scheme = new Scheme("https", 443, socketFactory);
        httpClient.getConnectionManager().getSchemeRegistry().register(scheme);
        
        return httpClient;
    }

    @Test
    public void testConstructorWithPreConfiguredAccessToken() throws Exception {
        // Client with pre-configured access token
        long expiration = System.currentTimeMillis() / 1000 + 3600;
        IrisClient client = new IrisClient("accountId", "username", "password",
                "test-access-token", expiration);

        stubFor(get(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v1.0/accounts/accountId/sites");

        // Should use Bearer token
        verify(getRequestedFor(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .withHeader("Authorization", equalTo("Bearer test-access-token")));
        
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testConstructorWithClientCredentials() throws Exception {
        DefaultHttpClient httpClient = createProxyHttpClient();
        
        // Client with client credentials only
        IrisClient client = new IrisClient(httpClient, "http://localhost:8090", "accountId", "username", "password");
        client.setClientId("test-client-id");
        client.setClientSecret("test-client-secret");

        // Token endpoint mock
        stubFor(post(urlEqualTo("/api/v1/oauth2/token"))
            .withHost(equalTo("api.bandwidth.com"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{\"access_token\":\"fetched-token\",\"expires_in\":3600}")));

        stubFor(get(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v1.0/accounts/accountId/sites");

        // Should fetch token and use it
        verify(postRequestedFor(urlEqualTo("/api/v1/oauth2/token"))
                .withHost(equalTo("api.bandwidth.com"))
                .withHeader("Authorization", matching("Basic .*"))
                .withRequestBody(equalTo("grant_type=client_credentials")));
                
        verify(getRequestedFor(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .withHeader("Authorization", equalTo("Bearer fetched-token")));

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testConstructorWithAllOAuthFields() throws Exception {
        // Client with all OAuth fields (client credentials + token + expiration) - default URI
        long futureExpiration = System.currentTimeMillis() / 1000 + 3600;
        IrisClient client = new IrisClient("accountId", "username", "password",
                "v1.0", "test-client-id", "test-client-secret",
                "existing-token", futureExpiration);

        stubFor(get(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v1.0/accounts/accountId/sites");

        // Should use existing token and not fetch new one
        verify(0, postRequestedFor(urlPathEqualTo("/api/v1/oauth2/token")));
        verify(getRequestedFor(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .withHeader("Authorization", equalTo("Bearer existing-token")));
        
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testConstructorWithAllFieldsFullCustomization() throws Exception {
        // Client with ALL fields customized
        long futureExpiration = System.currentTimeMillis() / 1000 + 3600;
        IrisClient client = new IrisClient(new DefaultHttpClient(), "http://localhost:8090",
                "accountId", "username", "password",
                "v1.0", "test-client-id", "test-client-secret",
                "full-custom-token", futureExpiration);

        stubFor(get(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v1.0/accounts/accountId/sites");

        // Should use existing token and not fetch new one
        verify(0, postRequestedFor(urlPathEqualTo("/api/v1/oauth2/token")));
        verify(getRequestedFor(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .withHeader("Authorization", equalTo("Bearer full-custom-token")));
        
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testExpiredTokenTriggersRefresh() throws Exception {
        // Client with expired access token
        DefaultHttpClient httpClient = createProxyHttpClient();
        long pastExpiration = System.currentTimeMillis() / 1000 - 3600;
        IrisClient client = new IrisClient(httpClient, "http://localhost:8090", "accountId",
                "username", "password", "v1.0", "test-client-id",
                "test-client-secret", "expired-token", pastExpiration);

        stubFor(post(urlPathEqualTo("/api/v1/oauth2/token"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"access_token\":\"new-token\",\"expires_in\":3600}")));

        stubFor(get(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v1.0/accounts/accountId/sites");

        // Should fetch new token and use it
        verify(postRequestedFor(urlPathEqualTo("/api/v1/oauth2/token"))
                .withHeader("Authorization", matching("Basic .*"))
                .withRequestBody(equalTo("grant_type=client_credentials")));

        verify(getRequestedFor(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .withHeader("Authorization", equalTo("Bearer new-token")));
        
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testClientWithoutOAuthUsesBasicAuth() throws Exception {
        // Client without OAuth configuration
        IrisClient client = new IrisClient("accountId", "username", "password");

        stubFor(get(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v1.0/accounts/accountId/sites");

        // Should NOT have Bearer token
        verify(0, postRequestedFor(urlPathEqualTo("/api/v1/oauth2/token")));
        verify(getRequestedFor(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .withoutHeader("Authorization"));
        
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testTokenExpirationWithinOneMinuteTriggersRefresh() throws Exception {
        // Client with token expiring in 30 seconds
        DefaultHttpClient httpClient = createProxyHttpClient();
        long soonExpiration = System.currentTimeMillis() / 1000 + 30;
        IrisClient client = new IrisClient(httpClient, "accountId", "username", "password",
                "v1.0", "test-client-id", "test-client-secret",
                "expiring-soon-token", soonExpiration);

        stubFor(post(urlPathEqualTo("/api/v1/oauth2/token"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"access_token\":\"refreshed-token\",\"expires_in\":3600}")));

        stubFor(get(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v1.0/accounts/accountId/sites");

        // Should fetch new token and use it
        verify(postRequestedFor(urlPathEqualTo("/api/v1/oauth2/token"))
                .withHeader("Authorization", matching("Basic .*"))
                .withRequestBody(equalTo("grant_type=client_credentials")));

        verify(getRequestedFor(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .withHeader("Authorization", equalTo("Bearer refreshed-token")));
        
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testConstructorWithCustomUriAndVersion() throws Exception {
        // Client with custom URI and version
        IrisClient client = new IrisClient("http://localhost:8090", "accountId", "username", "password", "v2.0");

        stubFor(get(urlPathEqualTo("/v2.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v2.0/accounts/accountId/sites");

        // Should NOT have Bearer token
        verify(0, postRequestedFor(urlPathEqualTo("/api/v1/oauth2/token")));
        verify(getRequestedFor(urlPathEqualTo("/v2.0/accounts/accountId/sites"))
                .withoutHeader("Authorization"));
        
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testConstructorWithCustomUriVersionAndToken() throws Exception {
        // Client with custom URI, version, and pre-configured token
        long futureExpiration = System.currentTimeMillis() / 1000 + 3600;
        IrisClient client = new IrisClient("http://localhost:8090", "accountId", "username", "password",
                "v2.0", "custom-uri-token", futureExpiration);

        stubFor(get(urlPathEqualTo("/v2.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v2.0/accounts/accountId/sites");

        // Should use existing token and not fetch new one
        verify(0, postRequestedFor(urlPathEqualTo("/api/v1/oauth2/token")));
        verify(getRequestedFor(urlPathEqualTo("/v2.0/accounts/accountId/sites"))
                .withHeader("Authorization", equalTo("Bearer custom-uri-token")));
        
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testConstructorWithHttpClientUriAndClientCredentials() throws Exception {
        // Client with custom httpClient, URI, and OAuth client credentials
        DefaultHttpClient httpClient = createProxyHttpClient();
        IrisClient client = new IrisClient(httpClient, "http://localhost:8090", "accountId",
                "username", "password", "http-client-id", "http-client-secret");

        stubFor(post(urlEqualTo("/api/v1/oauth2/token"))
                .withHost(equalTo("api.bandwidth.com"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"access_token\":\"fetched-token\",\"expires_in\":3600}")));

        stubFor(get(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("<Sites></Sites>")));

        IrisResponse response = client.get("http://localhost:8090/v1.0/accounts/accountId/sites");

        // Should fetch token and use it
        verify(postRequestedFor(urlEqualTo("/api/v1/oauth2/token"))
                .withHost(equalTo("api.bandwidth.com")));
        verify(getRequestedFor(urlPathEqualTo("/v1.0/accounts/accountId/sites"))
                .withHeader("Authorization", equalTo("Bearer fetched-token")));
        
        assertEquals(200, response.getStatusCode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForNullAccountId() {
        new IrisClient(new DefaultHttpClient(), "http://localhost:8090", null, "username", "password", "v1.0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForEmptyAccountId() {
        new IrisClient(new DefaultHttpClient(), "http://localhost:8090", "", "username", "password", "v1.0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForNullUsername() {
        new IrisClient(new DefaultHttpClient(), "http://localhost:8090", "accountId", null, "password", "v1.0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForEmptyPassword() {
        new IrisClient(new DefaultHttpClient(), "http://localhost:8090", "accountId", "username", "", "v1.0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForNullUri() {
        new IrisClient(new DefaultHttpClient(), null, "accountId", "username", "password", "v1.0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForEmptyVersion() {
        new IrisClient(new DefaultHttpClient(), "http://localhost:8090", "accountId", "username", "password", "");
    }
}
