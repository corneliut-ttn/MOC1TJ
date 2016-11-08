<%--
  Created by IntelliJ IDEA.
  User: Cornelius
  Date: 20.10.2016
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error page.</title>
</head>
<body>
<h2 align="left">
    <br><br>
    <p style="color:red"> Error!</p>
    <br>
    <strong style="color:darkred">${requestScope.get("error")}</strong>
</h2>
<p align="center">
    <a href="/authenticationservlet">Back</a>
    <a href="/index.jsp">Home</a>
</p>
</body>
</html>
