package com.finalTask.tsk.dao;

import com.finalTask.tsk.entity.UserRequest;
import com.finalTask.tsk.exeption.UserCheckExeption;
import org.junit.Assert;
import org.junit.Test;

public class UserCheckDaoTest {

    @Test
    public void checkUser() {
        UserRequest user = new UserRequest();
        user.setId(6);
        user.setName("Admin");
        user.setPassword("admin");
        user.setEmail("admin@company.com");
        user.setRole(4);

        UserCheckDao dao = new UserCheckDao();
        boolean result = false;
        try {
            result = dao.checkUser(user).isRegistered();
        } catch (UserCheckExeption userCheckExeption) {
            userCheckExeption.printStackTrace();
        }
        Assert.assertTrue(result);
    }
}