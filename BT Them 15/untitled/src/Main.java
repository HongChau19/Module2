import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManage manager = new ProductManage();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm mới");
            System.out.println("3. Hiển thị sản phẩm có giá từ 200.000 trở lên");
            System.out.println("4. Cập nhật giá sản phẩm");
            System.out.println("0. Thoát");
            System.out.println("==========================");
            System.out.print("Nhập lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập một số.");
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    List<Product> allProducts = manager.readProductsFromFile();
                    manager.displayProducts(allProducts);
                    break;
                case 2:
                    System.out.print("Nhập mã sản phẩm: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá bán: ");
                    double price = -1;
                    try {
                        price = Double.parseDouble(scanner.nextLine());
                        if (price < 0) {
                            System.out.println("Giá không được âm. Vui lòng thử lại.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Giá không hợp lệ. Vui lòng nhập một số.");
                        break;
                    }
                    Product newProduct = new Product(id, name, price);
                    manager.addProduct(newProduct);
                    break;
                case 3:
                    List<Product> currentProducts = manager.readProductsFromFile();
                    manager.displayProductsExpensive(currentProducts);
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm cần cập nhật giá: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Nhập giá mới: ");
                    double newPrice = -1;
                    try {
                        newPrice = Double.parseDouble(scanner.nextLine());
                        if (newPrice < 0) {
                            System.out.println("Giá không được âm. Vui lòng thử lại.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Giá không hợp lệ. Vui lòng nhập một số.");
                        break;
                    }
                    manager.updateProductPrice(updateId, newPrice);
                    break;
                case 0:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
        scanner.close();
    }
}