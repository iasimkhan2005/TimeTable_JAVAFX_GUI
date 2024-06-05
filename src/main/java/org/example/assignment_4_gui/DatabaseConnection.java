package org.example.assignment_4_gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/timetable";
    private static final String USER = "root"; // replace with your MySQL username
    private static final String PASSWORD = "123456789"; // replace with your MySQL password
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
