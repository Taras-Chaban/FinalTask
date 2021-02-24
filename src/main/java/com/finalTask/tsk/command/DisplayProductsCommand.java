package com.finalTask.tsk.command;

import com.finalTask.tsk.constants.ForwardPath;
import com.finalTask.tsk.dao.ProductDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayProductsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        final int PRODUCTS_NUMBER_ON_PAGE = 10;

        ProductDao dao = new ProductDao();

        int rows = dao.getCountOfRows();

        int pages = (int) Math.round(rows / PRODUCTS_NUMBER_ON_PAGE + 0.5);

        int currentPage = Integer.parseInt(request.getParameter("page"));

        int start = (currentPage * PRODUCTS_NUMBER_ON_PAGE) - PRODUCTS_NUMBER_ON_PAGE + 1;

        request.setAttribute("products", dao.getProducts(start, start + PRODUCTS_NUMBER_ON_PAGE - 1));
        request.setAttribute("numOfPages", pages);
        request.setAttribute("currentPage", currentPage);


        return ForwardPath.GOODS_PAGE;
    }


}
