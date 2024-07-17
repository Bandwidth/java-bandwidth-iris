package com.bandwidth.iris.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class BaseModelTests {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090); // No-args constructor defaults to port 8080
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    protected String message;

    protected IrisClient getDefaultClient() {
        return new IrisClient("http://localhost:8090", "accountId", "username", "password", "v1.0");
    }

    protected IrisClient getCustomClient() {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpHost proxy = new HttpHost("localhost",8090);
        client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);

        Credentials credentials = new UsernamePasswordCredentials("userName", "password");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials( new AuthScope("localhost",8080), credentials);

        client.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());

        return new IrisClient(client, "http://localhost:8090", "accountId", "username", "password");
    }

    public void setMessage(String s) {
        this.message = s;
    }

}
