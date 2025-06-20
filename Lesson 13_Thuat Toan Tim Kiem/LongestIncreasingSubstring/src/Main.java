import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập vào một chuỗi bất kỳ: ");
            String inputString = scanner.nextLine();

            String resultSubstring = LongestIncreasingSubstring.findLongestIncreasingSubstring(inputString);
            System.out.println("Chuỗi tăng dần lớn nhất là: " + resultSubstring);

            scanner.close();
    }
}