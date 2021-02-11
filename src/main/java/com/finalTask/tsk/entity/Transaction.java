package com.finalTask.tsk.entity;

import java.sql.Timestamp;

public class Transaction extends Entity {

    private Integer paymentId;
    private Long invoiceCode;
    private String userName;
    private String transactionType;
    private Double paymentValue;
    private Timestamp time;
    private String notes;

    public Integer getPaymentId() {
        return paymentId;
    }
    public Long getInvoiceCode() {
        return invoiceCode;
    }
    public String getUserName() {
        return userName;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public Double getPaymentValue() {
        return paymentValue;
    }
    public Timestamp getTime() {
        return time;
    }
    public String getNotes() {
        return notes;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
    public void setInvoiceCode(Long invoiceCode) {
        this.invoiceCode = invoiceCode;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public void setPaymentValue(Double paymentValue) {
        this.paymentValue = paymentValue;
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
