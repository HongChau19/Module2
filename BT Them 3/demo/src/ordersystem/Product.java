package ordersystem;

public class Product {
    private String name;
    private double basePrice;

    public Product(String name; double oriPrice) {
        this.name = name;
        this.oriPrice = oriPrice;
    }

    public String getName() {
        return name;
    }

    public double getOriPrice() {
        return oriPrice;
    }

    public abstract double shippingFee();


    public double getFinalPrice() {
        return originalPrice + shippingFee();
    }
}
