public class Calculator {
    public static int add(int a, int b){
        return a + b;
    }
    public static int subtract(int a, int b){
        return a - b;
    }
    public static int multiply(int a, int b) {
        return a * b;
    }
    public static double divide(int a, int b) {
        // Kiểm tra chia cho 0 và xử lý ngoại lệ
        if (b == 0) {
            throw new ArithmeticException("Không thể chia cho 0");
        }
        return (double) a / b;
    }
    public static void main(String[] args) {
        // Ví dụ sử dụng các phương thức của lớp Calculator
        int a = 10;
        int b = 5;

        System.out.println("Cộng: " + Calculator.add(a, b));
        System.out.println("Trừ: " + Calculator.subtract(a, b));
        System.out.println("Nhân: " + Calculator.multiply(a, b));
        try {
            System.out.println("Chia: " + Calculator.divide(a, b));
            System.out.println("Chia cho 0: " + Calculator.divide(a, 0)); // Sẽ gây ra ngoại lệ
        } catch (ArithmeticException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
