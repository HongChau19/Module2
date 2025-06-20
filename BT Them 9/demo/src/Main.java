import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Order> orders = new ArrayList<>();

        System.out.print("Nhập số lượng đơn hàng bạn muốn thêm: ");
        int numberOfOrders = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng newline sau khi đọc số nguyên

        for (int i = 0; i < numberOfOrders; i++) {
            System.out.println("\nNhập thông tin cho đơn hàng #" + (i + 1));
            System.out.print("Mã đơn hàng: ");
            String orderId = scanner.nextLine();

            System.out.print("Tổng tiền: ");
            double totalAmount = scanner.nextDouble();
            scanner.nextLine();

            orders.add(new Order(orderId, totalAmount));
        }

        System.out.println("\n--- Danh sách đơn hàng trước khi sắp xếp ---");
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println("------------------------------------");

        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return Double.compare(o2.getTotalAmount(), o1.getTotalAmount());
            }
        });

        System.out.println("\n--- Danh sách đơn hàng sau khi sắp xếp (giảm dần theo tổng tiền) ---");
        for (Order order : orders) {
            System.out.println(order);
        }

        scanner.close();
    }
}