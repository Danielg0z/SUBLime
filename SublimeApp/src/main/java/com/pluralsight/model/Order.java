package com.pluralsight.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static int nextID = 1;
    private int orderID;
    private String customerName; // nam for the order
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private double totalPrice; //
    private LocalDateTime orderTime; //

    public Order() {

        this.orderID = nextID++;
        this.customerName = customerName;
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    //Getters
    public int getOrderID() {
        return this.orderID;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    //Methods for adding Sandwiches, Chips and drinks to an order
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    //Methods for removing Sandwiches, Chips and drinks to an order
    public void removeSandwich(Sandwich sandwich) {
        sandwiches.remove(sandwich);
    }

    public void removeDrink(Drink drink) {
        drinks.remove(drink);
    }

    public void removeChips(Chips chip) {
        chips.remove(chip);
    }

    public double calculatePrice() {
        totalPrice = 0; // reset each price

        for (Sandwich sandwich : sandwiches) {
            totalPrice += sandwich.calculatePrice();
        }

        for (Drink drink : drinks) {
            totalPrice += drink.getPrice();
        }

        for (Chips chip : chips) {
            totalPrice += chip.getPrice();
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        //replicates realistic sandwich shop receipts

        StringBuilder sb = new StringBuilder();

        //Store info
        sb.append("     🥪SUBLime🍈 Sandwich Shop!\n");
        sb.append("    828 Bay Harbor Lane\n");
        sb.append("    Dallas, TX 75243\n");
        sb.append("    (123) 456-7890\n");

        sb.append("------------------------------\n");
        //timestamp
        sb.append("Order #: ").append(orderID).append(" | Name: ").append(customerName).append("\n");
        sb.append("Order Time - ").append(orderTime.toString()).append("\n");
        sb.append("------------------------------\n");

          // Items
         // formats ITEM 20 spaces to the Left,
        // quantity 5 spaces to the Right, and Price 8 spaces to the right
        sb.append(String.format("%-20s %5s %8s\n", "ITEM", "QTY", "PRICE"));

         //Loops through each Sandwich. in the list and prints i
        // with a specific description - 8" sandwich on rye with ham"
        for (Sandwich sandwich : sandwiches ) {
            sb.append(String.format("%-20s %5d %8.2f\n", "Sandwich", 1, sandwich.calculatePrice()));
        }

        for (Drink drink : drinks ) {
            sb.append(String.format("%-20s %5d %8.2f\n", drink.getSize().getLabel() + "Drink", 1, drink.getPrice()));
        }

        for (Chips chip : chips ) {
            sb.append(String.format("%-20s %5d %8.2f\n", chip.getFlavor().toString(), 1, chip.getPrice()));
        }

        sb.append("------------------------------\n");

        //Subtotal and tax
        double subtotal = calculatePrice();
        double tax = subtotal * 0.07;
        double total = subtotal + tax;


        sb.append(String.format("%-25s %6.2f\n", "SUBTOTAL", subtotal));
        sb.append(String.format("%-25s %6.2f\n", "SALES TAX", tax));
        sb.append(String.format("%-25s %6.2f\n", "TOTAL", total));

        sb.append("\nCASH     LTCA TENDERED $6.00\n");
        sb.append(String.format("CHANGE DUE              $%.2f\n", 6.00 - total));

        //Footer
        sb.append("\n******** UNDER YUU OWNERSHIP ********\n");
        sb.append("\n******** OPEN 7 DAYS 10AM - 10PM ********\n");

        return sb.toString();
    }

}
