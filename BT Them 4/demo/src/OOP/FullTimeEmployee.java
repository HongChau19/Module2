package OOP;

public class FullTimeEmployee extends Employee implements Assignable {
    private double bonus;

    public FullTimeEmployee(String Id, String fullName, String email, double baseSalary, double bonus) {
        super(Id, fullName, email, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary(){
        return getBaseSalary() + bonus;
    }
    @Override
    public void displayEmployeeInfo() {
        System.out.println("--- Thông tin Nhân viên Chính thức ---");
        System.out.println("Mã NV: " + getId());
        System.out.println("Họ tên: " + getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("Lương cơ bản: " + getBaseSalary());
        System.out.println("Phụ cấp: " + this.bonus);
        System.out.println("Lương thực nhận: " + calculateSalary());
    }


    @Override
    public void assignToProject(Project p) {
        p.addMembers(this); // Giao nhân viên vào dự án [cite: 11]
    }
}
