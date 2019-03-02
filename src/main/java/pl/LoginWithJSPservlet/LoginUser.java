package pl.LoginWithJSPservlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "loginUser", urlPatterns = "/loginUser")
public class LoginUser extends HttpServlet {

    private UserList userList = UserList.g;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Optional<User> logedUser = userList.getUserByLoginData(login, password);


        if (logedUser.isPresent()){
            req.getRequestDispatcher("/userPanel.jsp").forward(req, resp);
        } else {

        }



    }
}
