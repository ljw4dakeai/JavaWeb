<%--
  Created by IntelliJ IDEA.
  User: ljw4dakeai
  Date: 2022/8/27
  Time: 1:49 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>
<%--在servlet中保存数据, 然后再jsp中通过el获取数据--%>
<%--获取所有数据--%>
${list}
<%--获取索引的数据--%>
<hr>
${list.get(1)}<br>
${list[1]}
<hr>
<%--获取属性值--%>
<hr>
<%--通过方法获取--%>
${list.get(1).getBrandName()}<br>
<%--通过成员变量名获取--%>
${list[1].brandName}
<hr>
${list[1].status == 1 ?  "启用" : "禁用"}
<hr>

</body>
</html>
