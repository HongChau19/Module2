package kethua;

public class FullTimeEmployee extends Employee {
    double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
    @Override
    public String getType(){
        return "Full-time";
    }
}
