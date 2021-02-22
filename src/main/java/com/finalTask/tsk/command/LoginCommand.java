package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.Path;
import com.finalTask.tsk.dao.UserDao;
import com.finalTask.tsk.entity.Role;
import com.finalTask.tsk.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        String forward = Path.ERROR_PAGE;
        String errorMessage;

        if (!isAuthDataEmpty(name, password)) {
            errorMessage = "Name or password cannot be empty";
            request.setAttribute("errorMessage", errorMessage);
            return forward;
        }

        User user = new UserDao().findUserByName(name);

        forward = Path.LOGIN_PAGE;

        if (user == null || !password.equals(user.getPassword())) {
            errorMessage = "User doesnt registered or wrong password";
            request.setAttribute("errorMessage", errorMessage);
            return forward;
        }

        Role userRole = Role.getRole(user);

        forward = Path.START_PAGE;

        session.setAttribute("user", user);
        session.setAttribute("userRole", userRole);

        return forward;
    }

    private static boolean isAuthDataEmpty(String name, String password) {
        return name != null && password != null && !name.isEmpty() && !password.isEmpty();
    }
}
