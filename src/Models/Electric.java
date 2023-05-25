package Models;

public class Electric extends Car{
    private double rangeValue;

    public Electric() {}

    public Electric(int id, String make, String model, int year, String color, double rentalPrice, double rangeValue) {
        super(id, make, model, year, color, rentalPrice);
        this.rangeValue = rangeValue;
    }

    public void setRange(double range) {
        this.rangeValue = range;
    }

    public double getRangeValue() {
        return rangeValue;
    }

    @Override
    public String toString() {
        return "Electric{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", range=" + rangeValue +
                '}';
    }
}
