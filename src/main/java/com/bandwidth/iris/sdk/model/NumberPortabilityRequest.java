package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "NumberPortabilityRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class NumberPortabilityRequest extends BaseModel {
    @XmlElementWrapper(name = "TnList")
    @XmlElement(name = "Tn")
    private List<String> tnList = new ArrayList<String>();

    public List<String> getTnList() {
        return tnList;
    }

    public void setTnList(List<String> tnList) {
        this.tnList = tnList;
    }
}
