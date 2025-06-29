public class AppConfig {
    private static AppConfig instance;

    private String storeName;
    private String language;
    private String currency;
    private double defaultTaxRate;

    private AppConfig(String storeName, String language, String currency, double defaultTaxRate) {
        this.storeName = storeName;
        this.language = language;
        this.currency = currency;
        this.defaultTaxRate = defaultTaxRate;
        System.out.println("AppConfig đã được khởi tạo lần đầu tiên.");
    }

    public static AppConfig getInstance(String storeName, String language, String currency, double defaultTaxRate) {
        if (instance == null) {
            instance = new AppConfig(storeName, language, currency, defaultTaxRate);
        }
        return instance;
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            throw new IllegalStateException("AppConfig chưa được khởi tạo. Vui lòng gọi getInstance với các tham số cấu hình.");
        }
        return instance;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getLanguage() {
        return language;
    }

    public String getCurrency() {
        return currency;
    }

    public double getDefaultTaxRate() {
        return defaultTaxRate;
    }

    public void displayConfig() {
        System.out.println("--- Cấu hình hệ thống ---");
        System.out.println("Tên cửa hàng: " + storeName);
        System.out.println("Ngôn ngữ: " + language);
        System.out.println("Tiền tệ: " + currency);
        System.out.println("Thuế mặc định: " + (defaultTaxRate * 100) + "%");
    }
}