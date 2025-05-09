import java.util.Scanner;

public class LinerEquationResolver {
    public static void main(String[] args) {
        System.out.println("Liner Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constanst:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");
        double c = scanner.nextDouble();
    }
}
