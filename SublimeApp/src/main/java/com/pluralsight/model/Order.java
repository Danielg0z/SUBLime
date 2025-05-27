package com.pluralsight.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String name; // nam for the order
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;
    private double totalPrice; //
    private LocalDateTime orderTime; //

    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips, LocalDateTime orderTime) {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    //Methods for adding Sandwiches, Chips and drinks to an order
    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void addChips(Chips chip){
        chips.add(chip);
    }

    //Methods for removing Sandwiches, Chips and drinks to an order
    public void removeSandwich(Sandwich sandwich){
        sandwiches.remove(sandwich);
    }

    public void removeDrink(Drink drink){
        drinks.remove(drink);
    }

    public void removeChips(Chips chip){
        chips.remove(chip);
    }

}
