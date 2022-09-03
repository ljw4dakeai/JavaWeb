<%--
  Created by IntelliJ IDEA.
  User: ljw4dakeai
  Date: 2022/8/27
  Time: 2:04 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="core" uri ="http://java.sun.com/jsp/jstl/core"%>
<%--引入jstl核心标签库--%>
<html>
<head>
    <title>jstl if 使用</title>
</head>
<body>

<%--使用标签库中的标签--%>
<%--判断--%>
<core:if test="${list[1].status==1}">启用</core:if>
<core:if test="${list[1].status==0}">禁用</core:if>


</body>
</html>
