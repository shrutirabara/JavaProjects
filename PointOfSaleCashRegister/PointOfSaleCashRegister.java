package pointofsalecashregister;

import java.util.ArrayList;

/*
 * Author: Shruti Rabara
 * Date: 10/11/19
 * Course: ITSC 1213 Intro to Computer Science II
 * Description: Simulation of a Point of Sale cash register. When the 
program is finished, item information (such as name and cost) is created, accept 
any number of items for someone to buy, add up the total cost of a transaction, ask the user for 
payment information, and then prints out a receipt. 

This is the Main class. It contains the main method which contains a set of Item 
objects and a Transaction object. Then, it calls the takePayment method with the Transaction object. 
 */

public class PointOfSaleCashRegister {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Apple", 0.5));
        items.add(new Item("Pear", 0.75));
        items.add(new Item("Pineapple", 0.75));

        Transaction transaction = new Transaction(items);
        transaction.takePayment();
        Receipt receipt = new Receipt(transaction);
        System.out.println(receipt.getReceiptString());

    }

}
