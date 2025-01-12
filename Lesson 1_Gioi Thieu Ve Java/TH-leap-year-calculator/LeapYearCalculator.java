import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;
        System.out.print("Enter the year: ");
        year = scanner.nextInt();
        if(year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.printf("%d is a leap year, year", year);
                } else {
                    System.out.printf("%d is NOT a leap year, year", year);
                }
            } else {
                System.out.printf("%d is a leap year, year", year);
            }
        } else {
            System.out.printf("%d is NOT a leap year, year", year);
        }
    }
}
