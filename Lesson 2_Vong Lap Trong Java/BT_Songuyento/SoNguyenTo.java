import java.util.Scanner;
public class SoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập số lượng số nguyên tố cần in ra
        System.out.print("Nhập số lượng số nguyên tố cần hiển thị: ");
        int numbers = scanner.nextInt();

        // Bước 2: Khai báo biến count
        int count = 0;

        // Bước 3: Khai báo biến N
        int N = 2; // Số nguyên tố đầu tiên

        // Bước 4: Trong khi count < numbers
        while (count < numbers) {
            // Kiểm tra xem N có phải là số nguyên tố không
            if (isPrime(N)) {
                System.out.print(N + " "); // In ra số nguyên tố
                count++; // Tăng count lên 1
            }
            N++; // Tăng giá trị của N để kiểm tra số tiếp theo
        }

        scanner.close();
    }

    // Phương thức kiểm tra số nguyên tố
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
