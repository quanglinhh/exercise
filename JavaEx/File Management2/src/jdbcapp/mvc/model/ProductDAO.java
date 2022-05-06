package jdbcapp.mvc.model;

import jdbcapp.mvc.entity.Product;

import java.sql.SQLException;

public interface ProductDAO {
    //Create product
    public void createProduct(Product product) throws SQLException, ClassNotFoundException;

    //Read product by id
    public  void getProductById(int id) throws SQLException, ClassNotFoundException;

    //Get all products
    public Object getAllProduct() throws SQLException, ClassNotFoundException;

    //Update product
    public void updateProduct() throws SQLException, ClassNotFoundException;

    //Delete product
    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException;
}
