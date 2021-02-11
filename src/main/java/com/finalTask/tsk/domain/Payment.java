package com.finalTask.tsk.domain;

public class Payment extends Entity {

    private long invoiceCode;
    private String productCode;
    private double quantity;
    private double value;
    private byte statusId;
    private String notes;

    public long getInvoiceCode() {
        return invoiceCode;
    }
    public String getProductCode() {
        return productCode;
    }
    public double getQuantity() {
        return quantity;
    }
    public double getValue() {
        return value;
    }
    public byte getStatusId() {
        return statusId;
    }
    public String getNotes() {
        return notes;
    }

    public void setInvoiceCode(long invoiceCode) {
        this.invoiceCode = invoiceCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public void setStatusId(byte statusId) {
        this.statusId = statusId;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
