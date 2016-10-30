<%--
  Created by IntelliJ IDEA.
  User: Cornelius
  Date: 29.10.2016
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>This is the input page.</title>
</head>
<body>
<h1>Hello!</h1>
<h1>Servlet main.WordFinderServlet at <%=request.getContextPath()%>
</h1>

<form action="/wordfinderservlet" method="POST">
    Input string:<br>
    <input type="text" name="sInput"><br>
    Dictionary:<br>
    <input type="radio" name="dictType" value="ENG" checked> English<br>
    <input type="radio" name="dictType" value="RO"> Romanian<br>
    <input type="radio" name="dictType" value="FRA"> French<br>
    Minimum length:<br>
    <input type="text" name="sMinLength"><br>

    <input type="submit">
</form>

<p>Input string<%=request.getParameter("s")%><p>
</body>
</html>
