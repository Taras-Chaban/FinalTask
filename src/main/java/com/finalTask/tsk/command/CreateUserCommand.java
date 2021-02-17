package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.Path;
import com.finalTask.tsk.dao.UserDao;
import com.finalTask.tsk.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forward;

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String role = request.getParameter("role");

        if (!dataValidation(name, password, phone, email, address, role)) {
            forward = Path.ERROR_PAGE;
            return forward;
        }

        User user = new User(name, password, phone, email, address, Integer.parseInt(role));

        new UserDao().addUser(user);

        forward = request.getServletPath();

        return forward;
    }

    private static boolean dataValidation(String... userData) {
        for (String field : userData) {
            if (field == null) {
                return false;
            }
        }
        return true;
    }
}
