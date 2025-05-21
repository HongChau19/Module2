public class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

    class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("A", 9.0),
                new Student("B", 7.5),
                new Student("C", 4.5),
                new Student("D", 8.5),
                new Student("E", 6.0),
                new Student("F", 8.2),
                new Student("G", 5.5),
                new Student("H", 3.0),
                new Student("I", 7.0),
                new Student("J", 9.5)
        };

        System.out.println("\nDanh sách học sinh có điểm > 8.0:");
        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student.getGrade() > 8.0) {
                System.out.println(student.getName() + " - Điểm: " + student.getGrade());
            }
        }

        //Xét kết quả
        int Yeu = 0;
        int Tbinh = 0;
        int Gioi = 0;

        for (int i = 0; i < students.length; i++) {
            Student student = students[i];
            if (student.getGrade() < 5) {
                Yeu++;
            } else if (student.getGrade() >= 5 && student.getGrade() <= 7) {
                Tbinh++;
            } else {
                Gioi++;
            }
        }
        // Kết quả
        System.out.println("\nKết quả:");
        System.out.println("Yếu: " + Yeu + " sinh viên;");
        System.out.println("Trung bình: " + Tbinh + " sinh viên;");
        System.out.println("Khá/Giỏi: " + Gioi + " sinh viên;");
    }
}


