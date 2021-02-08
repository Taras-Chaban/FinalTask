package com.finalTask.tsk.domain;

public class UserRequest {
    //User data

    private int id;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String address;
    private int role;
    private String notes;

    //constructors

    public UserRequest() {}

    public UserRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getRole() {
        return role;
    }

    public String getNotes() {
        return notes;
    }

    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
