package br.com.senacrs.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/person";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123kauan";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
