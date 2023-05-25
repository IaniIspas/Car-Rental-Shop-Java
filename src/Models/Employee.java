package Models;

public class Employee extends Person {
    private double salary;

    public Employee() {}

    public Employee(int id, String name, String phone, String email, double salary) {
        super(id, name, phone, email);
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }
}