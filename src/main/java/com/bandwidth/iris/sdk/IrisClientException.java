package com.bandwidth.iris.sdk;

public class IrisClientException extends Exception {
    private String errorCode;
    private String description;
    private int statusCode;

    public IrisClientException(Throwable e) {
        super(e);
    }
    
    public IrisClientException(int statusCode, String errorCode, String description) {
        super(description);
        this.errorCode = errorCode;
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public int getStatusCode() { return statusCode; }

}
