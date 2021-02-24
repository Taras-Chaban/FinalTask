<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Cash Register</title>
    <link rel="stylesheet" type="text/css" href="resources/styles/style.css"/>
    <script src="https://kit.fontawesome.com/70d19259f2.js" crossorigin="anonymous"></script>
    <script src="resources/scripts/modal.js"></script>
</head>
<body>
<div class="sidebar" onclick="performClose()">
    <header><i class="fas fa-cash-register"></i> Cash Register</header>
    <ul>
        <div class="blocks">
            <p>МОЯ КАСА</p>
            <div class="lineBlocks">
                <li>
                    <a href="/WebApp_war/main?command=sales_forward"
                    ><i class="fas fa-arrow-alt-circle-right"></i> Продаж</a
                    >
                </li>
            </div>
            <div class="lineBlocks">
                <li>
                    <a href="/WebApp_war/main?command=refunds_forward"
                    ><i class="fas fa-arrow-alt-circle-left"></i> Повернення</a
                    >
                </li>
            </div>
            <div class="lineBlocks">
                <li>
                    <a href="/WebApp_war/main?command=reports_forward"
                    ><i class="far fa-list-alt"></i> Звіти</a
                    >
                </li>
            </div>
        </div>
        <div class="blocks">
            <p>УПРАВЛІННЯ</p>
            <div class="lineBlocks">
                <li>
                    <a style="color: white" href="/WebApp_war/main?command=display_users&page=1"
                    ><i class="fas fa-chalkboard-teacher"></i> Касири</a
                    >
                </li>
            </div>
            <div class="lineBlocks">
                <li>
                    <a href="/WebApp_war/main?command=display_archive&page=1"
                    ><i class="fas fa-clipboard-list"></i> Архів чеків</a
                    >
                </li>
            </div>
            <div class="lineBlocks">
                <li>
                    <a href="/WebApp_war/main?command=display_product&page=1"
                    ><i class="fas fa-barcode"></i> Товари</a
                    >
                </li>
            </div>
        </div>
        <div class="blocks">
            <p>МОЯ ОРГАНІЗАЦІЯ</p>
            <div class="lineBlocks">
                <li>
                    <a href="/WebApp_war/main?command=welcome_forward"
                    ><i class="fas fa-city"></i> Дані організації</a
                    >
                </li>
            </div>
            <div class="lineBlocks">
                <li>
                    <a href="/WebApp_war/main?command=payment_forward"
                    ><i class="fab fa-cc-visa"></i> Оплата</a
                    >
                </li>
            </div>
            <div class="lineBlocks">
                <li>
                    <a href="#"><i class="fas fa-power-off"></i> Вихід</a>
                </li>
            </div>
        </div>
    </ul>
</div>

<div class="content">
    <h1>Касири</h1>
    <button id="click" onclick="show()" class="gradient-button">
        <span>Додати касира</span>
    </button>

    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.getId()}" /></td>
                <td><c:out value="${user.getName()}" /></td>
                <td><c:out value="${user.getPassword()}" /></td>
                <td><c:out value="${user.getPhone()}" /></td>
                <td><c:out value="${user.getEmail()}" /></td>
                <td><c:out value="${user.getAddress()}" /></td>
                <td><c:out value="${user.getRole()}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--Pagination--%>
    <div class="pagination_menu">
        <c:if test="${currentPage != 1}">
            <a class="pagination" href="main?command=display_users&page=${currentPage - 1}">&laquo;</a>
        </c:if>
        <%--For displaying Page numbers.--%>
        <c:forEach begin="1" end="${numOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <a class="current-page">${i}</a>
                </c:when>
                <c:otherwise>
                    <a href="main?command=display_users&page=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <%--For displaying Next link--%>
        <c:if test="${currentPage < numOfPages}">
            <a href="main?command=display_users&page=${currentPage + 1}">&raquo;</a>
        </c:if>
    </div>

    <dialog id="dialog">
        <div class="registration_form">
            <div class="close-icon">
                <i onclick="performClose()" class="far fa-times-circle"></i>
            </div>
            <form method="post" action="/WebApp_war/main" class="form">
                <input type="hidden" name="command" value="registration" />
                <input type="hidden" name="command" value="registration" />
                <input type="hidden" name="command" value="registration" />
                <div class="gradient-border">
                    <input
                            type="text"
                            name="name"
                            size="36"
                            placeholder="Name"
                            class="input"
                    />
                </div>
                <div class="gradient-border">
                    <input
                            type="password"
                            name="password"
                            size="36"
                            placeholder="Password"
                            class="input"
                    />
                </div>
                <div class="gradient-border">
                    <input
                            type="text"
                            name="phone"
                            size="36"
                            placeholder="phone"
                            class="input"
                    />
                </div>
                <div class="gradient-border">
                    <input
                            type="text"
                            name="email"
                            size="36"
                            placeholder="Email"
                            class="input"
                    />
                </div>
                <div class="gradient-border">
                    <input
                            type="text"
                            name="address"
                            size="36"
                            placeholder="address"
                            class="input"
                    />
                </div>
                <div class="gradient-border">
                    <select id="roles" name="role" class="input select">
                        <option value="1">Касир</option>
                        <option value="2">Старший касир</option>
                        <option value="3">Товарознавець</option>
                    </select>
                </div>
                <button onclick="performClose()" class="gradient-button is-small">
                    Sign Up
                </button>
            </form>
        </div>
    </dialog>
</div>
</body>
</html>
