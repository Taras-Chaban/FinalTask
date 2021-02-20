<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 17.02.2021
  Time: 1:42 дп
  To change this template use File | Settings | File Templates.
--%>
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
            <div class="lineBlocks"><li><a style="color: white" href="#"><i class="fas fa-chalkboard-teacher"></i> Касири</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=archive_forward"><i class="fas fa-clipboard-list"></i> Архів чеків</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=goods_forward"><i class="fas fa-barcode"></i> Товари</a></li></div>
        </div>
        <div class="blocks">
            <p>МОЯ ОРГАНІЗАЦІЯ</p>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=welcome_forward"><i class="fas fa-city"></i> Дані організації</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=payment_forward"><i class="fab fa-cc-visa"></i> Оплата</a></li></div>
            <div class="lineBlocks"><li><a href="#"><i class="fas fa-power-off"></i> Вихід</a> </li></div>
        </div>
    </ul>
</div>

<script type="text/javascript">
    function show() {
        document.getElementById("dialog").showModal();
    }

    function performClose() {
        document.getElementById("dialog").close();
    }
</script>

<div class="content">
    <h1>Касири</h1></br></br>
    <button id="click" onclick="show()">
        <span>Додати касира</span>
    </button>

    <dialog id="dialog">
        <div class="registration_form">
            <p><i onclick="performClose()" class="far fa-times-circle"></i></p>
            <form method="get" action="/WebApp_war/main">
                <input type="hidden" name="command" value="registration">
                <input type="text" name="name" size="36" placeholder="Name"/><br/><br/>
                <input type="password" name="password" size="36" placeholder="Password"/><br/><br/>
                <input type="text" name="phone" size="36" placeholder="phone"/><br/><br/>
                <input type="text" name="email" size="36" placeholder="Email"/><br/><br/>
                <input type="text" name="address" size="36" placeholder="address"/><br/><br/>
                <label for="roles">Оберіть посаду:</label>
                <select id="roles" name="role">
                    <option value="1">Касир</option>
                    <option value="2">Старший касир</option>
                    <option value="3">Товарознавець</option>
                </select>
                <button onclick="performClose()">Sign Up</button>
            </form>
        </div>
    </dialog>

</div>
</body>
</html>
