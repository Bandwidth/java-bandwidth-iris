package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 11/17/14.
 */
@XmlRootElement(name="Subscriber")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subscriber {
    @XmlElement(name="SubscriberType")
    private String subscriberType;

    @XmlElement(name="BusinessName")
    private String businessName;

    @XmlElement(name="ServiceAddress")
    private ServiceAddress serviceAddress;

    @XmlElement(name="FirstName")
    private String firstName;

    @XmlElement(name="LastName")
    private String lastName;

    @XmlElement(name="MiddleInitial")
    private String middleInitial;

    public String getSubscriberType() {
        return subscriberType;
    }

    public void setSubscriberType(String subscriberType) {
        this.subscriberType = subscriberType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public ServiceAddress getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(ServiceAddress serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
