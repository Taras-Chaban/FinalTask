package com.finalTask.tsk.DB;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {

    private static DBManager instance;

    private static InitialContext ctx;

    private DBManager() {
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection openDostyp() {
        try {
            Context context = (Context) ctx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) context.lookup("jdbc/root");
            return dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public void test() throws SQLException {
        Connection connection = DriverManager.getConnection("");
    }
}
