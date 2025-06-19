public class BinarySearch {
    public static int binarySearch(int[] list, int value) {
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = low + (high - low) / 2;

            if (list[mid] == value) {
                return mid;
            } else if (list[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
