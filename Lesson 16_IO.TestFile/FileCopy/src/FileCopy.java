import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tập tin nguồn (source file): ");
        String sourcePath = scanner.nextLine();

        System.out.print("Nhập đường dẫn tập tin đích (target file): ");
        String targetPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        // --- Kiểm tra tập tin nguồn ---
        if (!sourceFile.exists()) {
            System.err.println("Lỗi: Tập tin nguồn không tồn tại!");
            scanner.close();
            return; // Dừng chương trình
        }
        if (!sourceFile.isFile()) {
            System.err.println("Lỗi: Đường dẫn nguồn không phải là một tập tin!");
            scanner.close();
            return;
        }

        // --- Kiểm tra tập tin đích ---
        if (targetFile.exists()) {
            System.out.print("Cảnh báo: Tập tin đích đã tồn tại. Bạn có muốn ghi đè không? (y/n): ");
            String confirm = scanner.nextLine();
            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("Hủy bỏ thao tác sao chép.");
                scanner.close();
                return; // Dừng chương trình
            }
        }

        // --- Tiến hành sao chép tập tin ---
        long charCount = 0; // Đếm số ký tự/byte
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) { // Đọc từng byte từ file nguồn
                fos.write(byteRead); // Ghi byte đó vào file đích
                charCount++; // Tăng số lượng ký tự/byte đã đọc và ghi
            }
            System.out.println("Sao chép tập tin thành công!");
            System.out.println("Tổng số ký tự (bytes) đã sao chép: " + charCount);

        } catch (IOException e) {
            System.err.println("Lỗi trong quá trình sao chép tập tin: " + e.getMessage());
        } finally {
            scanner.close(); // Đảm bảo đóng Scanner
        }
    }
}