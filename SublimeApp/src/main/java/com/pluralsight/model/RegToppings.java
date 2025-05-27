package com.pluralsight.model;

//No Prices for Toppings(Included)
public enum RegToppings {
    //All Enums should be uppercase
    LETTUCE,
    PEPPERS,
    ONIONS,
    TOMATOES,
    JALAPENOS,
    CUCUMBERS,
    PICKLES,
    GUACAMOLE,
    MUSHROOMS;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
