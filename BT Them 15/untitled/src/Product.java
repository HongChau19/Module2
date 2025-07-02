public class Product {
    private String id;
    private String Name;
    private double Price;

    public Product(String id, String Name, double price) {
        this.id = id;
        this.Name = Name;
        this.Price = price;
    }

    public String getName(){
        return Name;
    }
    public double getPrice(){
        return Price;
    }
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setPrice(double price){
        this.Price = price;
    }

    @Override
    public String toString(){
        return "id: " + id + "\nName: " + Name + "\nPrice: " + Price;
    }

}
