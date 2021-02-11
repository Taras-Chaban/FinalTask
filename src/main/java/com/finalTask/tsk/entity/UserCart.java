package com.finalTask.tsk.entity;

import java.util.HashMap;
import java.util.Map;

public class UserCart {
    private String userName;
    private String orderDescription;
    private Double amount;
    private Map<String, Double> products;

    public UserCart(String userName) {
        this.userName = userName;
        products = new HashMap<>();
    }

    public String getUserName() {
        return userName;
    }
    public String getOrderDescription() {
        return orderDescription;
    }
    public Double getAmount() {
        return amount;
    }
    public Map<String, Double> getProducts() {
        return products;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public void setProducts(Map<String, Double> products) {
        this.products = products;
    }

    public void addProduct(String productCode, Double quantity) {
        if (!products.containsKey(productCode)) {
            products.put(productCode, quantity);
        } else {
            products.replace(productCode, products.get(productCode) + quantity);
        }
    }
    public void removeProduct(String productCode) {
        products.remove(productCode);
    }
    public void cleanCart() {
        products.clear();
    }
}
