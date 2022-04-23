package jdbcapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatementDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = MySQLConnection.getMySQLConnection();
        //Statement=>Không an toàn
        //PrepareStatement:CRUD=> an toàn bì tham so truyền vào cua truy vấn được "set" bằng ?=>Loại đc mã độc tấn công CSDL
        //CallableStatement
        String query = "select * from employee where empId = ? and name like ?";
        //Tạo PreparedStatement
        //Tham số truyền vào cho PrepareStatement phải dưới dạng (?)
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        //Set đặt giá trị cho tham số của PreparedStatement
        preparedStatement.setInt(1,8);
        preparedStatement.setString(2,"Hoang Anh");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println("-----------------------");
            System.out.println("Emp id: "+resultSet.getInt(1));
            System.out.println("Emp No: "+resultSet.getString(2));
            System.out.println("Name: "+resultSet.getString(3));
        }
    }
}
