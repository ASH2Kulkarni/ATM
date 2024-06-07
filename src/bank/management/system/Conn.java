
package bank.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    private Connection connection;
    public Statement s;

    public Conn() throws SQLException {
        // Initialize the database connection
        connect();
    }

    private void connect() throws SQLException {
        // Connect to your database (replace the placeholders with your actual database URL, username, and password)
        String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
        String username = "root"; //  database username
        String password = "Ash2003"; // database password
        
        // Establish the connection
        connection = DriverManager.getConnection(url, username, password);
        s=connection.createStatement();
    }

    public java.sql.PreparedStatement prepareStatement(String sql) throws SQLException {
        // Create a PreparedStatement from the connection
        return connection.prepareStatement(sql);
    }

    public void close() {
        // Close the connection when no longer needed
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}