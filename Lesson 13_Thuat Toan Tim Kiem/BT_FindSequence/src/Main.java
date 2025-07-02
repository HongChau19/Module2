import java.util.Scanner;

public class Main {

    public static String findSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String chuoiDaiNhat = "";
        StringBuilder chuoiHienTai = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (chuoiHienTai.length() == 0 || currentChar >= chuoiHienTai.charAt(chuoiHienTai.length() - 1)) {
                chuoiHienTai.append(currentChar);
            } else {
                if (chuoiHienTai.length() > chuoiDaiNhat.length()) {
                    chuoiDaiNhat = chuoiHienTai.toString();
                }
                chuoiHienTai = new StringBuilder();
                chuoiHienTai.append(currentChar);
            }
        }

        // Kiểm tra lần cuối sau khi vòng lặp kết thúc
        if (chuoiHienTai.length() > chuoiDaiNhat.length()) {
            chuoiDaiNhat = chuoiHienTai.toString();
        }

        return chuoiDaiNhat;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        String result = findSubstring(userInput);
        System.out.println(result);

        scanner.close();
    }
}