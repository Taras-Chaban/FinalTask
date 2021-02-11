package com.finalTask.tsk.entity;

public class Payment extends Entity {

    private Long invoiceCode;
    private String productCode;
    private Double quantity;
    private Double value;
    private Byte statusId;
    private String notes;

    public Long getInvoiceCode() {
        return invoiceCode;
    }
    public String getProductCode() {
        return productCode;
    }
    public Double getQuantity() {
        return quantity;
    }
    public Double getValue() {
        return value;
    }
    public Byte getStatusId() {
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
