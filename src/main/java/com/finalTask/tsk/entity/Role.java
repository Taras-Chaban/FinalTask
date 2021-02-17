package com.finalTask.tsk.entity;

public enum Role {
    CASHIER,
    SENIOR_CASHIER,
    MERCHANT,
    ADMIN;
    public static Role getRole(User user) {
        return Role.values()[user.getRole()];
    }
}
