<%@ page import="com.ljw4dakeai.com.ljw4dakeai.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: ljw4dakeai
  Date: 2021/12/18
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入核心标签库--%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>查询所有</title>
</head>
<body>
<a href="addBrand.html"><input type="button" value="新增"></a><br>
<hr>
<table border="1" cellspacing="0" width="100%">
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
    <core:forEach items="#{brands}" var="brand"  varStatus="vs">
        <tr align="center">
            <td>${vs.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <td>
                <core:if test="${brand.status==1}">启用</core:if>
                <core:if test="${brand.status==0}">禁用</core:if>
            </td>
            <td>
                <a href="/BrandMVC/selectByIdServlet?id=${brand.id}">修改</a>
                <a href="/BrandMVC/deleteByIdServlet?id=${brand.id}">删除</a>
            </td>
        </tr>
    </core:forEach>

</table>

</body>
</html>
