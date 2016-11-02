<%--
  Created by IntelliJ IDEA.
  User: Cornelius
  Date: 29.10.2016
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index page.</title>
</head>

<body>
<h2>Hello to Word Finder! The new incredible tool for finding words! YEY!</h2>
<h3>Current date and time: <%= new java.util.Date() %>
</h3>
<ul>
    <li><a href="index.jsp">Home</a></li>
    <li><a href="/authenticationservlet">Login/Register</a></li>
    <li><a href="/wordfinderservlet">WordFinder</a></li>
    <li><a href="/input.jsp">[Test]Input</a></li>
    <li><a href="/result.jsp">[Test]Result</a></li>
</ul>
<%--<a href="/wordfinderservlet">Word Finder - Click here to send GET request</a>--%>
</body>
</html>
