package com.finalTask.tsk.dao;

import com.finalTask.tsk.entity.UserRequest;
import com.finalTask.tsk.entity.UserResponce;
import com.finalTask.tsk.exeption.UserCheckExeption;

import java.sql.*;

public class UserCheckDao {
    private static final String SQL_REQUEST = "SELECT user_password FROM project.users WHERE user_name = ?";

    public UserResponce checkUser(UserRequest request) throws UserCheckExeption {
        UserResponce responce = new UserResponce();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_REQUEST)) {

            preparedStatement.setString(1, request.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                responce.setRegistered(true);
            }

        } catch (SQLException e) {
            throw new UserCheckExeption(e);
        }

        return responce;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/p8db", "root", "admin123");
    }
}
