import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "products.txt"; // Tên file để lưu dữ liệu
    private static ProductManager productManager = new ProductManager(FILE_NAME);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        productManager.displayAllProducts();
                        break;
                    case 3:
                        searchProduct();
                        break;
                    case 0:
                        System.out.println("Thoát chương trình. Tạm biệt!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập một số.");
                choice = -1; // Để tiếp tục vòng lặp
            }
            System.out.println(); // Xuống dòng cho đẹp
        } while (choice != 0);

        scanner.close(); // Đóng Scanner khi thoát chương trình
    }

    private static void printMenu() {
        System.out.println("--- QUẢN LÝ SẢN PHẨM ---");
        System.out.println("1. Thêm sản phẩm mới");
        System.out.println("2. Hiển thị tất cả sản phẩm");
        System.out.println("3. Tìm kiếm sản phẩm theo tên");
        System.out.println("0. Thoát");
    }

    private static void addProduct() {
        System.out.println("\n--- THÊM SẢN PHẨM MỚI ---");
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        double price = 0;
        boolean validPrice = false;
        while (!validPrice) {
            System.out.print("Nhập giá sản phẩm: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    System.out.println("Giá không được âm. Vui lòng nhập lại.");
                } else {
                    validPrice = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ. Vui lòng nhập một số.");
            }
        }

        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Nhập mô tả sản phẩm: ");
        String description = scanner.nextLine();

        Product newProduct = new Product(id, name, price, manufacturer, description);
        productManager.addProduct(newProduct);
    }

    private static void searchProduct() {
        System.out.println("\n--- TÌM KIẾM SẢN PHẨM ---");
        System.out.print("Nhập từ khóa tìm kiếm (theo tên sản phẩm): ");
        String keyword = scanner.nextLine();

        List<Product> foundProducts = productManager.searchProductByName(keyword);

        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào với từ khóa '" + keyword + "'.");
        } else {
            System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
            System.out.printf("%-10s %-25s %-15s %-20s %s\n", "ID", "Tên sản phẩm", "Giá", "Hãng sản xuất", "Mô tả");
            System.out.println("--------------------------------------------------------------------------------------------------");
            for (Product product : foundProducts) {
                System.out.printf("%-10s %-25s %-15.2f %-20s %s\n",
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getManufacturer(),
                        product.getDescription());
            }
            System.out.println("--------------------------------------------------------------------------------------------------");
        }
    }
}