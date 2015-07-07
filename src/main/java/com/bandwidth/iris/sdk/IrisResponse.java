package com.bandwidth.iris.sdk;

import org.apache.http.HttpStatus;

import java.util.Map;

public class IrisResponse {
    private String responseBody;
    private int statusCode;
    private Map<String, String> headers;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isOK() {
        return (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_CREATED);
    }

}
