<%--
  Created by IntelliJ IDEA.
  User: Cornelius
  Date: 29.10.2016
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is the result page.</title>
</head>
<body>
<h1>Input was:</h1>
<jsp:useBean id="wordFinderBean" type="main.WordFinderBean" class="main.WordFinderBean" scope="request"/>
<h4 align="left">
    Initial letters:
    <span style="color:blue">"<jsp:getProperty name="wordFinderBean" property="sInitialLetters"/>"</span><br>
    Min length:
    <span style="color:green">"<jsp:getProperty name="wordFinderBean" property="nMinSize"/>"</span><br>
    Dictionary:
    <span style="color:red">"<jsp:getProperty name="wordFinderBean" property="sDbPath"/>"</span><br>
    Results:
    <span style="color:black">"<jsp:getProperty name="wordFinderBean" property="lFoundWords"/>"</span><br>
</h4>
<a href="/index.jsp">Word Finder Servlet - Click here to return Home.</a>
</body>
</html>
