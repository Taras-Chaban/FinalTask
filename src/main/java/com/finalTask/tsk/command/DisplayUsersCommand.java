package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.ForwardPath;
import com.finalTask.tsk.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayUsersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final int USERS_NUMBER_ON_PAGE = 10;

        UserDao dao = new UserDao();

        int rows = dao.getCountOfRows();

        int pages = (int) Math.round(rows / USERS_NUMBER_ON_PAGE + 0.5);

        int currentPage = Integer.parseInt(request.getParameter("page"));

        long start = currentPage * USERS_NUMBER_ON_PAGE - USERS_NUMBER_ON_PAGE + 1;

        request.setAttribute("users", dao.getUsers(start, start + USERS_NUMBER_ON_PAGE - 1));
        request.setAttribute("numOfPages", pages);
        request.setAttribute("currentPage", currentPage);


        return ForwardPath.REGISTRATION_PAGE;
    }
}
