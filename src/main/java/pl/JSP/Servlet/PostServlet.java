package pl.JSP.Servlet;

import pl.JSP.model.PostModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet (name = "postServlet", urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostModel post = new PostModel("Tytuł posta", "Jakaś treść posta", "Jan Kowalski", LocalDateTime.now());


        //dodajemy atrybut dla post
        req.setAttribute("post", post);

        //robimy przekierowanie do pliku JSP - post.jsp
        req.getRequestDispatcher("/post.jsp").forward(req, resp);
    }
}
