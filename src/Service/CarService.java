package Service;

import Models.Car;
import Models.Diesel;
import Models.Electric;
import Models.Gasoline;
import Repository.CarRepository;
import java.util.ArrayList;

public class CarService {
    private CarRepository carRepository;
    private static int reg_no;
    public CarService() {
        this.carRepository = new CarRepository();
        reg_no++;
    }
    public boolean addCar(int t, String make, String model, int year, String color, double rentalPrice, double value) {
        Car car;
        if(t == 0) {
            car = new Electric(make, model, year, color, rentalPrice, value);
        }
        else if(t == 1){
            car = new Gasoline(make, model, year, color, rentalPrice, value);
        }
        else {
            car = new Diesel(make, model, year, color, rentalPrice, value);
        }
        car.setId(reg_no);
        return this.carRepository.add(car);
    }
    public ArrayList<Car> getAllCars() {
        return this.carRepository.getAllCars();
    }
    public boolean updateCar(int id, Car car) {
        return carRepository.update(id, car);
    }
    public boolean deleteCar(int id) {
        return carRepository.delete(id);
    }
}