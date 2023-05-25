package Models;

public class Customer extends Person {
    private double balance;

    public Customer() {}

    public Customer(int id, String name, String phone, String email, double balance) {
        super(id, name, phone, email);
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}
