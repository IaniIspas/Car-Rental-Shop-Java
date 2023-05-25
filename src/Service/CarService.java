package Service;

import Models.Car;
import Models.Person;
import Repository.CarRepository;

import java.util.List;
import java.util.Set;

public class CarService {
    private CarRepository carRepository;

    public CarService() {
        this.carRepository = CarRepository.getInstance();
    }

    public Car findById(int id, int type) throws Exception {
        try {
            return carRepository.findById(id, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Car> findAllCars() throws Exception {
        return carRepository.findAllCars();
    }

    public void create(Car car, int type) throws Exception {
        try {
            carRepository.create(car, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Car car, int type) throws Exception {
        try {
            carRepository.update(car, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id, int type) throws Exception {
        try {
            carRepository.delete(id, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

