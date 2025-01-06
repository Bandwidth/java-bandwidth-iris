package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "LosingCarrierTnList")
@XmlAccessorType(XmlAccessType.FIELD)
public class LosingCarrierTnList {
    @XmlElement(name = "LosingCarrierSPID")
    private String losingCarrierSPID;

    @XmlElement(name = "LosingCarrierName")
    private String losingCarrierName;

    @XmlElementWrapper(name = "TnList")
    @XmlElement(name = "Tn")
    private List<String> tnList = new ArrayList<String>();

}
