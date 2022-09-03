<%@ page import="com.ljw4dakeai.com.ljw4dakeai.pojo.Brand" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ljw4dakeai
  Date: 2022/8/27
  Time: 2:04 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%--引入jstl核心标签库--%>
<html>
<head>
    <title>jstl forEach 使用</title>
</head>
<body>

<%--使用标签库中的标签--%>
<%--forEach--%>
<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>

    <%--
        遍历list集合，在表格中动态展示数据
        标签：
            <core:forEach >表示遍历 items="${list}"属性：表示被遍历的集合名称，也就是域对象中存值的
            key var="brand"属性：表示遍历出来的每一个值要保存的变量
            varStatus="vs"：遍历的状态对象，封装了遍历`的索引和序号等值
            vs.index：表示获取索引，从0开始 vs.count：表示获取索引，从1开始
    --%>
    <core:forEach items="${list}" var="brand" varStatus="vs">
        <tr align="center">
            <td>${vs.count}</td>
            <td>${brand.getBrandName()}</td>
            <td>${brand.getCompanyName()}</td>
            <td>${brand.getOrdered()}</td>
            <td>${brand.getDescription()}</td>
            <td>
                <core:if test="${brand.status==1}">启用</core:if>
                <core:if test="${brand.status==0}">禁用</core:if>
            </td>
            <td><a href="#">修改</a> <a href="#">删除</a></td>
        </tr>
    </core:forEach>
</table>


</body>
</html>
