public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(){
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}

class TestCircle {
    public static void main(String[] args) {

        // Tạo đối tượng Circle với hàm tạo không tham số
        Circle circle1 = new Circle();
        System.out.println("Circle 1:");
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea());
        System.out.println("---");

        // Tạo đối tượng Circle với hàm tạo có tham số radius
        Circle circle2 = new Circle(5.0);
        System.out.println("Circle 2:");
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea());
    }
}