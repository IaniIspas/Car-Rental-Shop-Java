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
    }
