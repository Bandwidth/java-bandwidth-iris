package com.bandwidth.iris.sdk.model;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CallbackCredentials")
@XmlAccessorType(XmlAccessType.FIELD)
public class CallbackCredentials {


    @XmlElement(name = "PublicKey")
    private String publicKey;

    @XmlElement(name = "BasicAuthentication")
    private BasicAuthentication basicAuthentication;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public BasicAuthentication getBasicAuthentication() {
        return basicAuthentication;
    }

    public void setBasicAuthentication(BasicAuthentication basicAuthentication) {
        this.basicAuthentication = basicAuthentication;
    }
}
