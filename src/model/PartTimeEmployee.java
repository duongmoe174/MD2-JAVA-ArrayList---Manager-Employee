package model;

public class PartTimeEmployee extends Employee {
    public static final int SALARYPERHOUR = 100000;
    private double workHours;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(double workHours) {
        this.workHours = workHours;
    }

    public PartTimeEmployee(String employeeID, String fullName, int age, String phoneNumber, String email, double workHours) {
        super(employeeID, fullName, age, phoneNumber, email);
        this.workHours = workHours;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    @Override
    public double getNetSalary() {
        double result = workHours * SALARYPERHOUR;
        return result;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "employeeID='" + super.getEmployeeID() + '\'' +
                ", fullName='" + super.getFullName() + '\'' +
                ", age=" + super.getAge() +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                ", workHours=" + workHours +
                '}';
    }
}
