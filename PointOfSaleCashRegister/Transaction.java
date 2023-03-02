package pointofsalecashregister;

import java.util.Scanner;

import java.util.ArrayList;

/*
 * Description: This class holds an ArrayList of Item objects. It is responsible for 
calculating the amount of money that needs to be paid, accepting money, and generating a 
receipt. 
 */

public class Transaction {

    public ArrayList<Item> items = new ArrayList<Item>();
    public ArrayList<Payment> payments = new ArrayList<Payment>();
    public double tax;
    public double total;
    public double change;
    public double subTotal;

    public Transaction() {
        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Payment> payments = new ArrayList<Payment>();

    }

    public Transaction(ArrayList<Item> items) {
        ArrayList<Payment> payments = new ArrayList<Payment>();
        this.items = items;

    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public double getChange() {
        return change;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void computeSubTotal() {
        // set the sutotal field based on the list of items
        // list of items is a arraylist
        /*
         * subtotal is the price of all the items added
         * tax is the percentage added on *like sales tax*
         * total is the subtotal+tax
         */
        subTotal = 0;
        for (int i = 0; i < items.size(); i++) {
            subTotal += items.get(i).getPrice();

        }

    }

    public double computeTax() {
        double tax = subTotal * .07;
        setTax(tax);
        return tax;

    }

    public double computeTotal() {
        total = subTotal + tax;
        setTotal(total);
        return total;
    }

    public void takePayment() {
        String paymentType = "";
        double paid = 0;
        computeSubTotal();
        computeTax();
        computeTotal();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("item " + (i + 1) + ": " + items.get(i).toString());
        }
        System.out.println("Total: " + getTotal());

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a payment type:");
        System.out.println("1. Cash");
        System.out.println("2. Debit card");
        System.out.println("3. Credit card");
        System.out.println("4. Check");
        int paytype = input.nextInt();

        System.out.println("Enter the amount to pay with this type. ");
        double amt = input.nextDouble();

        do {
            switch (paytype) {
                case 1:
                    paymentType = "CASH";
                    break;
                case 2:
                    paymentType = "DEBIT_CARD";
                    break;
                case 3:
                    paymentType = "CREDIT_CARD";
                    break;
                case 4:
                    paymentType = "CHECK";
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }

            paid += amt;
            payments.add(new Payment(PaymentType.valueOf(paymentType), amt));

        } while (paid < total);

        change = paid - total;

    }

    @Override
    public String toString() {
        return "Transaction{" + "items=" + items + ", payments=" + payments + ", tax=" + tax + ", total=" + total
                + ", change=" + change + ", subTotal=" + subTotal + '}';
    }

}
