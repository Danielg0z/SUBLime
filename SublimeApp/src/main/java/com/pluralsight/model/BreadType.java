package com.pluralsight.model;
//customers choose the type of bread… white, wheat, rye, wrap
public enum BreadType {
    //All Enums should be uppercase
    WHITE,
    WHEAT,
    RYE,
    WRAP;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

}
