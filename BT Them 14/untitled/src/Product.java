public class Product {
    private String Id;
    private String name;
    private double price;
    private String description;

    public Product(String id, String name, double price, String description) {
        this.Id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        Id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [ID=" + Id + ", name=" + name + ", price=" + price + ", description=" + description + "]";
    }

}
