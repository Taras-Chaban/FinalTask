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
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=refunds_forward"><i class="fas fa-arrow-alt-circle-left"></i> Повернення</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=reports_forward"><i class="far fa-list-alt"></i> Звіти</a></li></div>
        </div>
        <div class="blocks">
            <p>УПРАВЛІННЯ</p>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=display_users&page=1"><i class="fas fa-chalkboard-teacher"></i> Касири</a></li></div>
            <div class="lineBlocks"><li><a style="color: white" href="/WebApp_war/main?command=display_archive&page=1"><i class="fas fa-clipboard-list"></i> Архів чеків</a></li></div>
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
    <h1>Архів чеків</h1></br></br>
    <div class="table-wrapper">
        <table class="table">
            <thead>
            <tr>
                <th>Cashier</th>
                <th>Date</th>
                <th>Code</th>
                <th>Price</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="invoice" items="${invoices}">
                <tr>
                    <td><c:out value="${invoice.getUserName()}"/></td>
                    <td><c:out value="${invoice.getDate()}"/></td>
                    <td><c:out value="${invoice.getCode()}"/></td>
                    <td><c:out value="${invoice.getPrice()}"/></td>
                    <td><c:out value="${invoice.getStatusId()}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%--Pagination--%>
    <div class="pagination_menu">
        <c:if test="${currentPage != 1}">
            <a class="pagination" href="main?command=display_archive&page=${currentPage - 1}">&laquo;</a>
        </c:if>
        <%--For displaying Page numbers.--%>
        <c:forEach begin="1" end="${numOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <a class="current-page">${i}</a>
                </c:when>
                <c:otherwise>
                    <a href="main?command=display_archive&page=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <%--For displaying Next link--%>
        <c:if test="${currentPage < numOfPages}">
            <a href="main?command=display_archive&page=${currentPage + 1}">&raquo;</a>
        </c:if>
    </div>
</div>

</body>
</html>
