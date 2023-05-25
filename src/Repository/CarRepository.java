package Repository;
import Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarRepository {
    private static CarRepository instance;

    private CarRepository() {}
    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
        }
        return instance;
    }
    public Car findById(int id, int type) throws Exception {
        Car car = null;
        String tp;
        Connection connection = ConnectionDB.getDatabaseConnection();
        if (type == 1) {
            tp = "Diesel";
        } else if (type == 2) {
            tp = "Electric";
        } else if (type == 3) {
            tp = "Gasoline";
        } else {
            throw new Exception("Invalid type");
        }
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Car WHERE id = ?");
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM " + tp + " WHERE car_id = ?");

        statement.setInt(1, id);
        statement1.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        ResultSet resultSet1 = statement1.executeQuery();
        try {
            if (resultSet1.next() && resultSet.next()) {
                if (type == 1) {
                    car = new Diesel(resultSet.getInt("id"), resultSet.getString("make"),
                            resultSet.getString("model"), resultSet.getInt("year"),
                            resultSet.getString("color"), resultSet.getDouble("rentalPrice"),
                            resultSet1.getDouble("fuelCapacity"));
                } else if (type == 2) {
                    car = new Electric(resultSet.getInt("id"), resultSet.getString("make"),
                            resultSet.getString("model"), resultSet.getInt("year"),
                            resultSet.getString("color"), resultSet.getDouble("rentalPrice"),
                            resultSet1.getDouble("rangeValue"));
                } else if (type == 3) {
                    car = new Gasoline(resultSet.getInt("id"), resultSet.getString("make"),
                            resultSet.getString("model"), resultSet.getInt("year"),
                            resultSet.getString("color"), resultSet.getDouble("rentalPrice"),
                            resultSet1.getDouble("fuelCapacity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }

    public Set<Car> findAllCars() throws Exception {
        Set<Car> cars = new HashSet<>();
        Connection connection = ConnectionDB.getDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Car");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String make = resultSet.getString("make");
            String model = resultSet.getString("model");
            int year = resultSet.getInt("year");
            String color = resultSet.getString("color");
            double rentalPrice = resultSet.getDouble("rentalPrice");
            cars.add(new Car(id, make, model, year, color, rentalPrice));
        }

        return cars;
    }

    public void create(Car car, int type) throws Exception {
        String tp;
        Connection connection = ConnectionDB.getDatabaseConnection();
        if (type == 1) {
            tp = "Diesel";
        } else if (type == 2) {
            tp = "Electric";
        } else if (type == 3) {
            tp = "Gasoline";
        } else {
            throw new Exception("Invalid type");
        }

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Car(make, model, year, color, rentalPrice) VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, car.getMake());
        statement.setString(2, car.getModel());
        statement.setInt(3, car.getYear());
        statement.setString(4, car.getColor());
        statement.setDouble(5, car.getRentalPrice());

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating car failed, no rows affected.");
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                car.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating car failed, no ID obtained.");
            }
        }

        PreparedStatement statement1;
        if (type == 1) {
            Diesel dieselCar = (Diesel) car;
            statement1 = connection.prepareStatement(
                    "INSERT INTO Diesel(car_id, fuelCapacity) VALUES (?, ?)");
            statement1.setInt(1, dieselCar.getId());
            statement1.setDouble(2, dieselCar.getFuelCapacity());
        } else if (type == 2) {
            Electric electricCar = (Electric) car;
            statement1 = connection.prepareStatement(
                    "INSERT INTO Electric(car_id, rangeValue) VALUES (?, ?)");
            statement1.setInt(1, electricCar.getId());
            statement1.setDouble(2, electricCar.getRangeValue());
        } else {
            Gasoline gasolineCar = (Gasoline) car;
            statement1 = connection.prepareStatement(
                    "INSERT INTO Gasoline(car_id, fuelCapacity) VALUES (?, ?)");
            statement1.setInt(1, gasolineCar.getId());
            statement1.setDouble(2, gasolineCar.getFuelCapacity());
        }

        affectedRows = statement1.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating " + tp + " failed, no rows affected.");
        }
    }
    public void update(Car car, int type) throws Exception {
        String tp;
        Connection connection = ConnectionDB.getDatabaseConnection();
        if (type == 1) {
            tp = "Diesel";
        } else if (type == 2) {
            tp = "Electric";
        } else if (type == 3) {
            tp = "Gasoline";
        } else {
            throw new Exception("Invalid type");
        }

        PreparedStatement statement = connection.prepareStatement(
                "UPDATE Car SET make = ?, model = ?, year = ?, color = ?, rentalPrice = ? WHERE id = ?");
        statement.setString(1, car.getMake());
        statement.setString(2, car.getModel());
        statement.setInt(3, car.getYear());
        statement.setString(4, car.getColor());
        statement.setDouble(5, car.getRentalPrice());
        statement.setInt(6, car.getId());

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Updating car failed, no rows affected.");
        }

        PreparedStatement statement1;
        if (type == 1) {
            Diesel dieselCar = (Diesel) car;
            statement1 = connection.prepareStatement(
                    "UPDATE Diesel SET fuelCapacity = ? WHERE car_id = ?");
            statement1.setDouble(1, dieselCar.getFuelCapacity());
            statement1.setInt(2, dieselCar.getId());
        } else if (type == 2) {
            Electric electricCar = (Electric) car;
            statement1 = connection.prepareStatement(
                    "UPDATE Electric SET rangeValue = ? WHERE car_id = ?");
            statement1.setDouble(1, electricCar.getRangeValue());
            statement1.setInt(2, electricCar.getId());
        } else {
            Gasoline gasolineCar = (Gasoline) car;
            statement1 = connection.prepareStatement(
                    "UPDATE Gasoline SET fuelCapacity = ? WHERE car_id = ?");
            statement1.setDouble(1, gasolineCar.getFuelCapacity());
            statement1.setInt(2, gasolineCar.getId());
        }
    }

    public void delete(int id, int type) throws Exception {
        String tp;
        Connection connection = ConnectionDB.getDatabaseConnection();
        if (type == 1) {
            tp = "Diesel";
        } else if (type == 2) {
            tp = "Electric";
        } else if (type == 3) {
            tp = "Gasoline";
        } else {
            throw new Exception("Invalid type");
        }

        PreparedStatement statement1 = connection.prepareStatement("DELETE FROM " + tp + " WHERE car_id = ?");
        statement1.setInt(1, id);

        int affectedRows = statement1.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Deleting " + tp + " failed, no rows affected.");
        }

        PreparedStatement statement = connection.prepareStatement("DELETE FROM Car WHERE id = ?");
        statement.setInt(1, id);

        affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Deleting car failed, no rows affected.");
        }
    }
}
