package OOP;

class Intern extends Employee {
    private String mentor;

    public Intern(String Id, String fullName, String email, double baseSalary, String mentor) {
        super(Id, fullName, email, baseSalary);
        this.mentor = mentor;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Thực tập sinh không có phụ cấp
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println("--- Thông tin Thực tập sinh ---");
        System.out.println("Mã NV: " + getId());
        System.out.println("Họ tên: " + getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("Lương cơ bản: " + getBaseSalary());
        System.out.println("Người hướng dẫn: " + this.mentor);
        System.out.println("Lương thực nhận: " + calculateSalary());
    }
}
