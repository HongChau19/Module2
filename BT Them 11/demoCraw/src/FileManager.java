import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public void writeToFile(String fileName, List<String> dataList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String data : dataList) {
                writer.write(data);
                writer.newLine();
            }
            System.out.println("Đã ghi thành công " + dataList.size() + " tiêu đề vào file: " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file " + fileName + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            System.out.println("Đã đọc thành công " + lines.size() + " tiêu đề từ file: " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file " + fileName + ": " + e.getMessage());
            e.printStackTrace();
        }
        return lines;
    }
}