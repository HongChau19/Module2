import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManage {
    private static final String FILE_NAME = "products.txt";

    public List<Product> readProductsFromFile() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        String id = parts[0].trim();
                        String name = parts[1].trim();
                        double price = Double.parseDouble(parts[2].trim());
                        products.add(new Product(id, name, price));
                    } catch (NumberFormatException e) {
                        System.err.println("Cảnh báo: Bỏ qua dòng lỗi định dạng giá trong file: " + line);
                    }
                } else {
                    System.err.println("Cảnh báo: Bỏ qua dòng lỗi định dạng (không đủ 3 phần) trong file: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File products.txt không tìm thấy. Sẽ tạo mới khi ghi dữ liệu.");
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file products.txt: " + e.getMessage());
        }
        return products;
    }

    public void writeProductsToFile(List<Product> products) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product product : products) {
                writer.write(product.toString());
                writer.newLine();
            }
            System.out.println("Cập nhật file " + FILE_NAME + " thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi vào file products.txt: " + e.getMessage());
        }
    }

    /**
     * Thêm một sản phẩm mới vào danh sách và cập nhật file.
     *
     * @param newProduct Sản phẩm mới cần thêm.
     */
    public void addProduct(Product newProduct) {
        List<Product> products = readProductsFromFile();
        boolean idExists = products.stream()
                .anyMatch(p -> p.getId().equalsIgnoreCase(newProduct.getId()));
        if (idExists) {
            System.out.println("Lỗi: Mã sản phẩm '" + newProduct.getId() + "' đã tồn tại. Không thể thêm.");
            return;
        }
        products.add(newProduct);
        writeProductsToFile(products);
        System.out.println("Đã thêm sản phẩm: " + newProduct.getName());
    }

    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
        System.out.printf("%-10s %-25s %-15s\n", "Mã SP", "Tên Sản Phẩm", "Giá Bán");
        System.out.println("--------------------------------------------------");
        for (Product product : products) {
            System.out.printf("%-10s %-25s %-15.0f\n", product.getId(), product.getName(), product.getPrice());
        }
        System.out.println("--------------------------------------------------\n");
    }

        public void displayProductsExpensive(List<Product> products) {
        List<Product> expensiveProducts = products.stream()
                .filter(p -> p.getPrice() >= 200000)
                .collect(Collectors.toList());
        if (expensiveProducts.isEmpty()) {
            System.out.println("Không có sản phẩm nào có giá từ 200.000 trở lên.");
        } else {
            System.out.println("\n--- SẢN PHẨM CÓ GIÁ TỪ 200.000 TRỞ LÊN ---");
            displayProducts(expensiveProducts); // Tái sử dụng phương thức hiển thị chung
        }
    }

    public boolean updateProductPrice(String productId, double newPrice) {
        List<Product> products = readProductsFromFile();
        boolean found = false;
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(productId)) {
                product.setPrice(newPrice);
                found = true;
                break;
            }
        }
        if (found) {
            writeProductsToFile(products); // Ghi lại danh sách đã cập nhật
            System.out.println("Đã cập nhật giá sản phẩm '" + productId + "' thành " + newPrice);
        } else {
            System.out.println("Không tìm thấy sản phẩm với mã: " + productId);
        }
        return found;
    }
}