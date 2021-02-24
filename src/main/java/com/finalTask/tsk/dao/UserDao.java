package com.finalTask.tsk.dao;

import com.finalTask.tsk.DB.PoolConnectionBuilder;
import com.finalTask.tsk.entity.EntityMap;
import com.finalTask.tsk.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private static final String SQL_GET_COUNT_OF_ROWS = "SELECT count(user_id) from project.users";

    private static final String SQL_FIND_USER_BY_NAME =
            "SELECT * FROM project.users WHERE user_name = ?";

    private static final String SQL_FIND_USER_BY_ID =
            "SELECT * FROM project.users WHERE user_id = ?";

    private static final String SQL_UPDATE_USER =
            "UPDATE project.users SET " +
                    "user_name = ?, " +
                    "user_password = ?, " +
                    "user_phone = ?, " +
                    "user_email = ?, " +
                    "user_address = ?, " +
                    "role_id = ? " +
                    "WHERE user_id = ?";
    private static final String SQL_ADD_USER = "INSERT INTO project.users " +
            "(user_name, user_password, user_phone, user_email, user_address, role_id)" +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SQL_GET_USERS = "SELECT * FROM project.users " +
            "WHERE user_id >= ? AND user_id <= ?";

    public int getCountOfRows() {
        return getInt(SQL_GET_COUNT_OF_ROWS);
    }

    static int getInt(String sqlGetCountOfRows) {
        int rows = -1;

        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(sqlGetCountOfRows);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rows = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }

        return rows;
    }

    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement;
        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_ADD_USER);
            //map user fields to prepared statement
            new UserMapper().mapField(preparedStatement, user);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }
    }

    public ArrayList<User> getUsers(Long start, Long end) {
        ArrayList<User> users = new ArrayList<>();

        PreparedStatement preparedStatement;
        ResultSet rs;
        Connection connection = null;
        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_USERS);
            preparedStatement.setLong(1, start);
            preparedStatement.setLong(2, end);
            rs = preparedStatement.executeQuery();
            UserMapper mapper = new UserMapper();

            while (rs.next()) {
                users.add(mapper.mapRow(rs));
            }
            rs.close();
            preparedStatement.close();
        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }


        return users;
    }

    public User findUserById(Long id) {
        User user = null;
        PreparedStatement preparedStatement;
        ResultSet rs;
        Connection con = null;
        try {
            con = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = con.prepareStatement(SQL_FIND_USER_BY_ID);
            preparedStatement.setLong(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next())
                user = new UserMapper().mapRow(rs);
            rs.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(con);
            ex.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(con);
        }
        return user;
    }

    public User findUserByName(String name) {
        User user = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = null;
        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_NAME);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new UserMapper().mapRow(resultSet);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }
        return user;
    }

    public void updateUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement;
        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();

            preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
            //map user fields to prepared statement
            new UserMapper().mapField(preparedStatement, user);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }
    }

    private static class UserMapper implements EntityMap<User> {

        @Override
        public User mapRow(ResultSet rs) {
            try {
                User user = new User();
                user.setId(rs.getLong("user_id"));
                user.setName(rs.getString("user_name"));
                user.setPassword(rs.getString("user_password"));
                user.setAddress(rs.getString("user_address"));
                user.setNotes(rs.getString("user_notes"));
                user.setEmail(rs.getString("user_email"));
                user.setRole(rs.getInt("role_id"));
                user.setPhone(rs.getString("user_phone"));
                return user;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public void mapField(PreparedStatement preparedStatement, User user) throws SQLException {
            int i = 1;
            preparedStatement.setString(i++, user.getName());
            preparedStatement.setString(i++, user.getPassword());
            preparedStatement.setString(i++, user.getPhone());
            preparedStatement.setString(i++, user.getEmail());
            preparedStatement.setString(i++, user.getAddress());
            preparedStatement.setInt(i, user.getRole());
        }
    }
}
