public class Main {

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        int valueToFind1 = 23;
        int index1 = BinarySearch.binarySearch(sortedArray, valueToFind1);
        if (index1 != -1) {
            System.out.println("Giá trị " + valueToFind1 + " được tìm thấy tại chỉ số: " + index1);
        } else {
            System.out.println("Giá trị " + valueToFind1 + " không được tìm thấy trong mảng.");
        }

        int valueToFind2 = 10;
        int index2 = BinarySearch.binarySearch(sortedArray, valueToFind2);
        if (index2 != -1) {
            System.out.println("Giá trị " + valueToFind2 + " được tìm thấy tại chỉ số: " + index2);
        } else {
            System.out.println("Giá trị " + valueToFind2 + " không được tìm thấy trong mảng.");
        }

        int valueToFind3 = 2;
        int index3 = BinarySearch.binarySearch(sortedArray, valueToFind3);
        if (index3 != -1) {
            System.out.println("Giá trị " + valueToFind3 + " được tìm thấy tại chỉ số: " + index3);
        } else {
            System.out.println("Giá trị " + valueToFind3 + " không được tìm thấy trong mảng.");
        }

        int valueToFind4 = 91;
        int index4 = BinarySearch.binarySearch(sortedArray, valueToFind4);
        if (index4 != -1) {
            System.out.println("Giá trị " + valueToFind4 + " được tìm thấy tại chỉ số: " + index4);
        } else {
            System.out.println("Giá trị " + valueToFind4 + " không được tìm thấy trong mảng.");
        }
    }
}