package kethua;

public class Intern extends Employee {
    double allowance;

    public Intern(String name, double allowance) {
        super(name);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return allowance;
    }
    @Override
    public String getType() {
        return "Intern";
    }

    //Phương thức riêng
    public void attendTraining(){
        System.out.println(getName() + " is attending training.");
    }
}
