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


@WebServlet(name = "LoadServlet", urlPatterns = {"/loadProduct"})
public class LoadServlet extends HttpServlet {

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
        String pid = request.getParameter("pid");
        int id = Integer.parseInt(pid);
        try {
            CategoryRepoImpl cat = new CategoryRepoImpl();
            ProductRepoImpl pr = new ProductRepoImpl();
            Product p = pr.getProductByID(id);

            List<Category> listC = cat.getAllCategory();

            request.setAttribute("detail", p);
            request.setAttribute("listCC", listC);
            request.getRequestDispatcher("/WEB-INF/views/Edit.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

