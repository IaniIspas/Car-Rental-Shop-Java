package Repository;
import Models.Customer;
import Models.Employee;
import Models.Person;
import Models.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PersonRepository {
    private static PersonRepository instance;
    private PersonRepository() {}

    public static PersonRepository getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
        }
        return instance;
    }
    public Person findById(int id, int type) throws Exception {
        Person person = null;
        String tp;
        Connection connection = ConnectionDB.getDatabaseConnection();
        if (type == 1) {
            tp = "Customer";

        } else if (type == 2) {
            tp = "Employee";

        } else {
            throw new Exception("Invalid type");
        }
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person WHERE id = ?");
        PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM " + tp + " WHERE id = ?");

        statement.setInt(1, id);
        statement1.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        ResultSet resultSet1 = statement1.executeQuery();
        try {
            if (resultSet1.next() && resultSet.next()) {
                if (type == 1) {
                    person = new Customer(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getString("phone"), resultSet.getString("email"),
                            resultSet1.getDouble("balance"));
                } else if (type == 2) {
                    person = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
                            resultSet.getString("phone"), resultSet.getString("email"),
                            resultSet1.getDouble("salary"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public List<Person> findAll() throws Exception {
        List<Person> persons = new ArrayList<>();
        Connection connection = ConnectionDB.getDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");

            persons.add(new Person(id, name, phone, email));
        }

        return persons;
    }

    public Person findByEmail(String email) throws Exception {
        Person person = null;
        Connection connection = ConnectionDB.getDatabaseConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person WHERE email = ?");
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String personEmail = resultSet.getString("email");

            if (personEmail.equals(email)) {
                person = new Person(id, name, phone, personEmail);
            }
        }
        return person;
    }

    public List<Person> findByName(String name) throws Exception {
        List<Person> persons = new ArrayList<>();
        Connection connection = ConnectionDB.getDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Person WHERE name LIKE ?");
        statement.setString(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String personName = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("email");

            persons.add(new Person(id, personName, phone, email));
        }
        return persons;
    }


    public Person findByNameAndPhone(String name, String phone) throws Exception {
        Person person = null;
        Connection connection = ConnectionDB.getDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person WHERE name = ? AND phone = ?");
        statement.setString(1, name);
        statement.setString(2, phone);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");

            person = new Person(id, name, phone, email);
        }

        return person;
    }

    public Person findPerson(String name, String phone, String email) throws Exception {
        Connection connection = ConnectionDB.getDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Person WHERE name = ? AND phone = ? AND email = ?");
        statement.setString(1, name);
        statement.setString(2, phone);
        statement.setString(3, email);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            return new Person(id, name, phone, email);
        }

        return null; // Person not found
    }


    public void create(Person person, int type) throws Exception {
        String tp;
        Connection connection = ConnectionDB.getDatabaseConnection();
        if (type == 1) {
            tp = "Customer";
        } else if (type == 2) {
            tp = "Employee";
        } else {
            throw new Exception("Invalid type");
        }

        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Person(name, phone, email) VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, person.getName());
        statement.setString(2, person.getPhone());
        statement.setString(3, person.getEmail());

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating person failed, no rows affected.");
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                person.setId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating person failed, no ID obtained.");
            }
        }

        PreparedStatement statement1;
        if (type == 1) {
            Customer customer = (Customer) person;
            statement1 = connection.prepareStatement(
                    "INSERT INTO Customer(person_id, balance) VALUES (?, ?)");
            statement1.setInt(1, customer.getId());
            statement1.setDouble(2, customer.getBalance());
        } else {
            Employee employee = (Employee) person;
            statement1 = connection.prepareStatement(
                    "INSERT INTO Employee(person_id, salary) VALUES (?, ?)");
            statement1.setInt(1, employee.getId());
            statement1.setDouble(2, employee.getSalary());
        }

        affectedRows = statement1.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating " + tp + " failed, no rows affected.");
        }
    }

    public void update(Person person, int type) throws Exception {
        String tp;
        Connection connection = ConnectionDB.getDatabaseConnection();
        if (type == 1) {
            tp = "Customer";
        } else if (type == 2) {
            tp = "Employee";
        } else {
            throw new Exception("Invalid type");
        }

        PreparedStatement statement = connection.prepareStatement(
                "UPDATE Person SET name = ?, phone = ?, email = ? WHERE id = ?");
        statement.setString(1, person.getName());
        statement.setString(2, person.getPhone());
        statement.setString(3, person.getEmail());
        statement.setInt(4, person.getId());

        int affectedRows = statement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Updating person failed, no rows affected.");
        }

        PreparedStatement statement1;
        if (type == 1) {
            Customer customer = (Customer) person;
            statement1 = connection.prepareStatement(
                    "UPDATE Customer SET balance = ? WHERE person_id = ?");
            statement1.setDouble(1, customer.getBalance());
            statement1.setInt(2, customer.getId());
        }
        else {
            Employee employee = (Employee) person;
            statement1 = connection.prepareStatement(
                    "UPDATE Employee SET salary = ? WHERE  person_id = ?");
            statement1.setDouble(1, employee.getSalary());
            statement1.setInt(2, employee.getId());
        }
    }

    public void delete(int id, int type) throws Exception {
        String tp;
        Connection connection = ConnectionDB.getDatabaseConnection();
        if (type == 1) {
            tp = "Customer";
        } else if (type == 2) {
            tp = "Employee";
        } else {
            throw new Exception("Invalid type");
        }

        PreparedStatement statement1 = connection.prepareStatement("DELETE FROM " + tp + " WHERE person_id = ?");
        statement1.setInt(1, id);

        int affectedRows = statement1.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Deleting " + tp + " failed, no rows affected.");
        }

        PreparedStatement statement = connection.prepareStatement("DELETE FROM Person WHERE id = ?");
        statement.setInt(1, id);

        affectedRows = statement.executeUpdate();



        if (affectedRows == 0) {
            throw new SQLException("Deleting person failed, no rows affected.");
        }
    }

    public void deleteEmployeeByEmail(String email) throws Exception {
        Connection connection = ConnectionDB.getDatabaseConnection();

        // Check if the employee with the given email exists
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Person WHERE email = ?");
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next()) {
            System.out.println("Employee not found!");
            return;
        }

        int employeeId = resultSet.getInt("id");

        PreparedStatement deleteEmployeeStatement = connection.prepareStatement(
                "DELETE FROM Employee WHERE person_id = ?");
        deleteEmployeeStatement.setInt(1, employeeId);
        int affectedRows = deleteEmployeeStatement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Deleting employee failed, no rows affected.");
        }

        PreparedStatement deletePersonStatement = connection.prepareStatement(
                "DELETE FROM Person WHERE id = ?");
        deletePersonStatement.setInt(1, employeeId);
        affectedRows = deletePersonStatement.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Deleting person failed, no rows affected.");
        }

        System.out.println("Employee deleted successfully!");
    }
}