package com.pluralsight.model;


//No Prices for Sides(Included)
public enum SideTypes {
    //All Enums should be uppercase
    AU_JUS,
    SAUCE;

    @Override
    public String toString() {
        return name().toLowerCase().replace("_", " ");
    }
}
