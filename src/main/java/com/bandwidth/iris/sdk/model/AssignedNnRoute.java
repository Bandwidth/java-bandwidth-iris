package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "AssignedNnRoute")
@XmlAccessorType(XmlAccessType.FIELD)
public class AssignedNnRoute extends BaseModel {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Nnid")
    private String nnid;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNnid() {
        return nnid;
    }

    public void setNnid(String nnid) {
        this.nnid = nnid;
    }
}
