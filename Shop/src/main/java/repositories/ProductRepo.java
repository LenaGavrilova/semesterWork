package repositories;

import entities.Product;

import java.util.List;

public interface ProductRepo {

    public List<Product> getTop3();

    public List<Product> getNext3Product(int amount);

    public List<Product> getAllProduct();

    public List<Product> getProductByCID(int cid);

    public List<Product> searchByName(String text);

    public Product getProductByID(int id);

    public String deleteProduct(int pid);

    public String insertProduct(String name, String image, int price,
                                String title, String description, int category);

    public String editProduct(String name, String image, int price,
                              String title, String description, int category, int pid);

    public Product getLast();

}
