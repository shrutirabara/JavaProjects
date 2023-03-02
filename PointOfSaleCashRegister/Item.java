package pointofsalecashregister;

/*
 * Description: This class represents an item at a store. Each item will have a name and price. 
 */

public class Item {
    public String name;
    public double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }

}
