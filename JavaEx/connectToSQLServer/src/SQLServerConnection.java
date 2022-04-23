import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLServerConnection {

    public static Connection getSQLServerConnection() throws SQLException, ClassNotFoundException{
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("as");
        ds.setPortNumber(1433);
        ds.setDatabaseName("myjdbcapp");
        ds.setServerName("LAPTOP-0P2V8T43\\LINHDQ");
        return ds.getConnection();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn= getSQLServerConnection();
        if (conn!=null){
            System.out.println("ket noi thanh cong");
        }else {
            System.out.println("Khong tra ve connection");
        }

    }
}
