package com.example.ecommerceapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/eCommerce";
    private static final  String JDBC_USERNAME = "root";
    private static final  String JDBC_PASSWORD = "Jnrvoltage1";


    public static Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
