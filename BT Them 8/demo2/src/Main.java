import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String inputString = scanner.nextLine();

        if (IncreasingSubStringChecker.isIncreasingSubString(inputString)) {
            System.out.println("Chuỗi là chuỗi con tăng dần liên tiếp.");
        } else {
            System.out.println("Chuỗi không phải là chuỗi con tăng dần liên tiếp.");
        }
        scanner.close(); // Đóng Scanner
    }
}