<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <!--===============================================================================================-->
    <!-- <base src= "http://localhost:8080/WebApp_war/"/> -->
    <link rel="stylesheet" type="text/css" href="resources/styles/main.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <div class="login100-pic js-tilt" data-tilt>
                <img src="resources/images/img-01.png" alt="IMG">
            </div>

            <form class="login100-form validate-form" action="/WebApp_war/main">
					<span class="login100-form-title">
						Member Login
					</span>
                <input type="hidden" name="command" value="login">

                <div class="wrap-input100 validate-input">
                    <label>
                        <input class="input100" type="text" name="name" placeholder="Name">
                    </label>
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                </div>

                <div class="wrap-input100 validate-input" data-validate = "Password is required">
                    <label>
                        <input class="input100" type="password" name="password" placeholder="Password">
                    </label>
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
</body>
</html>
