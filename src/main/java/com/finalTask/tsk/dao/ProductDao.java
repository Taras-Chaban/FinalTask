package com.finalTask.tsk.dao;

import com.finalTask.tsk.DB.PoolConnectionBuilder;
import com.finalTask.tsk.entity.EntityMap;
import com.finalTask.tsk.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
    private static final String SQL_ADD_PRODUCT = "INSERT INTO project.products " +
            "(product_code, product_name_en, product_cost, product_quantity) " +
            " VALUES (?, ?, ?, ?)";
    private static final String SQL_GET_PRODUCTS = "SELECT " +
            "product_id, " +
            "product_code, " +
            "product_name_en, " +
            "product_cost, " +
            "product_quantity" +
            " FROM project.products WHERE product_id >= ? AND product_id <= ?";

    public ArrayList<Product> getProducts(Long start, Long end) {
        ArrayList<Product> products = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_PRODUCTS);
            //set range for get products
            preparedStatement.setLong(1, start);
            preparedStatement.setLong(2, end);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("product_id"));
                product.setCode(resultSet.getString("product_code"));
                product.setNameEn(resultSet.getString("product_name_en"));
                product.setCost(resultSet.getDouble("product_cost"));
                product.setQuantity(resultSet.getDouble("product_quantity"));
                products.add(product);
            }

        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }
        return products;
    }

    public void addProduct(Product product) {
        Connection connection = null;
        PreparedStatement preparedStatement;
        try {
            connection = PoolConnectionBuilder.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(SQL_ADD_PRODUCT);
            //map product fields to prepared statement
            new ProductDao.ProductMapper().mapField(preparedStatement, product);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            PoolConnectionBuilder.getInstance().rollbackAndClose(connection);
            e.printStackTrace();
        } finally {
            PoolConnectionBuilder.getInstance().commitAndClose(connection);
        }
    }

    private static class ProductMapper implements EntityMap<Product> {

        @Override
        public Product mapRow(ResultSet rs) {
            try {
                Product product = new Product();
                product.setId(rs.getLong("product_id"));
                product.setCode(rs.getString("product_code"));
                product.setAvailable(rs.getBoolean("is_available"));
                product.setNameUa(rs.getString("product_name_en"));
                product.setCost(rs.getDouble("product_cost"));
                product.setQuantity(rs.getDouble("product_quantity"));
                product.setReservedQuantity(rs.getDouble("reserved_quantity"));
                return product;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public void mapField(PreparedStatement preparedStatement, Product product) throws SQLException {
            int i = 1;
            preparedStatement.setString(i++, product.getCode());
            preparedStatement.setString(i++, product.getNameEn());
            preparedStatement.setDouble(i++, product.getCost());
            preparedStatement.setDouble(i++, product.getQuantity());
        }
    }

}
