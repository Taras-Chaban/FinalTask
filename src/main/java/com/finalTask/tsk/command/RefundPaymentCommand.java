package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.RedirectPath;
import com.finalTask.tsk.dao.PaymentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class RefundPaymentCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Set<String> paramNames = request.getParameterMap().keySet();
        PaymentDao dao = new PaymentDao();

        for (String name : paramNames) {
            String value = request.getParameter(name);
            if (!value.equals("refund_payment")) {
                dao.deletePaymentById(Integer.parseInt(value));
            }
        }

        return RedirectPath.REFUND_PAGE;
    }
}
