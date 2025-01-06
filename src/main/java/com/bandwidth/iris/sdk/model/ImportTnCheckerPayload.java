package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name="ImportTnCheckerPayload")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportTnCheckerPayload extends BaseModel {

    @XmlElement( name = "SiteId")
    private Integer siteId;

    @XmlElement( name = "SipPeerId")
    private Integer sipPeer;

    @XmlElementWrapper(name = "TelephoneNumbers")
    @XmlElement(name = "TelephoneNumber")
    private List<String> telephoneNumberList;

    @XmlElementWrapper(name = "ImportTnErrors")
    @XmlElement(name ="ImportTnError")
    private List<ImportTnError> importTnErrorList;

    public List<String> getTelephoneNumberList() {
        return telephoneNumberList;
    }

    public void setTelephoneNumberList(List<String> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public List<ImportTnError> getImportTnErrorList() {
        return importTnErrorList;
    }

    public void setImportTnErrorList(List<ImportTnError> importTnErrorList) {
        this.importTnErrorList = importTnErrorList;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getSipPeer() {
        return sipPeer;
    }

    public void setSipPeer(Integer sipPeer) {
        this.sipPeer = sipPeer;
    }
}
