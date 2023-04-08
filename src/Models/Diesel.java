package Models;

public class Diesel extends Car{
    private Double fuelCapacity;

    public Diesel() {}

    public Diesel(String make, String model, int year, String color, double rentalPrice, Double fuelCapacity) {
        super(make, model, year, color, rentalPrice);
        this.fuelCapacity = fuelCapacity;
    }
    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}
