import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double VND =23000;
        double USD;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập số tiền: ");
        USD = scanner.nextDouble();
        double quydoi = USD * 23000;
        System.out.println("Giá trị VND: " + quydoi);
    }
}
