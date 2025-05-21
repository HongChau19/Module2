
import java.util.Scanner;

public class ElectricBillCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Nhập số điện tiêu thụ trong tháng (kWh):");
        int kWhtieuthu = in.nextInt();
        double total = 0;

        if (kWhtieuthu <= 50) {
            total = kWhtieuthu * 1800;
        } else if (kWhtieuthu <= 100) {
            total = (50 * 1800) + ((kWhtieuthu - 50) * 2300);
        } else {
            total = (50 * 1800) + (50 * 2300) + ((kWhtieuthu - 100) * 3000);
        }
        System.out.printf("Số kWh đã sử dụng: %d\n", kWhtieuthu);
        System.out.printf("Tiền điện phải trả: %.0f VNĐ\n", total);

    }
}
