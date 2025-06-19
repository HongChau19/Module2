public class Order {
    public String  orderId;
    public double totalAmount;

    public Order(String orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Mã đơn hàng: " + orderId + ", Tổng tiền: " + totalAmount;
    }
}
