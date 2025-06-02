package OOP;

public abstract class Employee {
    private String Id;
    private String fullName;
    private String email;
    private double baseSalary;

    public Employee(String id, String fullName, String email, double baseSalary) {
        this.Id = id;
        this.fullName = fullName;
        this.email = email;
        this.baseSalary = baseSalary;
    }

    public String getId() {
        return Id;
    }
    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public abstract void displayEmployeeInfo();

    @Override
    public String toString() {
        return "Mã NV: " + Id + ", Tên: " + fullName + ", Email: " + email;
    }
}