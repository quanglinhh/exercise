package jdbcapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadEmployeeData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Tra ve 1 doi tuong connection da ket noi den SCDL
        //SQL Connection
//        Connection connection = SQLSeverConnection.getSQLServerConnection();
        //MySQL Connection
        Connection connection = MySQLConnection.getMySQLConnection();
        Statement statement = connection.createStatement();

        //Ket Qua tra ve tu bang Employee duoc ResultSET chua thong  tin
        ResultSet resultSet = statement.executeQuery("select*from employee");
        while (resultSet.next()){
            int empId = resultSet.getInt(1);
            String empNo = resultSet.getString(2);
            String name = resultSet.getString(3);
            System.out.println("-------------------------");
            System.out.println("EmpId: "+empId);
            System.out.println("EmpNo: "+empNo);
            System.out.println("Name: "+ name);
        }
    }
}
