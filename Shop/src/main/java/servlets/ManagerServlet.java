package servlets;

import entities.Category;
import entities.Product;
import entities.User;
import repositories.CategoryRepoImpl;
import repositories.ProductRepoImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManagerServlet", urlPatterns = {"/manager"})
public class ManagerServlet extends HttpServlet {


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
        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("acc");
        String login = a.getLogin();
        try {
            CategoryRepoImpl cat = new CategoryRepoImpl();
            ProductRepoImpl pr = new ProductRepoImpl();
            List<Product> list = pr.getAllProduct();
            List<Category> listC = cat.getAllCategory();

            request.setAttribute("listCC", listC);
            request.setAttribute("listP", list);
            request.getRequestDispatcher("/WEB-INF/views/ManagerProduct.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

