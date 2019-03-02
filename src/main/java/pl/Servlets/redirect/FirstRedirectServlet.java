package pl.Servlets.redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet (name = "FirstRedirectServlet", urlPatterns = "/redirect")
public class FirstRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Servlet 1: before redirect");
        //wykonujemy przekierowanie zwykłe, lecą dwa zapytania po stronie serwera
        //resp.sendRedirect("/redirect-target");

        //wykonujemy przekierowanie za pomocą forward - czyli 1: pierwszy servlet, następnie redirect do drugiego i odpowiada responsem drugi servlet, a nie ten pierwszy
        //leci tylko jedno zapytanie po stronie serwera
        //req.getRequestDispatcher("/redirect-target").forward(req, resp); //tu mozna zamiast forward uzyc include

        //przekierowanie include - czeka na odpowiedz, serwlety gadaja pomiedzy soba, ale odpowiada ten pierwszy
        req.getRequestDispatcher("redirect-target").include(req, resp);

        writer.println("Servlet 1: after redirect");
    }
}
