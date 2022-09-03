<%--
  Created by IntelliJ IDEA.
  User: zhouxiangyang
  Date: 2021/12/20
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="https://tomcat.apache.org/cookie_decode_func" prefix="func" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>
<body>
<div id="loginDiv" style="height: 350px">
    <form action="loginServlet" id="form" method="post">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${login_msg}</div>

        <p>Username:<input id="username" name="username" type="text" value="${func:cookieDecode(cookie.username.value)}"></p>
        <p>Password:<input id="password" name="password" type="password" value="${func:cookieDecode(cookie.password.value)}"></p>
        <p>Remember:<input id="remember" name="remember" type="checkbox" value="yes" ${cookie.password == null ? "" : "checked"}></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>
