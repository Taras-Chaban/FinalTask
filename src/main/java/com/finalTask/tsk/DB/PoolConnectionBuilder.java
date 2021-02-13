package com.finalTask.tsk.DB;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder {

    private static PoolConnectionBuilder instance;
    private DataSource dataSource;

    public static synchronized PoolConnectionBuilder getInstance() {
        if (instance == null) {
            instance = new PoolConnectionBuilder();
        }
        return instance;
    }

    /**
     * Returns a DB connection from the Pool Connections.
     */

    private PoolConnectionBuilder() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/cashRegister");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void commitAndClose(Connection connection) {
        try {
            connection.commit();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void rollbackAndClose(Connection connection) {
        try {
            connection.rollback();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
