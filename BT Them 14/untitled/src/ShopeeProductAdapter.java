import java.util.ArrayList;
import java.util.List;

public class ShopeeProductAdapter implements ProductDataReader {
    private ShopeeProductData shopeeData;

    public ShopeeProductAdapter(ShopeeProductData shopeeData) {
        this.shopeeData = shopeeData;
    }

    @Override
    public List<Product> readProducts() {
        List<Product> products = new ArrayList<>();
        List<String> csvLines = shopeeData.getCsvProductLines();

        System.out.println("\nAdapter: Đang chuyển đổi dữ liệu từ Shopee...");
        for (String line : csvLines) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                try {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String description = parts[3].trim();
                    products.add(new Product(id, name, price, description));
                    System.out.println("Adapter: Đã chuyển đổi thành công sản phẩm: " + name);
                } catch (NumberFormatException e) {
                    System.err.println("Adapter: Lỗi chuyển đổi giá sản phẩm từ dòng: " + line);
                }
            } else {
                System.err.println("Adapter: Định dạng dòng CSV không hợp lệ: " + line);
            }
        }
        System.out.println("Adapter: Hoàn tất chuyển đổi dữ liệu từ Shopee.");
        return products;
    }
}