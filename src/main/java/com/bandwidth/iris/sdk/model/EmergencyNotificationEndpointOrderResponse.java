package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "EmergencyNotificationEndpointOrderResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmergencyNotificationEndpointOrderResponse {

    @XmlElement(name = "Links")
    private Links links;

    @XmlElementWrapper(name = "EmergencyNotificationEndpointOrders")
    @XmlElement(name = "EmergencyNotificationEndpointOrder")
    private List<EmergencyNotificationEndpointOrder> emergencyNotificationEndpointOrders;

    @XmlElement(name = "EmergencyNotificationEndpointOrder")
    private EmergencyNotificationEndpointOrder emergencyNotificationEndpointOrder;

    @XmlElement(name = "EmergencyNotificationEndpointAssociation")
    private EmergencyNotificationEndpointAssociation emergencyNotificationEndpointAssociation;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<EmergencyNotificationEndpointOrder> getEmergencyNotificationEndpointOrders() {
        return emergencyNotificationEndpointOrders;
    }

    public void setEmergencyNotificationEndpointOrders(List<EmergencyNotificationEndpointOrder> emergencyNotificationEndpointOrders) {
        this.emergencyNotificationEndpointOrders = emergencyNotificationEndpointOrders;
    }

    public EmergencyNotificationEndpointOrder getEmergencyNotificationEndpointOrder() {
        return emergencyNotificationEndpointOrder;
    }

    public void setEmergencyNotificationEndpointOrder(EmergencyNotificationEndpointOrder emergencyNotificationEndpointOrder) {
        this.emergencyNotificationEndpointOrder = emergencyNotificationEndpointOrder;
    }

    public EmergencyNotificationEndpointAssociation getEmergencyNotificationEndpointAssociation() {
        return emergencyNotificationEndpointAssociation;
    }

    public void setEmergencyNotificationEndpointAssociation(EmergencyNotificationEndpointAssociation emergencyNotificationEndpointAssociation) {
        this.emergencyNotificationEndpointAssociation = emergencyNotificationEndpointAssociation;
    }
}
