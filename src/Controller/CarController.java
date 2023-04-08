package Controller;

import Models.Car;
import Service.CarService;

import java.util.ArrayList;

public class CarController {
    private CarService carService;

    public CarController() {
        this.carService = new CarService();
    }

    public boolean addCar(int t, String make, String model, int year, String color, double rentalPrice, double value) {
        return carService.addCar(t, make, model, year, color, rentalPrice, value);
    }

    public void displayAllCars() {
        ArrayList<Car> cars = carService.getAllCars();
        if (cars.isEmpty()) {
            System.out.println("There are no cars in the rental shop!");
        } else {
            for (Car car : cars) {
                System.out.println(", Make: " + car.getMake() + ", Model: " + car.getModel() +
                        ", Year: " + car.getYear() + ", Color: " + car.getColor() + ", Rental Price: $" + car.getRentalPrice());
            }
        }
    }

    public boolean updateCar(int id, String make, String model, int year, String color, double rentalPrice) {
        Car car = new Car(make, model, year, color, rentalPrice);
        return carService.updateCar(id, car);
    }
    public boolean deleteCar(int id) {
        return carService.deleteCar(id);
    }
}