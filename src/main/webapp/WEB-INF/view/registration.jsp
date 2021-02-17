<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 17.02.2021
  Time: 1:42 дп
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<h1>Registration for customer</h1>
<div class = index_div>
    <form name="LoginForm" method="post">
        <input type="text" name="name" size="36" placeholder="Name"/><br/><br/>
        <input type="password" name="password" size="36" placeholder="Password"/><br/><br/>
        <input type="text" name="phone" size="36" placeholder="phone"/><br/><br/>
        <input type="text" name="email" size="36" placeholder="Email"/><br/><br/>
        <input type="text" name="address" size="36" placeholder="address"/><br/><br/>
        <button>Sign Up</button>
    </form>
</div>
</body>
</html>
