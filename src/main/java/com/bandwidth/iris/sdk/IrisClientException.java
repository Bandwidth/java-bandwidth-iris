package com.bandwidth.iris.sdk;

public class IrisClientException extends Exception {
    private String errorCode;
    private String description;

    public IrisClientException(Throwable e) {
        super(e);
    }

    public IrisClientException(String message) {
        super(message);
    }

    public IrisClientException(String errorCode, String description) {
        super(description);
        this.errorCode = errorCode;
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

}
