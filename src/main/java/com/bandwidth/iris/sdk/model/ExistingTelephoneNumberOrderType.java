package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 10/14/14.
 */
@XmlRootElement(name="ExistingTelephoneNumberOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExistingTelephoneNumberOrderType {
    @XmlElementWrapper(name="TelephoneNumberList")
    @XmlElement(name="TelephoneNumber")
    private List<String> telephoneNumberList = new ArrayList<String>();

    public List<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

}
