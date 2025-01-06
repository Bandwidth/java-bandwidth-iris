package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "LineOptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class LineOptions {
    @XmlElementWrapper(name = "CompletedNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<String> completedNumbers = new ArrayList<String>();

    @XmlElementWrapper(name = "Errors")
    @XmlElement(name = "Error")
    private List<Error> errors = new ArrayList<Error>();

    public List<String> getCompletedNumbers() {
        return completedNumbers;
    }

    public void setCompletedNumbers(List<String> telephoneNumbers) {
        this.completedNumbers = telephoneNumbers;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
