public class BinarySearchRecursive {

    public static int find(int[] array, int left, int right, int value) {
        if (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == value) {
                return middle;
            }

            if (value > array[middle]) {
                return find(array, middle + 1, right, value);
            }

            else {
                return find(array, left, middle - 1, value);
            }
        }
        return -1;
    }
}