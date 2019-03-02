package pl.n2god.authorisationWithCookie;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(filterName = "checkCookie", servletNames = {"giveData"})
public class CheckCookies implements Filter {

    public static final String COOKIE_NAME = "access";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies(); //mam tablicę z ciasteczkami

        Optional<Cookie> accessCookie = Arrays.stream(cookies)
                .filter(cookie -> COOKIE_NAME.equals(cookie.getName())).findFirst();

        if (accessCookie.isPresent()){
            String access = accessCookie.get().getValue();
            Boolean hasAccess = Boolean.valueOf(access);
            if (hasAccess){
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            servletResponse.getWriter().println("Access denied!");
        }
    }


    @Override
    public void destroy() {
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
