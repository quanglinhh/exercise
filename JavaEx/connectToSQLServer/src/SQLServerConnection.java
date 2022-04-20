import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLServerConnection {
    public static void main(String[] args) throws SQLServerException {
        var server = "LAPTOP-0P2V8T43\\SQLEXPRESS";
        String useName="sa";
        String password="as";
        var db ="myjdbcapp";
        var port = 1433;

        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(useName);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);

        try(Connection conn = ds.getConnection()){
            System.out.println("Ket noi thanh cong");
            System.out.println(conn.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
