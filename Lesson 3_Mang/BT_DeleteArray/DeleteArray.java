import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khai báo và khởi tạo mảng số nguyên
        System.out.print("Nhập kích thước mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Nhập giá trị cho mảng:");
        for (int i = 0; i < n; i++) {
            while (true) {
                try {
                    System.out.print("Phần tử " + (i + 1) + ": ");
                    array[i] = scanner.nextInt();
                    break; // Thoát khỏi vòng lặp nếu nhập thành công
                } catch (InputMismatchException e) {
                    System.out.println("Vui lòng nhập một số nguyên.");
                    scanner.next(); // Xóa giá trị không hợp lệ
                }
            }
        }

        // Bước 2: Nhập phần tử cần xoá
        System.out.print("Nhập phần tử cần xoá: ");
        int x = scanner.nextInt();

        // Bước 3: Tìm phần tử X trong mảng
        int indexDel = -1; // Khởi tạo với -1 để kiểm tra xem phần tử có tồn tại hay không
        for (int i = 0; i < n; i++) {
            if (array[i] == x) {
                indexDel = i;
                System.out.println("Phần tử " + x + " được tìm thấy tại vị trí: " + indexDel);
                break; // Thoát khỏi vòng lặp khi tìm thấy phần tử
            }
        }

        // Kiểm tra xem phần tử có tồn tại không
        if (indexDel == -1) {
            System.out.println("Phần tử " + x + " không tồn tại trong mảng.");
        } else {
            // Bước 4: Thực hiện xoá phần tử X khỏi mảng
            for (int i = indexDel; i < n - 1; i++) {
                array[i] = array[i + 1]; // Ghi đè phần tử tiếp theo lên phần tử cần xoá
            }
            n--; // Giảm kích thước mảng đi 1

            // Bước 5: In ra mảng sau khi xoá
            System.out.print("Mảng sau khi xoá phần tử " + x + ": ");
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
