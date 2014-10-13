package com.bandwidth.iris.sdk;

/**
 * Created by sbarstow on 10/10/14.
 */
public class IrisClientException extends Exception {
    public IrisClientException(){}

    public IrisClientException(Throwable e){
        super(e);
    }

    public IrisClientException(String message){
        super(message);
    }

}
