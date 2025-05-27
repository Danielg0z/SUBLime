package com.pluralsight.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sandwich {

    private SandwichSize size;
    private BreadType bread;
    private boolean isToasted;
    private Map<MeatType, Integer> meatMap = new HashMap<>();
    private Map<CheeseType, Integer> cheeseMap = new HashMap<>();
    private List<regToppings> toppings;
    private List<SauceTypes> sauces;
    private List<sideTypes> sides;

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

    //getter and setter for isToasted
    public boolean isToasted() {
        return this.isToasted;
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }

    //customers choose the type of bread… white, wheat, rye, wrap
    //No price for Bread type(Included)
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

    //Meats is a premium topping(handles price)
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

        @Override
        public String toString () {
                 return name().charAt(0) + name().substring(1).toLowerCase();
            }
    }


    //No Prices for Toppings(Included)
    public enum regToppings {
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

    //No Prices for Sauce(Included)
    public enum SauceTypes {
        //All Enums should be uppercase
        MAYO,
        MUSTARD,
        KETCHUP,
        RANCH,
        THOUSAND_ISLAND,
        VINAIGRETTE;



        public String toString() {

             return name().charAt(0) + name().substring(1).toLowerCase();
        }
    }

    //No Prices for Sides(Included)
    public enum sideTypes {
        //All Enums should be uppercase
        AU_JUS,
        SAUCE;

        @Override
        public String toString() {
            return name().toLowerCase().replace("_", " ");
        }
    }

    //Methods for indecisive or picky customers
    //Accounts for a customers desire to swap, add, and/or remove meat, cheese, toppings, and/or sauces
    public void changeMeat(MeatType from, MeatType to){
        int count = meatMap.getOrDefault(from, 0);
        if(count > 0){
            meatMap.remove(from);
            meatMap.put(to, meatMap.getOrDefault(to, 0) + count);
        }
    }

    public void addMeat(MeatType meat){
        // get current count (or 0) then add 1
        int current = meatMap.getOrDefault(meat,0);
        meatMap.put(meat, current + 1);
    }

    public void removeMeat(MeatType meat){
        if (meatMap.containsKey(meat)){
            meatMap.remove(meat);
        }
    }


    public void changeCheese(CheeseType from, CheeseType to){
        int count = cheeseMap.getOrDefault(from, 0);
        if(count > 0){
            cheeseMap.remove(from);
            cheeseMap.put(to, cheeseMap.getOrDefault(to, 0) + count);
        }
    }

    public void addCheese(CheeseType cheese){
        // get current count (or 0) then add 1
        int current = cheeseMap.getOrDefault(cheese,0);
        cheeseMap.put(cheese, current + 1);
    }

    public void removeCheese(CheeseType cheese){
        if (cheeseMap.containsKey(cheese)){
            cheeseMap.remove(cheese);
        }
    }

    public void changeTopping(regToppings from, regToppings to){
        if(toppings.contains(from)){
            toppings.remove(from);
            toppings.add(to);
        }
    }

    public void addTopping(regToppings topping) {
        if(!toppings.contains(topping)){
            toppings.add(topping);
        }
    }

    public void removeTopping(regToppings topping) {
        toppings.remove(topping);
    }

    public void changeSauce(SauceTypes from, SauceTypes to){
        if(sauces.contains(from)){
            sauces.remove(from);
            sauces.add(to);
        }
    }

    public void addSauce(SauceTypes sauce) {
        if(!sauces.contains(sauce)){
            sauces.add(sauce);
        }
    }

    public void removeSauce(SauceTypes sauce) {
        sauces.remove(sauce);
    }

    //Calculate the total price
    public double calculatePrice(){
        double total = 0;

        for(Map.Entry<MeatType, Integer> entry : meatMap.entrySet()){
            MeatType meat = entry.getKey();
            int count = entry.getValue();

            if(count > 0){
                total += meat.getPrice(size); // regular
                total += (count - 1) * size.getMeatPrice();// extra meat

            }
        }

        for(Map.Entry<CheeseType, Integer> entry : cheeseMap.entrySet()){
            CheeseType cheese = entry.getKey();
            int count = entry.getValue();

            total += cheese.getPrice(size); ///assuming each entry in the cheese list is a single portion has
            total += (count - 1) * size.getExtraCheesePrice(); // extra cheese
        }

        //Everything else is included, or doesn't have a pricing to accumulate

        return total;
    }

}
