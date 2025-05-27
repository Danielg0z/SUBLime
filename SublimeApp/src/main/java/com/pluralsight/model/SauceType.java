package com.pluralsight.model;

//No Prices for Sauce(Included)
public enum SauceType {
    //All Enums should be uppercase
    MAYO,
    MUSTARD,
    KETCHUP,
    RANCH,
    THOUSAND_ISLAND,
    VINAIGRETTE;

    public String toString() {

        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
