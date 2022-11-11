package repositories;

import connection.DBcon;
import entities.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartRepoImpl implements CartRepo {

    Connection con = DBcon.getConnection();

    public CartRepoImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public String updateProductToCart(String userLogin, int pid, int amount) {
        String status = "fail";

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select * from carts where login=? and productid=?")) {

            ps.setString(1, userLogin);
            ps.setInt(2, pid);

            rs = ps.executeQuery();

            if (rs.next()) {

                if (amount > 0) {
                    try (PreparedStatement ps2 = con.prepareStatement("update carts set amount=? where login=? and productid=?")) {

                        ps2.setInt(1, amount);

                        ps2.setString(2, userLogin);

                        ps2.setInt(3, pid);

                        int update = ps2.executeUpdate();

                        if (update > 0)
                            status = "done";

                    } catch (SQLException e) {
                        status = "fail";
                        e.printStackTrace();
                    }

                } else if (amount == 0) {
                    try (PreparedStatement ps2 = con.prepareStatement("delete from carts where login=? and productid=?")) {

                        ps2.setString(1, userLogin);

                        ps2.setInt(2, pid);

                        int update = ps2.executeUpdate();

                        if (update > 0)
                            status = "done";
                    } catch (SQLException e) {
                        status = "fail";
                        e.printStackTrace();
                    }
                }
            } else {
                try (PreparedStatement ps2 = con.prepareStatement("insert into carts values(?,?,?)")) {

                    ps2.setString(1, userLogin);

                    ps2.setInt(2, pid);

                    ps2.setInt(3, amount);

                    int update = ps2.executeUpdate();

                    if (update > 0)
                        status = "done";


                } catch (SQLException e) {
                    status = "fail";
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            status = "fail";
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Cart> getAllCartItems(String userLogin) {
        List<Cart> items = new ArrayList<>();

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select * from carts where login=?")) {

            ps.setString(1, userLogin);

            rs = ps.executeQuery();

            while (rs.next()) {
                items.add(new Cart(rs.getString(1),
                        (rs.getInt(2)),
                        rs.getInt(3)));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    @Override
    public String removeProductFromCart(String userLogin, int pid) {
        String status = "fail";

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select * from carts where login=? and productid=?")) {

            ps.setString(1, userLogin);
            ps.setInt(2, pid);

            rs = ps.executeQuery();

            if (rs.next()) {

                int prodAmount = rs.getInt("amount");

                prodAmount -= 1;

                if (prodAmount > 0) {
                    try (PreparedStatement ps2 = con.prepareStatement("update carts set amount=? where login=? and productid=?")) {

                        ps2.setInt(1, prodAmount);

                        ps2.setString(2, userLogin);

                        ps2.setInt(3, pid);

                        int update = ps2.executeUpdate();

                        if (update > 0)
                            status = "Product Successfully Added to Cart!";
                    } catch (SQLException e) {
                        status = "fail";
                        e.printStackTrace();
                    }
                } else if (prodAmount <= 0) {
                    try (PreparedStatement ps2 = con.prepareStatement("delete from carts where login=? and productid=?")) {

                        ps2.setString(1, userLogin);

                        ps2.setInt(2, pid);

                        int update = ps2.executeUpdate();

                        if (update > 0)
                            status = "Product Successfully Added to Cart!";
                    } catch (SQLException e) {
                        status = "fail";
                        e.printStackTrace();
                    }

                } else {

                    status = "done";

                }
            }
        } catch (SQLException e) {
            status = "fail";
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public boolean removeAProduct(String userLogin, int pid) {
        boolean status = false;

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("delete from carts where login=? and productid=?")) {
            ps.setString(1, userLogin);
            ps.setInt(2, pid);

            int update = ps.executeUpdate();

            if (update > 0) {
                status = true;
            }

        } catch (SQLException e) {
            status = false;
            e.printStackTrace();
        }

        return status;
    }
}
