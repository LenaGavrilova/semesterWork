package repositories;

import connection.DBcon;
import entities.Product;
import helpers.generateId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductRepoImpl implements ProductRepo {

    Connection con = DBcon.getConnection();

    public ProductRepoImpl() throws SQLException, ClassNotFoundException {

    }

    @Override
    public List<Product> getTop3() {
        List<Product> list = new ArrayList<>();

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("Select * from products fetch first 3 rows only")) {
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getNext3Product(int amount) {
        List<Product> list = new ArrayList<>();

        ResultSet rs = null;
        try (PreparedStatement ps = con.prepareStatement("select * from products order by id offset ? rows fetch next 3 rows only")) {
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getAllProduct() {

        List<Product> list = new ArrayList<>();

        ResultSet rs = null;
        try (PreparedStatement ps = con.prepareStatement("select * from products")) {

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getProductByCID(int cid) {

        List<Product> list = new ArrayList<>();

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select * from products where cateID = ?")) {

            ps.setInt(1, cid);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> searchByName(String text) {

        List<Product> list = new ArrayList<>();

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select * from products where name like ?")) {
            ps.setString(1, "%" + text + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product getProductByID(int id) {

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select * from products where id= ?")) {
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deleteProduct(int pid) {

        String status = "fail";

        try (PreparedStatement ps = con.prepareStatement("delete from products where id = ?")) {

            ps.setInt(1, pid);

            int update = ps.executeUpdate();

            if (update > 0) {
                status = "done";
            }

        } catch (SQLException e) {
            status = "fail";
            e.printStackTrace();
        }

        return status;

    }

    @Override
    public String insertProduct(String name, String image, int price, String title, String description, int category) {

        String status = "fail";

        try (PreparedStatement ps = con.prepareStatement("insert into products values (?,?,?,?,?,?,?)")) {

            ps.setInt(1, generateId.genId());
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setInt(4, price);
            ps.setString(5, title);
            ps.setString(6, description);
            ps.setInt(7, category);

            int update = ps.executeUpdate();

            if (update > 0) {
                status = "done";

            }

        } catch (SQLException e) {
            status = "fail";
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public String editProduct(String name, String image, int price, String title, String description, int category, int pid) {

        String status = "fail";

        try (PreparedStatement ps = con.prepareStatement("update products set name = ?, image = ?, price = ?, title = ?," +
                "description = ?, cateID = ? where id=? ")) {
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, price);
            ps.setString(4, title);
            ps.setString(5, description);
            ps.setInt(6, category);
            ps.setInt(7, pid);

            int update = ps.executeUpdate();

            if (update > 0) {
                status = "done";
            }

        } catch (SQLException e) {
            status = "fail";
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public Product getLast() {

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select * from products order by id desc")) {

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
