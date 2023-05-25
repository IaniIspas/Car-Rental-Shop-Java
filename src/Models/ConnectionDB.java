package Models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/PAO";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    private static ConnectionDB instance;
    private Connection connection;
    private static Connection databaseConnection;

    private ConnectionDB() {}

    public static Connection getDatabaseConnection()
    {
        try
        {
            if (databaseConnection == null || databaseConnection.isClosed())
            {
                databaseConnection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return databaseConnection;
    }
    public static void closeDatabaseConnection()
    {
        try
        {
            if (databaseConnection != null && !databaseConnection.isClosed())
            {
                databaseConnection.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
