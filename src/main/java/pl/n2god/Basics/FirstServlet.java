package pl.n2god;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


    //nadajemy adnotację z nazwą i patternem, extends httpservlet


@WebServlet(
        name = "first",
        urlPatterns = {"/hello", "/aas"},
        initParams = {
                @WebInitParam(name = "key", value = "val"),
                @WebInitParam(name = "test", value = "10")
        }, loadOnStartup = 1)


public class FirstServlet extends HttpServlet {

    //dodajemy nadpisanie z CTRL-O metod Get lub Post

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Post");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        if (name == null) {
            name = getInitParameter("name");
        }

        String test = getInitParameter("test");
        int count = Integer.parseInt(test);

        PrintWriter writer = resp.getWriter();
        for (int i = 0; i < count; i++) {
            writer.println("Witaj " + name);
        }
    }
}
