package jdbcapp;

import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

//Dấu đi toàn bộ code SQL không cho nó xuất hiện trong code java nữa
public class CallableStatementDemo{
    public static void main(String[]args) throws SQLException, ClassNotFoundException{
        Connection connection = SQLSeverConnection.getSQLServerConnection();
            //PrepareStatement
//        String query = "select * from employee empid=? and name like ?";
        //CallableStatement
        String query = "{call getEmployeeInfo(?,?,?)}";//See nothing
        CallableStatement callableStatement = connection.prepareCall(query);

        //Lay ket qua ten ra
        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.registerOutParameter(3, Types.VARCHAR);

        callableStatement.executeUpdate();

        int empId = callableStatement.getInt(1);
        String empNo = callableStatement.getString(2);
        String name = callableStatement.getString(3);

        System.out.println("Emp ID: "+empId);
        System.out.println("Emp No: "+empNo);
        System.out.println("Emp Name: "+name);
    }

}
