package servlets;

import entities.User;
import helpers.Validator;
import repositories.UserRepoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String password = request.getParameter("password");
        String re_password = request.getParameter("repassword");
        Validator valid = new Validator();

        if (!password.equals(re_password)) {
            request.getRequestDispatcher("/WEB-INF/views/Register.jsp").forward(request, response);
        } else {
            try {
                if(valid.checkLogin(login).equals("ok") & valid.checkEmail(email).equals("ok") & valid.checkCountry(country).equals("ok") & valid.checkPassword(password).equals("ok")) {
                    UserRepoImpl ur = new UserRepoImpl();
                    User a = ur.checkAccountExist(login);
                    if (a == null) {
                        User user = new User(login, email, country, password, 0);
                        ur.registerUser(user);
                        response.sendRedirect("home");
                    } else {
                        request.getRequestDispatcher("/WEB-INF/views/Register.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("message",valid.checkCountry(country));
                    request.setAttribute("message2",valid.checkEmail(email));
                    request.setAttribute("message3",valid.checkLogin(login));
                    request.setAttribute("message4",valid.checkPassword(password));
                    request.getRequestDispatcher("/WEB-INF/views/Register.jsp").forward(request, response);
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}

