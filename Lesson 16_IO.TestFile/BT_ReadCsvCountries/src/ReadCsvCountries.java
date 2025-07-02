import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCsvCountries {

    public static void main(String[] args) {
        String csvFilePath = "countries.csv"; // Tên file CSV
        String line;
        String cvsSplitBy = ","; // Dấu phân cách trong CSV

        System.out.println("Danh sách các quốc gia từ file CSV:");
        System.out.println("------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                // Sử dụng split để phân tách các thuộc tính
                // Dùng -1 để đảm bảo các chuỗi rỗng ở cuối cũng được giữ lại nếu có
                String[] countryData = line.split(cvsSplitBy, -1);

                // Loại bỏ dấu nháy kép (") nếu có ở đầu và cuối chuỗi
                String id = countryData[0].trim();
                String code = countryData[1].trim().replace("\"", "");
                String name = countryData[2].trim().replace("\"", "");

                // In thông tin quốc gia
                System.out.println("ID: " + id + ", Code: " + code + ", Name: " + name);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file CSV: " + e.getMessage());
            System.err.println("Hãy đảm bảo file '" + csvFilePath + "' tồn tại và có thể đọc được.");
        }
    }
}