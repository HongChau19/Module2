import java.util.Scanner;

public class ConvertTemperature {
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double farhenheit;
        double celsius;
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Farhenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter fahrenheit: ");
                    farhenheit = in.nextDouble();
                    System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius(farhenheit));
                    break;
                }
                case 2:{
                    System.out.println("Enter Celsius: ");
                    celsius = in.nextDouble();
                    System.out.println("Celsius to Fahrenheit: " + celsiusToFahrenheit(celsius));
                    break;
                }
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}
