package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

/**
 * Created by sbarstow on 11/19/14.
 */
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

    public static Subscription create(IrisClient client, Subscription subscription) throws Exception {
        IrisResponse irisResponse = client.post(client.buildUserModelUri(new String[] { IrisConstants.SUBSCRIPTIONS_URI_PATH }),
                subscription);
        String id = client.getIdFromLocationHeader(irisResponse.getHeaders().get("Location"));
        return get(client, id);
    }

    public static Subscription get(IrisClient client, String subscriptionId) throws Exception {
        SubscriptionsResponse subscriptionsResponse = client.get(client.buildUserModelUri(
                new String[] { IrisConstants.SUBSCRIPTIONS_URI_PATH,
                subscriptionId }), SubscriptionsResponse.class);
        Subscription subscription = subscriptionsResponse.getSubscriptions().get(0);
        subscription.setClient(client);
        return subscription;
    }

    public static List<Subscription> list(IrisClient client, Map<String, Object> query) throws Exception {
        SubscriptionsResponse subscriptions = client.get(
                client.buildUserModelUri(new String[] { IrisConstants.SUBSCRIPTIONS_URI_PATH }, query),
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
        client.put(client.buildUserModelUri(new String[] { IrisConstants.SUBSCRIPTIONS_URI_PATH, subscriptionId }), this);
    }

    public void delete() throws Exception {
        client.delete(client.buildUserModelUri(new String[] { IrisConstants.SUBSCRIPTIONS_URI_PATH, subscriptionId }));
    }
}
