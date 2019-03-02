package pl.Servlets;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "secondF", servletNames = {"first"})
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();
        writer.println("SecondF: 1");

        filterChain.doFilter(servletRequest, servletResponse);
        writer.println("secondF: 2");
    }

    @Override
    public void destroy() {

    }

}
