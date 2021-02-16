package com.finalTask.tsk.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "mainServlet", value = "/mainServlet")
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        PrintWriter printWriter = response.getWriter();


        HttpSession session = request.getSession();

        Integer counter = (Integer) session.getAttribute("count");

        if (counter == null) {
            session.setAttribute("count", 1);
            counter = 1;
        } else {
            session.setAttribute("count", counter + 1);
        }



        printWriter.println("<html>");

        printWriter.println("<h1> Your count: " + counter + "</h1>");
        //printWriter.println("<h1> command = " + command + " </h1>");
        printWriter.println("</html>");
        //request.getRequestDispatcher("/empty.jsp").forward(request, response);
        //response.sendRedirect("/WebApp_war/empty.jsp");
    }
}
