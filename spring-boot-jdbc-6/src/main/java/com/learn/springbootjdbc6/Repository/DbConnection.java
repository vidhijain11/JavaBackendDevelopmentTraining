package com.learn.springbootjdbc6.Repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            //load the driver
            Class.forName(dbDriverClassName);
            //establish the connection
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Connection established successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //return the connection object
        return connection;
    }
}
