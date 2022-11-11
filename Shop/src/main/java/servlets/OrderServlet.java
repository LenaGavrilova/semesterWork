package servlets;

import entities.Order;
import entities.User;
import repositories.OrderRepoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OrderServlet", urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User user = (User) request.getSession().getAttribute("acc");
        if (user == null) {
            response.sendRedirect("login");
        }

        assert user != null;
        String userLogin = user.getLogin();
        String pid = request.getParameter("id");
        int prodId = Integer.parseInt(pid);

        try {
            OrderRepoImpl ord = new OrderRepoImpl();
            ord.addOrder(userLogin, prodId);
            response.sendRedirect("/WEB-INF/views/Order.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
