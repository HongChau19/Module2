import java.util.Scanner;

public class XoaMang {
    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,5};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phần tử cần xóa:");
        int x = scanner.nextInt();
        int index_del = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == x) {
                index_del = i;
            }
        }
    }
}
