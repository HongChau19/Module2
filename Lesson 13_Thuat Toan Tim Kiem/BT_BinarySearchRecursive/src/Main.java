import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Khởi tạo một mảng bất kì với các giá trị được nhập vào từ bàn phím
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Mảng ban đầu: " + Arrays.toString(array));

        // Bước 2: Sắp xếp lại mảng trên theo thứ tự từ bé đến lớn
        Arrays.sort(array); // Sử dụng hàm sort của Java để sắp xếp mảng
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(array));

        System.out.print("Nhập giá trị cần tìm: ");
        int valueToFind = scanner.nextInt();

        // Gọi hàm tìm kiếm nhị phân từ lớp BinarySearchRecursive
        int result = BinarySearchRecursive.find(array, 0, array.length - 1, valueToFind);

        if (result != -1) {
            System.out.println("Giá trị " + valueToFind + " được tìm thấy tại chỉ số: " + result);
        } else {
            System.out.println("Giá trị " + valueToFind + " không được tìm thấy trong mảng.");
        }
        scanner.close();
    }
}