package Models;

public class Car {
    protected int id;
    protected String make;
    protected String model;
    protected int year;
    protected String color;
    protected double rentalPrice;

    public Car() {}
    public Car(String make, String model, int year, String color, double rentalPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.rentalPrice = rentalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
}
