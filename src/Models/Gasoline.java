package Models;
public class Gasoline extends Car{
    private Double fuelCapacity;
    public Gasoline() {}
    public Gasoline(int id,String make, String model, int year, String color, double rentalPrice, Double fuelCapacity) {
        super(id, make, model, year, color, rentalPrice);
        this.fuelCapacity = fuelCapacity;
    }

    public void setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    @Override
    public String toString() {
        return "Gasoline{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", fuelCapacity=" + fuelCapacity +
                '}';
    }
}
