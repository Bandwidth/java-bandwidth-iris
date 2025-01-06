package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ExistingTelephoneNumberOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExistingTelephoneNumberOrderType {
    @XmlElementWrapper(name = "TelephoneNumberList")
    @XmlElement(name = "TelephoneNumber")
    private List<String> telephoneNumberList = new ArrayList<String>();

    @XmlElementWrapper(name = "ReservationIdList")
    @XmlElement(name = "ReservationId", nillable = true)
    private List<String> reservationIdList = new ArrayList<String>();

    public List<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public List<String> getReservationIdList() {
        return reservationIdList;
    }

    public void setReservationIdList(List<String> reservationIdList) {
        this.reservationIdList = reservationIdList;
    }
}
