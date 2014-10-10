package com.bandwidth.iris.sdk;

/**
 * Created by sbarstow on 10/6/14.
 */
public class IrisResponse {
    private String responseBody;
    private String statusCode;

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
