import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        String query = "{call getEmployeeInfo(?,?,?)}";

        CallableStatement callableStatement = connection.prepareCall(query);

        callableStatement.registerOutParameter(1, Types.INTEGER);
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.registerOutParameter(3, Types.VARCHAR);

        callableStatement.executeUpdate();

        int empId = callableStatement.getInt(1);
        String empNo = callableStatement.getString(2);
        String name = callableStatement.getString(3);

        System.out.println("-------------------------");
        System.out.println("Employee Id: "+ empId);
        System.out.println("Employee Id: "+ empNo);
        System.out.println("Employee Id: "+ name);


    }
}
