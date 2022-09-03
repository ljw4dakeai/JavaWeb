<%--
  Created by IntelliJ IDEA.
  User: ljw4dakeai
  Date: 2022/8/27
  Time: 9:39 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp脚本</title>
</head>
<body>

<%--    <% %>局部代码脚本, 都会放在service方法里面--%>
<%
    int m = 5;
    for (int i = 0; i < m; i++) {
        System.out.println("i = " + i);
    }
    System.out.println("m = " + m);
%>
<%--    <%= %>输出脚本, 都会放在out.prrint()方法里面--%>
<%=
    m
%>
<%--    <%! %>成员代码脚本, 都会放在_jspService里面, 被类包含, 成员代码--%>
<%!
    private String name;
    public static void show(String string){
        System.out.println(string);
    }
%>

</body>
</html>
