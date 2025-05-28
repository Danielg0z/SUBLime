package com.pluralsight.model;

public class ReceiptManager {

    public void saveReceipt(Order order){
        String fileName = "receipt" + order.getOrderID() + "_" + order.getCustomerName().replaceAll("\\s+", "_") + ".txt";
        String directory = "src/main/resources/receipts/";
    }
}
