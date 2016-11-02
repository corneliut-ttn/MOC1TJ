<%@ page import="main.beans.WordFinderUserBean" %><%--
  Created by IntelliJ IDEA.
  User: Cornelius
  Date: 29.10.2016
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result page.</title>
</head>
<body>
<% if (request.getSession().getAttribute("userBean") != null &&
        ((WordFinderUserBean) request.getSession().getAttribute("userBean")).isLoggedIn()) {%>
<header style="height: 8%;">
    <jsp:include page="info/header.jsp">
        <jsp:param name="showMenu" value="block"/>
    </jsp:include>
</header>
<h2>Input was:</h2>
<jsp:useBean id="wordFinderResultBean" type="main.beans.WordFinderResultBean" class="main.beans.WordFinderResultBean"
             scope="request"/>
<h4 align="left">
    Initial letters:
    <span style="color:blue">"<jsp:getProperty name="wordFinderResultBean" property="sInitialLetters"/>"</span><br>
    Min length:
    <span style="color:blueviolet">"<jsp:getProperty name="wordFinderResultBean" property="nMinSize"/>"</span><br>
    Dictionary:
    <span style="color:red">"<jsp:getProperty name="wordFinderResultBean" property="sDbPath"/>"</span><br>
</h4>
<h2>Results:</h2>
<h4>
    Found words:
    <span style="color:green">"<jsp:getProperty name="wordFinderResultBean" property="lFoundWords"/>"</span><br>
    Time spend:
    <span style="color:deepskyblue">"${requestTimeMillis}"</span><br>
</h4>
<a href="/index.jsp">Word Finder Servlet - Click here to return Home.</a>
<footer style="height: 7%;">
    <jsp:include page="info/footer.jsp"/>
</footer>
<% } else {
    out.println("<h1 align=\"center\">Access restricted</h1>");
    out.println("<a href=\"/authentication.jsp\">Back to Login/Register</a>");
}%>
</body>

</html>
