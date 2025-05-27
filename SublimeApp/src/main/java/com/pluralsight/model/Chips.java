package com.pluralsight.model;

public class Chips {
    OtherProducts.chipType flavor;

    public Chips(OtherProducts.chipType flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
       return 1.50;
    }

    public OtherProducts.chipType getFlavor (){
        return flavor;
    }

    @
}
