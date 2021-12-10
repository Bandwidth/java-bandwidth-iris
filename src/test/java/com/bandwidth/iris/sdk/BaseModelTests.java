package com.bandwidth.iris.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
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

    public void setMessage(String s) {
        this.message = s;
    }

}
