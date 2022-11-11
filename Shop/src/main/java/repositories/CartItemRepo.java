package repositories;

import entities.CartItem;
import entities.Product;

import java.util.List;

public interface CartItemRepo {

    public List<CartItem> getAllFromCart(String login);
}
