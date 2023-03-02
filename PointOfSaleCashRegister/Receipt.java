package pointofsalecashregister;

/*
 * Description: This class holds information about a transaction to display how much each 
item cost, how the transaction was paid for, etc. 
 */

public class Receipt {
    private final Transaction transaction;

    public Receipt(Transaction t) {
        super();
        this.transaction = t;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getReceiptString() {
        String str = "";
        for (int i = 0; i < transaction.getItems().size(); i++) {
            str += transaction.getItems().get(i).toString() + "\n";

        }
        str += "-------------------\n";
        str += "Subtotal:\t" + transaction.getSubTotal() + "\nTax:\t" + transaction.getTax() + "\nTotal:\t"
                + transaction.getTotal() + "\n";

        for (int j = 0; j < transaction.getPayments().size(); j++) {
            str += transaction.getPayments().get(j).toString() + "\n";
        }

        str += "Change:\t" + transaction.getChange();

        return str;
    }
}
