package servlets;

import entities.Product;
import repositories.ProductRepoImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SearchByAjax", urlPatterns = {"/searchAjax"})
public class SearchByAjax extends HttpServlet {

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
            ProductRepoImpl pr = new ProductRepoImpl();
            List<Product> list = pr.searchByName(text);
            PrintWriter out = response.getWriter();
            for (Product o : list) {
                out.println("<div class=\"product col-12 col-md-6 col-lg-4\">\n"
                        + "                                <div class=\"card\">\n"
                        + "                                    <img class=\"card-img-top\" src=\"" + o.getImage() + "\" alt=\"Card image cap\">\n"
                        + "                                    <div class=\"card-body\">\n"
                        + "                                        <h4 class=\"card-title show_txt\"><a href=\"detail?pid=" + o.getId() + "\" title=\"View Product\">" + o.getName() + "</a></h4>\n"
                        + "                                        <p class=\"card-text show_txt\">" + o.getTitle() + "</p>\n"
                        + "                                        <div class=\"row\">\n"
                        + "                                            <div class=\"col\">\n"
                        + "                                                <p class=\"btn btn-danger btn-block\">" + o.getPrice() + " $</p>\n"
                        + "                                            </div>\n"
                        + "                                            <div class=\"col\">\n"
                        + "                                                <a href=\"#\" class=\"btn btn-success btn-block\">Add to cart</a>\n"
                        + "                                            </div>\n"
                        + "                                        </div>\n"
                        + "                                    </div>\n"
                        + "                                </div>\n"
                        + "                            </div>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}