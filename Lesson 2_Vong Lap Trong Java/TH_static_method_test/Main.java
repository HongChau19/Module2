public class Main {
    public static void main(String[] args) {
        Student.change();

        Student s1= new Student(12, "John");
        Student s2= new Student(13, "Jane");
        Student s3= new Student(14, "Jane");

        s1.display();
        s2.display();
        s3.display();
    }
}