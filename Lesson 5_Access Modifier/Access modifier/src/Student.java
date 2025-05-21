public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student (){
    }
    public void setName (String name){
        this.name = name;
    }
    public void setClasses(String classes){
        this.classes = classes;
    }
    public String getName() {
        return name;
    }
    public String getClasses() {
        return classes;
    }
}

class Test {
    public static void main(String[] args) {
        Student student1 = new Student();

        System.out.println("Thông tin Student ban đầu:");
        System.out.println("Tên: " + student1.getName());
        System.out.println("Lớp: " + student1.getClasses());

        student1.setName("Alice");
        student1.setClasses("B03");

        System.out.println("Thông tin Student sau khi cập nhật:");
        System.out.println("Tên: " + student1.getName());
        System.out.println("Lớp: " + student1.getClasses());
    }
}