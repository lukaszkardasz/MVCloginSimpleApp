package pl.n2god.authorisationWithCookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet (name = "giveCookie", urlPatterns = "/giveCookie")
public class giveCookie extends HttpServlet {

    public static final String COOKIE_NAME = "access";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie(COOKIE_NAME, "true");
        cookie.setMaxAge(60); //czas zycia ustawiamy na 1 min
        resp.addCookie(cookie);
    }
}
