package com.pluralsight.model;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ReceiptManager {

    public void saveReceipt(Order order) {
        //This makes a folder where we will save the receipt
        String directory = "src/main/java/resources/receipts/";
        new File(directory).mkdirs();

        String fileName = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";

        // this is folder will save the receipt
        File file = new File(directory + fileName);

        //opens the file and to write into it
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter(file))) {
            //writes an order to a file using order's toString
            bufWriter.write(order.toString());
            System.out.println(" Receipt saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }


    }


    //stores all Receipts
    public void saleAllReceipts(List<Order> orders) {
        for (Order order : orders) {
            saveReceipt(order);
        }
    }

    //Helper method for Different Receipt Searches
    private List<String> findReceiptByLineMatch(Predicate<String> condition) {
        List<String> matchingFiles = new ArrayList<>();

        File folder = new File("src/main/resources/receipts/");

        if (!folder.exists()) {
            return matchingFiles; // return an empty list if file doesn't exist
        }

        // takes all .txt files in that folder
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null) {
            return matchingFiles; // return an empty list if file doesn't exist
        }

        //checks for every file in the folder
        for (File file : files) {
            try (BufferedReader bufReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufReader.readLine()) != null) {
                    //checks if current line matches the condition we gave it
                    if (condition.test(line)) {
                        matchingFiles.add(file.getName()); // if they match, remember the file name
                        break; // no need to read the file anymore
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file not found: " + file.getName());
            }
        }
        return matchingFiles;

    }

    public List<String> findDate(LocalDate date) {
        return findReceiptByLineMatch(line -> {
            if (line.startsWith("Order Time - ")) {
                String dateStr = line.replace("Order Time -", "").trim();
                LocalDate lineDate = LocalDateTime.parse(dateStr).toLocalDate();
                return lineDate.equals(date);
            }
            return false;
        });
    }

    public List<String> findByName(String name) {
        return findReceiptByLineMatch(line -> line.contains("Name: ")
                && line.toLowerCase().contains(name.toLowerCase()));
    }

    public List<String> findByOrderID(int id) {
        return findReceiptByLineMatch(line -> line.contains("Order #: ")
                && line.contains(String.valueOf(id)));
    }

}

