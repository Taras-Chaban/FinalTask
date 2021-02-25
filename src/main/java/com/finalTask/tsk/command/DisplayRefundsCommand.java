package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.ForwardPath;
import com.finalTask.tsk.dao.InvoiceDao;
import com.finalTask.tsk.dao.PaymentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayRefundsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("invoices", new InvoiceDao().getInvoices(0, Integer.MAX_VALUE));
        request.setAttribute("payments", new PaymentDao().getPayments());

        return ForwardPath.REFUNDS_PAGE;
    }
}
