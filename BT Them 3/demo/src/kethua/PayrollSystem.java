package kethua;

public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new FullTimeEmployee("A", 10000000); // Nhân viên toàn thời gian
        employees[1] = new PartTimeEmployee("B", 120, 50000); // Nhân viên bán thời gian: 120 giờ * 50.000 VNĐ/giờ
        employees[2] = new Intern("C", 3000000);             // Thực tập sinh
        employees[3] = new FullTimeEmployee("D", 12000000); // Nhân viên toàn thời gian khác
        employees[4] = new PartTimeEmployee("E", 80, 60000);  // Nhân viên bán thời gian khác: 80 giờ * 60.000 VNĐ/giờ

        // Biến để lưu tổng lương công ty phải trả
        double totalCompanyPayroll = 0;

        System.out.println("--- Báo cáo lương nhân viên ---");
        System.out.println("------------------------------");

        // Duyệt mảng nhân viên và hiển thị thông tin
        for (Employee emp : employees) {
            String name = emp.getName();
            String type = emp.getType();
            double salary = emp.calculateSalary();

        // Hiển thị thông tin cơ bản của từng nhân viên
            System.out.println("Tên: " + name +
                    ", Loại: " + type +
                    ", Lương: " + String.format("%,.0f", salary) + " VNĐ");

            // Sử dụng 'instanceof' để kiểm tra loại đối tượng và gọi các phương thức riêng
            // 'instanceof' giúp chúng ta biết đối tượng 'emp' hiện tại có phải là một kiểu cụ thể hay không.
            if (emp instanceof Intern) {
                ((Intern) emp).attendTraining();
            } else if (emp instanceof PartTimeEmployee) {
                System.out.println("    (Số giờ làm: " + ((PartTimeEmployee) emp).getHoursWorked() + " giờ)");
            }
            totalCompanyPayroll += salary;
        }

        // c. Tính tổng lương công ty phải trả và hiển thị
        System.out.println("\n------------------------------");
        System.out.println("--- Tổng kết chi phí lương ---");
        // Hiển thị tổng số tiền công ty phải chi trả
        System.out.println("Tổng số tiền công ty phải chi trả: " + String.format("%,.0f", totalCompanyPayroll) + " VNĐ");
        System.out.println("------------------------------");
    }
}