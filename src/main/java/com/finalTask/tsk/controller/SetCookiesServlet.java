package com.finalTask.tsk.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");


        Cookie cookieId = new Cookie("userId","228");
        Cookie cookieName = new Cookie("userName", name);
        Cookie cookieAge = new Cookie("userAge", age);

        cookieId.setMaxAge(3600 * 24);
        cookieName.setMaxAge(3600 * 24);
        cookieAge.setMaxAge(3600 * 24);

        response.addCookie(cookieId);
        response.addCookie(cookieName);
        response.addCookie(cookieAge);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
