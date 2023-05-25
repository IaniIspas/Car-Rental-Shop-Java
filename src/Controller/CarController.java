package Controller;

import Models.Car;
import Models.Person;
import Service.CarService;

import java.util.List;
import java.util.Set;

public class CarController {
    private final CarService carService;
    public CarController() {
        this.carService = new CarService();
    }

    public Car getCarById(int id, int type) throws Exception {
        return carService.findById(id, type);
    }

    public void displayAllCars() throws Exception {
        Set<Car> cars = carService.findAllCars();
        if (!cars.isEmpty()) {
            System.out.println("All Cars:");
            for (Car car : cars) {
                System.out.println(car.toString());
            }
        } else {
            System.out.println("No cars found.");
        }
    }

    public void createCar(Car car, int type) throws Exception {
        carService.create(car, type);
    }

    public void updateCar(Car car, int type) throws Exception {
        carService.update(car, type);
    }

    public void deleteCar(int id, int type) throws Exception {
        carService.delete(id, type);
    }
}
