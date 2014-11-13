package com.bandwidth.iris.sdk.example;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisClientException;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.model.*;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sbarstow on 10/8/14.
 */
public class Example {

    public static void main(String[] args) throws IOException, IrisClientException {
        org.apache.log4j.BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
        ConsoleAppender a = (ConsoleAppender) Logger.getRootLogger().getAllAppenders().nextElement();
        a.setLayout(new PatternLayout("%d{ABSOLUTE} %5p %c{1}:%L - [%t] %m%n"));

        printSites();
        printSearchResults();

    }
    private static void printSites() throws IrisClientException {
        printMessage("Starting print sites");

        List<Site> sites = Site.list(getClient());
        for(Site s: sites){
            System.out.println(String.format("Site Id: %s | Site Name: %s | Description: %s", s.getId(), s.getName(), s.getDescription()));
        }
        printMessage("Ending print sites");
    }

    private static void printSearchResults() throws IrisClientException {
        printMessage("Starting print search results");
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("areaCode", "205");
        query.put("enableTNDetail", true);
        query.put("quantity", 2);

        List<TelephoneNumberDetail> numbers = (List<TelephoneNumberDetail>) TelephoneNumber.getAvailableNumbers(
                getClient(), query);
        for(TelephoneNumberDetail number : numbers){
            System.out.println(String.format("Full number: %s : Rate Center: %s", number.getFullNumber(), number.getRateCenter()));
        }
        printMessage("Ending print search results");
    }

    private static IrisClient getClient(){
        Map<String, String> env = System.getenv();
        String accountId = env.get("BANDWIDTH_IRIS_ACCOUNTID");
        String username = env.get("BANDWIDTH_IRIS_USERNAME");
        String password = env.get("BANDWIDTH_IRIS_PASSWORD");

        return new IrisClient(accountId,username, password);
    }


    private static void printMessage(String message){
        System.out.println("********** " + message + "**********");
    }
}