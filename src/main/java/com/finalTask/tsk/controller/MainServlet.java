package com.finalTask.tsk.controller;

import com.finalTask.tsk.command.Command;
import com.finalTask.tsk.command.CommandContainer;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response, "get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response, "post");
    }

    private void process(HttpServletRequest request, HttpServletResponse response, String method) throws IOException, ServletException {
        String commandName = request.getParameter("command");
        Command command = CommandContainer.get(commandName);

        String path = command.execute(request, response);

        if (path != null) {
            if (method.equals("get")) {
                request.getRequestDispatcher(path).forward(request, response);
            } else if (method.equals("post")) {
                response.sendRedirect(request.getContextPath() + path);
            }
        }
    }
}
