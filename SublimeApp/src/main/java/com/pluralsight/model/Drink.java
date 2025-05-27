package com.pluralsight.model;

public class Drink {
    private OtherProducts.drinkSize size;

    public Drink(OtherProducts.drinkSize size) {
        this.size = size;
    }

    public double getPrice() {
        return size.getPrice();
    }

    public OtherProducts.drinkSize getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return size.toString();
    }

}
