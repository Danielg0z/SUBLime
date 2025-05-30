package com.pluralsight.UserInterface;

import com.pluralsight.model.*;

import java.util.Scanner;

public class UserInterface {

    private static Order order;

    private UserInterface() {}

    public static void display(){
        Scanner scanner = new Scanner(System.in);
        boolean menuRunning = true;

        while (menuRunning){
            System.out.println("       (::::::::::::::::::::::)");
            System.out.println("      ^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("      (🥪SUBLime🍈 Sandwich Shop!)");
            System.out.println("      ############################");
            System.out.println("       (::::::::::::::::::::::)");

            System.out.println("1) - Start New Order");
            System.out.println("0) - Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt(); // stores option

            switch (option){
                case 1:
                    //start a New order
                    order =  new Order();
                    break;
                case 0:
                    //exit
                    System.out.println("Goodbye, Have a SUBLime Day!");
                default:
                    System.out.println("Invalid option. Please try again");

            }

        }

    }


    public static void addSandwich(Order order, Scanner scanner) {
        Sandwich sandwich = new Sandwich();

        //1. Select the Bread
        System.out.println("Select your bread:");
        //loops through all the types of bread in bread type
        //and get the all the values of the bread types(ex: RYE)
        for (int i = 0; i < BreadType.values().length; i++) {
            // for eaach bread type, print 1) Rye
            System.out.println((i + 1) + ") " + BreadType.values()[i]);
        }

        int breadPick = scanner.nextInt();

        // takes selected number and access the Bread assigned to it
        BreadType selectBread = BreadType.values()[breadPick - 1];
        // saves choice into the sandwich they're building
        sandwich.setBread(selectBread);

        //2. Select the Size
        System.out.println("Select your sandwich size:");
        for (int i = 0; i < SandwichSize.values().length; i++) {
            System.out.println((i + 1) + ") " + SandwichSize.values()[i]);
        }
        int sizePick = scanner.nextInt();
        SandwichSize selectSize = SandwichSize.values()[sizePick - 1];
        sandwich.setSize(selectSize);

        // 2. select meats
        System.out.println("Select meats (type 0 to stop):  ");
        while(true){
            //and get the all the values of the bread types(ex: RYE)
            for (int i = 0; i < MeatType.values().length; i++){
                System.out.println((i + 1) + ")" + MeatType.values()[i]);
            }
            int meatPick = scanner.nextInt();
            if(meatPick == 0){
                break;
            }
            sandwich.addMeat(MeatType.values()[meatPick - 1]);
        }

        // 3. select cheese
        System.out.println("Select cheeses (type 0 to stop):  ");
        while(true){
            for (int i = 0; i < CheeseType.values().length; i++){
                System.out.println((i + 1) + ")" + CheeseType.values()[i]);
            }
            int cheesePick = scanner.nextInt();
            if(cheesePick == 0){
                break;
            }
            sandwich.addCheese(CheeseType.values()[cheesePick - 1]);
        }


        // 4. Toppings
        System.out.println("Select your toppings:");
        while(true){
            for (int i = 0; i < RegToppings.values().length; i++){
                System.out.println((i + 1) + ")" + RegToppings.values()[i]);
            }
            int toppingPick = scanner.nextInt();
            if(toppingPick == 0){
                break;
            }
            sandwich.addTopping(RegToppings.values()[toppingPick - 1]);
        }

        // 5. Sauces
        System.out.println("Select your Sauces:");
        while(true){
            for (int i = 0; i < SauceType.values().length; i++){
                System.out.println((i + 1) + ")" + SauceType.values()[i]);
            }
            int saucePick = scanner.nextInt();
            if(saucePick == 0){
                break;
            }
            sandwich.addSauce(SauceType.values()[saucePick - 1]);
        }

        System.out.println("Would you like it Toasted? (y/n): ");
        String toasted = scanner.next();
        sandwich.setToasted(toasted.equalsIgnoreCase("y"));

        //add sandwich to order
        order.addSandwich(sandwich);
        System.out.println("Sandwich added to order.");

    }

    public static void addDrink(Order order, Scanner scanner){

        System.out.println("Select a Drink size: ");
        OtherProducts.drinkSize[] sizes = OtherProducts.drinkSize.values();
        for(int i = 0; i < sizes.length; i++) {
            System.out.println((i + 1) + ")" + sizes[i].getLabel() + " - $" + sizes[i].getPrice());
        }

        int drinkPick = scanner.nextInt();
        //Map ot Enum
        OtherProducts.drinkSize selectedSize = sizes[drinkPick - 1];

        //4. Create and Add drink to order
        Drink drink = new Drink(selectedSize);
        order.addDrink(drink);

        System.out.println("Drink added: " + selectedSize.getLabel());
    }

    public static void addChip(Order order, Scanner scanner){

        System.out.println("Select a Chip: ");
        OtherProducts.chipType[] flavors = OtherProducts.chipType.values();
        for(int i = 0; i < flavors.length; i++) {
            System.out.println((i + 1) + ")" + flavors[i]);
        }

        int chipPick = scanner.nextInt();
        scanner.nextLine(); // eat line

        //Map ot Enum
        OtherProducts.chipType selectedFlavor = flavors[chipPick - 1];

        Chips chips = new Chips(selectedFlavor);
        order.addChips(chips);

        System.out.println("Chips added: " + selectedFlavor);

    }

    public static void checkout(Order order, Scanner scanner){
        System.out.println("\n Checkout");

        //Show current order
        System.out.println(order);

        //2. Ask customer for there name
        System.out.println("Can I please get a name for the order:");
        String name = scanner.nextLine();
        order.setCustomerName(name);

        //confirm order
        System.out.println("Would you like to confirm your order? (y/n): ");
        String confirmOrder = scanner.nextLine();
        if(confirmOrder.equalsIgnoreCase("y")){
            ReceiptManager rm = new ReceiptManager();

            rm.saveReceipt(order);

            System.out.println("Thank you" + name + "| has been placed!");
        } else{
            System.out.println("Order Cancelled");
        }
    }

    private static void orderMenuHandler(Scanner scanner, Order order) {
        boolean ordering = true;

        while(ordering){
            System.out.println("\n--- Order Menu ---");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("5) Cancel Order");
            System.out.print("Choose an option: ");

            int subOption = scanner.nextInt();
            scanner.nextLine();

            switch (subOption) {
                case 1:
                    addSandwich(order, scanner);
                case 2:
                    addDrink(order, scanner);
                case 3:
                    addDrink(order, scanner);
                case 4:
                    addChip(order, scanner);
                case 5:
                    System.out.println("Order cancelled");
                    ordering = false;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }



}
