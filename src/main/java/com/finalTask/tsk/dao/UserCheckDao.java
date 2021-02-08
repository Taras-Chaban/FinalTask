package com.finalTask.tsk.dao;

import com.finalTask.tsk.domain.UserRequest;
import com.finalTask.tsk.domain.UserResponce;
import com.finalTask.tsk.exeption.UserCheckExeption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCheckDao {
    private static final String SQL_REQUEST = "";

    public UserResponce checkUser(UserRequest request) throws UserCheckExeption {
        UserResponce responce = new UserResponce();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_REQUEST)) {

        } catch (SQLException e) {
            throw new UserCheckExeption(e);
        }

        return responce;
    }

    private Connection getConnection() {
        return null;
    }
}
