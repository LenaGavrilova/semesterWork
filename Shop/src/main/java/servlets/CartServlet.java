package servlets;

import entities.Cart;
import entities.CartItem;
import entities.User;
import repositories.CartItemRepoImpl;
import repositories.CartRepoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "СartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

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
        try {
            CartRepoImpl cart = new CartRepoImpl();
            List<Cart> cartItem = cart.getAllCartItems(userLogin);
            CartItemRepoImpl itemImpl = new CartItemRepoImpl();
            List<CartItem> allItems = itemImpl.getAllFromCart(userLogin);
            int cost = 0;
            for (CartItem c : allItems
                 ) {
                cost += c.getPprice();
            }
            int costAll = cost+100;
            request.setAttribute("costAll",costAll);
            request.setAttribute("cost",cost);
            request.setAttribute("list", cartItem);
            request.setAttribute("listCP", allItems);
            request.getRequestDispatcher("/WEB-INF/views/Cart.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
