package Models;

public class Customer extends Person {
    private double balance;
    public Customer(String name, String address, String phone, String email, double balance) {
        super(name, address, phone, email);
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
