import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("www.google.com");
        Scanner scanner = new Scanner(System.in);
        int choice;

        browser.visit("facebook.com");
        browser.visit("youtube.com");
        browser.visit("netflix.com");

        do {
            System.out.println("\n--- Trình duyệt lịch sử ---");
            System.out.println("1. Truy cập trang mới");
            System.out.println("2. Quay lại trang trước");
            System.out.println("3. Tiến tới trang đã quay lại");
            System.out.println("4. Hiển thị trang hiện tại");
            System.out.println("5. Thoát");
            System.out.print("Chọn một tùy chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập URL trang mới: ");
                    String url = scanner.nextLine();
                    browser.visit(url);
                    break;
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.forward();
                    break;
                case 4:
                    System.out.println("Trang hiện tại: " + browser.getCurrentPage());
                    break;
                case 5:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);

        scanner.close();
    }
}