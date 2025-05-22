package kethua;

public class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    public PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    @Override
    public String getType(){
        return "Part-Time";
    }
    //Phương thức riêng
    public int getHoursWorked() {
        return hoursWorked;
    }
}
