package repositories;

import entities.User;

import java.sql.SQLException;

public interface UserRepo {

    public String registerUser(User user);

    public boolean isRegistered(String login);

    public User checkAccountExist(String login);

    public User login(String login, String password);
}
