package Repository;

import Models.Car;
import Models.Person;

import java.util.ArrayList;

public class CarRepository {
    private ArrayList<Car> cars = new ArrayList<Car>();
    public boolean add(Car car) {
        try {
            cars.add(car);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public Car get(int i) {
        return cars.get(i);
    }
    public ArrayList<Car> getAllCars() {
        return cars;
    }

    public boolean update(int i, Car car) {
        try {
            cars.set(i, car);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean delete(int i) {
        try {
            cars.remove(i);
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }

    public Car findByMakeAndModel(String make, String model) {
        for (Car car : cars) {
            if (car.getMake().equals(make) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public Car findByearAndColor(int year, String color) {
        for (Car car : cars) {
            if (car.getYear() == year && car.getColor().equals(color)) {
                return car;
            }
        }
        return null;
    }
}
