package main.filters;

import main.beans.WordFinderUserBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Cornelius on 01.11.2016.
 */
@WebFilter(filterName = "UserLoggedFilter", urlPatterns = {"/input.jsp", "/result.jsp"})
public class UserLoggedFilter implements Filter {

    private FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession(false);

        if ((session != null) && (!((session.getAttribute("userBean") != null) && ((WordFinderUserBean) session.getAttribute("userBean")).isLoggedIn()))) {
            httpServletResponse.sendRedirect("/authenticationservlet");
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
