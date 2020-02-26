package com.bandwidth.iris.sdk;

import com.bandwidth.iris.sdk.model.CallbackSubscription;
import com.bandwidth.iris.sdk.model.EmailSubscription;
import com.bandwidth.iris.sdk.model.Subscription;
import org.junit.Test;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class SubscriptionTests extends BaseModelTests {
    @Test
    public void testCreate() throws Exception {
        String url = "/v1.0/accounts/accountId/subscriptions";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withHeader("Location", "subscriptionId")));

        String getUrl = "/v1.0/accounts/accountId/subscriptions/subscriptionId";
        stubFor(get(urlMatching(getUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSubscriptionsResponseXml)));

        Subscription subscription = new Subscription();
        subscription.setOrderType("orders");
        subscription.setOrderId("orderId");
        EmailSubscription emailSubscription = new EmailSubscription();
        emailSubscription.setEmail("test@test.com");
        emailSubscription.setDigestRequested("NONE");
        subscription.setEmailSubscription(emailSubscription);
        Subscription createdSubscription = Subscription.create(getDefaultClient(), subscription);

        assertNotNull(createdSubscription);
        assertEquals("subscriptionId", createdSubscription.getSubscriptionId());
        assertEquals("test@test.com", createdSubscription.getEmailSubscription().getEmail());
    }

    @Test
    public void testCreateCallback() throws Exception {
        String url = "/v1.0/accounts/accountId/subscriptions";
        stubFor(post(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/xml")
                        .withHeader("Location", "subscriptionId")));

        String getUrl = "/v1.0/accounts/accountId/subscriptions/subscriptionId";
        stubFor(get(urlMatching(getUrl))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.callbackSubscription)));

        Subscription subscription = new Subscription();
        subscription.setOrderType("csrs");
        subscription.setOrderId("orderId");
        CallbackSubscription callbackSubscription = new CallbackSubscription();
        callbackSubscription.setURL("http://example.com");

        subscription.setCallbackSubscription(callbackSubscription);
        Subscription createdSubscription = Subscription.create(getDefaultClient(), subscription);

        assertNotNull(createdSubscription);
        assertEquals("bandwidth-dashboard-user-id", createdSubscription.getCallbackSubscription().getUser());
        assertEquals("http://yourhost:8080/path/to/resource", createdSubscription.getCallbackSubscription().getURL());
        assertEquals("superuser", createdSubscription.getCallbackSubscription().getCallbackCredentials().getBasicAuthentication().getUsername() );
        assertEquals("s3cure", createdSubscription.getCallbackSubscription().getCallbackCredentials().getBasicAuthentication().getPassword() );
        assertEquals("LS0tLS1CRUdJTiBDRVJUSkQgQ0VSVElGSUNBVEUtLS0tLQ0K", createdSubscription.getCallbackSubscription().getCallbackCredentials().getPublicKey() );
    }

    @Test
    public void testList() throws Exception {
        String url = "/v1.0/accounts/accountId/subscriptions";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSubscriptionsResponseXml)));

        List<Subscription> subscriptionList = Subscription.list(getDefaultClient(), null);
        assertNotNull(subscriptionList);
        assertEquals(1, subscriptionList.size());
    }

    @Test
    public void testDelete() throws Exception {
        String url = "/v1.0/accounts/accountId/subscriptions/subscriptionId";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSubscriptionsResponseXml)));

        stubFor(delete(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        Subscription subscription = Subscription.get(getDefaultClient(), "subscriptionId");
        subscription.delete();
    }

    @Test
    public void testUpdate() throws Exception {
        String url = "/v1.0/accounts/accountId/subscriptions/subscriptionId";
        stubFor(get(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200).withBody(IrisClientTestUtils.validSubscriptionsResponseXml)));

        stubFor(put(urlMatching(url))
                .willReturn(aResponse()
                        .withStatus(200)));

        Subscription subscription = Subscription.get(getDefaultClient(), "subscriptionId");
        subscription.getEmailSubscription().setEmail("another@test.com");
        subscription.update();

    }

}
