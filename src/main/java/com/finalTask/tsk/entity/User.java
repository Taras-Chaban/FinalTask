package com.finalTask.tsk.entity;

public class User extends Entity {

    //User data
    private String name;
    private String password;
    private String phone;
    private String email;
    private String address;
    private Integer role;
    private String notes;

    //constructors

    public User() {}

    public User(String name, String password, String phone, String email, String address, Integer role) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.role = role;
    }

//getters

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

