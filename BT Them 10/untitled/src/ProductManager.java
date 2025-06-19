import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static final String TEXT_FILE = "products.txt";
    private static final String BINARY_FILE = "products.dat";
    private List<Product> productList;
    private Scanner scanner;

    public ProductManager() {
        productList = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadProductsFromBinaryFile();
        if (productList.isEmpty()) {
            loadProductsFromTextFile();
        }
    }

    private void loadProductsFromTextFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(TEXT_FILE))){
            String line;
            while (line = br.readLine()) != null){
            String[] parts = line.split(" , ");
                if (parts.length == 3){
                    try{
                        String id = parts[0];
                        String name = parts[1];
                        double price = Double.parseDouble(parts[2]);
                        productList.add(new Product(id, name, price));
                    } catch (NumberFormatException e){
                        System.err.println("Lỗi định dạng giá trị trong text: " + line);
                    }
                }
            }
        }
        System.out.println("Đã đọc danh sách sản phẩm từ" + TEXT_FILE);
        } catch (IOException e) {
        System.err.println("Không tìm thấy file" + TEXT_FILE);
        }

    private void saveProductsToBinaryFile() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BINARY_FILE))) {
        oos.writeObject(productList);
        System.out.println("Đã ghi danh sách sản phẩm vào " + BINARY_FILE);
    } catch (IOException e) {
        System.err.println("Lỗi khi ghi file nhị phân: " + e.getMessage());
    }
    }

    private void loadProductsFromBinaryFile() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BINARY_FILE))) {
        productList = (List<Product>) ois.readObject();
        System.out.println("Đã đọc danh sách sản phẩm từ " + BINARY_FILE);
    } catch (FileNotFoundException e) {
        System.err.println("Không tìm thấy file " + BINARY_FILE + ". Sẽ thử đọc từ file text.");
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("Lỗi khi đọc file nhị phân: " + e.getMessage());
    }
    }

    private void updateAllFiles() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEXT_FILE))) {
        for (Product p : productList) {
            bw.write(p.toString());
            bw.newLine();
        }
        System.out.println("Đã cập nhật file " + TEXT_FILE);
    } catch (IOException e) {
        System.err.println("Lỗi khi ghi file văn bản: " + e.getMessage());
    }
    saveProductsToBinaryFile();
    }

    public void addProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        // Kiểm tra trùng ID
        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println("Mã sản phẩm đã tồn tại. Vui lòng nhập mã khác.");
                return;
            }
        }
    }
}

