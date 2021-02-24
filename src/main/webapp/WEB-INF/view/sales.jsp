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
<aside class="sidebar" onclick="performClose()">
    <header><i class="fas fa-cash-register"></i> Cash Register</header>
    <ul>
        <div class="blocks">
            <p>МОЯ КАСА</p>
            <div class="lineBlocks">
                <li>
                    <a style="color: white" href="#"
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
                    <a href="/WebApp_war/main?command=display_users&page=1"
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
</aside>

<div class="content">
    <h1>Продаж товару</h1>
    <button id="click" class="gradient-button">
        <span>Видати готівку</span>
    </button>
    <div class="two-column">
        <div class="table-wrapper">
            <table class="table">
                <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Cost</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>5</td>
                    <td>AAAA</td>
                    <td>51655.1312</td>
                    <td>
                        <button onclick="" class="gradient-button">
                            <span>→</span>
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="invoice">
            <div class="invoice-header">Invoice</div>
            <div class="box-star">
                <div class="check-star"></div>
            </div>
            <div class="container-price">
                <div class="goods-check">Кіт</div>
                <div class="box-count">
                    <span class="decrement"><i class="fas fa-minus"></i></span>
                    <div>1</div>
                    <span class="increment"><i class="fas fa-plus"></i></span>
                </div>
                <div class="box-price">
                    <div class="sum-price-wrapper">
                        <div>x20000₴</div>
                        <div class="price">x20000₴</div>
                    </div>
                    <button class="btn-sum"><span class="span-close">x</span></button>
                </div>
            </div>
            <div class="box-star">
                <div class="check-star"></div>
            </div>
            <div class="sum">
                <div>Sum all:</div>
                <div class="sum-number">
                    <div>20000 ₴</div>
                    <button class="btn-sum"><span class="span-close">x</span></button>
                </div>
            </div>
            <div class="btn-wrapper">
                <button class="btn-check">Видати чек →</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
