package Models;

public class Electric extends Car{
    private double range;

    public Electric() {}
    public Electric(String make, String model, int year, String color, double rentalPrice, double range) {
        super(make, model, year, color, rentalPrice);
        this.range = range;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}
