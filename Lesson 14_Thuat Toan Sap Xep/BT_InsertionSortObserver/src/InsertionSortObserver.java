import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortObserver {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        System.out.println("--- Bắt đầu Sắp xếp Chèn ---");
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        System.out.println("----------------------------");

        // Duyệt qua từng phần tử của mảng, bắt đầu từ phần tử thứ hai (chỉ số 1)
        // vì phần tử đầu tiên (chỉ số 0) mặc định đã được coi là mảng con đã sắp xếp
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Lấy phần tử hiện tại để chèn vào mảng con đã sắp xếp
            int j = i - 1;    // Chỉ số của phần tử cuối cùng trong mảng con đã sắp xếp

            System.out.println("\nBước " + i + ": Đang xử lý phần tử " + key + " (tại vị trí ban đầu " + i + ")");
            System.out.println("  Mảng con đã sắp xếp hiện tại: " + Arrays.toString(Arrays.copyOfRange(arr, 0, i)));
            System.out.println("  Phần tử cần chèn (key): " + key);

            // Di chuyển các phần tử của arr[0..i-1], lớn hơn key,
            // về phía trước một vị trí so với vị trí hiện tại của chúng
            while (j >= 0 && arr[j] > key) {
                System.out.println("    Dịch chuyển " + arr[j] + " từ vị trí " + j + " sang vị trí " + (j + 1));
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // Chèn key vào vị trí đúng của nó
            arr[j + 1] = key;
            System.out.println("  Chèn " + key + " vào vị trí " + (j + 1));

            System.out.println("  Trạng thái mảng sau bước " + i + ": " + Arrays.toString(arr));
            System.out.println("----------------------------");
        }
        System.out.println("--- Hoàn thành Sắp xếp Chèn ---");
        System.out.println("Mảng cuối cùng: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Chào mừng bạn đến với chương trình quan sát Sắp xếp Chèn!");
        System.out.print("Bạn muốn sắp xếp bao nhiêu số nguyên? ");
        int size = scanner.nextInt();

        int[] myArray = new int[size];
        System.out.println("Nhập " + size + " số nguyên, cách nhau bởi dấu cách hoặc Enter:");
        for (int i = 0; i < size; i++) {
            myArray[i] = scanner.nextInt();
        }

        // Gọi phương thức sắp xếp và quan sát các bước
        insertionSort(myArray);

        scanner.close();
    }
}