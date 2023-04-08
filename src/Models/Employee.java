package Models;

public class Employee extends Person {
    private double salary;
    public Employee() {}

    public Employee(String name, String address, String phone, String email, double salary) {
        super(name, address, phone, email);
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
