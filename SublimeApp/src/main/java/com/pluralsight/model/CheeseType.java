package com.pluralsight.model;

//Cheese is a premium topping(handles price)
public enum CheeseType {
    //each cheese and their per sandwich size
    AMERICAN(0.75, 1.50, 2.25),
    PROVOLONE(0.75, 1.50, 2.25),
    CHEDDAR(0.75, 1.50, 2.25),
    SWISS(0.75, 1.50, 2.25);

    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;

    CheeseType(double price4Inch, double price8Inch, double price12Inch) {
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;
    }

    public double getPrice(SandwichSize size) {
        // enhanced switch using lambdas
        return switch (size) {
            case FOUR_INCH -> price4Inch;
            case EIGHT_INCH -> price8Inch;
            case TWELVE_INCH -> price12Inch;
            default -> 0;
        };
    }
}
