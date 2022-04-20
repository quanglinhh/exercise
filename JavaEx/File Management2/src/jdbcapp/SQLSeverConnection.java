package jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLSeverConnection {
    public static Connection getSQLServerConnection()throws SQLException,ClassNotFoundException {
        String hostName="localhost";
        String instanceName="LAPTOP-0P2V8T43\\LINHDQ";
        String database="company";
        String useName="root";
        String password="";

        Connection connection = getSQLServerConnection(hostName,database,instanceName,useName,password);
        return connection;
    }
    public static Connection getSQLServerConnection(String hostName, String databaseName,String instanceName, String userName, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String connectionString="jdbc:sqlserver://"+hostName+":1433"
                +";instance="+instanceName
                +";databaseName="+databaseName;

//        String connectionstring="jdbc:jtds:sqlserver://localhost:1433/myjdbcapp;instance=LINHDQ";
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