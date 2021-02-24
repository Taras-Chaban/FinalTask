package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.ForwardPath;
import com.finalTask.tsk.dao.InvoiceDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayArchiveCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final int INVOICES_NUMBER_ON_PAGE = 10;

        InvoiceDao dao = new InvoiceDao();

        int rows = dao.getCountOfRows();

        int pages = (int) Math.round(rows / INVOICES_NUMBER_ON_PAGE + 0.5);

        int currentPage = Integer.parseInt(request.getParameter("page"));

        int start = currentPage * INVOICES_NUMBER_ON_PAGE - INVOICES_NUMBER_ON_PAGE + 1;

        request.setAttribute("invoices", dao.getInvoices(start, start + INVOICES_NUMBER_ON_PAGE - 1));
        request.setAttribute("numOfPages", pages);
        request.setAttribute("currentPage", currentPage);


        return ForwardPath.ARCHIVE_PAGE;
    }
}
