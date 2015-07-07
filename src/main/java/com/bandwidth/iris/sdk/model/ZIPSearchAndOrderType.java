package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ZIPSearchAndOrderType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZIPSearchAndOrderType extends BaseOrderType {
    @XmlElement(name = "Zip")
    private String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

}
