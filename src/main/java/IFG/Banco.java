package IFG;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    private Banco() {}

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/petisko","megauser","mysql123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}