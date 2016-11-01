<%--
  Created by IntelliJ IDEA.
  User: Cornelius
  Date: 01.11.2016
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<div align="right" style="display: ${param.showMenu}">
    <span align="right" style="float:right">
        <form action="/authenticationservlet" method="post">
            <input type="hidden" value="logout" name="action">
            <h3>
                <input type="submit" value="logout">
            </h3>
        </form>
    </span>
    <span align="left" style="float:left">
        <h3>
            <a href="#">
                <jsp:useBean id="userBean" type="main.beans.WordFinderUserBean" scope="session"/>
                Hello,
                <jsp:getProperty name="userBean" property="name"/>
                !
            </a>
        </h3>
    </span>
</div>
