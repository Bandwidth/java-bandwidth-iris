package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Error")
@XmlAccessorType(XmlAccessType.FIELD)
public class Error {
    @XmlElement(name = "Code")
    private String code;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "TelephoneNumber")
    private String telephoneNumber;


    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<TelephoneNumber> telephoneNumberList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public List<TelephoneNumber> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<TelephoneNumber> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

}
