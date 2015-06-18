package com.bandwidth.iris.sdk.examples;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.model.*;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sbarstow on 10/8/14.
 */
public class Example {

    public static void main(String[] args) throws Exception {
        org.apache.log4j.BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
        ConsoleAppender a = (ConsoleAppender) Logger.getRootLogger().getAllAppenders().nextElement();
        a.setLayout(new PatternLayout("%d{ABSOLUTE} %5p %c{1}:%L - [%t] %m%n"));

        try {
            printAvailableNpaNxx();
            printAvailableNumbers();
            printCities();
            printSites();
        }catch(Exception e){
            System.out.println("Got error: " + e.getStackTrace());
        }
//        printReservations();

    }

    private static void printAvailableNpaNxx() throws Exception {
        printMessage("Starting print search available Npa Nxx");
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("areaCode", "805");
        query.put("quantity", 2);
        List<AvailableNpaNxx> availableNpaNxxList = AvailableNpaNxx.list(getClient(), query);
        for(AvailableNpaNxx npaNxx : availableNpaNxxList){
            System.out.println(
              String.format("City: %s | Npa: %s | Nxx: %s | State: %s ", npaNxx.getCity(), npaNxx.getNpa(),
                      npaNxx.getNxx(), npaNxx.getState())
            );
        }
        printMessage("Ending print search available Npa Nxx");

    }

    private static void printAvailableNumbers() throws Exception {
        printMessage("Starting print search results");
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("areaCode", "205");
        query.put("enableTNDetail", true);
        query.put("quantity", 2);

        List<TelephoneNumberDetail> numbers = (List<TelephoneNumberDetail>) AvailableNumbers.search(
                getClient(), query);
        for (TelephoneNumberDetail number : numbers) {
            System.out.println(
                    String.format("Full number: %s : Rate Center: %s", number.getFullNumber(), number.getRateCenter()));
        }
        printMessage("Ending print search results");
    }

    private static void printCities() throws Exception {
        printMessage("Starting print cities");
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("state", "NC");

        List<City> cities = City.list(getClient(), query);
        for(City c : cities){
            System.out.println(String.format("Name: %s | RcAbbreviation: %s", c.getName(), c.getRcAbbreviation()));
        }
        printMessage("Ending print cities");

    }


    private static void printSites() throws Exception {
        printMessage("Starting print sites");

        List<Site> sites = Site.list(getClient());
        for (Site s : sites) {
            System.out.println(
                    String.format("Site Id: %s | Site Name: %s | Description: %s", s.getId(), s.getName(), s.getDescription()));
        }

        Site s = new Site();
        printMessage("Ending print sites");
    }


    private static void printReservations() {
        printMessage("Starting print reservations");
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("areaCode", "205");
        query.put("enableTNDetail", true);
        query.put("quantity", 2);
        try {

            List<TelephoneNumberDetail> numbers = (List<TelephoneNumberDetail>) AvailableNumbers.search(
                    getClient(), query);

            Reservation reservation = new Reservation();
            reservation.getReservedTn().add("2052350804");
            reservation = Reservation.create(getClient(), reservation);
            System.out.println(String.format("Reservation Id: %s : Reserved For: %s", reservation.getReservationId(),
                    reservation.getReservationExpires()));
        } catch (Exception e) {
        }

        printMessage("Ending print reservations");

    }

    private static IrisClient getClient() {
        Map<String, String> env = System.getenv();
        String accountId = env.get("BANDWIDTH_IRIS_ACCOUNTID");
        String username = env.get("BANDWIDTH_IRIS_USERNAME");
        String password = env.get("BANDWIDTH_IRIS_PASSWORD");
        String url = env.get("BANDWIDTH_IRIS_URL");

        return new IrisClient(url, accountId, username, password, "v1.0");
    }

    private static void printMessage(String message) {
        System.out.println("********** " + message + "**********");
    }
}