package ordersystem;

public interface Discountable {

    double getDiscountPercentage();

    default double calculatePriceAfterDiscount(double priceBeforeDiscount) {
        return priceBeforeDiscount * (1 - getDiscount());
    }
}
