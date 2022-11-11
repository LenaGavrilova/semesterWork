package repositories;

import connection.DBcon;
import entities.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepoImpl implements CategoryRepo {

    Connection con = DBcon.getConnection();

    public CategoryRepoImpl() throws SQLException, ClassNotFoundException {

    }

    @Override
    public List<Category> getAllCategory() {

        List<Category> list = new ArrayList<>();

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select * from categories")) {
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
