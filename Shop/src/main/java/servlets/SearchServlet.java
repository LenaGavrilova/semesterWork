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


@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

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
        String text = request.getParameter("txt");
        try {

            CategoryRepoImpl cat = new CategoryRepoImpl();
            ProductRepoImpl pr = new ProductRepoImpl();
            List<Product> list = pr.searchByName(text);

            List<Category> listC = cat.getAllCategory();
            Product last = pr.getLast();

            request.setAttribute("listP", list);
            request.setAttribute("listCC", listC);
            request.setAttribute("p", last);
            request.setAttribute("txtS", text);
            request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

