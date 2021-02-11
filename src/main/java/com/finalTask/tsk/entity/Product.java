package com.finalTask.tsk.entity;

public class Product extends Entity {

    private String code;
    private Boolean isAvailable;
    private String nameEn;
    private String nameUa;
    private String descriptionEn;
    private String descriptionUa;
    private Double cost;
    private Double quantity;
    private Double reservedQuantity;
    private String notesEn;
    private String notesUa;

    public String getCode() {
        return code;
    }
    public Boolean isAvailable() {
        return isAvailable;
    }
    public String getNameEn() {
        return nameEn;
    }
    public String getNameUa() {
        return nameUa;
    }
    public String getDescriptionEn() {
        return descriptionEn;
    }
    public String getDescriptionUa() {
        return descriptionUa;
    }
    public Double getCost() {
        return cost;
    }
    public Double getQuantity() {
        return quantity;
    }
    public Double getReservedQuantity() {
        return reservedQuantity;
    }
    public String getNotesEn() {
        return notesEn;
    }
    public String getNotesUa() {
        return notesUa;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    public void setNameUa(String nameUa) {
        this.nameUa = nameUa;
    }
    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
    public void setDescriptionUa(String descriptionUa) {
        this.descriptionUa = descriptionUa;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public void setReservedQuantity(double reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }
    public void setNotesEn(String notesEn) {
        this.notesEn = notesEn;
    }
    public void setNotesUa(String notesUa) {
        this.notesUa = notesUa;
    }
}
