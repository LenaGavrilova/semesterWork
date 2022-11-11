package servlets;

import entities.Category;
import entities.Product;
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


@WebServlet(name = "DetailServlet", urlPatterns = {"/detail"})
public class DetailServlet extends HttpServlet {

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
        String pid = request.getParameter("pid");
        int id = Integer.parseInt(pid);
        try {
            CategoryRepoImpl cat = new CategoryRepoImpl();
            ProductRepoImpl pr = new ProductRepoImpl();
            Product p = pr.getProductByID(id);
            List<Category> listC = cat.getAllCategory();
            Product last = pr.getLast();
            request.setAttribute("detail", p);
            request.setAttribute("listCC", listC);
            request.setAttribute("p", last);
            request.getRequestDispatcher("/WEB-INF/views/Detail.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
