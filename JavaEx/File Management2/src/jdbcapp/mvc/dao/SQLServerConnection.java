package jdbcapp.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    public static Connection getSQLServerConnection()throws SQLException,ClassNotFoundException {
        String hostName="localhost";
        String instanceName="LAPTOP-0P2V8T43\\SQLEXPRESS01";
        String database="myjdbcapp";
        String useName="sa";
        String password="as";

        Connection connection = getSQLServerConnection(hostName,database,instanceName,useName,password);
        return connection;
    }
    public static Connection getSQLServerConnection(String hostName, String databaseName,String instanceName, String userName, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String connectionString="jdbc:sqlserver://"+hostName+":1433" +";instance="+instanceName +";databaseName="+databaseName;


        Connection connection= DriverManager.getConnection(connectionString,userName,password);
        return connection;

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn=getSQLServerConnection();
        if (conn!=null){
            System.out.println("ket noi thanh cong");
        }else {
            System.out.println("Khong tra ve connection");
        }
    }
}
