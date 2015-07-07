package com.bandwidth.iris.sdk.model;

public class TelephoneNumberSearchFilters {
    private String inAreaCode;
    private String filterPattern;
    private String inState;
    private String inPostalCode;
    private boolean isTollFree;
    private int quantity = 5;
    private boolean returnTelephoneNumberDetails = true;
    private String inRateCenter;
    private String inLata;

    public boolean isReturnTelephoneNumberDetails() {
        return returnTelephoneNumberDetails;
    }

    public void setReturnTelephoneNumberDetails(boolean returnTelephoneNumberDetails) {
        this.returnTelephoneNumberDetails = returnTelephoneNumberDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getInAreaCode() {
        return inAreaCode;
    }

    public void setInAreaCode(String inAreaCode) {
        this.inAreaCode = inAreaCode;
    }

    public String getFilterPattern() {
        return filterPattern;
    }

    public void setFilterPattern(String filterPattern) {
        this.filterPattern = filterPattern;
    }

    public String getInState() {
        return inState;
    }

    public void setInState(String inState) {
        this.inState = inState;
    }

    public String getInPostalCode() {
        return inPostalCode;
    }

    public void setInPostalCode(String inPostalCode) {
        this.inPostalCode = inPostalCode;
    }

    public boolean isTollFree() {
        return isTollFree;
    }

    public void setTollFree(boolean isTollFree) {
        this.isTollFree = isTollFree;
    }

    public String getInRateCenter() {
        return inRateCenter;
    }

    public void setInRateCenter(String inRateCenter) {
        this.inRateCenter = inRateCenter;
    }

    public String getInLata() {
        return inLata;
    }

    public void setInLata(String inLata) {
        this.inLata = inLata;
    }
}
