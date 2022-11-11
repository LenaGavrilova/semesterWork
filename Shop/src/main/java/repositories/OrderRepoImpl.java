package repositories;

import connection.DBcon;
import entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepoImpl implements OrderRepo {

    Connection con = DBcon.getConnection();

    public OrderRepoImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public boolean addOrder(String login, int pid) {

        boolean status = false;
        try (PreparedStatement ps = con.prepareStatement("insert into orders values(?,?,?)")) {
            Order order = new Order();
            int id = order.getId();
            ps.setInt(1, id);
            ps.setString(2, login);
            ps.setInt(3, pid);
            id += 1;
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

    @Override
    public List<Order> getAllOrders(String login) {
        List<Order> list = new ArrayList<>();

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select o.oid,o.login,o.pid,sum(c.amount),sum(p.price)from orders as o, carts as c,products as p where o.login = ? and o.login=c.login\n" +
                "group by o.pid, o.login, o.oid")) {

            ps.setString(1, login);

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
