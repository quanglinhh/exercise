import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadEmployeeData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select*from employee");
        while (resultSet.next()){
            int empId = resultSet.getInt(1);
            String empNo = resultSet.getString(2);
            String name = resultSet.getString(3);

            System.out.println("------------------------");
            System.out.println("Employee Id: "+ empId);
            System.out.println("Employee Id: "+ empNo);
            System.out.println("Employee Id: "+ name);
        }
    }
}
