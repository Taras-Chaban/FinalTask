package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.TreeMap;

public class ForwardCommand implements Command {
    private static final Map<String, String> forwards = new TreeMap<>();

    static {
        forwards.put("reg_forward", Path.REGISTRATION_PAGE);
        forwards.put("welcome_forward", Path.START_PAGE);
        forwards.put("goods_forward", Path.GOODS_PAGE);
        forwards.put("payment_forward", Path.PAYMENT_PAGE);
        forwards.put("refunds_forward", Path.REFUNDS_PAGE);
        forwards.put("reports_forward", Path.REPORTS_PAGE);
        forwards.put("sales_forward", Path.SALES_PAGE);
        forwards.put("archive_forward", Path.ARCHIVE_PAGE);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forward = request.getParameter("command");

        return forwards.get(forward);
    }
}
