package ru.tolkacheva.spring.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class DBMain {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:h2:/mydb");
        DAO dao = new DAO(connection, new HashMap<>());
    }
}
