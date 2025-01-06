package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "NumberPortabilityResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class NumberPortabilityResponse extends BaseResponse {
    @XmlElementWrapper(name = "PortableNumbers")
    @XmlElement(name = "Tn")
    private List<String> portableNumbers = new ArrayList<String>();

    @XmlElementWrapper(name = "SupportedRateCenters")
    @XmlElement(name = "RateCenterGroup")
    private List<RateCenterGroup> supportedRateCenters = new ArrayList<RateCenterGroup>();

    @XmlElementWrapper(name = "UnsupportedRateCenters")
    @XmlElement(name = "RateCenterGroup")
    private List<RateCenterGroup> unsupportedRateCenters = new ArrayList<RateCenterGroup>();

    @XmlElement(name = "Errors")
    private List<Error> errors = new ArrayList<Error>();

    @XmlElementWrapper(name = "UnsupportedLosingCarriers")
    @XmlElement(name = "LosingCarrierTnList")
    private List<LosingCarrierTnList> unsupportedLosingCarriers = new ArrayList<LosingCarrierTnList>();

    @XmlElementWrapper(name = "SupportedLosingCarriers")
    @XmlElement(name = "LosingCarrierTnList")
    private List<LosingCarrierTnList> supportedLosingCarriers = new ArrayList<LosingCarrierTnList>();

    public List<String> getPortableNumbers() {
        return portableNumbers;
    }

    public void setPortableNumbers(List<String> portableNumbers) {
        this.portableNumbers = portableNumbers;
    }

    public List<RateCenterGroup> getSupportedRateCenters() {
        return supportedRateCenters;
    }

    public void setSupportedRateCenters(List<RateCenterGroup> supportedRateCenters) {
        this.supportedRateCenters = supportedRateCenters;
    }

    public List<RateCenterGroup> getUnsupportedRateCenters() {
        return unsupportedRateCenters;
    }

    public void setUnsupportedRateCenters(List<RateCenterGroup> unsupportedRateCenters) {
        this.unsupportedRateCenters = unsupportedRateCenters;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public List<LosingCarrierTnList> getUnsupportedLosingCarriers() {
        return unsupportedLosingCarriers;
    }

    public void setUnsupportedLosingCarriers(List<LosingCarrierTnList> unsupportedLosingCarriers) {
        this.unsupportedLosingCarriers = unsupportedLosingCarriers;
    }

    public List<LosingCarrierTnList> getSupportedLosingCarriers() {
        return supportedLosingCarriers;
    }

    public void setSupportedLosingCarriers(List<LosingCarrierTnList> supportedLosingCarriers) {
        this.supportedLosingCarriers = supportedLosingCarriers;
    }
}
