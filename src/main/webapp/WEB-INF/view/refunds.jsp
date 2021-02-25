<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Cash Register</title>
    <link rel="stylesheet" type="text/css" href="resources/styles/style.css"/>
    <script src="https://kit.fontawesome.com/70d19259f2.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="sidebar" onclick="performClose()">
    <header><i class="fas fa-cash-register"></i> Cash Register</header>
    <ul>
        <div class="blocks">
            <p>МОЯ КАСА</p>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=sales_forward"><i class="fas fa-arrow-alt-circle-right"></i> Продаж</a></li></div>
            <div class="lineBlocks"><li><a style="color: white" href="#"><i class="fas fa-arrow-alt-circle-left"></i> Повернення</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=reports_forward"><i class="far fa-list-alt"></i> Звіти</a></li></div>
        </div>
        <div class="blocks">
            <p>УПРАВЛІННЯ</p>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=display_users&page=1"><i class="fas fa-chalkboard-teacher"></i> Касири</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=display_archive&page=1"><i class="fas fa-clipboard-list"></i> Архів чеків</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=display_product&page=1"><i class="fas fa-barcode"></i> Товари</a></li></div>
        </div>
        <div class="blocks">
            <p>МОЯ ОРГАНІЗАЦІЯ</p>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=welcome_forward"><i class="fas fa-city"></i> Дані організації</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=payment_forward"><i class="fab fa-cc-visa"></i> Оплата</a></li></div>
            <div class="lineBlocks"><li><a href="#"><i class="fas fa-power-off"></i> Вихід</a> </li></div>
        </div>
    </ul>
</div>

<div class="content">
    <h1>Поверення товару</h1></br></br>

    <c:forEach var="invoice" items="${invoices}">
        <p>Invoice #: <c:out value="${invoice.getCode()}"></c:out></p>
        <form method="get" action="/WebApp_war/main">
            <input type="hidden" name="command" value="refund_payment">
        <div class="table-wrapper">
            <table class="table">
                <thead>
                <tr>
                    <th>Товари</th>
                    <th>Кількість</th>
                    <th>Вартість</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="payment" items="${payments}">
                    <c:if test="${invoice.getCode() == payment.getInvoiceCode()}">
                        <tr>
                            <td><c:out value="${payment.getProductCode()}"/></td>
                            <td><c:out value="${payment.getQuantity()}"/></td>
                            <td><c:out value="${payment.getValue()}"/></td>
                            <td>
                                <input type="checkbox" name="checked_payment${payment.getId()}" value="${payment.getId()}">
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <br/><br/>

        <input type="submit" value="Refund">
        </form>
    </c:forEach>
</div>
</body>
</html>
