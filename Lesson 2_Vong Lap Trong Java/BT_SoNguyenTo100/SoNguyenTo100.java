public class SoNguyenTo100 {
    public static void main(String[] args) {
        // Bước 2: Lặp lại việc kiểm tra trên từng số trong khoảng từ 2 tới 100
        System.out.println("Các số nguyên tố nhỏ hơn 100 là:");
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) { // Kiểm tra xem i có phải là số nguyên tố không
                System.out.print(i + " "); // In ra số nguyên tố
            }
        }
    }

    // Bước 1: Phương thức kiểm tra số nguyên tố
    public static boolean isPrime(int num) {
        if (num <= 1) return false; // Số nguyên tố phải lớn hơn 1
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // Nếu chia hết cho i thì không phải số nguyên tố
            }
        }
        return true; // Nếu không chia hết cho bất kỳ số nào thì là số nguyên tố
    }
}
