package repositories;

import entities.Order;

import java.util.List;

public interface OrderRepo {

    public boolean addOrder(String login, int pid);

    public List<Order> getAllOrders(String login);
}
