import java.util.Arrays;
public class Main {

    public static void insertionSort(int[] list) {

        if (list == null || list.length <= 1) {
            return;
        }

        int n = list.length;

        for (int i = 1; i < n; i++) {
            int currentElement = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > currentElement) {
                list[j + 1] = list[j];
                j--;
            }

            list[j + 1] = currentElement;
        }
    }

    // Phương thức main để kiểm tra (ví dụ)
    public static void main(String[] args) {
        int[] myArray = {5, 2, 8, 1, 9, 4, 7, 3, 6};
        System.out.println("Mảng trước khi sắp xếp: " + Arrays.toString(myArray));

        insertionSort(myArray);


        System.out.println("Mảng sau khi sắp xếp:  " + Arrays.toString(myArray));

        int[] emptyArray = {};
        System.out.println("\nMảng rỗng trước khi sắp xếp: " + Arrays.toString(emptyArray));
        insertionSort(emptyArray);
        System.out.println("Mảng rỗng sau khi sắp xếp:  " + Arrays.toString(emptyArray));

        int[] singleElementArray = {42};
        System.out.println("\nMảng một phần tử trước khi sắp xếp: " + Arrays.toString(singleElementArray));
        insertionSort(singleElementArray);
        System.out.println("Mảng một phần tử sau khi sắp xếp:  " + Arrays.toString(singleElementArray));
    }
}