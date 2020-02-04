package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class ImportTnCheckerPayload extends BaseModel {

    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<TelephoneNumber> telephoneNumberList;
    @XmlElementWrapper(name = "ImportTnErrors")
    @XmlElement(name ="ImportTnError")
    private List<ImportTnError> importTnErrorList;


}
