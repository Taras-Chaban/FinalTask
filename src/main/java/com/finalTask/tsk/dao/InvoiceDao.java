package com.finalTask.tsk.dao;

import com.finalTask.tsk.DB.PoolConnectionBuilder;
import com.finalTask.tsk.entity.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InvoiceDao {
    //private static final String SQL_GET_INVOICE_CODE = "SELECT invoice_code FROM project.invoices";
    private static final String SQL_GET_COUNT_OF_ROWS = "SELECT count(invoice_id) from project.invoices";
    private static final String SQL_GET_INVOICES =
            "SELECT  user_name," +
                    "invoice_date," +
                    "invoice_code," +
                    "invoice_price," +
                    "status_id FROM project.invoices WHERE invoice_id > ? AND invoice_id < ?";

    public int getCountOfRows() {
        return new UserDao().getInt(SQL_GET_COUNT_OF_ROWS);
    }

    public ArrayList<Invoice> getInvoices(int start, int end) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_INVOICES);
            //set range for get products
            preparedStatement.setLong(1, start);
            preparedStatement.setLong(2, end);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Invoice invoice = new Invoice();
                invoice.setUserName(resultSet.getString("user_name"));
                invoice.setDate(resultSet.getTimestamp("invoice_date"));
                invoice.setCode(resultSet.getLong("invoice_code"));
                invoice.setPrice(resultSet.getDouble("invoice_price"));
                invoice.setStatusId(resultSet.getInt("status_id"));
                invoices.add(invoice);
            }

        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }

        return invoices;
    }

    /*
    public ArrayList<Invoice> getAllInvoices() {
        ArrayList<Invoice> invoices = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_INVOICE_CODE);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Invoice invoice = new Invoice();
                invoice.setUserName(resultSet.getString("user_name"));
                invoice.setDate(resultSet.getTimestamp("invoice_date"));
                invoice.setCode(resultSet.getLong("invoice_code"));
                invoice.setPrice(resultSet.getDouble("invoice_price"));
                invoice.setStatusId(resultSet.getInt("status_id"));
                invoices.add(invoice);
            }

        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }

        return invoices;
    }

     */
}
