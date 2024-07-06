package Java.JDBCDataBaseDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/healthcare_wecp";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME,PASSWORD);
    }
}
