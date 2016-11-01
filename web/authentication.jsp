<%--
  Created by IntelliJ IDEA.
  User: Cornelius
  Date: 29.10.2016
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Login Page</title>
</head>

<body>
<main style="height: 60%; margin: 10% 25%">
        <span style="float: left;">
            <jsp:include page="info/form.jsp">
                <jsp:param name="action" value="login"/>
                <jsp:param name="remember" value="block"/>
            </jsp:include>
        </span>

    <span style="float: right;">
            <jsp:include page="info/form.jsp">
                <jsp:param name="action" value="register"/>
                <jsp:param name="remember" value="none"/>
            </jsp:include>
        </span>
</main>
</body>
</html>
