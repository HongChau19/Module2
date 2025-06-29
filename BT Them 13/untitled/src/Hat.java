public class Hat implements Product {
    private String name;
    private double price;
    private String color;
    private String style;

    public Hat(String name, double price, String color, String style) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.style = style;
    }

    @Override
    public void displayInfo() {
        System.out.println("Mũ: " + name + ", Giá: " + price + " VND, Màu sắc: " + color + ", Kiểu dáng: " + style);
    }
}