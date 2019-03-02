package pl.Servlets.Basics;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        PrintWriter writer = resp.getWriter();
        //sprawdzamy id sesji
        writer.println(session.getId());

        //czas utworzenia
        writer.println(session.getCreationTime());


    }
}
