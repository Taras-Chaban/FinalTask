package com.finalTask.tsk.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookieId = new Cookie("userId","");
        Cookie cookieName = new Cookie("userName", "");
        Cookie cookieAge = new Cookie("userAge", "");

        cookieId.setMaxAge(1);
        cookieName.setMaxAge(1);
        cookieAge.setMaxAge(1);

        response.addCookie(cookieId);
        response.addCookie(cookieName);
        response.addCookie(cookieAge);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
