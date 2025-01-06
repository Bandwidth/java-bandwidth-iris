package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "TnOptionGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class TnOptionGroup extends BaseModel {

    @XmlElement(name = "CallingNameDisplay")
    private String callingNameDisplay;

    @XmlElement(name = "Sms")
    private String sms;

    @XmlElement(name = "FinalDestinationURI")
    private String finalDestinationURI;

    @XmlElement(name = "OrderId")
    private String orderId;

    @XmlElement(name = "LastModifiedDate")
    private String lastModifiedDate;

    @XmlElement(name = "ProcessingStatus")
    private String processingStatus;

    @XmlElement(name = "NumberFormat")
    private String numberFormat;

    @XmlElement(name = "RPIDFormat")
    private String rPIDFormat;

    @XmlElement(name = "RewriteUser")
    private String rewriteUser;

    @XmlElement(name = "CallForward")
    private String callForward;

    @XmlElement(name = "PortOutPasscode")
    private String portOutPasscode;

    @XmlElement(name = "Protected")
    private String protectedOpt;

    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<String> TelephoneNumbers;

    @XmlElementWrapper(name = "ErrorList")
    @XmlElement(name = "Errors")
    private List<Error> errors;

    @XmlElementWrapper(name = "Warnings")
    @XmlElement(name = "Warning")
    private List<Warning> Warnings;

    @XmlElement(name = "A2pSettings")
    private A2pSettings a2pSettings;

    public String getPortOutPasscode() {
        return portOutPasscode;
    }

    public void setPortOutPasscode(String portOutPasscode) {
        this.portOutPasscode = portOutPasscode;
    }

    public String getCallingNameDisplay() {
        return callingNameDisplay;
    }

    public void setCallingNameDisplay(String callingNameDisplay) {
        this.callingNameDisplay = callingNameDisplay;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getFinalDestinationURI() {
        return finalDestinationURI;
    }

    public void setFinalDestinationURI(String finalDestinationURI) {
        this.finalDestinationURI = finalDestinationURI;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }

    public String getNumberFormat() {
        return numberFormat;
    }

    public void setNumberFormat(String numberFormat) {
        this.numberFormat = numberFormat;
    }

    public String getRPIDFormat() {
        return rPIDFormat;
    }

    public void setRPIDFormat(String rPIDFormat) {
        this.rPIDFormat = rPIDFormat;
    }

    public String getRewriteUser() {
        return rewriteUser;
    }

    public void setRewriteUser(String rewriteUser) {
        this.rewriteUser = rewriteUser;
    }

    public String getCallForward() {
        return callForward;
    }

    public void setCallForward(String callForward) {
        this.callForward = callForward;
    }

    public String getProtectedOpt() {
        return protectedOpt;
    }

    public void setProtectedOpt(String protectedOpt) {
        this.protectedOpt = protectedOpt;
    }

    public List<String> getTelephoneNumbers() {
        return TelephoneNumbers;
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        TelephoneNumbers = telephoneNumbers;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public List<Warning> getWarnings() {
        return Warnings;
    }

    public void setWarnings(List<Warning> warnings) {
        Warnings = warnings;
    }

    public A2pSettings getA2pSettings() {
        return a2pSettings;
    }

    public void setA2pSettings(A2pSettings a2pSettings) {
        this.a2pSettings = a2pSettings;
    }
}
