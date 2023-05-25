package Repository;
import Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractRepository {
    private static ContractRepository instance;
    private ContractRepository() {}

    public static ContractRepository getInstance() {
        if (instance == null) {
            instance = new ContractRepository();
        }
        return instance;
    }

    public Contract findById(int id) throws Exception {
        Contract contract = null;
        Connection connection = ConnectionDB.getDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Contract WHERE id = ?");

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        try {
            if (resultSet.next()) {
                contract = new Contract(resultSet.getInt("id"), resultSet.getInt("customer_id"),
                        resultSet.getInt("employee_id"), resultSet.getInt("car_id"),
                        resultSet.getString("startDate"), resultSet.getString("endDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }

    public void create(Contract contract) throws Exception {
        Connection connection = ConnectionDB.getDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Contract(customer_id, employee_id, car_id, startDate, endDate) VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, contract.getCustomer_id());
        statement.setInt(2, contract.getEmployee_id());
        statement.setInt(3, contract.getCar_id());
        statement.setString(4, contract.getStartDate());
        statement.setString(5, contract.getEndDate());

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating contract failed, no rows affected.");
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                contract.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating contract failed, no ID obtained.");
            }
        }
    }

    public void update(Contract contract) throws Exception {
        Connection connection = ConnectionDB.getDatabaseConnection();

        PreparedStatement statement = connection.prepareStatement(
                "UPDATE Contract SET customer_id = ?, employee_id = ?, car_id = ?, startDate = ?, endDate = ? WHERE id = ?");
        statement.setInt(1, contract.getCustomer_id());
        statement.setInt(2, contract.getEmployee_id());
        statement.setInt(3, contract.getCar_id());
        statement.setString(4, contract.getStartDate());
        statement.setString(5, contract.getEndDate());
        statement.setInt(6, contract.getId());

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Updating contract failed, no rows affected.");
        }
    }

    public void delete(int id) throws Exception {
        Connection connection = ConnectionDB.getDatabaseConnection();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM Contract WHERE id = ?");
        statement.setInt(1, id);

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Deleting contract failed, no rows affected.");
        }
    }
}

