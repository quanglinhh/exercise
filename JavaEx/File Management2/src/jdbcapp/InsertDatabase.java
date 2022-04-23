package jdbcapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDatabase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = SQLSeverConnection.getSQLServerConnection();

        //Create statement
        Statement statement = connection.createStatement();
        String query = "insert into employee values (7,'F008','Hoang Anh')";

        //Thuc thi cau lenh insert
        int row = statement.executeUpdate(query);
        System.out.println("Row inserted: "+row);
    }
}
