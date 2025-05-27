package com.pluralsight.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String name; // nam for the order
    private List<Sandwich> sandwiches;
    private List<OtherProducts> drinks;
    private double totalPrice; //
    private LocalDateTime orderTime; //


}
