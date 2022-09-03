<%--
  Created by IntelliJ IDEA.
  User: zhouxiangyang
  Date: 2021/12/20
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
        <%--展示错误信息的div--%>
        <div id="errorMsg"><font color="red">${register_msg}</font></div>
    </div>
    <form id="reg-form" action="/CookieSessionLoginRegister/registerServlet" method="get">
        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg" style="display: none">用户名不太受欢迎</span>
                </td>

            </tr>
            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>
            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img src="/CookieSessionLoginRegister/checkCodeServlet" id="checkCodeImg" onclick="changeImage()">
                    <a href="#" id="changeImg" onclick="changeImage()">看不清？</a>
                </td>
            </tr>
        </table>
        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>
<script>
    function changeImage() {
        console.log("changeImage");
        //修改image标签的src属性
        document.querySelector("#checkCodeImg").src="/CookieSessionLoginRegister/checkCodeServlet?"+new Date().getTime()
    }
</script>
</body>
</html>
