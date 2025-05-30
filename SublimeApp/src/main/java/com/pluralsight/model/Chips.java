package com.pluralsight.model;

public class Chips {
    OtherProducts.chipType flavor;
    private double price;

    public Chips(OtherProducts.chipType flavor) {
        this.flavor = flavor;
        this.price = OtherProducts.CHIP_PRICE;
    }

    public double getPrice() {
       return 1.50;
    }

    public OtherProducts.chipType getFlavor (){
        return this.flavor;
    }

    @Override
    public String toString() {
        return flavor.toString();
    }    
}
