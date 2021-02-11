package com.finalTask.tsk.domain;

import java.sql.Timestamp;

public class Invoice extends Entity {

    private long code;
    private String userName;
    private boolean isPaid;
    private byte statusId;
    private Timestamp date;
    private String notes;

    public long getCode() {
        return code;
    }
    public String getUserName() {
        return userName;
    }
    public boolean isPaid() {
        return isPaid;
    }
    public byte getStatusId() {
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
