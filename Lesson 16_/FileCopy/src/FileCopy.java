import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            // Nhập tên tệp nguồn và tệp đích
            System.out.print("Nhập tên tệp nguồn: ");
            String sourceFileName = reader.readLine();
            System.out.print("Nhập tên tệp đích: ");
            String destinationFileName = reader.readLine();

            // Kiểm tra nếu tệp nguồn tồn tại
            File sourceFile = new File(sourceFileName);
            if (!sourceFile.exists()) {
                System.out.println("Cảnh báo: Tệp nguồn không tồn tại.");
                return;
            }

            // Kiểm tra nếu tệp đích đã tồn tại
            File destinationFile = new File(destinationFileName);
            if (destinationFile.exists()) {
                System.out.println("Cảnh báo: Tệp đích đã tồn tại.");
                return;
            }

            // Sao chép nội dung từ tệp nguồn sang tệp đích
            FileReader fileReader = new FileReader(sourceFile);
            FileWriter fileWriter = new FileWriter(destinationFile);

            int character;
            int charCount = 0;

            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
                charCount++;
            }

            // Đóng các luồng
            fileReader.close();
            fileWriter.close();

            // Hiển thị số ký tự đã sao chép
            System.out.println("Số ký tự trong tệp: " + charCount);
            System.out.println("Sao chép tệp thành công!");

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
