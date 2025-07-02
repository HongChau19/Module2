import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
    private String manufacturer;
    private String description;

    public Product(String id, String name, double price, String manufacturer, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getDescription() {
        return description;
    }

    // Setters (nếu cần, nhưng không dùng trong ví dụ này)
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    // Phương thức để chuyển đổi đối tượng Product thành một dòng CSV để lưu vào file
    @Override
    public String toString() {
        // Đảm bảo không có dấu phẩy trong dữ liệu để tránh lỗi khi đọc lại
        // và thay thế chúng bằng một ký tự khác hoặc loại bỏ.
        // Trong ví dụ này, tôi sẽ thay thế dấu phẩy bằng dấu chấm phẩy trong mô tả nếu có
        String cleanedDescription = description.replace(",", ";");
        String cleanedName = name.replace(",", ";");
        String cleanedManufacturer = manufacturer.replace(",", ";");


        return String.join(",",
                id,
                cleanedName,
                String.valueOf(price),
                cleanedManufacturer,
                cleanedDescription);
    }

    // Phương thức tĩnh để tạo đối tượng Product từ một dòng CSV đọc từ file
    public static Product fromCsvLine(String line) {
        String[] parts = line.split(",", -1); // Dùng -1 để giữ các phần tử trống ở cuối

        if (parts.length != 5) {
            throw new IllegalArgumentException("Dòng CSV không hợp lệ: " + line);
        }

        String id = parts[0];
        String name = parts[1];
        double price = Double.parseDouble(parts[2]);
        String manufacturer = parts[3];
        String description = parts[4];

        return new Product(id, name, price, manufacturer, description);
    }
}