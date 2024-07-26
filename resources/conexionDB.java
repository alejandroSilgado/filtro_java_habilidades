package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {
    private static final String CONNECTION_URL = "jdbc:mysql:/root@locahost:3306/sgpzf?password=";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL);
    }
}
