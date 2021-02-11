package com.finalTask.tsk.entity;

import java.sql.Timestamp;

public class Invoice extends Entity {

    private Long code;
    private String userName;
    private Boolean isPaid;
    private Byte statusId;
    private Timestamp date;
    private String notes;

    public Long getCode() {
        return code;
    }
    public String getUserName() {
        return userName;
    }
    public Boolean isPaid() {
        return isPaid;
    }
    public Byte getStatusId() {
        return statusId;
    }
    public Timestamp getDate() {
        return date;
    }
    public String getNotes() {
        return notes;
    }

    public void setCode(long code) {
        this.code = code;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPaid(boolean paid) {
        isPaid = paid;
    }
    public void setStatusId(byte statusId) {
        this.statusId = statusId;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
