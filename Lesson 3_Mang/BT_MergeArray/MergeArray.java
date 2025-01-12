import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Tạo 2 mảng số với kích thước cho trước
        System.out.print("Nhập kích thước mảng 1: ");
        int size1 = scanner.nextInt();
        System.out.print("Nhập kích thước mảng 2: ");
        int size2 = scanner.nextInt();

        int[] array1 = new int[size1];
        int[] array2 = new int[size2];

        // Bước 2: Sử dụng vòng lặp nhập giá trị cho các phần tử trong mảng
        System.out.println("Nhập giá trị cho mảng 1:");
        for (int i = 0; i < size1; i++) {
            while (true) {
                try {
                    System.out.print("Phần tử " + (i + 1) + ": ");
                    array1[i] = scanner.nextInt();
                    break; // Thoát khỏi vòng lặp nếu nhập thành công
                } catch (InputMismatchException e) {
                    System.out.println("Vui lòng nhập một số nguyên.");
                    scanner.next(); // Xóa giá trị không hợp lệ
                }
            }
        }

        System.out.println("Nhập giá trị cho mảng 2:");
        for (int i = 0; i < size2; i++) {
            while (true) {
                try {
                    System.out.print("Phần tử " + (i + 1) + ": ");
                    array2[i] = scanner.nextInt();
                    break; // Thoát khỏi vòng lặp nếu nhập thành công
                } catch (InputMismatchException e) {
                    System.out.println("Vui lòng nhập một số nguyên.");
                    scanner.next(); // Xóa giá trị không hợp lệ
                }
            }
        }

        // Bước 3: Tạo mảng thứ 3 có kích thước bằng kích thước mảng 1 + kích thước mảng 2
        int[] array3 = new int[size1 + size2];

        // Bước 4: Gán các phần tử của mảng 1 vào mảng 3
        for (int i = 0; i < size1; i++) {
            array3[i] = array1[i];
        }

        // Bước 5: Gán các phần tử của mảng 2 vào mảng 3
        for (int i = 0; i < size2; i++) {
            array3[size1 + i] = array2[i];
        }

        // In ra mảng kết quả
        System.out.print("Mảng gộp (mảng 3): ");
        for (int num : array3) {
            System.out.print(num + " ");
        }
    }
}
