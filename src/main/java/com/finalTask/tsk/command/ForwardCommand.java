package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.ForwardPath;
import com.finalTask.tsk.dao.ProductDao;
import com.finalTask.tsk.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.TreeMap;

public class ForwardCommand implements Command {
    private static final Map<String, String> forwards = new TreeMap<>();

    private static final String GOODS_FORWARD = "goods_forward";
    private static final String REG_FORWARD = "reg_forward";

    static {
        forwards.put(REG_FORWARD, ForwardPath.REGISTRATION_PAGE);
        forwards.put("welcome_forward", ForwardPath.START_PAGE);
        forwards.put(GOODS_FORWARD, ForwardPath.GOODS_PAGE);
        forwards.put("payment_forward", ForwardPath.PAYMENT_PAGE);
        forwards.put("refunds_forward", ForwardPath.REFUNDS_PAGE);
        forwards.put("reports_forward", ForwardPath.REPORTS_PAGE);
        forwards.put("sales_forward", ForwardPath.SALES_PAGE);
        forwards.put("archive_forward", ForwardPath.ARCHIVE_PAGE);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forward = request.getParameter("command");

        if (forward.equals(GOODS_FORWARD)) {
            request.setAttribute("products", new ProductDao().getProducts(1L, 15L));
        } else if (forward.equals(REG_FORWARD)) {
            request.setAttribute("users", new UserDao().getUsers(1L, 15L));
        }

        return forwards.get(forward);
    }
}
