package com.pluralsight.model;

//Meats is a premium topping(handles price)
public enum MeatType {
    //each cheese and their per sandwich size
    STEAK(1.00, 2.00, 3.00),
    HAM(1.00, 2.00, 3.00),
    SALAMI(1.00, 2.00, 3.00),
    ROAST_BEEF(1.00, 2.00, 3.00),
    Chicken(1.00, 2.00, 3.00),
    BACON(1.00, 2.00, 3.00);

    private final double price4Inch;
    private final double price8Inch;
    private final double price12Inch;

    MeatType(double price4Inch, double price8Inch, double price12Inch) {
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;
    }

    public double getPrice(SandwichSize size) {
        switch (size){
            case FOUR_INCH:
                return price4Inch;
            case EIGHT_INCH:
                return price8Inch;
            case TWELVE_INCH:
                return price12Inch;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return name().toLowerCase().replace("_", " ");
    }
}
