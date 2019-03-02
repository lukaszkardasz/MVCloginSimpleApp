package pl.Servlets;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "firstF", servletNames = {"first"})
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        writer.println("FirstF: 1");

        String name = ((HttpServletRequest)servletRequest).getParameter("name");

        if (!StringUtils.isEmpty(name)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            writer.println("Sorka, nie podałeś imienia");
        }
        writer.println("firstF: 2");
    }

    @Override
    public void destroy() {

    }

}
