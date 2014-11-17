package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 11/17/14.
 */
@XmlRootElement(name="LosingCarrierTnList")
@XmlAccessorType(XmlAccessType.FIELD)
public class LosingCarrierTnList {
    @XmlElement(name="LosingCarrierSPID")
    private String losingCarrierSPID;

    @XmlElement(name="LosingCarrierName")
    private String losingCarrierName;

    @XmlElementWrapper(name="TnList")
    @XmlElement(name="Tn")
    private List<String> tnList = new ArrayList<String>();



}
