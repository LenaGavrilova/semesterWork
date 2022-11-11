package repositories;

import connection.DBcon;
import entities.CartItem;
import entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartItemRepoImpl implements CartItemRepo {

    Connection con = DBcon.getConnection();

    public CartItemRepoImpl() throws SQLException, ClassNotFoundException {

    }

    @Override
    public List<CartItem> getAllFromCart(String login) {

        List<CartItem> list = new ArrayList<>();

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select p.id,p.name,p.image,p.price,s.amount,p.title,p.description,p.cateid from carts as s left join products p on s.productID = p.id where login=?")) {
            ps.setString(1, login);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CartItem(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

