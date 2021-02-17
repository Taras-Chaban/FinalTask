package com.finalTask.tsk.controller;

import com.finalTask.tsk.command.Command;
import com.finalTask.tsk.command.CommandContainer;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String commandName = request.getParameter("command");
        Command command = CommandContainer.get(commandName);

        String forward = command.execute(request, response);

        if (forward != null) {
            request.getRequestDispatcher(forward).forward(request, response);
        }
    }
}
