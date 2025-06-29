// Shoe.java
public class Shoe implements Product {
    private String name;
    private double price;
    private String brand;
    private int size;

    public Shoe(String name, double price, String brand, int sizeEU) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.size = sizeEU;
    }

    @Override
    public void displayInfo() {
        System.out.println("Giày: " + name + ", Giá: " + price + " VND, Thương hiệu: " + brand + ", Size : " + size);
    }
}