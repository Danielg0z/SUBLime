package com.pluralsight.model;

//Customers can order 3 sizes of sandwiches(4", 8", 12")
public enum SandwichSize {
    //All Enums should be uppercase
    FOUR_INCH("4\"", 5.50, 1.00, 0.50, 0.75, 0.30),
    EIGHT_INCH("8\"", 7.00, 2.00, 1.00, 1.50, 0.60),
    TWELVE_INCH("12\"", 8.50, 3.00, 1.50, 2.25, 0.90),
    ;

    private final String label;           // How the size should look when shown to the customer, like "4\""
    private final double basePrice;       // How much the sandwich costs with just the bread
    private final double meatPrice;       // How much it costs to add meat
    private final double extraMeatPrice; // How much extra it costs if you want more meat
    private final double cheesePrice; // How much it costs to add cheese
    private final double extraCheesePrice; // How much extra it costs if you want more cheese

    SandwichSize(String label, double basePrice, double meatPrice, double extraMeatPrice, double cheesePrice, double extraCheesePrice) {
        this.label = label;
        this.basePrice = basePrice;
        this.meatPrice = meatPrice;
        this.extraMeatPrice = extraMeatPrice;
        this.cheesePrice = cheesePrice;
        this.extraCheesePrice = extraCheesePrice;
    }

    public String getLabel() {
        return this.label;
    }

    public double getBasePrice() {
        return this.basePrice; // price of a sandwich that was only bread
    }

    public double getMeatPrice() {
        return this.meatPrice; // How much meat cost
    }

    public double getExtraMeatPrice() {
        return this.extraMeatPrice; // how much more if you wanted extra meat
    }

    public double getCheesePrice() {
        return this.cheesePrice; // How much cheese costs
    }

    public double getExtraCheesePrice() {
        return this.extraCheesePrice; // how much more if you wanted extra cheese
    }

    @Override
    public String toString() {
        return this.label + " Sandwich";
    }
}
