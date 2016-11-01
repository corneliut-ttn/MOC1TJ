package main;

import main.beans.WordFinderUserBean;
import main.model.AuthenticationManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cornelius on 31.10.2016.
 */
@WebServlet(name = "main.AuthenticationServlet", urlPatterns = {"/authenticationservlet"})
public class AuthenticationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];

            if (cookie.getName().equals("userName")) {
                String[] userCookie = cookie.getValue().split(" ");

                WordFinderUserBean userBean = new WordFinderUserBean();
                userBean.setName(userCookie[0]);
                userBean.setPassword("");
                userBean.setLoggedIn(true);
                request.getSession().setAttribute("userBean", userBean);

                RequestDispatcher view = request.getRequestDispatcher("/wordfinderservlet");
                view.forward(request, response);
                return;
            }
        }

        RequestDispatcher view = request.getRequestDispatcher("authentication.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String rememberMe = request.getParameter("rememberMe");
        AuthenticationManager authenticationManager = new AuthenticationManager();

        WordFinderUserBean userBean = new WordFinderUserBean();
        switch (request.getParameter("action")) {
            case "login":
                if (authenticationManager.login(userName, userPassword) == AuthenticationManager.ERR_NO_USER)
                    request.setAttribute("error", "<br> Login error: <br> User name doesnt exist!");
                if (authenticationManager.login(userName, userPassword) == AuthenticationManager.ERR_WRONG_PASS)
                    request.setAttribute("error", "<br> Login error: <br> Wrong password!");
                else {
                    userBean.setName(userName);
                    userBean.setPassword(userPassword);
                    userBean.setLoggedIn(true);
                }
                if (rememberMe != null && rememberMe.equals("on")) {
                    Cookie c = new Cookie("userName", userBean.getName());

                    c.setMaxAge(24 * 60 * 60);
                    response.addCookie(c);
                }
                break;
            case "register":
                if (authenticationManager.register(userName, userPassword) == AuthenticationManager.ERR_USER_EXISTS)
                    request.setAttribute("error", "<br> Register error: <br> User already exists!");
                else {
                    userBean.setName(userName);
                    userBean.setPassword(userPassword);
                    userBean.setLoggedIn(true);
                }
                break;
            case "logout":
                userBean = (WordFinderUserBean) request.getSession().getAttribute("userBean");
                userBean.setLoggedIn(false);
                request.getSession().setAttribute("userBean", userBean);
                break;
            default:
                break;
        }
        request.getSession().setAttribute("userBean", userBean);
        if (request.getAttribute("error") != null) {
            RequestDispatcher view = request.getRequestDispatcher("/error.jsp");
            view.forward(request, response);
        } else if (!userBean.isLoggedIn()) {
            response.sendRedirect("index.jsp");
        } else {
            request.getSession().setAttribute("user", userBean);
            response.sendRedirect("/wordfinderservlet");
        }


    }

}
