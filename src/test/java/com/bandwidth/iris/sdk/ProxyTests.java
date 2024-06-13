package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.Order;
import com.bandwidth.iris.sdk.model.OrderResponse;
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
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.Assert.assertEquals;

public class ProxyTests {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090); // No-args constructor defaults to port 8080
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    protected IrisClient getDefaultClient() {
        return new IrisClient("https://d815f3b06d79650d7a886f0c2ce1955d.m.pipedream.net", "accountId", "username", "password", "v1.0");
    }

    protected IrisClient getCustomClient() {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpHost proxy = new HttpHost("localhost",80);
        client.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY,proxy);

        Credentials credentials = new UsernamePasswordCredentials("userName", "password");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials( new AuthScope("localhost",8080), credentials);

        client.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());

        return new IrisClient(client, "http://localhost:8090", "accountId", "username", "password");
    }

    @Test
    public void testWithCustomClient() throws Exception {
        String url = "/v1.0/accounts/accountId/orders/someid";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(IrisClientTestUtils.validOrderResponseXml)));

        OrderResponse orderResponse = Order.get(getCustomClient(), "someid");
        assertEquals(orderResponse.getOrder().getid(), "someid");
        assertEquals(orderResponse.getOrder().getExistingTelephoneNumberOrderType().getTelephoneNumberList().get(0),
                "2052865046");
        assertEquals(orderResponse.getOrder().getName(), "A New Order");
    }
}
