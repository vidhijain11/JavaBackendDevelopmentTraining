package com.learn.springbootjdbc6.Repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DbConnection {

    @Value("${db.datasource.url}")
    private String dbUrl;

    @Value("${db.datasource.username}")
    private String dbUsername;

    @Value("${db.datasource.password}")
    private String dbPassword;

    @Value("${db.driver.classname}")
    private String dbDriverClassName;

    public DbConnection() {
        System.out.println("DbConnection constructor called");
    }

    public Connection getConnection() {

        Connection connection = null;
        try {
//            //load the driver
//            Class.forName(dbDriverClassName);
            //establish the connection
            connection = DriverManager.getConnection("jdbc:sqlite:/Users/vidhijain/my_database.db");
            System.out.println("Connection established successfully. Connected to SQLite database!");

            // Create a statement object for executing SQL commands
            Statement statement = connection.createStatement();

            // Example: Create a table (if it doesn't already exist)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS product (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "price FLOAT NOT NULL, " +
                    "manufacturedDate DATE" +
                    ");";
            statement.execute(createTableSQL);
            System.out.println("Table created or already exists.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //return the connection object
        return connection;
    }
}
