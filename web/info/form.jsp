<%--
  Created by IntelliJ IDEA.
  User: Cornelius
  Date: 31.10.2016
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div align="center">
    <h2>${param.action}</h2>
    <form action="/authenticationservlet" method="post">
        <input type="hidden" name="action" value="${param.action}">
        User:
        <input type="text" name="userName" required>
        <br><br>
        Password:
        <input type="password" name="userPassword" required>
        <br><br>
        <span style="display: ${param.rememberMe}">Remember Me <input type="checkbox" name="rememberMe"></span>
        <br>
        <input type="submit" name="submit" value="Submit">
        <br><br>
    </form>
</div>
