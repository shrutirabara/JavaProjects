package pointofsalecashregister;

/*
 * Description: This class holds data about the type of payment that was used and the amount that 
was paid with that type. 
 */

public class Payment {
    public PaymentType type;
    public double amount;

    public Payment(PaymentType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public PaymentType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void setType() {
        this.type = type;
    }

    public void setAmount() {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + ":   " + amount;
    }

}
