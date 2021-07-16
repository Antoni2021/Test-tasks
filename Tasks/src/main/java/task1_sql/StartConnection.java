package task1_sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StartConnection {

    private static final String base = "jdbc:mysql://localhost:3306/students";
    private static final String user = "root";
    private static final String password = "rootroot";
    public static Connection connection;
    public static Statement statement;
    static {
        try {
            connection = DriverManager.getConnection(base, user, password);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}