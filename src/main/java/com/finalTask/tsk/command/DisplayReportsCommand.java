package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.ForwardPath;
import com.finalTask.tsk.dao.ReportDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayReportsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 

        request.setAttribute("reports", new ReportDao().getReports());

        return ForwardPath.REPORTS_PAGE;
    }
}
