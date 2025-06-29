import java.util.Scanner; // Import lớp Scanner để đọc input
import java.util.ArrayList; // Để lưu trữ các sản phẩm đã tạo

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> createdProducts = new ArrayList<>();

        System.out.println("===== Bắt đầu chương trình Quản lý sản phẩm =====");

        System.out.println("\n--- Bước 1: Khởi tạo và truy cập AppConfig ---");
        AppConfig config1 = AppConfig.getInstance("Cửa hàng ABC", "vi", "VND", 0.10);
        config1.displayConfig();

        System.out.println("\n--- Bước 2: Tạo sản phẩm bằng cách nhập từ bàn phím ---");

        String continueChoice = "y";
        while (continueChoice.equalsIgnoreCase("y")) {
            System.out.println("\nNhập loại sản phẩm bạn muốn tạo (shirt, shoe, hat):");
            String productType = scanner.nextLine().toLowerCase();

            System.out.println("Nhập tên sản phẩm:");
            String name = scanner.nextLine();

            System.out.println("Nhập giá sản phẩm:");
            double price = 0.0;
            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Lỗi: Giá không hợp lệ. Vui lòng nhập một số. Bỏ qua sản phẩm này.");
                continue;
            }

            try {
                Product newProduct = null;
                switch (productType) {
                    case "shirt":
                        System.out.println("Nhập size áo (S, M, L, XL):");
                        String size = scanner.nextLine();
                        System.out.println("Nhập chất liệu áo:");
                        String material = scanner.nextLine();
                        newProduct = ProductFactory.createProduct("shirt", name, price, size, material);
                        break;
                    case "shoe":
                        System.out.println("Nhập thương hiệu giày:");
                        String brand = scanner.nextLine();
                        System.out.println("Nhập size giày EU (ví dụ: 41, 42):");
                        String sizeEUStr = scanner.nextLine();
                        newProduct = ProductFactory.createProduct("shoe", name, price, brand, sizeEUStr);
                        break;
                    case "hat":
                        System.out.println("Nhập màu sắc mũ:");
                        String color = scanner.nextLine();
                        System.out.println("Nhập kiểu dáng mũ:");
                        String style = scanner.nextLine();
                        newProduct = ProductFactory.createProduct("hat", name, price, color, style);
                        break;
                    default:
                        System.err.println("Loại sản phẩm không hợp lệ: " + productType + ". Vui lòng thử lại.");
                        continue; // Quay lại đầu vòng lặp để nhập lại loại sản phẩm
                }

                if (newProduct != null) {
                    System.out.println("Đã tạo sản phẩm thành công:");
                    newProduct.displayInfo();
                    createdProducts.add(newProduct); // Thêm sản phẩm vào danh sách
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Lỗi khi tạo sản phẩm: " + e.getMessage());
            }

            System.out.println("\nBạn có muốn tạo thêm sản phẩm khác không? (y/n)");
            continueChoice = scanner.nextLine();
        }

        // 3. Hiển thị thông tin tất cả sản phẩm đã tạo
        System.out.println("\n--- Bước 3: Hiển thị tất cả sản phẩm đã tạo ---");
        if (createdProducts.isEmpty()) {
            System.out.println("Chưa có sản phẩm nào được tạo.");
        } else {
            for (int i = 0; i < createdProducts.size(); i++) {
                System.out.print((i + 1) + ". ");
                createdProducts.get(i).displayInfo();
            }
        }

        scanner.close(); // Đóng Scanner khi không còn sử dụng
        System.out.println("\n===== Chương trình kết thúc =====");
    }
}