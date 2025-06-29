import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
    private static Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getId(), product);
        System.out.println("Đã thêm sản phẩm ID= " + product.getId());
    }
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public void removeProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            System.out.println("Đã xóa sản phẩm ID= " + productId);
        } else {
            System.out.println("Không tìm thấy sản phẩm ID= " + productId);
        }
    }
    public void updateProduct(Product product) {
        if (products.containsKey(product.getId())) {
            products.put(product.getId(), product);
            System.out.println("DB: Đã cập nhật sản phẩm ID=" + product.getId());
        } else {
            System.out.println("DB: Không tìm thấy sản phẩm ID=" + product.getId() + " để cập nhật.");
        }
    }

    public Map<String, Product> getAllProducts() {
        return products;
    }
}
