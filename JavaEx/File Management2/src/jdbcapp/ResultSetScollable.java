package jdbcapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetScollable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = SQLSeverConnection.getSQLServerConnection();

        //Tao Statement. Its nhạy cảm với sự thay đổi của bảng
        //Chỉ đọc
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "select * from employee";

        //Thuc thi chi thi cua SQL thong qua satatement
        ResultSet resultSet = statement.executeQuery(query);

        //Di chuyen con trỏ đến cuối bản ghi
        boolean last =resultSet.last();
        System.out.println("Last: "+last);
        boolean first =resultSet.first();
        if(last){
            //ghi ban ghi cua last
            System.out.println("Employee Id: "+resultSet.getInt(1));
            System.out.println("Employee No: "+resultSet.getString(2));
            System.out.println("Employee's name: "+resultSet.getString(3));
            System.out.println("--------------------------------------");
        }
        System.out.println("First: "+first);
        if(first){
            //ghi ban ghi cua last
            System.out.println("Employee Id: "+resultSet.getInt(1));
            System.out.println("Employee No: "+resultSet.getString(2));
            System.out.println("Employee's name: "+resultSet.getString(3));
        }
        while (resultSet.next()){
            //Lay du lieu theo id
            String empNo = resultSet.getString(2);
            //Lay du lieu theo id cua cot 1
            int empId = resultSet.getInt(1);
            //Lay di lieu theo ten cot
            String empName = resultSet.getString("name");

            System.out.println("--------------------------------------");
            System.out.println("Id: "+empId);
            System.out.println("Emp No: "+empNo);
            System.out.println("Name : "+empName);

        }
    }
}
