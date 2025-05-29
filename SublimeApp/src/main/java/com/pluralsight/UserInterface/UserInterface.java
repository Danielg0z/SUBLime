package com.pluralsight.UserInterface;

import com.pluralsight.model.Order;
import com.pluralsight.model.ReceiptManager;

import java.util.Scanner;

public class UserInterface {

    private static Order order;

    private UserInterface() {}

    public static void display(){
        Scanner scanner = new Scanner(System.in);
        boolean menuRunning = true;

        while (menuRunning){
            System.out.println("(::::::::::::::::::::::)");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("(🥪SUBLime🍈 Sandwich Shop!)");
            System.out.println("##############################");
            System.out.println("(::::::::::::::::::::::)");

            System.out.println("1 - Start New Order");
            System.out.println("2 - Add Sandwich");
            System.out.println("3 - Add Drink");
            System.out.println("4 - Add Chips");
            System.out.println("5 - View Current Order");
            System.out.println("6 - Save and Print Receipt");
            System.out.println("99 - Exit");
            System.out.print("Enter option: ");


        }

    }
}
