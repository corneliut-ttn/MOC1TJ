package main.filters;

import main.CharResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Cornelius on 02.11.2016.
 */
@WebFilter(filterName = "DecoratorFilter", urlPatterns = {"/*"})
public class DecoratorFilter implements Filter {

    private FilterConfig mFilterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.mFilterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        CharResponseWrapper wrapper = new CharResponseWrapper(httpServletResponse);
        //Send the decorated object as a replacement for the original response
        filterChain.doFilter(servletRequest, wrapper);
        //Get the dynamically generated content from the decorator
        String content = wrapper.toString();
        // Modify the content
        StringWriter sw = new StringWriter();
        sw.write(content);
        sw.write("<p>Thank you for using our WordFinder service!</p>");
        sw.write("<p>Kindly provided by Cornelius!</p>");
        //Send the modified content using the original response
        PrintWriter out = servletResponse.getWriter();
        out.write(sw.toString());
    }

    @Override
    public void destroy() {

    }
}
