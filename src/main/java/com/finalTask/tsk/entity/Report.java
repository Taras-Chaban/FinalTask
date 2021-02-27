package com.finalTask.tsk.entity;

import java.sql.Timestamp;

public class Report extends Entity {
    private String reportType;
    private Timestamp date;
    private int cashBefore;
    private int cashAfter;
    private int currentCash;

    public String getReportType() {
        return reportType;
    }
    public Timestamp getDate() {
        return date;
    }
    public int getCashBefore() {
        return cashBefore;
    }
    public int getCashAfter() {
        return cashAfter;
    }
    public int getCurrentCash() {
        return currentCash;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
    public void setCashBefore(int cashBefore) {
        this.cashBefore = cashBefore;
    }
    public void setCashAfter(int cashAfter) {
        this.cashAfter = cashAfter;
    }
    public void setCurrentCash(int currentCash) {
        this.currentCash = currentCash;
    }
}
