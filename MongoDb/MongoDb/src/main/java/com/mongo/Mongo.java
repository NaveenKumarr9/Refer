package com.mongo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mongo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String databaseUrl = "jdbc:mongo://localhost:27017/Spring";
        String userName = "root";
        String password = "root";
        Connection connection=null;

        try {
            Class.forName("mongodb.jdbc.MongoDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: Unable to load SQLServer JDBC Driver");
            e.printStackTrace();
            return;
        }
        System.out.println("MongoDB JDBC Driver has been registered...");

        System.out.println("Trying to get a connection to the database...");
        try {
            connection = DriverManager.getConnection(databaseUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to establish a connection with the database!");
            e.printStackTrace();
        }

        if (connection != null) {
            DatabaseMetaData metadata = connection.getMetaData();
            System.out.println("Connection to the database has been established...");
            System.out.println("JDBC Driver Name : " + metadata.getDriverName());
            System.out.println("JDBC Driver Version : " + metadata.getDriverVersion());
        } else {
            System.out.println("ERROR: Unable to make a database connection!");
        }
    }
}
