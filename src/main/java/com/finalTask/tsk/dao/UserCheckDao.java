package com.finalTask.tsk.dao;

import com.finalTask.tsk.entity.User;
import com.finalTask.tsk.exeption.UserCheckExeption;

import java.sql.*;

public class UserCheckDao {
    private static final String SQL_REQUEST = "SELECT user_password FROM project.users WHERE user_name = ?";

    public boolean checkUser(User request) throws UserCheckExeption {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_REQUEST)) {

            preparedStatement.setString(1, request.getName());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            throw new UserCheckExeption(e);
        }

        return false;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/p8db", "root", "admin123");
    }
}
