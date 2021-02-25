package com.finalTask.tsk.dao;

import com.finalTask.tsk.DB.PoolConnectionBuilder;
import com.finalTask.tsk.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDao {
    private static final String SQL_DELETE_PAYMENT_BY_ID = "DELETE FROM project.payments WHERE payment_id = ?";
    private static final String SQL_GET_PAYMENTS = "SELECT payment_id, invoice_code, product_code, quantity, payment_value FROM project.payments";

    public ArrayList<Payment> getPayments() {
            ArrayList<Payment> payments = new ArrayList<>();
            Connection connection = null;
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            try {
                connection = PoolConnectionBuilder.getInstance().getConnection();
                preparedStatement = connection.prepareStatement(SQL_GET_PAYMENTS);
                //set range for get products
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Payment payment = new Payment();
                    payment.setInvoiceCode(resultSet.getLong("invoice_code"));
                    payment.setProductCode(resultSet.getString("product_code"));
                    payment.setQuantity(resultSet.getDouble("quantity"));
                    payment.setValue(resultSet.getDouble("payment_value"));
                    payment.setId(resultSet.getLong("payment_id"));
                    payments.add(payment);
                }

            } catch (SQLException e) {
                PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
                e.printStackTrace();
            } finally {
                PoolConnectionBuilder.getInstance().commitAndClose(connection);
            }
            return payments;
    }

    public void deletePaymentById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement;
        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_PAYMENT_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }
    }
}
