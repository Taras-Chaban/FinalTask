<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 31.01.2021
  Time: 1:05 дп
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../../resources/styles/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="../../resources/images/img-01.png" alt="IMG">
            </div>

            <form class="login100-form validate-form">
					<span class="login100-form-title">
						Member Login
					</span>

                <div class="wrap-input100 validate-input">
                    <input class="input100" type="text" name="name" placeholder="Name">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Password is required">
                    <input class="input100" type="password" name="password" placeholder="Password">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Login
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</html>
