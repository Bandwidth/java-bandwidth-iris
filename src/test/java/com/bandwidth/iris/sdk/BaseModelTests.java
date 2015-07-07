package com.bandwidth.iris.sdk;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.junit.Before;
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

    @Before
    public void setUp() throws ConfigurationException {
        org.apache.log4j.BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.DEBUG);
        ConsoleAppender a = (ConsoleAppender) Logger.getRootLogger().getAllAppenders().nextElement();
        a.setLayout(new PatternLayout("%d{ABSOLUTE} %5p %c{1}:%L - [%t] %m%n"));

    }

    public void setMessage(String s) {
        this.message = s;
    }

}
