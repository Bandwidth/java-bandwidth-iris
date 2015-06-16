package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 6/16/15.
 */
@XmlRootElement(name="LineOptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineOptions {
    @XmlElementWrapper(name="CompletedNumbers")
    @XmlElement(name="TelephoneNumber")
    private List<String> telephoneNumbers = new ArrayList<String>();

    @XmlElementWrapper(name="Errors")
    @XmlElement(name="Error")
    private List<Error> errors = new ArrayList<Error>();

    public List<String> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<String> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
