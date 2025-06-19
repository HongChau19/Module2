import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderSorting {

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();

        orders.add(new Order("DH001", 500.0));
        orders.add(new Order("DH002", 1500.0));
        orders.add(new Order("DH003", 750.0));
        orders.add(new Order("DH004", 200.0));
        orders.add(new Order("DH005", 1000.0));

        System.out.println("Danh sách đơn hàng trước khi sắp xếp:");

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

        System.out.println("Danh sách đơn hàng sau khi sắp xếp (giảm dần theo tổng tiền):");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}