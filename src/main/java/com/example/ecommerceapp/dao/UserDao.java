package com.example.ecommerceapp.dao;

import com.example.ecommerceapp.model.User;
import com.example.ecommerceapp.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = ConnectionUtil.getConnection();
    }

    public void addUser(User user){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into customerT(firstName,lastName,email,password) values (?,?,?,?)");
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setString(4,user.getPassword());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
