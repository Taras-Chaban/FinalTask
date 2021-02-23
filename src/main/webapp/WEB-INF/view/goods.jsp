<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <a href="/WebApp_war/main?command=sales_forward">
                        <i class="fas fa-arrow-alt-circle-right"></i> Продаж</a>
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
                    <a href="/WebApp_war/main?command=reg_forward"
                    ><i class="fas fa-chalkboard-teacher"></i> Касири</a
                    >
                </li>
            </div>
            <div class="lineBlocks">
                <li>
                    <a href="/WebApp_war/main?command=archive_forward"
                    ><i class="fas fa-clipboard-list"></i> Архів чеків</a
                    >
                </li>
            </div>
            <div class="lineBlocks">
                <li>
                    <a style="color: white" href="#"
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

<dialog id="dialog">
    <div class="registration_form">
        <div class="close-icon">
            <i onclick="performClose()" class="far fa-times-circle"></i>
        </div>
        <form method="post" action="/WebApp_war/main" class="form">
            <input type="hidden" name="command" value="add_product"/>
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
                        type="text"
                        name="product_code"
                        size="36"
                        placeholder="Barcode"
                        class="input"
                />
            </div>
            <div class="gradient-border">
                <input
                        type="number"
                        name="product_cost"
                        size="36"
                        placeholder="Cost"
                        class="input number-input"
                        min="0"
                />
            </div>
            <div class="gradient-border">
                <input
                        type="number"
                        name="quantity"
                        size="36"
                        placeholder="Quantity"
                        class="input number-input"
                        min="0"
                />
            </div>
            <button class="gradient-button is-small">
                Add
            </button>
        </form>
    </div>
</dialog>

<div class="content">
    <h1>Товари</h1>
    <button class="gradient-button" onclick="show()">
        <span>Додати товари</span>
    </button>
    <div class="table-wrapper">
        <table class="table">
            <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Barcode</th>
                <th>Cost</th>
                <th>Quantity</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td><c:out value="${product.getId()}"/></td>
                    <td><c:out value="${product.getNameEn()}"/></td>
                    <td><c:out value="${product.getCode()}"/></td>
                    <td><c:out value="${product.getCost()}"/></td>
                    <td><c:out value="${product.getQuantity()}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</body>
</html>
