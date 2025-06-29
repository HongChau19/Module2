public class Shirt implements Product {
    private String name;
    private double price;
    private String size;
    private String material;

    public Shirt(String name, double price, String size, String material) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.material = material;
    }

    @Override
    public void displayInfo() {
        System.out.println("Áo thun: " + name + ", Giá: " + price + " VND, Size: " + size + ", Chất liệu: " + material);
    }
}