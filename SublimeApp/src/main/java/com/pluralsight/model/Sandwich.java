package com.pluralsight.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sandwich {

    private SandwichSize size;
    private BreadType bread;
    private boolean isToasted;
    private Map<MeatType, Integer> meatMap = new HashMap<>();
    private Map<CheeseType, Integer> cheeseMap = new HashMap<>();
    private List<RegToppings> toppings;
    private List<SauceType> sauces;
    private List<SideTypes> sides;

    public Sandwich() {
        this.toppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public void setBread(BreadType bread) {
        this.bread = bread;
    }

    public void setMeatMap(Map<MeatType, Integer> meatMap) {
        this.meatMap = meatMap;
    }

    public void setCheeseMap(Map<CheeseType, Integer> cheeseMap) {
        this.cheeseMap = cheeseMap;
    }

    public void setToppings(List<RegToppings> toppings) {
        this.toppings = toppings;
    }

    public void setSauces(List<SauceType> sauces) {
        this.sauces = sauces;
    }

    public void setSides(List<SideTypes> sides) {
        this.sides = sides;
    }

    //getter and setter for Toasted
    public boolean isToasted() {
        return this.isToasted;
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
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

    public void changeTopping(RegToppings from, RegToppings to){
        if(toppings.contains(from)){
            toppings.remove(from);
            toppings.add(to);
        }
    }

    public void addTopping(RegToppings topping) {
        if(!toppings.contains(topping)){
            toppings.add(topping);
        }
    }

    public void removeTopping(RegToppings topping) {
        toppings.remove(topping);
    }

    public void changeSauce(SauceType from, SauceType to){
        if(sauces.contains(from)){
            sauces.remove(from);
            sauces.add(to);
        }
    }

    public void addSauce(SauceType sauce) {
        if(!sauces.contains(sauce)){
            sauces.add(sauce);
        }
    }

    public void removeSauce(SauceType sauce) {
        sauces.remove(sauce);
    }

    //Calculate the total price
    public double calculatePrice(){
        double total = 0;

        //Base sandwich price
        total += size.getBasePrice();

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
