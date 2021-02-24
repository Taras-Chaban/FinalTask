<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Cash Register</title>
    <link rel="stylesheet" type="text/css" href="resources/styles/style.css"/>
    <script src="https://kit.fontawesome.com/70d19259f2.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="sidebar">
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
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=display_archive&page=1"><i class="fas fa-clipboard-list"></i> Архів чеків</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=display_product&page=1"><i class="fas fa-barcode"></i> Товари</a></li></div>
        </div>
        <div class="blocks">
            <p>МОЯ ОРГАНІЗАЦІЯ</p>
            <div class="lineBlocks"><li><a style="color: white" href="#"><i class="fas fa-city"></i> Дані організації</a></li></div>
            <div class="lineBlocks"><li><a href="/WebApp_war/main?command=payment_forward"><i class="fab fa-cc-visa"></i> Оплата</a></li></div>
            <div class="lineBlocks"><li><a href="#"><i class="fas fa-power-off"></i> Вихід</a> </li></div>
        </div>
    </ul>
</div>

<div class="content">
    <h1>Моя Організація</h1></br></br>
    <table border="0" width="1400px" cellspacing="20">
        <tr><td>Найменування</td><td>ТОВ ІВАНЧЕНКО ІВАН</td></tr>
        <tr><td>Коротка назва</td><td>Іван</td></tr>
        <tr><td>ЄДРПОУ</td><td>33880213</td></tr>
        <tr><td>Податковий номер</td><td>67548210239</td></tr>
        <tr><td>Тип платника</td><td>Товариство з обмеженою відповідальністю</td></tr>
        <tr><td>Директор</td><td>Іван Іванович Іванченко</td></tr>
    </table>
</div>
</body>
</html>