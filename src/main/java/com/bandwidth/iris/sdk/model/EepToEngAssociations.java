package com.bandwidth.iris.sdk.model;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "EepToEngAssociations")
@XmlAccessorType(XmlAccessType.FIELD)
public class EepToEngAssociations {

    @XmlElementWrapper(name = "EepTns")
    @XmlElement(name = "TelephoneNumber")
    private List<String> eepTns;

    @XmlElementWrapper(name = "EepAeuiIds")
    @XmlElement(name = "Identifier")
    private List<String> eepAeuiIds;

    public List<String> getEepTns() {
        return eepTns;
    }

    public void setEepTns(List<String> eepTns) {
        this.eepTns = eepTns;
    }

    public List<String> getEepAeuiIds() {
        return eepAeuiIds;
    }

    public void setEepAeuiIds(List<String> eepAeuiIds) {
        this.eepAeuiIds = eepAeuiIds;
    }
}
