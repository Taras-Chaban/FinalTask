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
            <div class="lineBlocks"><li><a style="color: white" href="#"><i class="far fa-list-alt"></i> Звіти</a></li></div>
        </div>
        <div class="blocks">
            <p>УПРАВЛІННЯ</p>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=reg_forward"><i class="fas fa-chalkboard-teacher"></i> Касири</a></li></div>
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

<div class="content">
    <h1>Звіти</h1></br></br>
</div>

</body>
</html>
