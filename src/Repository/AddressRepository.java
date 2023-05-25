package Repository;
import Models.Address;
import Models.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository {
    private static AddressRepository instance;
    private AddressRepository() {}

    public static AddressRepository getInstance() {
        if (instance == null) {
            instance = new AddressRepository();
        }
        return instance;
    }
    public Address findById(int id) {
        Address address = null;

        Connection connection = ConnectionDB.getDatabaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM address WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                address = new Address(
                        resultSet.getInt("id"),
                        resultSet.getString("street"),
                        resultSet.getString("city"),
                        resultSet.getString("country")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();
        Connection connection = ConnectionDB.getDatabaseConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Address");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address(
                        resultSet.getInt("id"),
                        resultSet.getString("street"),
                        resultSet.getString("city"),
                        resultSet.getString("country")
                );
                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addresses;
    }

    public void create(Address address) {
        Connection connection = ConnectionDB.getDatabaseConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO address (street, city, country) VALUES (?, ?, ?)");
            statement.setString(1, address.getStreet());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getCountry());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Address address) {
        Connection connection = ConnectionDB.getDatabaseConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Address SET street = ?, city = ?, country = ? WHERE id = ?");
            statement.setString(1, address.getStreet());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getCountry());
            statement.setInt(4, address.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Connection connection = ConnectionDB.getDatabaseConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM address WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

