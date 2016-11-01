<%@ page import="main.beans.WordFinderUserBean" %><%--
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
    <title>Input page.</title>
</head>
<body>
<% if (request.getSession().getAttribute("userBean") != null &&
        ((WordFinderUserBean) request.getSession().getAttribute("userBean")).isLoggedIn()) {%>
<header style="height: 8%;">
    <jsp:include page="info/header.jsp">
        <jsp:param name="showMenu" value="block"/>
    </jsp:include>
</header>

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
<footer style="height: 7%;">
    <jsp:include page="info/footer.jsp"/>
</footer>
<% } else {
    out.println("<h1 align=\"center\">Access restricted</h1>");
    out.println("<a href=\"/authentication.jsp\">Back to Login/Register</a>");
}%>

</body>
</html>
