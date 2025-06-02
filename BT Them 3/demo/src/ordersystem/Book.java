package ordersystem;

public class Book extends Product {
    double weight;
    double discount;

    public Book(String name, double originalPrice, double discount) {
        super(name, originalPrice);
        this.discount = originalPrice - discount;
    }
}
