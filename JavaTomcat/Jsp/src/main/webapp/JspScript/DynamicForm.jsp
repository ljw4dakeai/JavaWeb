<%@ page import="com.ljw4dakeai.com.ljw4dakeai.com.ljw4dakeai.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: ljw4dakeai
  Date: 2022/8/27
  Time: 10:04 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动态表格</title>
</head>
<body>
<input type="button" value="新增"><br>
<%--1 定义集合数据--%>
<%
    List<Brand> brands = new ArrayList<Brand>();
    brands.add(new Brand(1, "三只松鼠", "三只松鼠", 100, "三只松鼠，好吃不上火", 1));
    brands.add(new Brand(2, "优衣库", "优衣库", 200, "优衣库，服适人生", 0));
    brands.add(new Brand(3, "小米", "小米科技有限公司", 1000, "为发烧而生", 1));
%>
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

    <%
        for (Brand v : brands) {

    %>

        <tr align="center">
            <td><%=v.getId()%></td>
            <td><%=v.getBrandName()%></td>
            <td><%=v.getCompanyName()%></td>
            <td><%=v.getOrdered()%></td>
            <td><%=v.getDescription()%></td>
            <td><%=v.getStatus() == 1?  "启用" : "关闭"%></td>
            <td><a href="#">修改</a> <a href="#">删除</a></td>
        </tr>

    <%
        }
    %>


</table>

</body>
</html>
