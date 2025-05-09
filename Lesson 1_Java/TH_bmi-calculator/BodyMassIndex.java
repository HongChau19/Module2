import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double weight, height, bmi;
    System.out.print("Cân nặng của bạn (tính bằng kilogram):");

    weight = scanner.nextDouble();

    System.out.print("Chiều cao của bạn (tính bằng mét):");

    height = scanner.nextDouble();

    bmi = weight / Math.pow(height, 2);

    System.out.printf("%-20s%s", "bmi", "Diễn giải\n");

        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Thiếu cân");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Bình thường");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Thừa cân");
        else
                System.out.printf("%-20.2f%s", bmi, "Obese");
    }
    }