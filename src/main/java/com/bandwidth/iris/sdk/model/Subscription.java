package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisPath;
import com.bandwidth.iris.sdk.IrisResponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "Subscription")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subscription extends BaseModel {

    @XmlElement(name = "SubscriptionId")
    private String subscriptionId;
    @XmlElement(name = "OrderType")
    private String orderType;
    @XmlElement(name = "OrderId")
    private String orderId;
    @XmlElement(name = "EmailSubscription")
    private EmailSubscription emailSubscription;
    @XmlElement(name = "CallbackSubscription")
    private CallbackSubscription callbackSubscription;

    public static Subscription create(IrisClient client, Subscription subscription) throws Exception {
        IrisResponse irisResponse = client.post(client.buildAccountModelUri(
                        new String[] { IrisPath.SUBSCRIPTIONS_URI_PATH }),
                subscription);
        String id = client.getIdFromLocationHeader(irisResponse.getHeaders().get("Location"));
        return get(client, id);
    }

    public static Subscription get(IrisClient client, String subscriptionId) throws Exception {
        SubscriptionsResponse subscriptionsResponse = client.get(client.buildAccountModelUri(
                new String[] { IrisPath.SUBSCRIPTIONS_URI_PATH,
                        subscriptionId }), SubscriptionsResponse.class);
        Subscription subscription = subscriptionsResponse.getSubscriptions().get(0);
        subscription.setClient(client);
        return subscription;
    }

    public static List<Subscription> list(IrisClient client, Map<String, Object> query) throws Exception {
        SubscriptionsResponse subscriptions = client.get(
                client.buildAccountModelUri(new String[] { IrisPath.SUBSCRIPTIONS_URI_PATH }, query),
                SubscriptionsResponse.class);
        for (Subscription s : subscriptions.getSubscriptions()) {
            s.setClient(client);
        }
        return subscriptions.getSubscriptions();
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public EmailSubscription getEmailSubscription() {
        return emailSubscription;
    }

    public void setEmailSubscription(EmailSubscription emailSubscription) {
        this.emailSubscription = emailSubscription;
    }

    public void update() throws Exception {
        client.put(client.buildAccountModelUri(new String[] { IrisPath.SUBSCRIPTIONS_URI_PATH, subscriptionId }), this);
    }

    public void delete() throws Exception {
        client.delete(client.buildAccountModelUri(new String[] { IrisPath.SUBSCRIPTIONS_URI_PATH, subscriptionId }));
    }

    public CallbackSubscription getCallbackSubscription() {
        return callbackSubscription;
    }

    public void setCallbackSubscription(CallbackSubscription callbackSubscription) {
        this.callbackSubscription = callbackSubscription;
    }
}
