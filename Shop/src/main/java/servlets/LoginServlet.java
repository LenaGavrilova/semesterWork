package servlets;

import entities.User;
import repositories.UserRepoImpl;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {


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
        String password = request.getParameter("password");

        try {
            UserRepoImpl ur = new UserRepoImpl();
            User a = ur.login(login, password);
            if (a == null) {
                request.setAttribute("mess", "Wrong login or password");
                request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("acc", a);
                response.sendRedirect("home");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            }
        }
    }
