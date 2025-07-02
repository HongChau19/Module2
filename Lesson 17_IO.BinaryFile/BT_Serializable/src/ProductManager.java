import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {
    private String filePath;

    public ProductManager(String filePath) {
        this.filePath = filePath;
        // Đảm bảo file tồn tại, nếu không thì tạo mới
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Không thể tạo file: " + filePath + ". Lỗi: " + e.getMessage());
            }
        }
    }

    // Đọc tất cả sản phẩm từ file
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Bỏ qua dòng trống
                    try {
                        products.add(Product.fromCsvLine(line));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Bỏ qua dòng lỗi trong file: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + filePath + ". Lỗi: " + e.getMessage());
        }
        return products;
    }

    // Ghi danh sách sản phẩm vào file (ghi đè toàn bộ file)
    private void saveAllProducts(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) { // false để ghi đè
            for (Product product : products) {
                writer.write(product.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + filePath + ". Lỗi: " + e.getMessage());
        }
    }

    // Thêm một sản phẩm mới vào file
    public void addProduct(Product newProduct) {
        List<Product> products = getAllProducts();
        // Kiểm tra trùng mã sản phẩm
        if (products.stream().anyMatch(p -> p.getId().equalsIgnoreCase(newProduct.getId()))) {
            System.out.println("Sản phẩm với mã ID '" + newProduct.getId() + "' đã tồn tại. Không thể thêm.");
            return;
        }
        products.add(newProduct);
        saveAllProducts(products);
        System.out.println("Đã thêm sản phẩm thành công!");
    }

    // Hiển thị tất cả sản phẩm
    public void displayAllProducts() {
        List<Product> products = getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
        System.out.printf("%-10s %-25s %-15s %-20s %s\n", "ID", "Tên sản phẩm", "Giá", "Hãng sản xuất", "Mô tả");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (Product product : products) {
            System.out.printf("%-10s %-25s %-15.2f %-20s %s\n",
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getManufacturer(),
                    product.getDescription());
        }
        System.out.println("--------------------------------------------------------------------------------------------------");
    }

    // Tìm kiếm sản phẩm theo tên (hoặc một phần tên)
    public List<Product> searchProductByName(String keyword) {
        List<Product> products = getAllProducts();
        String lowerCaseKeyword = keyword.toLowerCase();
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(lowerCaseKeyword))
                .collect(Collectors.toList());
    }
}