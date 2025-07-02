import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class FileCopier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập đường dẫn tập tin nguồn: ");
        String sourceFilePath = scanner.nextLine();

        System.out.print("Nhập đường dẫn tập tin đích: ");
        String targetFilePath = scanner.nextLine();

        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);

        // Kiểm tra tập tin nguồn tồn tại
        if (!sourceFile.exists()) {
            System.err.println("Lỗi: Tập tin nguồn không tồn tại.");
            return; // Kết thúc chương trình
        }

        // Kiểm tra tập tin đích đã tồn tại
        if (targetFile.exists()) {
            System.err.println("Cảnh báo: Tập tin đích đã tồn tại. Chương trình sẽ ghi đè lên tập tin này.");
            // Bạn có thể thêm lựa chọn hỏi người dùng có muốn ghi đè hay không tại đây
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024]; // Đọc từng khối 1KB
            int bytesRead;
            long totalBytesCopied = 0;

            System.out.println("Đang sao chép tập tin...");

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytesCopied += bytesRead;
            }

            System.out.println("Sao chép hoàn tất!");
            System.out.println("Số byte đã sao chép: " + totalBytesCopied + " bytes.");

        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi trong quá trình sao chép: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}