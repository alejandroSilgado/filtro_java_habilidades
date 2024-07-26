package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {
        private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/sgpzf";
        private static final String USERNAME = "campus2023";
        private static final String PASSWORD = "campus2023";
    
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        }
}



