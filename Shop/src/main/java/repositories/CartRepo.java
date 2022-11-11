package repositories;

import entities.Cart;

import java.util.List;

public interface CartRepo {


    public String updateProductToCart(String userLogin, int pid, int amount);

    public List<Cart> getAllCartItems(String userLogin);

    public String removeProductFromCart(String userLogin, int pid);

    public boolean removeAProduct(String userLogin, int pid);
}
