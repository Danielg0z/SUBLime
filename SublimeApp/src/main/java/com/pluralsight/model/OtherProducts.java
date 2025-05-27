package com.pluralsight.model;

public class OtherProducts {
    private drinkSize size;
    private static final double CHIP_PRICE = 1.50;// chips are a final cause they only have one value

    public enum drinkSize {

        //All Enums should be uppercase
        SMALL("Small $", 2.00),
        MEDIUM("Medium $", 2.50),
        LARGE("Large $", 3.00);


        private final String label;
        private final double price;


        // this controls everything else
        drinkSize(String label, double price) {
            this.label = label;
            this.price = price;
        }

        public String getLabel() {
            return this.label;
        }

        public double getPrice() {
            return this.price;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public enum chipType {
        BBQ,
        KETTLE_COOKED,
        NACHO_CHEESE,
        SEA_SALT,
        SOUR_CREAM;

        @Override
        public String toString() {
            return name().toLowerCase().replace("_", " ");
        }


    }
}


