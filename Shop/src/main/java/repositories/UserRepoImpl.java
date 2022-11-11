package repositories;

import connection.DBcon;
import entities.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepoImpl implements UserRepo {

    Connection con = DBcon.getConnection();

    public UserRepoImpl() throws SQLException, ClassNotFoundException {

    }

    @Override
    public String registerUser(User user) {
        String status = "fail";

        boolean checkUser = isRegistered(user.getLogin());

        if (checkUser) {
            status = "fail";
            return status;
        }

        String pass = user.getPassword();
        String newPass = DigestUtils.md5Hex(pass);
        try (PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?)")) {

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setString(4, newPass);

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
    public boolean isRegistered(String login) {
        boolean status = false;

        ResultSet rs = null;

        try (PreparedStatement ps = con.prepareStatement("select * from users where login=?")) {

            ps.setString(1, login);

            rs = ps.executeQuery();

            if (rs.next())
                status = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public User checkAccountExist(String login) {

        ResultSet rs = null;
        try (PreparedStatement ps = con.prepareStatement(" select from users where login = ?")) {
            ps.setString(1, login);

            rs = ps.executeQuery();

            while (rs.next()) {

                return new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User login(String login, String password) {

        ResultSet rs = null;
        String newPass = DigestUtils.md5Hex(password);
        try (PreparedStatement ps = con.prepareStatement("select * from users where login = ? and password = ?")) {
            ps.setString(1, login);
            ps.setString(2, newPass);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
