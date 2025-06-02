package OOP;

public class Contractor extends Employee {
    private int workingHours;
    private double hourlyRate;

    public Contractor(String Id, String fullName, String email, double baseSalary, int workingHours, double hourlyRate) {
        super(Id, fullName, email, baseSalary);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println("--- Thông tin Nhân viên Hợp đồng ---");
        System.out.println("Mã NV: " + getId());
        System.out.println("Họ tên: " + getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("Số giờ làm việc: " + this.workingHours);
        System.out.println("Đơn giá mỗi giờ: " + this.hourlyRate);
        System.out.println("Lương thực nhận: " + calculateSalary());
    }
}
