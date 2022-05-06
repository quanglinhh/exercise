package jdbcapp.mvc.model;

import jdbcapp.SQLSeverConnection;
import jdbcapp.mvc.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductDAOImpl implements ProductDAO{
    @Override
    public void createProduct(Product product) throws SQLException, ClassNotFoundException {
        //SQL engine:
        //Insert into product values(...)

        Connection connection = SQLSeverConnection.getSQLServerConnection();
        String query = "INSERT INTO product VALUES(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, product.getProName());
        ps.setString(2, product.getProDesc());
        ps.setDouble(3,product.getPrice());

        ps.executeUpdate();
        ResultSet resultSet = ps.getGeneratedKeys();
        if(resultSet.next()){
            product.setId(resultSet.getInt(1));
        }
    }

    @Override
    public void getProductById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = SQLSeverConnection.getSQLServerConnection();
        String query = "SELECT * FROM product WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet resultSet = ps.executeQuery();
        System.out.println("-------------------------------");
        System.out.println("ID    |  ProName  |  ProDesc  |  Price");
        while (resultSet.next()){
            int pId =resultSet.getInt(1);
            String pName = resultSet.getString(2);
            String pDesc = resultSet.getString(3);
            Double price = resultSet.getDouble(4);
            System.out.println("-------------------------------");
            System.out.println("  "+pId+"    |  "+pName+"  |  "+pDesc+"|  "+price);
        }
        System.out.println("-------------------------------");

    }

    @Override
    public ArrayList<Product> getAllProduct() throws SQLException, ClassNotFoundException {
        ArrayList<Product> products = new ArrayList<>();
        Connection connection = SQLSeverConnection.getSQLServerConnection();
        String query = "SELECT * FROM product";
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            Product product = new Product();
            product.setId(resultSet.getInt(1));
            product.setProName(resultSet.getString(2));
            product.setProDesc(resultSet.getString(3));
            product.setPrice(resultSet.getDouble(4));
            products.add(product);
        }
        for(Product product : products){
            System.out.println(product);
        }
        return products;
    }

    @Override
    public void updateProduct() throws SQLException, ClassNotFoundException {
        Connection connection = SQLSeverConnection.getSQLServerConnection();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm bạn muốn thay đổi: ");
        String pName = sc.nextLine();
        System.out.print("Thay đổi tên sản phẩm đã chọn thành: ");
        String pNewName = sc.nextLine();
        System.out.print("Thay đổi Desc mới thành: ");
        String pDesc = sc.nextLine();
        System.out.print("Thay đổi giá sản phẩm đã chọn thành: ");
        Double pPrice = sc.nextDouble();
        String query = "UPDATE product SET proName = ?, proDesc = ?, price = ? WHERE proName = ?";
        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,pNewName);
        ps.setString(2,pDesc);
        ps.setDouble(3,pPrice);
        ps.setString(4,pName);
        ps.executeUpdate();
    }
    @Override
    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException {
        Connection connection = SQLSeverConnection.getSQLServerConnection();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập id sản phẩm cần xóa: ");
        id = sc.nextInt();
        String query = "DELETE FROM product WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,id);
        ps.executeUpdate();
        return true;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        Product product = new Product("samsung1","the new product",3000);
        productDAO.getAllProduct();
    }
}
