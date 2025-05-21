import java.util.Scanner;

public class ArrayInsertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo và khởi tạo mảng số nguyên
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        // Khởi tạo mảng với giá trị mặc định là 0
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }

        // In ra mảng ban đầu
        System.out.println("Mảng ban đầu:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Bước 2: Nhập phần tử cần chèn
        System.out.print("Nhập phần tử cần chèn: ");
        int x = scanner.nextInt();

        // Bước 3: Nhập vị trí cần chèn
        System.out.print("Nhập vị trí cần chèn (0-9): ");
        int index = scanner.nextInt();

        // Bước 4: Kiểm tra vị trí chèn
        if (index < 0 || index >= array.length) {
            System.out.println("Không chèn được phần tử vào mảng.");
            return;
        }

        // Bước 5: Thực hiện chèn phần tử
        for (int i = 9; i > index; i--) {
            array[i] = array[i - 1]; // Dịch chuyển các phần tử về phía sau
        }
        array[index] = x; // Chèn phần tử vào vị trí index

        // In ra mảng sau khi chèn
        System.out.println("Mảng sau khi chèn:");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
