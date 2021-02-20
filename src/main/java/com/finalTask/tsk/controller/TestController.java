package com.finalTask.tsk.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TestController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/WEB-INF/view/goods.jsp").forward(request, response);
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<h1>TO create user</h1><br/>");
        printWriter.println("<h1> User name: " + name + "</h1><br/>");
        printWriter.println("<h1> User pass: " + password + " </h1><br/>");
        printWriter.println("<h1> User phone: " + phone + "</h1><br/>");
        printWriter.println("<h1> User email: " + email + "</h1><br/>");
        printWriter.println("<h1> User address: " + address + "</h1><br/>");
        printWriter.println("</html>");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String command = request.getParameter("command");
//        PrintWriter printWriter = response.getWriter();
//
//
//        HttpSession session = request.getSession();
//
//        Integer counter = (Integer) session.getAttribute("count");
//
//        if (counter == null) {
//            session.setAttribute("count", 1);
//            counter = 1;
//        } else {
//            session.setAttribute("count", counter + 1);
//        }



//        printWriter.println("<html>");

        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);




        //printWriter.println("<h1> Your count: " + counter + "</h1>");
        //printWriter.println("<h1> command = " + command + " </h1>");
//        printWriter.println("</html>");
        //request.getRequestDispatcher("/empty.jsp").forward(request, response);
        //response.sendRedirect("/WebApp_war/empty.jsp");
    }
}
