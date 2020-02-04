package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class ImportTnError {

    @XmlElement(name = "Cdoe")
    private String code;
    @XmlElement(name = "Description")
    private String description;
    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<TelephoneNumber> telephoneNumberList;
}
