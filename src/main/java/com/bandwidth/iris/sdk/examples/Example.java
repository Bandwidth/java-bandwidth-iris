package com.bandwidth.iris.sdk.examples;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.model.*;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import sun.tools.asm.Cover;

import java.io.File;
import java.util.*;

/**
 * Created by sbarstow on 10/8/14.
 */
public class Example {
    private static Site SITE = null;
    private static SipPeer SIP_PEER = null;


    public static void main(String[] args) throws Exception {
        org.apache.log4j.BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
        ConsoleAppender a = (ConsoleAppender) Logger.getRootLogger().getAllAppenders().nextElement();
        a.setLayout(new PatternLayout("%d{ABSOLUTE} %5p %c{1}:%L - [%t] %m%n"));

        try {
            printCreateSite();
            printCreateAndGetSipPeer();
            printCreateLnpOrder();
            printAvailableNpaNxx();
            printAvailableNumbers();
            printCoveredRateCenters();
            printCities();
            printLnpChecker();
            printCreateAndGetOrder();
            printRateCenters();
            printGetTnDetails();
            printGetTns();

        }catch(Exception e){
            System.out.println("Got error: " + e.getMessage());
        }

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

    private static void printCoveredRateCenters() throws Exception {
        printMessage("Starting print covered Rate Centers");
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("state", "NC");

        List<CoveredRateCenter> rateCenters = CoveredRateCenter.list(getClient(), query);
        for(CoveredRateCenter rc : rateCenters){
            System.out.println(String.format("Name: %s | Abbreviation: %s | State: %s | Lata: %s", rc.getName(),
                    rc.getAbbreviation(), rc.getState(), rc.getLata()));
        }
        printMessage("Ending print covered Rate Centers");
    }


    private static void printCreateSite() throws Exception {
        printMessage("Starting print sites");

        Address a = new Address();
        a.setHouseNumber("123");
        a.setStreetName("Anywhere St");
        a.setCity("Raleigh");
        a.setState("NC");
        a.setZip("27609");
        a.setAddressType("Service");
        Site s = new Site();
        s.setName("A new site " + new Random().nextInt());
        s.setDescription("Test site from Java Lib");
        s.setAddress(a);

        s = Site.create(getClient(), s);
        SITE = s;

        printMessage("Ending print sites");
    }

    private static void printLnpChecker() throws Exception {
        printMessage("Starting print LNP Check");

        NumberPortabilityRequest request = new NumberPortabilityRequest();
        request.getTnList().add("9195551212");
        NumberPortabilityResponse response = LnpChecker.checkLnp(getClient(), request, "true");
        if(response.getPortableNumbers().size() > 0){
            System.out.println(response.getPortableNumbers().get(0));
        }else {
            System.out.println("This number is not portable. Try another one");
        }
        printMessage("Ending print LNP Check");
    }

    private static void printCreateAndGetOrder() throws Exception {
        printMessage("Starting create Order");
        Order o = new Order();
        o.setSiteId(SITE.getId());
        o.setName("A New Order");
        ExistingTelephoneNumberOrderType existingTelephoneNumberOrderType = new ExistingTelephoneNumberOrderType();
        existingTelephoneNumberOrderType.getTelephoneNumberList().add("2052865046");
        o.setExistingTelephoneNumberOrderType(existingTelephoneNumberOrderType);

        OrderResponse createdOrder = Order.create(getClient(), o);
        System.out.println(String.format("Created order ID: %s", createdOrder.getOrder().getid()));

        OrderResponse theSameOrder = Order.get(getClient(), createdOrder.getOrder().getid());
        System.out.println("Successfully retrieved order, order status: " + theSameOrder.getOrderStatus());
        printMessage("Ending create Order");
    }

    private static void printCreateLnpOrder() throws Exception {
        LnpOrder order = new LnpOrder();
        order.setSiteId(getFirstSite().getId());
        order.setPeerId(getFirstSipPeer().getPeerId());
        order.setBillingTelephoneNumber("9195551212");
        Subscriber s = new Subscriber();
        s.setSubscriberType("BUSINESS");
        s.setBusinessName("Company");
        ServiceAddress serviceAddress = new ServiceAddress();
        serviceAddress.setHouseNumber("123");
        serviceAddress.setStreetName("Anywhere St");
        serviceAddress.setCity("Raleigh");
        serviceAddress.setStateCode("NC");
        serviceAddress.setZip("27609");
        s.setServiceAddress(serviceAddress);
        order.setSubscriber(s);
        order.setLoaAuthorizingPerson("Joe Blow");
        order.getListOfPhoneNumbers().add("9195551212");

        order = LnpOrder.create(getClient(), order);
        File file = File.createTempFile("file", "pdf");
        order.uploadLoa(file, LoaFileType.PDF);
        System.out.println("Created new Lnp Order: " + order.getOrderId());
    }

    private static void printRateCenters() throws Exception {
        printMessage("Starting printRateCenters");
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("state", "NC");
        query.put("available", true);

        List<RateCenter> rateCenters = RateCenter.list(getClient(),query);
        for(RateCenter rc : rateCenters){
            System.out.println(String.format("Name: %s | Abbreviation: %s", rc.getName(), rc.getAbbreviation()));
        }
        printMessage("Ending printRateCenters");
    }

    private static void printCreateAndGetSipPeer() throws Exception {
        printMessage("Starting create Sip Peer");
        Host host = new Host();
        host.setHostName("1.1.1.1");

        TerminationHost termHost = new TerminationHost();
        termHost.setHostName("1.1.2.3");
        termHost.setPort("5060");

        SipPeer peer = new SipPeer();
        peer.setPeerName("A new Sip Peer " + new Random().nextInt());
        peer.setDefaultPeer(true);
        peer.setShortMessagingProtocol("SMPP");
        peer.setSiteId(getFirstSite().getId());

        peer.getVoiceHosts().add(host);
        peer.getSmsHosts().add(host);
        peer.getTerminationHosts().add(termHost);

        peer = SipPeer.create(getClient(), SITE.getId(), peer);
        System.out.println("Created SipPeer: " + peer.getPeerId());
        SIP_PEER = peer;

        printMessage("Ending create and get sip peer");
    }

    private static void printGetTnDetails() throws Exception {
        printMessage("Starting get Tn Detail");
        TelephoneNumberDetail detail = Tns.getTnDetails(getClient(), "9195551212");
        if(detail.getFullNumber() != null){
            System.out.println("Got TN Detail for : " + detail.getFullNumber());
        }

        printMessage("Ending get TN detail");
    }

    private static void printGetTns() throws Exception {
        printMessage("Starting get TNs");
        Map<String, Object> query = new HashMap<String, Object>();
        query.put("state", "NC");

        TelephoneNumbersResponse response = Tns.list(getClient(),query );
        System.out.println(String.format("Got %s numbers for this list", response.getTelephoneNumberCount()));
        printMessage("Ending get TNs");
    }

    private static Site getFirstSite() throws Exception {
        return Site.list(getClient()).get(0);
    }

    private static SipPeer getFirstSipPeer() throws Exception {
        return SipPeer.list(getClient(), getFirstSite().getId()).get(0);
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