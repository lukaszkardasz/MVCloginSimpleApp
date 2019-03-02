package pl.Servlets.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "setCookie", urlPatterns = "/set-cookie")
public class SetCookieServlet extends HttpServlet {

    public static final String COOKIE_NAME = "test";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        //z tablicy ciastek robimy stream i sprawdzamy czy w tej tablicy z ciastkami jest ciastko o nazwie test

        Optional<Cookie> testCookie = Arrays.stream(cookies)
                .filter(cookie -> COOKIE_NAME.equals(cookie.getName())).findFirst();

        if (!testCookie.isPresent()){
            Cookie cookie = new Cookie(COOKIE_NAME, "test-cookie-name");
            cookie.setMaxAge(60); //czas zycia ustawiamy na 1 min
            resp.addCookie(cookie); //dodajemy cookie co responsa
        } else {
            resp.getWriter().println("Ciastko o nazwie 'test' ma wartość " + testCookie.get().getValue() + " '");
        }
    }
}
