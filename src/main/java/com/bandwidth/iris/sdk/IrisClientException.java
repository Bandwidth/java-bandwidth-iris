package com.bandwidth.iris.sdk;


/**
 * Created by sbarstow on 10/10/14.
 */
public class IrisClientException extends Exception {
    private String errorCode;
    private String description;

    public IrisClientException(){}

    public IrisClientException(Throwable e){
        super(e);
    }

    public IrisClientException(String message){
        super(message);
    }

    public IrisClientException(String errorCode, String description){
        super(description);
        this.errorCode = errorCode;
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
