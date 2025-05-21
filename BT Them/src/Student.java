    public class Student {
    String name;
    int age;
    double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("Tên: " + this.name + ", Tuổi: " + this.age + ", Điểm: " + this.grade);
    }
}
    class ThucHanh {
        public static void main(String[] args) {
        Student student1 = new Student("Nguyen", 22, 3.5);
        student1.displayInfo();
    }
}
