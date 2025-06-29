public class ProductFactory {
    public static Product createProduct(String productType, String name, double price, String... args) {
        switch (productType.toLowerCase()) {
            case "shirt":
                // Đảm bảo có đủ 2 đối số bổ sung: size và material
                if (args.length < 2) {
                    throw new IllegalArgumentException("Thiếu đối số cho Áo (cần size, material).");
                }
                return new Shirt(name, price, args[0], args[1]);
            case "shoe":
                if (args.length < 2) {
                    throw new IllegalArgumentException("Thiếu đối số cho Giày (cần brand, sizeEU).");
                }
                try {
                    int size = Integer.parseInt(args[1]);
                    return new Shoe(name, price, args[0], size);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Kích thước giày (size) phải là một số nguyên hợp lệ. Lỗi: " + e.getMessage());
                }
            case "hat":
                // Đảm bảo có đủ 2 đối số bổ sung: color và style
                if (args.length < 2) {
                    throw new IllegalArgumentException("Thiếu đối số cho Mũ (cần color, style).");
                }
                return new Hat(name, price, args[0], args[1]);
            default:
                throw new IllegalArgumentException("Loại sản phẩm không hợp lệ: " + productType);
        }
    }
}