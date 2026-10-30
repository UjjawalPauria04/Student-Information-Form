package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_URL  = "jdbc:mysql://localhost:3306/studentdata";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "uhil4";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(
                "MySQL driver not found. Add mysql-connector-j JAR to the project libraries.");
        }
    }

    private DBConnection() { }   

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
}
