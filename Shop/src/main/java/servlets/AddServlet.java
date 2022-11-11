package servlets;

import entities.User;
import repositories.ProductRepoImpl;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AddServlet", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {


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
        String pname = request.getParameter("name");
        String pimage = request.getParameter("image");
        String pprice = request.getParameter("price");
        int price = Integer.parseInt(pprice);
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        String pcategory = request.getParameter("category");
        int cate = Integer.parseInt(pcategory);

        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("acc");
        try {
            ProductRepoImpl pr = new ProductRepoImpl();
            pr.insertProduct(pname, pimage, price, ptitle, pdescription, cate);
            response.sendRedirect("manager");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
