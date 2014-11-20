package com.bandwidth.iris.sdk.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 11/19/14.
 */
@XmlRootElement(name="Notes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Notes {
    @XmlElement(name="Note")
    private List<Note> notes = new ArrayList<Note>();

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
