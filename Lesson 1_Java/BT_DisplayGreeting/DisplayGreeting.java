import java.util.Scanner;

public class DisplayGreeting {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sr.nextLine();
        System.out.println("Hello " + name);
    }
}
