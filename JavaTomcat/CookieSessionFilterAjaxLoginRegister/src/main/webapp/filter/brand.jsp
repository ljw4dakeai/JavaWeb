<%@ page import="com.ljw4dakeai.com.ljw4dakeai.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouxiangyang
  Date: 2021/12/18
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入核心标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>品牌列表页面</title>
</head>
<body>
<h2>${user.username},欢迎您!</h2>
<input type="button" value="新增" onclick="toAdd()"><br>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <%--开始遍历
        items="":被遍历的容器名称，也就是域对象中集合的名称
        var="":表示每次遍历出来的结果保存的变量
        varStatus="vs" :表示遍历的状态信息
            vs.index:表示当前元素的索引，从0开始
            vs.count:表示第几个元素，从1开始
    --%>
    <c:forEach items="${brands}" var="brand" varStatus="vs">
        <tr align="center">
            <td>${vs.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <td>${brand.status==1?"启用":"禁用"}</td>
            <td><a href="selectByIdServlet?id=${brand.id}">修改</a>
                <a href="deleteByIdServlet?id=${brand.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>


<script>
    function toAdd() {
        //跳转到addBrand.html页面
        location.href="/CookieSessionFilterAjaxLoginRegister/filter/addBrand.html";
    }
</script>
</body>
</html>
